package com.example.manitto.services;

import com.example.manitto.common.Constants;
import com.example.manitto.common.LoginSessionManager;
import com.example.manitto.dtos.Action;
import com.example.manitto.dtos.UserMatch;
import com.example.manitto.repositories.ActionRepository;
import com.example.manitto.repositories.UserMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/25,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;

    private final UserMatchRepository userMatchRepository;

    private final LoginSessionManager loginSessionManager;

    public  List<Action.InfoDto> getMissionList() {
        UserMatch.ExtendedDto extendedDto = userMatchRepository.getExtendedUserMatchListByUserId(Constants.STATUS_ACTIVE, loginSessionManager.getLoginUserInfo().getId()).stream().findFirst().get();

        return actionRepository.getActionListByMatchIdAndType(extendedDto.getMatchId(),Constants.TYPE_MISSION).stream().map(action -> action.toInfoDto()).toList();
    }
}
