//package com.example.demo.service.impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.mq.RabbitConfig;
//import com.example.demo.service.RabbitReceiverService;
//
//
//@Service
//public class RabbitReceiverServiceImpl implements RabbitReceiverService{
//
//	private final static Logger log = LoggerFactory.getLogger(RabbitReceiverServiceImpl.class);
//	
//	@Override
//	@RabbitListener(queues=RabbitConfig.QUEUE)
//	public void receive(String message) {
//		log.info("receive message:"+message);
//	}
//}
