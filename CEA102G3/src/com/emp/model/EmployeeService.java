package com.emp.model;

import java.sql.Date;
import java.util.List;



public class EmployeeService {
	private EmployeeDAO_interface dao;

	public EmployeeService() {

		dao = new EmployeeDAO();
		
	}

	public EmployeeVO addEmployee(String account, String password, String name,
			Integer sex, String phone, String email, Date start_From, Integer emp_State, byte[] emp_Pic) {
		
		EmployeeVO employeeVO = new EmployeeVO();

		employeeVO.setAccount(account);
		employeeVO.setPassword(password);
		employeeVO.setName(name);
		employeeVO.setSex(sex);
		employeeVO.setPhone(phone);
		employeeVO.setEmail(email);
		employeeVO.setStart_From(start_From);
		employeeVO.setEmp_State(emp_State);
		employeeVO.setEmp_Pic(emp_Pic);
		
		dao.insert(employeeVO);
		return employeeVO;
	}
	

	public EmployeeVO updateEmployee(Integer emplo_No, String account, String name, Integer sex, String phone, String email, Date start_From, Integer emp_State, byte[] emp_Pic) {
		
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setEmplo_No(emplo_No);
		employeeVO.setAccount(account);
//		employeeVO.setPassword(password);
		employeeVO.setName(name);
		employeeVO.setSex(sex);
		employeeVO.setPhone(phone);
		employeeVO.setEmail(email);
		employeeVO.setStart_From(start_From);
		employeeVO.setEmp_State(emp_State);
		employeeVO.setEmp_Pic(emp_Pic);
		
		dao.update(employeeVO);
		return employeeVO;
	}
	
	public void deleteEmployee(Integer emplo_No) {
		dao.delete(emplo_No);
	}
	
		
		public EmployeeVO getOneEmployee(Integer emplo_No) {
			return dao.findByPrimaryKey(emplo_No);
		}

		public List<EmployeeVO> getAll() {
			return dao.getAll();
		}

		public EmployeeVO getOneByAccount(String account) {
			return dao.findByAccount(account);
		}
		
	}
