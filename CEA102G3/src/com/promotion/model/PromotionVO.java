package com.promotion.model;

import java.io.Serializable;
import java.sql.Date;

public class PromotionVO implements Serializable{
	private Integer promot_No;
	private String promot_Content;
	private Date promot_Start;
	private Date promot_End;
	private Date release_Date;
	private Integer promot_Product_No;
	private Integer promot_Product_Price;
	private String promot_Product_Title;
	private byte[] promot_Product_Pic;

	
	public PromotionVO() {
	}


	public Integer getPromot_No() {
		return promot_No;
	}


	public void setPromot_No(Integer promot_No) {
		this.promot_No = promot_No;
	}


	public String getPromot_Content() {
		return promot_Content;
	}


	public void setPromot_Content(String promot_Content) {
		this.promot_Content = promot_Content;
	}


	public Date getPromot_Start() {
		return promot_Start;
	}


	public void setPromot_Start(Date promot_Start) {
		this.promot_Start = promot_Start;
	}


	public Date getPromot_End() {
		return promot_End;
	}


	public void setPromot_End(Date promot_End) {
		this.promot_End = promot_End;
	}


	public Date getRelease_Date() {
		return release_Date;
	}


	public void setRelease_Date(Date release_Date) {
		this.release_Date = release_Date;
	}


	public Integer getPromot_Product_No() {
		return promot_Product_No;
	}


	public void setPromot_Product_No(Integer promot_Product_No) {
		this.promot_Product_No = promot_Product_No;
	}


	public Integer getPromot_Product_Price() {
		return promot_Product_Price;
	}


	public void setPromot_Product_Price(Integer promot_Product_Price) {
		this.promot_Product_Price = promot_Product_Price;
	}


	public String getPromot_Product_Title() {
		return promot_Product_Title;
	}


	public void setPromot_Product_Title(String promot_Product_Title) {
		this.promot_Product_Title = promot_Product_Title;
	}


	public byte[] getPromot_Product_Pic() {
		return promot_Product_Pic;
	}


	public void setPromot_Product_Pic(byte[] promot_Product_Pic) {
		this.promot_Product_Pic = promot_Product_Pic;
	}
	
}


