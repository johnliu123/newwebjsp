//package com.example.demo.service.impl;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.mq.RabbitConfig;
//import com.example.demo.service.RabbitMqService;
//
//@Service
//public class RabbitMqServiceImpl  implements RabbitMqService{
//
//	@Autowired
//	private AmqpTemplate amqpTemplate;
//	
//	
//	@Override
//	public void send(Object message) {
//		
//		for(int i=0;i<10;i++) {
//			amqpTemplate.convertAndSend(RabbitConfig.QUEUE,message);
//		}
//		
//		
//	}
//	
//}
