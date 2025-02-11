package com.sleepyjelly.pb.common.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sleepyjelly.pb.common.user.service.UserService;
import com.sleepyjelly.pb.common.user.service.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserVO selectUserByUserId(UserVO userVO)throws Exception {
		UserVO findedUserVO = userMapper.selectUserByUserId(userVO);
		return findedUserVO;
	}


	@Override
	public void insertUserByRegiste(UserVO userVO) throws Exception {
		UserVO tmpUserVO = userMapper.selectUserByUserId(userVO);

		if(tmpUserVO.getUserId().equals(userVO.getUserId())) {
			throw new RuntimeException("userId(username) is taken");
		}
		
		passwordEncoder.encode(userVO.getUserPw());
		
		
		userMapper.selectUserByUserId(userVO);

		 
		
		
		
	}
	
	
	

	
	
}
