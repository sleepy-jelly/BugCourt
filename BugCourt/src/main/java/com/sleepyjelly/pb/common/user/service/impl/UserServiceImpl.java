package com.sleepyjelly.pb.common.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleepyjelly.pb.common.user.service.UserService;
import com.sleepyjelly.pb.common.user.service.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	

	@Override
	public UserVO selectUserByUserId(UserVO userVO) {
		UserVO findedUserVO = userMapper.selectUserByUserId(userVO);
		return findedUserVO;
	}
	
	
	

	
	
}
