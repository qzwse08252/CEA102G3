package com.functions.model;

import java.io.Serializable;
import java.sql.Date;

public class FunctionsVO implements Serializable{
	private Integer funct_No;
	private String funct_Name;
	
	public FunctionsVO() {
	}
	
	public Integer getFunct_No() {
		return funct_No;
	}
	public void setFunct_No(Integer funct_No) {
		this.funct_No = funct_No;
	}
	public String getFunct_Name() {
		return funct_Name;
	}
	public void setFunct_Name(String funct_Name) {
		this.funct_Name = funct_Name;
	}
}

	