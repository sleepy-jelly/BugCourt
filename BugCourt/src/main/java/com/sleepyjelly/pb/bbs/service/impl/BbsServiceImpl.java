package com.sleepyjelly.pb.bbs.service.impl;

import org.springframework.stereotype.Service;

import com.sleepyjelly.pb.bbs.service.BbsService;
import com.sleepyjelly.pb.bbs.service.BbsVO;
import com.sleepyjelly.pb.common.user.service.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("bbsService")
public class BbsServiceImpl implements BbsService{@Override
	
	public BbsVO selectBbsByBbsId(BbsVO userVO) {
		return null;
	}

	@Override
	public int insertBbs(BbsVO userVO) {
		return 0;
	}

		

	
}
