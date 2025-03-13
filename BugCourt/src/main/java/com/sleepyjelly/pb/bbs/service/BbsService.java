package com.sleepyjelly.pb.bbs.service;

import org.springframework.stereotype.Service;

@Service
public interface BbsService {
	
	
	public BbsVO selectBbsByBbsId(BbsVO userVO);
	
	public int insertBbs(BbsVO userVO);
	

}
