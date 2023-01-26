package com.example.manitto.services;

import com.example.manitto.apicall.NicknameApiService;
import com.example.manitto.common.Constants;
import com.example.manitto.common.LoginSessionManager;
import com.example.manitto.dtos.User;
import com.example.manitto.repositories.UserMatchRepository;
import com.example.manitto.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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
        User.UpdateDto updateDto = user.generateUpdateDto(User.UpdateDto.builder()
                .randomName(randomName)
                .role(Constants.ROLE_NONE)
                .build());
        userRepository.updateUser(updateDto);
    }

    public void login(User.AuthDto authDto) {
        User find = userRepository.getUserByUsername(authDto.getUsername()).orElseThrow(RuntimeException::new); // TODO: 2023/01/24 Not Found User 핸들링
        if (!BCrypt.checkpw(authDto.getPassword(), find.getPassword()))
            throw new RuntimeException(); // TODO: 2023/01/24 Incorrect Password 핸들링
        loginSessionManager.setLoginUserInfo(find.toInfoDto());
    }

    public String getUserRole(long id) {
        User user = userRepository.getUserById(id).get();
        if (user.getAwareRole()) return user.getRole();
        AtomicReference<String> role = new AtomicReference<>(Constants.ROLE_NONE);
        userMatchRepository.getUserMatchByUserId(false, user.getId())
                .stream().findFirst().ifPresentOrElse(userMatch -> {
                    if (userMatch.getIsContributor()) role.set(Constants.ROLE_CONTRIBUTOR);
                    if (userMatch.getIsReceiver()) role.set(Constants.ROLE_RECEIVER);
                }, () -> {
                });
        userRepository.updateUser(user.generateUpdateDto(User.UpdateDto.builder()
                .role(role.get())
                .awareRole(true)
                .build()));
        User updated = userRepository.getUserById(id).get();
        loginSessionManager.updateLoginUserInfo(updated.toInfoDto());
        return role.get();
    }
    public List<User.InfoDto> getAllUserList() {
    List<User.InfoDto> list = new ArrayList<>();
    userRepository.getAllUserList().forEach(user  -> list.add(user.toInfoDto()));
    return list;
    }
    public String getTotalUser() {
    
    	return userRepository.getAllUserList();
    }
}
