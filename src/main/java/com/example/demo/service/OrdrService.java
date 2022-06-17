package com.example.demo.service;

import antung.db.wf.entity.OrdrEntity;

public interface OrdrService {

	OrdrEntity findByDocEntry(String docEntry);
}
