package com.sleepyjelly.pb.bbs.service;

import com.sleepyjelly.pb.common.base.web.BaseVO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString  
public class BbsVO extends BaseVO{
	
    @NotBlank(message = "bbsSn(bbsSn) can't be empty.")
	private Long bbsSn;
	
	private String bbsDvsnCd;
	
	@NotBlank(message = "Title can't be empty.")
	private String bbsTitle;
	
	@NotBlank(message = "Context can't be empty.")
	private String bbsCn;
	
	private String bbsStatus;		//Status has 
	
	private long views;
	
	private long respnsSn;
	
	private String delYn;
	
	private String testCaseEx;
	
	private long fileGrpSn;
	
	private String bbsTag;
	
	
	
}
