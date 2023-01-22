package com.example.manitto.controllers.rest;

import com.example.manitto.dtos.User;
import com.example.manitto.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonghyeon on 2023/01/21,
 * Package : com.example.manitto.controllers.rest
 */
@RestController("/api/user")
@RequiredArgsConstructor
public class UserDataController {
    private final UserService service;

    @PostMapping
    public void registerUser(@RequestBody User.RegisterDto registerDto, HttpSession session) {
        User.InfoDto info = service.registerUser(registerDto);
        session.setAttribute("info", info);
    }
}
