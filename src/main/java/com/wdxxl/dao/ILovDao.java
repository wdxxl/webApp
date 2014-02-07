package com.wdxxl.dao;

import com.wdxxl.domain.Lov;

public interface ILovDao {
	Lov getLovById(Integer id);
	void saveLov(Lov lov);
}
