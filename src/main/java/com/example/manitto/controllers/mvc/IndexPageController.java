package com.example.manitto.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jonghyeon on 2023/01/26,
 * Package : com.example.manitto.controllers.mvc
 */
@Controller
@RequestMapping("/")
public class IndexPageController {
    @GetMapping
    public String index(){
        return "index";
    }
}
