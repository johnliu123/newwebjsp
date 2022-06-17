package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.service.OrdrService;

import antung.db.wf.dao.OrdrDao;
import antung.db.wf.entity.OrdrEntity;

@Service
@CacheConfig(cacheNames = "Ordr")
public class OrdrServiceImpl implements OrdrService{

	@Autowired
	private OrdrDao ordrDao;
	
	@Cacheable(key = "#docEntry")
	@Override
	public OrdrEntity findByDocEntry(String docEntry){
		
		return ordrDao.findByDocEntry(docEntry);
	}
}
