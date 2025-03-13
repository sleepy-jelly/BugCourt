package com.sleepyjelly.pb.bbs.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper=true)  
public class SearchBbsVO extends BbsVO{
	
	//Problems		PRB
	//Discuss		DSCN
	private String searchBbsDvsnCd;

	//BT == BBS_TITLE
	//FRI == FRST_REGR_ID
	private String searchKeyword;
	
	
	//BT == BBS_TITLE = searchKeyword
	//FRI == FRST_REGR_ID = searchKeyword
	private String searchCondition;
	
	
}
