package com.sleepyjelly.pb.bbs.service.impl;

import org.apache.ibatis.annotations.Mapper;

import com.sleepyjelly.pb.bbs.service.BbsVO;

@Mapper
public interface BbsMapper {
	
	BbsVO selectDtlBbs(BbsVO bbsVO);

}
