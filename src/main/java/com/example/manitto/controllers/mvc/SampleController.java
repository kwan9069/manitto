package com.example.manitto.controllers.mvc;

import com.example.manitto.apicall.NicknameApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sample")
@RequiredArgsConstructor
public class SampleController {
    private final Retrofit.Builder retrofitBuilder;
    @GetMapping
    public String index() throws IOException {
        Retrofit client = retrofitBuilder.baseUrl(NicknameApiService.baseUrl)
                .addConverterFactory(NicknameApiService.converter)
                .build();
        Map body = client.create(NicknameApiService.class).call("json", 10).execute().body();
        List<String> words = (List<String>) body.get("words");
        words.forEach(System.out::println);
        return "sample";
    }
}
