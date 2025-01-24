package com.sleepyjelly.pb.common.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sleepyjelly.pb.common.base.web.BaseController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	
	@RequestMapping(value="/viewLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Void> login(ModelAndView mav) {
		log.info("strd");
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/login/login")
                .build();
	}
	
	@PostMapping("/viewPageRegister")
	public ResponseEntity<Void> viewPageRegister(ModelAndView mav) {
		
		log.info("strd");
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/viewPageRegister")
                .build();
	}
	
	
	
	
}