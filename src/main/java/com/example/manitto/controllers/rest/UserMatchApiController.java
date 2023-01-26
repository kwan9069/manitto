package com.example.manitto.controllers.rest;

import com.example.manitto.dtos.User;
import com.example.manitto.services.UserMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonghyeon on 2023/01/25,
 * Package : com.example.manitto.controllers.rest
 */
@RestController
@RequestMapping("/api/user-match")
@RequiredArgsConstructor
public class UserMatchApiController {
    private final UserMatchService userMatchService;

    @GetMapping("/receiver")
    public User.InfoDto getReceiverName(){
        return userMatchService.getReceiverName();
    }
}
