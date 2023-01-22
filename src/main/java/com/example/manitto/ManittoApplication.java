package com.example.manitto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.example.manitto.repositories")
public class ManittoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManittoApplication.class, args);
    }

    @Bean
    public Retrofit.Builder retrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Bean
    public JacksonConverterFactory jacksonConverterFactory() {
        return JacksonConverterFactory.create();
    }

    @Bean
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }
}
