package com.wdxxl.dao.impl;

import org.springframework.stereotype.Repository;

import com.wdxxl.dao.ISampleDao;

@Repository("sampleDao")
public class SampleDaoImpl implements ISampleDao {

	public void printSample() {
		System.out.println("SampleDao Impl Hibernate");
	}

}
