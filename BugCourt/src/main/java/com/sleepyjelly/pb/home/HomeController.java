package com.sleepyjelly.pb.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sleepyjelly.pb.common.base.web.BaseController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

	
	@GetMapping("/login")
	@PostMapping("/login")
	public String viewHome(ModelAndView mav) {
		
		mav.addObject("asdf", "123");
		
		mav.setViewName("thymeleaf/login");
		
		return "thymeleaf/login";
	}
	
	@PostMapping("/pages-register")
	public String viewPagesRegister(ModelAndView mav) {
		
		mav.addObject("asdf", "123");
		
		mav.setViewName("thymeleaf/login");
		
		return "thymeleaf/login";
	}
	
 
}