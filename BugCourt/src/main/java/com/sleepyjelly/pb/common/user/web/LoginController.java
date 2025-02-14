package com.sleepyjelly.pb.common.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sleepyjelly.pb.common.base.web.BaseController;
import com.sleepyjelly.pb.common.user.service.UserService;
import com.sleepyjelly.pb.common.user.service.UserVO;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	@Autowired
    private PasswordEncoder pwEncoder;
	 
	@Autowired
	private UserService userService;
	
	 
	@RequestMapping(value="/viewLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Void> login(ModelAndView mav) {
		log.info("viewLogin");
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/login/login-page")
                .build();
	}
	
	
	@PostMapping("/loginProcess")
	public ResponseEntity<Void> loginProcess(@RequestBody UserVO userVO, ModelAndView mav) throws Exception {
		log.info("loginProcess");
		log.info("userVO");

		
		UserVO compareUserVO =  userService.selectUserByUserId(userVO);
		
		boolean isMatches = pwEncoder.matches(userVO.getUserPw(), compareUserVO.getUserPw());
		
		
//		Authentication authentication = SecurityContextHolder.getContext().getJAJAuthentication();
//        String email = authentication.getName();
//        String authorities = authentication.getAuthorities().toString();
//
//        log.info("로그인한 유저 이메일:" + email);
//        log.info("유저 권한:" + authentication.getAuthorities());
//
//        Map<String, String> userInfo = new HashMap<>();
//        userInfo.put("email", email);
//        userInfo.put("authorities", authorities);
//        
        
		
		
		if(isMatches) {
				
			return ResponseEntity.status(HttpStatus.ACCEPTED)
	                .header("Location", "http://localhost:5173/bbs/algoBbs")
	                .build();
				
		}
		
		
		return ResponseEntity.status(500)
                .header("Location", "http://localhost:5173/login/login-page")
                .build();
		
		
	}
	
	
	
	
	
	@RequestMapping(value="/viewPageRegister", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Void> viewPageRegister(ModelAndView mav) throws Exception {
		log.info("viewPageRegister");
		

		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/login/register-page")
                .build();
	}
	
	
	
	@PostMapping(value="/registerProcess")
	public ResponseEntity<String> registerProcess(@RequestBody @Valid UserVO userVO, ModelAndView mav, BindingResult bindingResult)  {
		if (bindingResult.hasErrors()) {
	        List<FieldError> list = bindingResult.getFieldErrors();
	        for(FieldError error : list) {
	            return new ResponseEntity<String>(error.getDefaultMessage() , HttpStatus.BAD_REQUEST);
	        }
	    }
		
		log.info("registerProcess");
		
		
		try {
			userService.insertUserByRegiste(userVO);
		} catch (Exception e) {
			e.printStackTrace();
	 		return ResponseEntity.status(500)
	 				.header("Location", "http://localhost:5173/login/login-page").build();
		}

		return ResponseEntity.status(HttpStatus.FOUND)
	        .header("Location", "http://localhost:5173/login/login-page")
	        .build();

	}
	
	

	

	
	
//	
//	UserVO userVO = new UserVO();
//	
//	userVO.setUserId("sleepyjelly");
//	
//	if(userService.selectUserByUserId(userVO)!=null) {
//		userVO = userService.selectUserByUserId(userVO);
//	};
//	log.info("userVO"+userVO);
//
//	log.info("selectUserByUserId");
	
	
	
	
}