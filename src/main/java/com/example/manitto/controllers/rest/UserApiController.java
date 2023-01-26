package com.example.manitto.controllers.rest;

import com.example.manitto.common.LoginSessionManager;
import com.example.manitto.dtos.User;
import com.example.manitto.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jonghyeon on 2023/01/21,
 * Package : com.example.manitto.controllers.rest
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor

public class UserApiController {
    private final UserService service;

    private final LoginSessionManager loginSessionManager;

    @PostMapping
    public void registerUser(User.RegisterDto registerDto) {
        service.registerUser(registerDto);
    }

    @PostMapping("/login")
    public void login(User.AuthDto authDto) {
        service.login(authDto);
    }

    @PutMapping("/role")
    public String getUserRole() {
        User.InfoDto info = loginSessionManager.getLoginUserInfo();
        return service.getUserRole(info.getId());
    }
    @GetMapping("/logout")
    public void logout(){
        loginSessionManager.removeLoginUserInfo();
    }

    @GetMapping("/list")
    public List<User.InfoDto> getUserList(){
        return service.getUserList();
    }
}
