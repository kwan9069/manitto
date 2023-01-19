package com.example.manitto.controllers;

import com.example.manitto.api.call.NicknameApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/")
public class SampleController {
    @GetMapping
    @ResponseBody
    public Object index() throws IOException {
        Retrofit apiClient = new Retrofit.Builder()
                .baseUrl(NicknameApiService.baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        Response<Map> response = apiClient.create(NicknameApiService.class).call("json", 20).execute();
        return response.body();

    }
}
