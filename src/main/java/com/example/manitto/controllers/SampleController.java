package com.example.manitto.controllers;

import com.example.manitto.apicall.NicknameApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {
    private final NicknameApiService nicknameApiService;

    @GetMapping
    public String index() throws IOException {
        Map<String, Object> body = nicknameApiService.call("json", 10).execute().body();
        Object words = body.get("words");
        ((Iterable) words).forEach(System.out::println);
        return "sample";
    }
}
