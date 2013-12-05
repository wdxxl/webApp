package com.wdxxl.dao.hibernate.impl;

import org.springframework.stereotype.Repository;

import com.wdxxl.dao.ISampleDao;

@Repository("sampleDao")
public class SampleDaoImplHibernate implements ISampleDao {

	public void printSample() {
		System.out.println("SampleDao Impl Hibernate");
	}

}
