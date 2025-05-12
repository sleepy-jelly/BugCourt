package com.sleepyjelly.pb.bbs.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sleepyjelly.pb.bbs.service.BbsVO;

@Mapper
public interface BbsMapper {
	
	BbsVO selectDtlBbs(BbsVO bbsVO);
	
	List<BbsVO> selectBbsList(BbsVO bbsVO);
	
	void insertBbsVO(BbsVO bbsVO);
	

}
