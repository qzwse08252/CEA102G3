package com.functions.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;

import javax.servlet.http.*;

import com.functions.model.FunctionsService;
import com.functions.model.FunctionsVO;


public class FunctionsServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		
		if ("getOne_For_Display".equals(action)) { // 來自select_faq_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();

			
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("funct_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入功能編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer funct_No = null;
				try {
					funct_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("功能編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				

				/***************************2.開始查詢資料*****************************************/
				FunctionsService funSvc = new FunctionsService();
				FunctionsVO functionsVO = funSvc.getOneFunctions(funct_No);
				if (functionsVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}

				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("functionsVO", functionsVO); // 資料庫取出的empVO物件,存入req
				String url = "/front-end/functions/listOneFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneFaq.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllFaq.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer funct_No = new Integer(req.getParameter("funct_No"));
						
				/***************************2.開始查詢資料****************************************/
				FunctionsService funSvc = new FunctionsService();
				FunctionsVO functionsVO = funSvc.getOneFunctions(funct_No);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("functionsVO", functionsVO);         // 資料庫取出的empVO物件,存入req
				String url = "/front-end/functions/update_functions_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_faq_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/listAllFunctions.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // 來自update_function_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				
				
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer funct_No = new Integer(req.getParameter("funct_No").trim());
				
				String funct_Name = req.getParameter("funct_Name");
//				String questionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (funct_Name == null || funct_Name.trim().length() == 0) {
					errorMsgs.add("請填寫功能名稱!");
				}
//			

				FunctionsVO functionsVO = new FunctionsVO();
				functionsVO.setFunct_No(funct_No);
				functionsVO.setFunct_Name(funct_Name);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("functionsVO", functionsVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/update_functions_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				FunctionsService funSvc = new FunctionsService();
				functionsVO = funSvc.updateFunctions(funct_No, funct_Name);
			
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("functionsVO", functionsVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/front-end/functions/listOneFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneFaq.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/update_functions_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addFaq.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/

				
				String funct_Name = req.getParameter("funct_Name");
//				String functionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (funct_Name == null || funct_Name.trim().length() == 0) {
					errorMsgs.add("請填寫功能名稱!");
				}
			
		
				FunctionsVO functionsVO = new FunctionsVO();
				functionsVO.setFunct_Name(funct_Name);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("functionsVO", functionsVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/addFunctions.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				FunctionsService funSvc = new FunctionsService();
				functionsVO = funSvc.addFunctions(funct_Name);
				
					
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/front-end/functions/listAllFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllFaq.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/addFunctions.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // 來自listAllFaq.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.接收請求參數***************************************/
				Integer funct_No = new Integer(req.getParameter("funct_No"));
				
				/***************************2.開始刪除資料***************************************/
				FunctionsService funSvc = new FunctionsService();
				funSvc.deleteFunctions(funct_No);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/front-end/functions/listAllFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/listAllFunctions.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
