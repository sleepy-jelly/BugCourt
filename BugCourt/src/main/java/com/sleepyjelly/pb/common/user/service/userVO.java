package com.sleepyjelly.pb.common.user.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class userVO {

	private String userId;

    private String userPw;
    
    private String userNm;
    
    private String userDc;
    
    private String userEmail;
    
    private String userPhone;
    
    private String userCmpny;
    
    

}
