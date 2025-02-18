package com.sleepyjelly.pb.common.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		log.info("selectUserByUserId ->{}",findedUserVO);
		return findedUserVO;
	}


	@Override
	public void insertUserByRegiste(UserVO userVO) throws Exception {
		
		UserVO tmpUserVO = new UserVO();
		
		tmpUserVO.setUserId(userVO.getUserId());
		tmpUserVO =	selectUserByUserId(userVO);	// select userVO for check if user name Taken

		if(tmpUserVO != null && tmpUserVO.getUserId().equals(userVO.getUserId())) {
			throw new DataIntegrityViolationException("userId(username) is taken");
		}
		 
		passwordEncoder.encode(userVO.getUserPw());
		
		log.info("tmpUserVO =>{}",tmpUserVO);
		log.info("insertUserByRegiste =>{}",userVO);

		int commited = userMapper.insertUserByRegiste(userVO);

		if(commited==0) {
			throw new DataIntegrityViolationException("userId(username) is taken");
		}
		 
		
		
	}
	
	
	

	
	
}
