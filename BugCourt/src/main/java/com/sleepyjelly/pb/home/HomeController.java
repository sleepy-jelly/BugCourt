package com.sleepyjelly.pb.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sleepyjelly.pb.common.base.web.BaseController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

	@GetMapping("/viewHome")
	@PostMapping("/viewHome")
	public String test(Model model) {
		
		model.addAttribute("name", "asdb");
		
		return "thymeleaf/login";
	}
 
}