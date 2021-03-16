package com.news.model;

import java.io.Serializable;
import java.sql.Date;

import com.sun.mail.iap.ByteArray;

public class NewsVO implements Serializable{
	private Integer news_No;
	private String news_Content;
	private Date release_Date;
	private String news_Title;
	private byte[] news_Pic;

	public NewsVO() {
	}

	public Integer getNews_No() {
		return news_No;
	}

	public void setNews_No(Integer news_No) {
		this.news_No = news_No;
	}

	public String getNews_Content() {
		return news_Content;
	}

	public void setNews_Content(String news_Content) {
		this.news_Content = news_Content;
	}

	public Date getRelease_Date() {
		return release_Date;
	}

	public void setRelease_Date(Date release_Date) {
		this.release_Date = release_Date;
	}

	public String getNews_Title() {
		return news_Title;
	}

	public void setNews_Title(String news_Title) {
		this.news_Title = news_Title;
	}

	public byte[] getNews_Pic() {
		return news_Pic;
	}

	public void setNews_Pic(byte[] news_Pic) {
		this.news_Pic = news_Pic;
	}
	
}
