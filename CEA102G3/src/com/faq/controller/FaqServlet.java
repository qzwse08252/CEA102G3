package com.faq.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.faq.model.FaqService;
import com.faq.model.FaqVO;

public class FaqServlet extends HttpServlet {

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
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("question_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J���u�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/faq/select_faq_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer question_No = null;
				try {
					question_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�`�����D�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/faq/select_faq_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				FaqService faqSvc = new FaqService();
				FaqVO faqVO = faqSvc.getOneQuestion(question_No);
				if (faqVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/faq/select_faq_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("faqVO", faqVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/front-end/faq/listOneFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneFaq.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/faq/select_faq_page.jsp");
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
				Integer question_No = new Integer(req.getParameter("question_No"));
				
				/***************************2.�}�l�d�߸��****************************************/
				FaqService faqSvc = new FaqService();
				FaqVO faqVO = faqSvc.getOneQuestion(question_No);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("faqVO", faqVO);         // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/front-end/faq/update_faq_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_faq_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/faq/listAllFaq.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_faq_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer question_No = new Integer(req.getParameter("question_No").trim());
				
				String question = req.getParameter("question");
//				String questionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (question == null || question.trim().length() == 0) {
					errorMsgs.add("�ж�g�`�����D���e!");
				}
//				} else if(!question.trim().matches(questionReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("�Цb�`�����D���e���A��J1000�H�����r�ơC");
//	            }
				
				String answer = req.getParameter("answer");
//				String answerReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (answer == null || answer.trim().length() == 0) {
					errorMsgs.add("�Цb�`�����D���^������g���e!");
				}
//				} else if(!answer.trim().matches(answerReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("�Цb�`�����D���^������g���e�A��J1000�H�����r�ơC");
//	            }
				
				java.sql.Date update_Time = null;
				try {
					update_Time = java.sql.Date.valueOf(req.getParameter("update_Time").trim());
				} catch (IllegalArgumentException e) {
					update_Time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}

				FaqVO faqVO = new FaqVO();
				faqVO.setQuestion_No(question_No);
				faqVO.setQuestion(question);
				faqVO.setAnswer(answer);
				faqVO.setUpdate_Time(update_Time);



				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("faqVO", faqVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/faq/update_faq_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				FaqService faqSvc = new FaqService();
				faqVO = faqSvc.updateFaq(question_No, question, answer, update_Time);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("faqVO", faqVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/front-end/faq/listOneFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneFaq.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/faq/update_faq_input.jsp");
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
//				String question_No = req.getParameter("question_No");
				
				String question = req.getParameter("question");
//				String questionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (question == null || question.trim().length() == 0) {
					errorMsgs.add("�ж�g�`�����D���e!");
				}
//				} else if(!question.trim().matches(questionReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("�Цb�`�����D���e���A��J1000�H�����r�ơC");
//	            }
				
				String answer = req.getParameter("answer");
//				String answerReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (answer == null || answer.trim().length() == 0) {
					errorMsgs.add("�Цb�`�����D���^������g���e!");
				}
//				} else if(!answer.trim().matches(answerReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("�Цb�`�����D���^������g���e�A��J1000�H�����r�ơC");
//	            }
				
				java.sql.Date update_Time = null;
				try {
					update_Time = java.sql.Date.valueOf(req.getParameter("update_Time").trim());
				} catch (IllegalArgumentException e) {
					update_Time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}
				


				FaqVO faqVO = new FaqVO();
//				faqVO.setQuestion_No(question_No);
				faqVO.setQuestion(question);
				faqVO.setAnswer(answer);
				faqVO.setUpdate_Time(update_Time);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("faqVO", faqVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/front-end/faq/addFaq.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				FaqService faqSvc = new FaqService();
				faqVO = faqSvc.addFaq(question, answer, update_Time);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/front-end/faq/listAllFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllFaq.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/faq/addFaq.jsp");
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
				Integer question_No = new Integer(req.getParameter("question_No"));
				
				/***************************2.�}�l�R�����***************************************/
				FaqService faqSvc = new FaqService();
				faqSvc.deleteQuestion(question_No);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/front-end/faq/listAllFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/faq/listAllFaq.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
