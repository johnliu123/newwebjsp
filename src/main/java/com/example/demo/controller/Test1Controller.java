package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrdrService;
import com.example.demo.service.UnitService;

import antung.db.wf.entity.OrdrEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/test1")
@RestController
public class Test1Controller {

	@Autowired
	private UnitService unitService;
	@Autowired
	private OrdrService ordrService;
	
	@RequestMapping("/hello1")
    public String index(){
		
		log.info("123");
		
//		String result=unitService.test();
		
		OrdrEntity entity=ordrService.findByDocEntry("SC2021110700001");
		
        return "123";
    }
}
