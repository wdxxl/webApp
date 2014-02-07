package com.wdxxl.dao.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.wdxxl.domain.Lov;
import com.wdxxl.test.util.SpringTransactionalTestCase;

public class LovDaoImplTestCase extends SpringTransactionalTestCase {
	@Autowired
	public LovDaoImpl lovDao;
	
	@Test
	public void testGetLovById(){
		Lov lov = lovDao.findById(1);
		assertTrue(lov.getId() == 1);
	}
	
	@Test
	@Rollback(false)
	public void testSaveLov(){
		Lov lov = new Lov();
		lov.setName("hahaha");
		lovDao.saveLov(lov);
	}
	
}
