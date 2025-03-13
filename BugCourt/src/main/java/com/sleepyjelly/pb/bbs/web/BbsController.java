package com.sleepyjelly.pb.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sleepyjelly.pb.bbs.service.BbsService;
import com.sleepyjelly.pb.common.base.web.BaseController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/bbs")
public class BbsController extends BaseController{

	@Autowired
	BbsService bbsService;
	
	
	
	
	

	
	
}
