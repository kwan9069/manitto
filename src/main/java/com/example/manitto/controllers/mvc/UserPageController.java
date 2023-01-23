package com.example.manitto.controllers.mvc;

import com.example.manitto.dtos.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jonghyeon on 2023/01/21,
 * Package : com.example.manitto.controllers.mvc
 */
@Controller
@RequestMapping("/user")
public class UserPageController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/main")
    public String mainPage(HttpSession session){
        User.InfoDto info = (User.InfoDto) session.getAttribute("info");
        if (info == null) return loginPage();
        if (!info.getAwareRole()) return "role-check";
        return "main";
    }
}
