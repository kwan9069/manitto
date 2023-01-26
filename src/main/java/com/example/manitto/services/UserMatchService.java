package com.example.manitto.services;

import com.example.manitto.common.Constants;
import com.example.manitto.common.LoginSessionManager;
import com.example.manitto.dtos.User;
import com.example.manitto.dtos.UserMatch;
import com.example.manitto.repositories.UserMatchRepository;
import com.example.manitto.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by jonghyeon on 2023/01/24,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class UserMatchService {
    private final UserMatchRepository userMatchRepository;

    private final UserRepository userRepository;

    private final LoginSessionManager loginSessionManager;
    public User.InfoDto getReceiverName() {
        if (!loginSessionManager.haveLoginSession()) throw new RuntimeException();
        UserMatch.ExtendedDto receiverUserMatch = userMatchRepository.getExtendedUserMatchList(Constants.STATUS_ACTIVE)
                .stream().filter(userMatch -> userMatch.getRole().equals(Constants.ROLE_RECEIVER))
                .findFirst().get();
        return userRepository.getUserById(receiverUserMatch.getUserId()).get().toInfoDto();
    }
}
