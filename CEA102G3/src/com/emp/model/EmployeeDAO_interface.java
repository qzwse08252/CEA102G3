package com.emp.model;

import java.util.List;

public interface EmployeeDAO_interface {
	public void insert(EmployeeVO employeeVO);
	public void update(EmployeeVO employeeVO);
	public void delete(Integer emplo_No);
	public EmployeeVO findByPrimaryKey(Integer emplo_No);
    public EmployeeVO findByAccount(String account);
//	public EmployeeVO findByNewsTitle(String news_title);

	public List<EmployeeVO> getAll();
}

