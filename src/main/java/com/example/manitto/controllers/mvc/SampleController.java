package com.example.manitto.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class SampleController {
    @GetMapping
    public String index() throws IOException {
        return "sample";
    }
}
