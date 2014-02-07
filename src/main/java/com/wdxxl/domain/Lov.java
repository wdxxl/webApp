package com.wdxxl.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the lov database table.
 * 
 */
@Entity
public class Lov implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	public Lov() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}