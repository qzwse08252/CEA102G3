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

		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_faq_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();

			
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("funct_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�\��s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer funct_No = null;
				try {
					funct_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�\��s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				

				/***************************2.�}�l�d�߸��*****************************************/
				FunctionsService funSvc = new FunctionsService();
				FunctionsVO functionsVO = funSvc.getOneFunctions(funct_No);
				if (functionsVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}

				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("functionsVO", functionsVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/front-end/functions/listOneFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneFaq.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/select_functions_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllFaq.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer funct_No = new Integer(req.getParameter("funct_No"));
						
				/***************************2.�}�l�d�߸��****************************************/
				FunctionsService funSvc = new FunctionsService();
				FunctionsVO functionsVO = funSvc.getOneFunctions(funct_No);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("functionsVO", functionsVO);         // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/front-end/functions/update_functions_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_faq_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/listAllFunctions.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_function_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				
				
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer funct_No = new Integer(req.getParameter("funct_No").trim());
				
				String funct_Name = req.getParameter("funct_Name");
//				String questionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (funct_Name == null || funct_Name.trim().length() == 0) {
					errorMsgs.add("�ж�g�\��W��!");
				}
//			

				FunctionsVO functionsVO = new FunctionsVO();
				functionsVO.setFunct_No(funct_No);
				functionsVO.setFunct_Name(funct_Name);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("functionsVO", functionsVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/update_functions_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				FunctionsService funSvc = new FunctionsService();
				functionsVO = funSvc.updateFunctions(funct_No, funct_Name);
			
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("functionsVO", functionsVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/front-end/functions/listOneFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneFaq.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/update_functions_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // �Ӧ�addFaq.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/

				
				String funct_Name = req.getParameter("funct_Name");
//				String functionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (funct_Name == null || funct_Name.trim().length() == 0) {
					errorMsgs.add("�ж�g�\��W��!");
				}
			
		
				FunctionsVO functionsVO = new FunctionsVO();
				functionsVO.setFunct_Name(funct_Name);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("functionsVO", functionsVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/functions/addFunctions.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				FunctionsService funSvc = new FunctionsService();
				functionsVO = funSvc.addFunctions(funct_Name);
				
					
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/front-end/functions/listAllFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllFaq.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/addFunctions.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllFaq.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer funct_No = new Integer(req.getParameter("funct_No"));
				
				/***************************2.�}�l�R�����***************************************/
				FunctionsService funSvc = new FunctionsService();
				funSvc.deleteFunctions(funct_No);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/front-end/functions/listAllFunctions.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/functions/listAllFunctions.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
