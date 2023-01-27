package com.example.manitto.services;

import com.example.manitto.apicall.NicknameApiService;
import com.example.manitto.common.Constants;
import com.example.manitto.common.LoginSessionManager;
import com.example.manitto.dtos.Match;
import com.example.manitto.dtos.User;
import com.example.manitto.dtos.UserMatch;
import com.example.manitto.repositories.MatchRepository;
import com.example.manitto.repositories.UserMatchRepository;
import com.example.manitto.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final LoginSessionManager loginSessionManager;
    private final NicknameApiService nicknameApiService;
    private final UserRepository userRepository;
    private final UserMatchRepository userMatchRepository;
    private final MatchRepository matchRepository;

    public void registerUser(User.RegisterDto registerDto) {
        if (userRepository.isExistUsername(registerDto.getUsername()))
            throw new RuntimeException(); // TODO: 2023/01/23 유저네임 중복 에러 핸들링
        if (userRepository.isExistEmail(registerDto.getEmail())) throw new RuntimeException();
        userRepository.registerUser(registerDto);
        User user = userRepository.getUserByUsername(registerDto.getUsername()).get();
        Map<String, Object> callResultBody;
        try {
            callResultBody = nicknameApiService.call("json", 1).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e); // TODO: 2023/01/24 API Call 에러 핸들링
        }
        String randomName = ((List<String>) callResultBody.get("words")).stream().findFirst().get();
        userRepository.updateUser(User.UpdateDto.builder(user)
                .randomName(randomName)
                .role(Constants.ROLE_NONE)
                .build());
    }

    public void login(User.AuthDto authDto) {
        User find = userRepository.getUserByUsername(authDto.getUsername()).orElseThrow(RuntimeException::new); // TODO: 2023/01/24 Not Found User 핸들링
        if (!BCrypt.checkpw(authDto.getPassword(), find.getPassword()))
            throw new RuntimeException(); // TODO: 2023/01/24 Incorrect Password 핸들링
        loginSessionManager.setLoginUserInfo(find.toInfoDto());
//        if (!find.getRole().equals(Constants.ROLE_NONE)){
//            UserMatch.ExtendedDto userMatch = userMatchRepository.getExtendedUserMatchListByUserId(Constants.STATUS_ACTIVE, find.getId()).stream().findFirst().get();
//            UserMatch.ExtendedDto extended = userMatchRepository.getExtendedUserMatchListByMatchId(Constants.STATUS_ACTIVE, userMatch.getMatchId()).stream()
//                    .filter(extendedDto -> extendedDto.getUserId() != find.getId()).findFirst().get();
//            loginSessionManager.setExtendedInfo(extended);
//        }

    }

    public String getUserRole(long id) {
        User user = userRepository.getUserById(id).get();
        if (!user.getAwareRole()) {
            userRepository.updateUser(user.generateUpdateDto(User.UpdateDto.builder(user)
                    .awareRole(true)
                    .build()));
            User updated = userRepository.getUserById(id).get();
            loginSessionManager.updateLoginUserInfo(updated.toInfoDto());
        }
        return user.getRole();
    }

    public List<User.InfoDto> getUserList() {
        return userRepository.getAllUserList().stream().filter(user -> !user.getId().equals(loginSessionManager.getLoginUserInfo().getId()))
                .map(user -> user.toInfoDto())
                .toList();
    }

    public User.InfoDto getReceiver() {
        if (!loginSessionManager.haveLoginSession()) throw new RuntimeException();
        UserMatch.ExtendedDto receiverUserMatch = userMatchRepository.getExtendedUserMatchList(Constants.STATUS_ACTIVE)
                .stream().filter(userMatch -> userMatch.getRole().equals(Constants.ROLE_RECEIVER))
                .findFirst().get();
        return userRepository.getUserById(receiverUserMatch.getUserId()).get().toInfoDto();
    }

    public User.InfoDto getContributor(long checkId) {
        if (!loginSessionManager.haveLoginSession()) throw new RuntimeException();
        long sessionId = loginSessionManager.getLoginUserInfo().getId();
        UserMatch.ExtendedDto sessionUserMatch = userMatchRepository.getExtendedUserMatchListByUserId(Constants.STATUS_ACTIVE, sessionId)
                .stream().filter(userMatch -> userMatch.getRole().equals(Constants.ROLE_RECEIVER))
                .findFirst().get();
        Match match = matchRepository.getMatchById(sessionUserMatch.getMatchId()).get();
        try {
            UserMatch.ExtendedDto contributorUserMatch = userMatchRepository.getExtendedUserMatchListByUserId(Constants.STATUS_ACTIVE, checkId)
                    .stream().filter(userMatch -> userMatch.getRole().equals(Constants.ROLE_CONTRIBUTOR))
                    .findFirst().orElseThrow(RuntimeException::new);

            if (!Objects.equals(contributorUserMatch.getMatchId(), sessionUserMatch.getMatchId()))
                throw new RuntimeException();
            matchRepository.updateMatch(
                    Match.UpdateDto.builder(match)
                            .result(true)
                            .build()
            );
            return userRepository.getUserById(contributorUserMatch.getUserId()).get().toInfoDto();
        } catch (RuntimeException e) {
            matchRepository.updateMatch(
                    Match.UpdateDto.builder(match)
                            .result(false)
                            .build()
            );
            return loginSessionManager.getLoginUserInfo();
        }
    }
}
