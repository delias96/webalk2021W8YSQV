package com.proba.demo.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Licit {
	private int licit;
	private Long userId;
	@Id @GeneratedValue
	private Long id;
	
	public int getLicit() {
		return licit;
	}
	public void setLicit(int licit) {
		this.licit = licit;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Licit(int licit, Long userId) {
		super();
		this.licit = licit;
		this.userId = userId;
	}
	
}
