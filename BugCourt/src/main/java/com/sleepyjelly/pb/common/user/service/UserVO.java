package com.sleepyjelly.pb.common.user.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.sleepyjelly.pb.common.base.web.BaseVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVO extends BaseVO{

	private String userId;

    private String userPw;
    
    private String userNm;
    
    private String userDc;
    
    private String userEmail;
    
    private String userPhone;
    
    private String userCmpny;
    
    private String userGithubLink;
    
    private String userPermission;
    
    private String userStatus;
    
    private long fileGrpSn;
    
    private String user2FactorYn;
    
    private String user2FactorKey;
    
    // Represents an authority granted to an Authentication object. 
    private List<GrantedAuthority> securityAuthList;
    
    

}
