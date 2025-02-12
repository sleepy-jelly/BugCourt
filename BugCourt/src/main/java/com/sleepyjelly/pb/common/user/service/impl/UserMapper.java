package com.sleepyjelly.pb.common.user.service.impl;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sleepyjelly.pb.common.user.service.UserVO;

@Mapper
public interface UserMapper {

	public UserVO selectUserByUserId(UserVO userVO);
	
	public int insertUserByRegiste(UserVO userVO);
	
		
	
}
