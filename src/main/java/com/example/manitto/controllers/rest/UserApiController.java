package com.example.manitto.controllers.rest;

import com.example.manitto.dtos.User;
import com.example.manitto.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jonghyeon on 2023/01/21,
 * Package : com.example.manitto.controllers.rest
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor

public class UserApiController {
    private final UserService service;

    @PostMapping
    public void registerUser(User.RegisterDto registerDto) {
        service.registerUser(registerDto);
    }

    @PostMapping("/login")
    public void login(User.AuthDto authDto, HttpSession session){
        service.login(authDto, session);
    }
}
