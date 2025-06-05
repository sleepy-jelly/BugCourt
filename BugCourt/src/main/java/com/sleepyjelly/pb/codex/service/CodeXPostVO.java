package com.sleepyjelly.pb.codex.service;

import com.sleepyjelly.pb.common.base.web.BaseVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * VO For posting codeX-API 
 * 
 */
@Getter
@Setter
@ToString
public class CodeXPostVO extends BaseVO{
	
	private long bbsAnswerSn;

	private String answerCn;
	
	private String isCorrect;
	
	private String errorLog;
	
	private String lang;
	
	private String sttus;
	
	
	//////////////
	// TN_BBS	
	//////////////
	private long bbsSn;

	
	
	
	
	
	
	
	

}