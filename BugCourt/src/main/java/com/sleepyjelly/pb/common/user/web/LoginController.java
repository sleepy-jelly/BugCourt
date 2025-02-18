package com.sleepyjelly.pb.common.user.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	private UserService userService;
	
	 
	@RequestMapping(value="/viewLogin", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Void> login(ModelAndView mav) {
		log.info("viewLogin");
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/login/login-page")
                .build();
	}
	
	
	@RequestMapping(value="/loginSuccessful", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Map<String, String>>  loginSuccessful() throws Exception {
		log.info("loginSuccessful");
		
		Map<String, String> resultMap = new HashMap<String, String>();
		
		resultMap.put("ReturnMessage", "Sucessful");
		
		
		
		resultMap.put("Redirect", "/login-page");
		
		
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		log.info("loginSuccessful --> username ->{}",username);
		
//
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("Origin", "http://localhost:5173")
				.body((resultMap));
			
	}
	

	@RequestMapping(value="/viewPageRegister", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Void> viewPageRegister(ModelAndView mav) throws Exception {
		log.info("viewPageRegister");
		

		return ResponseEntity.status(HttpStatus.OK)
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
	 				.header("Location", "http://localhost:5173/login/login-page")
	 				.build();
		}

		return ResponseEntity.status(HttpStatus.FOUND)
	        .header("Location", "http://localhost:5173/login/login-page")
	        .build();

	}
	
	 /**
     * check user if Authenticated
     * 
     * @return Authenticated(TRUE / FALSE)
     */
    public static Boolean isAuthenticated() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if (Objects.isNull(authentication)) {
        	log.debug("## authentication object is null!!");
            return Boolean.FALSE;
        }

        String username = authentication.getName();
        if (username.equals("anonymousUser")) {		
        	log.debug("## username is {}", username);
            return Boolean.FALSE;
        }

        Object principal = authentication.getPrincipal();

        return (Boolean.valueOf(!Objects.isNull(principal)));
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