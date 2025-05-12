package com.sleepyjelly.pb.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BbsService {
	
	
	
	public BbsVO selectBbsByBbsId(BbsVO bbsVO);
	
	public List<BbsVO> selectBbsList(BbsVO bbsVO);

	
	public void insertBbs(BbsVO bbsVO) throws Exception;
	

}
