package com.example.manitto.apicall;

import retrofit2.Call;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

/**
 * Created by jonghyeon on 2023/01/20,
 * Package : com.example.manitto.services
 */

public interface NicknameApiService {

    String baseUrl = "https://nickname.hwanmoo.kr";
    JacksonConverterFactory converter = JacksonConverterFactory.create();

    @GET("/")
    Call<Map<String, Object>> call(@Query("format") String format, @Query("count") int count);
}
