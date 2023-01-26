package com.example.manitto.controllers.mvc;

import com.example.manitto.common.LoginSessionManager;

import com.example.manitto.dtos.User;
import com.example.manitto.services.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView getAllUseLis(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		//몇페이지 구성 선택 가능 보여주는 링크 
		//1.select count(*) from board=int-nil 저장
		//2.select * from board limit (page -1)*3,3-list-model 저장
		//3.board/list 뷰 	
    	int totalboard = userService.getTotalUser();
		int limit = (page-1)*5;
		List<User.InfoDto> userList = userService.getAllUserList(limit);
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("list",userList);
		mv.setViewName("admin/userrev");
		return mv;
	}
}
