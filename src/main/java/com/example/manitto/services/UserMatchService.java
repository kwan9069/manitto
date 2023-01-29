package com.example.manitto.services;

import com.example.manitto.common.Constants;
import com.example.manitto.common.LoginSessionManager;
import com.example.manitto.dtos.UserMatch;
import com.example.manitto.repositories.UserMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/24,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class UserMatchService {
    private final UserMatchRepository userMatchRepository;

    private final LoginSessionManager loginSessionManager;

    public UserMatch.ExtendedDto getUserMatchBySession() {
        long sessionId = loginSessionManager.getLoginUserInfo().getId();
        UserMatch.ExtendedDto userMatchBySession = userMatchRepository.getExtendedUserMatchListByUserId(Constants.STATUS_ACTIVE, sessionId).stream().findFirst().get();
        return userMatchRepository.getExtendedUserMatchListByMatchId(Constants.STATUS_ACTIVE,userMatchBySession.getMatchId()).stream()
                .filter(extendedDto -> extendedDto.getUserId() != sessionId).findFirst().get();
    }

    public List<UserMatch.ExtendedDto> getUserMatchByMatchId(long matchId) {
        return userMatchRepository.getExtendedUserMatchListByMatchId(Constants.STATUS_ACTIVE,matchId);
    }
}
