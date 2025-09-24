package com.sleepyjelly.pb.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration	
@PropertySource({"classpath:/config/config.properties"})
public class CustomConfig {
	
	boolean isLocal = true;
	
	@Autowired
	private Environment env;

	public String getFileUploadPath() {
		return env.getProperty("file.upload.path");
	}

	public String getFileAllowedExt() {
		return env.getProperty("file.allowed.ext");
	}
	
	public boolean getIsLocal() {
		boolean isLocal = true;
		
		if(!env.getProperty("is.local").equals("true")) {
			isLocal = false;
		}
		
		this.isLocal = isLocal;
		
		return isLocal;
	}
	
	public String getUrl() {
		String url;
		if(isLocal){
			url=env.getProperty("local.codex.api.url");
		}else {
			url=env.getProperty("prd.codex.api.url");
		}
		
		return url;
	}

}