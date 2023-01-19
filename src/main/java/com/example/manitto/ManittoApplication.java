package com.example.manitto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableScheduling
@SpringBootApplication
public class ManittoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManittoApplication.class, args);
    }

}
