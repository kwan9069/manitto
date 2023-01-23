package com.example.manitto.services;

import com.example.manitto.Constants;
import com.example.manitto.apicall.NicknameApiService;
import com.example.manitto.dtos.User;
import com.example.manitto.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by jonghyeon on 2023/01/22,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final NicknameApiService nicknameApiService;

    public void registerUser(User.RegisterDto registerDto) {
        if (repository.isExistUsername(registerDto.getUsername())) throw new RuntimeException();
        if (repository.isExistEmail(registerDto.getEmail())) throw new RuntimeException();
        repository.registerUser(registerDto);
        User user = repository.getUserByUsername(registerDto.getUsername()).get();
        Map<String, Object> callResultBody;
        try {
            callResultBody = nicknameApiService.call("json", 1).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e); // TODO: 2023/01/22 api call error handling
        }
        String randomName = ((List<String>) callResultBody.get("words")).stream().findFirst().get();
        User.UpdateDto updateDto = user.generateUpdateDto(User.UpdateDto.builder()
                .randomName(randomName)
                .role(Constants.ROLE_NONE)
                .build());
        repository.updateUser(updateDto);
    }

    public void login(User.AuthDto authDto, HttpSession session) {
        User find = repository.getUserByUsername(authDto.getUsername()).orElseThrow(() -> new RuntimeException());
        if (!find.getPassword().equals(authDto.getPassword())) throw new RuntimeException();
        session.setAttribute("info", find.toInfoDto());
    }
}
