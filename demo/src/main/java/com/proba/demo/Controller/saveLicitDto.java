package com.proba.demo.Controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class saveLicitDto {
	
	@NotNull @Min(1)
	Long userId;
	@NotNull @Min(1)
	Integer Licit;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getLicit() {
		return Licit;
	}
	public void setLicit(Integer licit) {
		Licit = licit;
	}
	@Override
	public String toString() {
		return "saveLicitDto [userId=" + userId + ", Licit=" + Licit + "]";
	}
	
	
}
