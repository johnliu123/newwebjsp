package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService{

	@Override
	public String test() {
	
		String value="test";
		return value;
		
	}
	
}
