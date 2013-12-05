package com.wdxxl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdxxl.dao.ISampleDao;
import com.wdxxl.service.ISampleService;

@Service
public class SampleServiceImpl implements ISampleService {

	@Autowired
	private ISampleDao sampleDao;
	
	public void printSample() {
		sampleDao.printSample();
		System.out.println("SampleServiceImpl");
	}

}
