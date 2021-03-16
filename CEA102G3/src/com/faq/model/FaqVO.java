package com.faq.model;

import java.sql.Date;

public class FaqVO implements java.io.Serializable{
	private Integer question_No;
	private String question;
	private String answer;
	private Date update_Time;
	
	public FaqVO() {
	}

	public Integer getQuestion_No() {
		return question_No;
	}

	public void setQuestion_No(Integer question_No) {
		this.question_No = question_No;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getUpdate_Time() {
		return update_Time;
	}

	public void setUpdate_Time(Date update_Time) {
		this.update_Time = update_Time;
	}
	
}