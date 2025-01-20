package com.sleepyjelly.pb.common.user.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
     private final BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
     
     
}
