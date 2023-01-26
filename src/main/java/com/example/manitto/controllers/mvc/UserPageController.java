package com.example.manitto.controllers.mvc;

import com.example.manitto.common.LoginSessionManager;
import com.example.manitto.dtos.User;
import com.example.manitto.services.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jonghyeon on 2023/01/21,
 * Package : com.example.manitto.controllers.mvc
 */
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserPageController {
	
	private final UserService userService;
    private final LoginSessionManager loginSessionManager;

    @GetMapping("/login")
    public String loginPage() {
        System.out.println(loginSessionManager.getSession().hashCode());
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/main")
    public String mainPage() {
        User.InfoDto info = loginSessionManager.getLoginUserInfo();
        if (info == null) return loginPage();
        if (!info.getAwareRole()) return "role-check";
        if (info.getIsAdmin()) return "admin";
        return "main";
    }
    
    @GetMapping("/userrev") 
    public ModelAndView getAllUserList(){
    	List<User.InfoDto> userList =   userService.getAllUserList();
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("userList", userList);
    	mv.setViewName("admin/userrev");
    	return mv;
    }
}
