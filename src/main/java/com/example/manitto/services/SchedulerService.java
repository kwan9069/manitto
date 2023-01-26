package com.example.manitto.services;

import com.example.manitto.apicall.NicknameApiService;
import com.example.manitto.common.Constants;
import com.example.manitto.dtos.Match;
import com.example.manitto.dtos.User;
import com.example.manitto.dtos.UserMatch;
import com.example.manitto.repositories.MatchRepository;
import com.example.manitto.repositories.UserMatchRepository;
import com.example.manitto.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final UserRepository userRepository;
    private final MatchRepository matchRepository;
    private final UserMatchRepository userMatchRepository;

    private final NicknameApiService nicknameApiService;

    @Scheduled(fixedDelay = Long.MAX_VALUE)
    public void generateNewUserMatchAtBootStrop() throws IOException {
        updateUserRandomNames();
        generateNewMatch();
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void generateNewUserMatch() {
        generateNewMatch();
    }

    private void generateNewMatch() {
        if (userRepository.getTotalUserCount() < 2 * Constants.ACTIVE_MATCH_COUNT) {
            System.out.println("매칭을 위한 회원수가 부족합니다.");
            return;
        }
        List<Match> activeList = matchRepository.getMatchListActive();
        if (activeList.size() == 0) {
            IntStream.range(0, Constants.ACTIVE_MATCH_COUNT).forEach(i -> matchRepository.createMatch(new Match.CreateDto(UUID.randomUUID().toString(), 1, Constants.STATUS_WAITING)));
        }
        activeList.forEach(match -> matchRepository.updateMatch(Match.UpdateDto.builder(match)
                .result(match.getResult() != null && match.getResult())
                .status(Constants.STATUS_ARCHIVED)
                .build()));

        userRepository.getAllUserList().forEach(user -> userRepository.updateUser(user.generateUpdateDto(User.UpdateDto.builder(user)
                .prevContributor(user.getRole().equals(Constants.ROLE_CONTRIBUTOR))
                .prevReceiver(user.getRole().equals(Constants.ROLE_RECEIVER))
                .role(Constants.ROLE_NONE)
                .build())));
        List<User> matchTargets = userRepository.getUserListWithoutPrevMatch();
        Collections.shuffle(matchTargets);
        AtomicInteger index = new AtomicInteger();
        matchRepository.getMatchListWaiting().forEach(match -> {
            matchRepository.updateMatch(Match.UpdateDto.builder(match)
                    .status(Constants.STATUS_ACTIVE)
                    .build());
            for (int i = 0; i < Constants.ACTIVE_MATCH_COUNT; i++) {
                User user = userRepository.getUserByUsername(matchTargets.get(index.get()).getUsername()).get();
                userRepository.updateUser(User.UpdateDto.builder(user)
                        .role(index.get() % 2 == 0 ? Constants.ROLE_CONTRIBUTOR : Constants.ROLE_RECEIVER)
                        .build());
                userMatchRepository.createUserMatch(new UserMatch.CreateDto(user.getId(), match.getId()
                        , index.get() % 2 == 0
                        , index.getAndIncrement() % 2 != 0));
            }
        });
        IntStream.range(0, Constants.ACTIVE_MATCH_COUNT).forEach(i -> {
            String title = UUID.randomUUID().toString();
            matchRepository.createMatch(new Match.CreateDto(title, 1, Constants.STATUS_WAITING));
        });
    }

    private void updateUserRandomNames() throws IOException {
        List<User> userList = userRepository.getAllUserList();
        int totalUserCount = userList.size();

        List<String> nicknameLists = (List<String>) nicknameApiService.call("json", totalUserCount).execute().body().get("words");
        IntStream.range(0, totalUserCount).forEach(i -> userRepository.updateUser(User.UpdateDto.builder(userList.get(i))
                .randomName(nicknameLists.get(i))
                .build()));
    }
}
