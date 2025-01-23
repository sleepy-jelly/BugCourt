package com.sleepyjelly.pb.common.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sleepyjelly.pb.common.base.web.BaseController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	
	@GetMapping("/viewLogin")
	@PostMapping("/viewLogin")
	public String viewHome(ModelAndView mav) {
		
		mav.addObject("asdf", "123");
		
		mav.setViewName("thymeleaf/login");
		
		return "thymeleaf/user/login";
	}
	
	@PostMapping("/pages-register")
	public String viewPagesRegister(ModelAndView mav) {
		
		mav.addObject("asdf", "123");
		
		mav.setViewName("thymeleaf/login");
		//test for codeQL
		//test for ci with maven
		return "thymeleaf/user/login";
	}
	
	@GetMapping("/login/viewLogin")
	@PostMapping("/login/viewLogin")
	public ResponseEntity<Void> login(ModelAndView mav) {
		log.info("strd");
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/index")
                .build();
		
	}
	
	
}