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
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_news_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("emplo_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號!");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer emplo_No = null;
				try {
					emplo_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("員工編號格式不正確!");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				
				/***************************2.開始查詢資料*****************************************/
				EmployeeService empSvc = new EmployeeService();
				EmployeeVO employeeVO = empSvc.getOneEmployee(emplo_No);
				if (employeeVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("employeeVO", employeeVO); // 資料庫取出的empVO物件,存入req
				String url = "/front-end/employee/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneNews.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllNews.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer emplo_No = new Integer(req.getParameter("emplo_No"));
			
				/***************************2.開始查詢資料****************************************/
				EmployeeService empSvc = new EmployeeService();
				EmployeeVO employeeVO = empSvc.getOneEmployee(emplo_No);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("employeeVO", employeeVO);         // 資料庫取出的empVO物件,存入req
				String url = "/front-end/employee/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_news_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		

		if ("update".equals(action)) { // 來自update_news_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer emplo_No = new Integer(req.getParameter("emplo_No").trim());
		
				String account = req.getParameter("account").trim();
//				if (account == null || account.trim().length() == 0) {
//					errorMsgs.add("帳戶請勿空白!");
//				}	
				

				
//				String password = req.getParameter("password").trim();
//				if (password == null || password.trim().length() == 0) {
//					errorMsgs.add("密碼請勿空白!");
//				}	
				

				String name = req.getParameter("name");
//				String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//				if (name == null || name.trim().length() == 0) {
//					errorMsgs.add("請輸入姓名!");
//				} else if(!name.trim().matches(nameReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("姓名可填寫中文或英文，字數長度為2~10字之間!");
//	            }
				
				
				Integer sex = new Integer(req.getParameter("sex").trim());

				String phone = req.getParameter("phone").trim();
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("電話請勿空白!");
				}


//				String email = null;
//				try {
//					email = new String(req.getParameter("email").trim());
//					String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
//				} catch (NumberFormatException e) {
//					email = "";
//					errorMsgs.add("請確認輸入email格式是否有錯誤");
//				}

				String email = req.getParameter("email");
				String emailReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("電子信箱請勿空白!");
				} else if(!email.trim().matches(emailReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("xx");
	            }
				
//				Integer employee_state=null;
//				try {
//					System.out.println(employee_state);
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//				

				java.sql.Date start_From = null;
				try {
					start_From = java.sql.Date.valueOf(req.getParameter("start_From").trim());
				} catch (IllegalArgumentException e) {
					start_From=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入就職日期!");
				}
				
				Integer emp_State = new Integer(req.getParameter("emp_State").trim());

				
				
				byte[] emp_Pic=null;
				try {
					Part Emp_Pic = req.getPart("emp_Pic");
					InputStream in = Emp_Pic.getInputStream();
					emp_Pic = new byte[in.available()];
					in.read(emp_Pic);
					in.close();
					if(Emp_Pic.getSize()==0) {
						
						EmployeeService empSvc = new EmployeeService();
						EmployeeVO employeeVO = empSvc.getOneEmployee(emplo_No);
						emp_Pic = employeeVO.getEmp_Pic();
					} 
					System.out.println("buffer length: " + emp_Pic.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					errorMsgs.add("error");
				}
				System.out.println("emp_Pic:"+ emp_Pic);
				
			
				
//				byte[] emp_Pic=null;
//				try {
//					Part Emp_Pic = req.getPart("emp_Pic");
//					InputStream in = Emp_Pic.getInputStream();
//					emp_Pic = new byte[in.available()];
//					in.read(emp_Pic);
//					in.close();
//					System.out.println("buffer length: " + emp_Pic.length);
//				} catch (Exception e) {
//
//					errorMsgs.add("error");
//				}
				


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
				
		

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("employeeVO", employeeVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/update_emp_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				EmployeeService empSvc = new EmployeeService();
				employeeVO = empSvc.updateEmployee(emplo_No, account, name, sex, phone, email, start_From, emp_State, emp_Pic);

				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("employeeVO", employeeVO); // 資料庫update成功後,正確的的empVO物件,存入req				
				String url = "/front-end/employee/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneNews.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/update_emp_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addNews.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				Integer emplo_No = new Integer(req.getParameter("emplo_No").trim());
				
				String account = req.getParameter("account").trim();
				if (account == null || account.trim().length() == 0) {
					errorMsgs.add("帳戶請勿空白!");
				}	
				
				String password = req.getParameter("password").trim();
				if (password == null || password.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白!");
				}	
				
				
				String name = req.getParameter("name");
				String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (name == null || name.trim().length() == 0) {
					errorMsgs.add("員工姓名請勿空白!");
				} else if(!name.trim().matches(nameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("員工姓名請輸入文字10個字以內!");
	            }
				

				String phone = req.getParameter("phone").trim();
				String phoneReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (phone == null || phone.trim().length() == 0) {
					errorMsgs.add("員工電話請勿空白!");
				} else if(!phone.trim().matches(phoneReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("員工電話請輸入文字10個數字以內!");
	            }
				
				
				String email = req.getParameter("email").trim();
				String emailReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
				if (email == null || email.trim().length() == 0) {
					errorMsgs.add("電子信箱請勿空白!");
				} else if(!email.trim().matches(emailReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("電子信箱請輸入英文、數字或底線!");
	            }
		
				
				java.sql.Date start_From = null;
				try {
					start_From = java.sql.Date.valueOf(req.getParameter("start_From").trim());
				} catch (IllegalArgumentException e) {
					start_From = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入就職日期!");
				}
				
						
				
				Integer sex = new Integer(req.getParameter("sex").trim());
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
					req.setAttribute("employeeVO", employeeVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/employee/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				EmployeeService empSvc = new EmployeeService();
				employeeVO = empSvc.addEmployee(account, password, name, sex, phone, email, start_From, emp_State, emp_Pic);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/front-end/employee/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllNews.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/addEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自listAllNews.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer emplo_No = new Integer(req.getParameter("emplo_No"));
				
				/***************************2.開始刪除資料***************************************/
				EmployeeService empSvc = new EmployeeService();
				empSvc.deleteEmployee(emplo_No);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/front-end/employee/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/employee/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
