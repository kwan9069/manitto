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
    private final UserService userService;

    private final LoginSessionManager loginSessionManager;

    @PostMapping
    public void registerUser(User.RegisterDto registerDto) {
        userService.registerUser(registerDto);
    }

    @PostMapping("/login")
    public void login(User.AuthDto authDto) {
        userService.login(authDto);
    }

    @PutMapping("/role")
    public String getUserRole() {
        User.InfoDto info = loginSessionManager.getLoginUserInfo();
        return userService.getUserRole(info.getId());
    }
    @GetMapping("/logout")
    public void logout(){
        loginSessionManager.removeLoginUserInfo();
    }

    @GetMapping("/list")
    public List<User.InfoDto> getUserList(){
        return userService.getUserList();
    }

    @GetMapping("/receiver")
    public User.InfoDto getReceiver(){
        return userService.getReceiver();
    }

    @PutMapping("/contributor/{checkId}")
    public User.InfoDto getContributor(@PathVariable long checkId){
        return userService.getContributor(checkId);
    }
}
