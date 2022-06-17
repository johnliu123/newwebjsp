//package com.example.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.service.RabbitMqService;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RequestMapping("/mq")
//@RestController
//public class RabbitMqController {
//
//	@Autowired
//	private RabbitMqService rabbitMqService;
//	
//	@RequestMapping("/hello")
//    public String index(String msg){
//		rabbitMqService.send(msg);
//		return "發送成功";
//	}
//}
