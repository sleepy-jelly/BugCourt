package com.sleepyjelly.pb.common.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sleepyjelly.pb.common.base.web.BaseController;
import com.sleepyjelly.pb.common.user.service.UserService;
import com.sleepyjelly.pb.common.user.service.UserVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	@Autowired
    private PasswordEncoder passwordEncoder;
	 
	@Autowired
	private UserService userService;
	
	 
	@RequestMapping(value="/viewLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Void> login(ModelAndView mav) {
		log.info("viewLogin");
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/login/login-page")
                .build();
	}
	
	@RequestMapping(value="/viewPageRegister", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Void> viewPageRegister(ModelAndView mav) {
		log.info("viewPageRegister");
		UserVO userVO = new UserVO();
		
		userVO.setUserId("sleepyjelly");
		
		if(userService.selectUserByUserId(userVO)!=null) {
			userVO = userService.selectUserByUserId(userVO);
		};
		log.info("userVO"+userVO);

		log.info("selectUserByUserId");

		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/login/register-page")
                .build();
	}
	
	@PostMapping("/loginProcess")
	public ResponseEntity<Void> loginProcess(ModelAndView mav) {
		log.info("loginProcess");
		
		
		
		
		
		
		
		
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/bbs/algoBbs")
                .build();
	}
	
	
	

	
	
	
	
	
	
	
	
}