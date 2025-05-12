package com.sleepyjelly.pb.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sleepyjelly.pb.bbs.service.BbsService;
import com.sleepyjelly.pb.common.base.web.BaseController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/bbs")
public class BbsController extends BaseController{

	@Autowired		
	BbsService bbsService;

	@GetMapping(value="/viewBbsList")
	public ResponseEntity<Void> viewBbsList(ModelAndView mav) throws Exception {
		log.info("viewBbsList");
		
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/bbs/bbs-list-page")
                .build();
	}
	
	
	
	
	
	
	@PostMapping(value="/selectBbsList")
	public ResponseEntity<Void> selectBbsList(ModelAndView mav) throws Exception {
		log.info("viewBbsList");
		
		
		return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", "http://localhost:5173/bbs/bbs-list-page")
                .build();
		
		
	}
	
	
	
	
	
	
	
}
