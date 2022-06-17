package com.example.demo.controller;

import java.util.Collection;
import java.util.List;

import javax.cache.CacheManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.OrdrService;

import antung.db.wf.entity.OrdrEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/test")
@Controller
public class TestController {

	@Autowired
	private OrdrService ordrService;
	
	@Autowired
	private CacheManager cacheManager;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("/hello")
    public String index(){
		
		log.info("test");
		
		String t=restTemplate.getForObject("http://localhost:8080/test1/hello1", String.class);
//		ResponseEntity<MsgVO> entity = restTemplate.getForEntity("http://localhost:8080/server/get/MsgVO", MsgVO.class);
//		  System.out.println("==>/server/get/list return: " + entity.getBody());
		
		log.info(t);
		
        return "index";
    }
	
	@RequestMapping("/hello1")
    public String newIndex(Model model,HttpServletRequest request){
		
		log.info("test1");
		
		HttpSession session = request.getSession();
		
		Object obj=session.getAttribute("secretary");
		String secretarySession=obj.toString();
		
		OrdrEntity entity=ordrService.findByDocEntry("SC2021110700001");
		
        return "newIndex";
    }
	
	@RequestMapping("/excel")
    public String excel(){
		
        return "excel";
    }
	
	@RequestMapping("/cachesClear")
    public String newIndex(){
		
		((Collection<String>) cacheManager.getCacheNames()).stream().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
        
        return "newIndex";
    }
	
}
