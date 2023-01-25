package com.example.manitto.controllers.rest;

import com.example.manitto.services.UserMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonghyeon on 2023/01/25,
 * Package : com.example.manitto.controllers.rest
 */
@RestController("/api/user-match")
@RequiredArgsConstructor
public class UserMatchApiController {
    private final UserMatchService userMatchService;
}
