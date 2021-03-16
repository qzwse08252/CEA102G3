package com.emp.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.emp.model.EmployeeService;
import com.emp.model.EmployeeVO;



//@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@MultipartConfig
public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_news_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("emplo_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�̷s����ID");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer emplo_No = null;
				try {
					emplo_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�̷s����ID�榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				
				/***************************2.�}�l�d�߸��*****************************************/
				EmployeeService empSvc = new EmployeeService();
				EmployeeVO employeeVO = empSvc.getOneEmployee(emplo_No);
				if (employeeVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("employeeVO", employeeVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/front-end/employee/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneNews.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllNews.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer emplo_No = new Integer(req.getParameter("emplo_No"));
			
				/***************************2.�}�l�d�߸��****************************************/
				EmployeeService empSvc = new EmployeeService();
				EmployeeVO employeeVO = empSvc.getOneEmployee(emplo_No);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("employeeVO", employeeVO);         // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/front-end/employee/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_news_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		

		if ("update".equals(action)) { // �Ӧ�update_news_input.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer emplo_No = new Integer(req.getParameter("emplo_No").trim());
	

				
				String account = req.getParameter("account").trim();
				if (account == null || account.trim().length() == 0) {
					errorMsgs.add("�b��ФŪť�!");
				}	
				

				
//				String password = req.getParameter("password").trim();
//				if (password == null || password.trim().length() == 0) {
//					errorMsgs.add("�K�X�ФŪť�!");
//				}	
				

				String name = req.getParameter("name");
//				String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (name == null || name.trim().length() == 0) {
//					errorMsgs.add("���u�m�W�ФŪť�!");
//				} else if(!name.trim().matches(nameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb2��10����");
//	            }
				
				
				Integer sex = new Integer(req.getParameter("sex").trim());

				String phone = req.getParameter("phone").trim();
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("�q�ܽФŪť�");
				}
				
				String email = null;
				try {
					email = new String(req.getParameter("email").trim());
					String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				} catch (NumberFormatException e) {
					email = "email�ФŪť�";
					errorMsgs.add("�нT�{��Jemail�榡�O�_�����~");
				}
				

				java.sql.Date start_From = null;
				try {
					start_From = java.sql.Date.valueOf(req.getParameter("start_From").trim());
				} catch (IllegalArgumentException e) {
					start_From=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J�N¾���!");
				}
				
				Integer emp_State = new Integer(req.getParameter("emp_State").trim());

				
				byte[] emp_Pic=null;
				try {
					Part Emp_Pic = req.getPart("emp_Pic");
					InputStream in = Emp_Pic.getInputStream();
					emp_Pic = new byte[in.available()];
					in.read(emp_Pic);
					in.close();
					System.out.println("buffer length: " + emp_Pic.length);
				} catch (Exception e) {

					errorMsgs.add("error");
				}
				


				EmployeeVO employeeVO = new EmployeeVO();
				employeeVO.setEmplo_No(emplo_No);
				employeeVO.setAccount(account);
//				employeeVO.setPassword(password);
				employeeVO.setName(name);
				employeeVO.setSex(sex);
				employeeVO.setPhone(phone);
				employeeVO.setEmail(email);
				employeeVO.setStart_From(start_From);
				employeeVO.setEmp_State(emp_State);
				employeeVO.setEmp_Pic(emp_Pic);
				
		

//				// Send the use back to the form, if there were errors
//				if (!errorMsgs.isEmpty()) {
//					req.setAttribute("employeeVO", employeeVO); // �t����J�榡���~��empVO����,�]�s�Jreq
//					RequestDispatcher failureView = req
//							.getRequestDispatcher("/front-end/employee/update_emp_input.jsp");
//					failureView.forward(req, res);
//					return; //�{�����_
//				}

				/***************************2.�}�l�ק���*****************************************/
				
				EmployeeService empSvc = new EmployeeService();
				employeeVO = empSvc.updateEmployee(emplo_No, account, name, sex, phone, email, start_From, emp_State, emp_Pic);

				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("employeeVO", employeeVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq				
				String url = "/front-end/employee/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneNews.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/update_emp_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // �Ӧ�addNews.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
//				Integer emplo_No = new Integer(req.getParameter("emplo_No").trim());
				
				String account = req.getParameter("account").trim();
				if (account == null || account.trim().length() == 0) {
					errorMsgs.add("�b��ФŪť�!");
				}	
				
				String password = req.getParameter("password").trim();
				if (password == null || password.trim().length() == 0) {
					errorMsgs.add("�K�X�ФŪť�!");
				}	
				
				
				String name = req.getParameter("name");
				String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (name == null || name.trim().length() == 0) {
					errorMsgs.add("���u�m�W�ФŪť�!");
				} else if(!name.trim().matches(nameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("���u�m�W�п�J��r10�Ӧr�H��!");
	            }
				
				Integer sex = new Integer(req.getParameter("sex").trim());

				String phone = req.getParameter("phone").trim();
				String phoneReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("���u�q�ܽФŪť�!");
				} else if(!phone.trim().matches(phoneReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("���u�q�ܽп�J��r10�ӼƦr�H��!");
	            }
				
				String email = null;
				try {
					email = new String(req.getParameter("email").trim());
					String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
				} catch (NumberFormatException e) {
					email = "email�ФŪť�";
					errorMsgs.add("�нT�{��Jemail�榡�O�_�����~");
				}
				

				java.sql.Date start_From = null;
				try {
					start_From = java.sql.Date.valueOf(req.getParameter("start_From").trim());
				} catch (IllegalArgumentException e) {
					start_From=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J�N¾���!");
				}
				
				Integer emp_State = new Integer(req.getParameter("emp_State").trim());

				
				byte[] emp_Pic=null;
				try {
					Part Emp_Pic = req.getPart("emp_Pic");
					InputStream in = Emp_Pic.getInputStream();
					emp_Pic = new byte[in.available()];
					in.read(emp_Pic);
					in.close();
					System.out.println("buffer length: " + emp_Pic.length);
				} catch (Exception e) {

					errorMsgs.add("error");
				}
				
				
				
				EmployeeVO employeeVO = new EmployeeVO();
//				employeeVO.setEmplo_No(emplo_No);
				employeeVO.setAccount(account);
				employeeVO.setPassword(password);
				employeeVO.setName(name);
				employeeVO.setSex(sex);
				employeeVO.setPhone(phone);
				employeeVO.setEmail(email);
				employeeVO.setStart_From(start_From);
				employeeVO.setEmp_State(emp_State);
				employeeVO.setEmp_Pic(emp_Pic);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("employeeVO", employeeVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				EmployeeService empSvc = new EmployeeService();
				employeeVO = empSvc.addEmployee(account, password, name, sex, phone, email, start_From, emp_State, emp_Pic);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/front-end/employee/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllNews.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/addEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllNews.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer emplo_No = new Integer(req.getParameter("emplo_No"));
				
				/***************************2.�}�l�R�����***************************************/
				EmployeeService empSvc = new EmployeeService();
				empSvc.deleteEmployee(emplo_No);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/front-end/employee/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
