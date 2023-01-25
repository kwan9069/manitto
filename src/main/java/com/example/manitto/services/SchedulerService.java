package com.example.manitto.services;

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

import java.util.Collections;
import java.util.List;
import java.util.UUID;
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

    @Scheduled(fixedDelay = Long.MAX_VALUE)
    public void generateNewUserMatchAtBootStrop() {
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
        matchRepository.getMatchListActivated().forEach(match -> matchRepository.updateMatch(Match.UpdateDto.builder(match)
                .result(match.getResult() == null ? false : match.getResult())
                .archived(true)
                .build()));

        userRepository.getAllUserList().forEach(user -> userRepository.updateUser(user.generateUpdateDto(User.UpdateDto.builder(user)
                .prevContributor(user.getRole().equals(Constants.ROLE_CONTRIBUTOR))
                .prevReceiver(user.getRole().equals(Constants.ROLE_RECEIVER))
                .role(Constants.ROLE_NONE)
                .build())));
        List<User> matchTargets = userRepository.getUserListWithoutPrevMatch();
        Collections.shuffle(matchTargets);
        List<User> contributorCandidates = matchTargets.subList(0, Constants.ACTIVE_MATCH_COUNT);
        List<User> receiverCandidates = matchTargets.subList(Constants.ACTIVE_MATCH_COUNT, 2 * Constants.ACTIVE_MATCH_COUNT);
        IntStream.range(0, Constants.ACTIVE_MATCH_COUNT).forEach(i -> {
            User contributor = contributorCandidates.get(i);
            User receiver = receiverCandidates.get(i);
            String title = UUID.randomUUID().toString();
            matchRepository.createMatch(new Match.CreateDto(title, 1));
            Match match = matchRepository.getMatchByTitle(title).get();
            userMatchRepository.createUserMatch(new UserMatch.CreateDto(contributor.getId(), match.getId(), true, false));
            userMatchRepository.createUserMatch(new UserMatch.CreateDto(receiver.getId(), match.getId(), false, true));
            userRepository.updateUser(User.UpdateDto.builder(contributor)
                    .role(Constants.ROLE_CONTRIBUTOR)
                    .build());
            userRepository.updateUser(User.UpdateDto.builder(receiver)
                    .role(Constants.ROLE_RECEIVER)
                    .build());
        });
    }
}
