package com.example.manitto.controllers;

import com.example.manitto.apicall.NicknameApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {
    private final Retrofit.Builder retrofitBuilder;

    @GetMapping
    public String index(@Autowired JacksonConverterFactory converterFactory) throws IOException {
        Retrofit client = retrofitBuilder.baseUrl(NicknameApiService.baseUrl)
                .addConverterFactory(converterFactory)
                .build();
        Map<String, Object> body = client.create(NicknameApiService.class).call("json", 10).execute().body();
        Object words = body.get("words");
        ((Iterable) words).forEach(System.out::println);
        return "sample";
    }
}
