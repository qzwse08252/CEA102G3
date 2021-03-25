package com.emp.model;

import java.io.Serializable;
import java.sql.Date;

import com.sun.mail.iap.ByteArray;

public class EmployeeVO implements Serializable{
	private Integer emplo_No;
	private String account;
	private String password;
	private String name;
	private Integer sex;
	private String phone;
	private String email;
	private Date start_From;
	private Integer emp_State;
	private byte[] emp_Pic;

	public EmployeeVO() {
	}

	public Integer getEmplo_No() {
		return emplo_No;
	}

	public void setEmplo_No(Integer emplo_No) {
		this.emplo_No = emplo_No;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getStart_From() {
		return start_From;
	}

	public void setStart_From(Date start_From) {
		this.start_From = start_From;
	}

	public Integer getEmp_State() {
		return emp_State;
	}

	public void setEmp_State(Integer emp_State) {
		this.emp_State = emp_State;
	}

	public byte[] getEmp_Pic() {
		return emp_Pic;
	}

	public void setEmp_Pic(byte[] emp_Pic) {
		this.emp_Pic = emp_Pic;
	}
	
}