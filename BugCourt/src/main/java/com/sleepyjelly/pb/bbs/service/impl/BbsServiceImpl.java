package com.sleepyjelly.pb.bbs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sleepyjelly.pb.bbs.service.BbsService;
import com.sleepyjelly.pb.bbs.service.BbsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("bbsService")
public class BbsServiceImpl implements BbsService{
		
	private BbsMapper bbsMapper;
	
	@Override
	public BbsVO selectBbsByBbsId(BbsVO bbsVO) {
		BbsVO selectedBbs = bbsMapper.selectDtlBbs(bbsVO);	
		return selectedBbs;
	}

	@Override
	public void insertBbs(BbsVO bbsVO)throws Exception{
		bbsMapper.insertBbsVO(bbsVO);
	}

	@Override
	public List<BbsVO> selectBbsList(BbsVO bbsVO) {
		List<BbsVO> selectedBbsList = bbsMapper.selectBbsList(bbsVO);
		return selectedBbsList;	
	}

	
}
