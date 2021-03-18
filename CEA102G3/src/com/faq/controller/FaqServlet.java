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
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_faq_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("question_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入常見問題編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/faq/select_faq_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer question_No = null;
				try {
					question_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("常見問題編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/faq/select_faq_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				FaqService faqSvc = new FaqService();
				FaqVO faqVO = faqSvc.getOneQuestion(question_No);
				if (faqVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/faq/select_faq_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("faqVO", faqVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/faq/listOneFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneFaq.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/faq/select_faq_page.jsp");
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
				Integer question_No = new Integer(req.getParameter("question_No"));
				
				/***************************2.開始查詢資料****************************************/
				FaqService faqSvc = new FaqService();
				FaqVO faqVO = faqSvc.getOneQuestion(question_No);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("faqVO", faqVO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/faq/update_faq_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_faq_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/faq/listAllFaq.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // 來自update_faq_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer question_No = new Integer(req.getParameter("question_No").trim());
				
				String question = req.getParameter("question");
				String questionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (question == null || question.trim().length() == 0) {
					errorMsgs.add("請填寫常見問題內容!");
				} else if(!question.trim().matches(questionReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請在常見問題內容中，輸入3~1000以內的字數。");
	            }
				
				String answer = req.getParameter("answer");
				String answerReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (answer == null || answer.trim().length() == 0) {
					errorMsgs.add("請在常見問題的回答中填寫內容!");
				} else if(!answer.trim().matches(answerReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請在常見問題的回答中填寫內容，輸入3~1000以內的字數。");
	            }
				
				java.sql.Date update_Time = null;
				try {
					update_Time = java.sql.Date.valueOf(req.getParameter("update_Time").trim());
				} catch (IllegalArgumentException e) {
					update_Time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

				FaqVO faqVO = new FaqVO();
				faqVO.setQuestion_No(question_No);
				faqVO.setQuestion(question);
				faqVO.setAnswer(answer);
				faqVO.setUpdate_Time(update_Time);



				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("faqVO", faqVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/faq/update_faq_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				FaqService faqSvc = new FaqService();
				faqVO = faqSvc.updateFaq(question_No, question, answer, update_Time);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("faqVO", faqVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/back-end/faq/listOneFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneFaq.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/faq/update_faq_input.jsp");
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
//				String question_No = req.getParameter("question_No");
				
				String question = req.getParameter("question");
				String questionReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (question == null || question.trim().length() == 0) {
					errorMsgs.add("請填寫常見問題內容!");
				} else if(!question.trim().matches(questionReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請在常見問題內容中，輸入3~1000以內的字數。");
	            }
				
				String answer = req.getParameter("answer");
				String answerReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (answer == null || answer.trim().length() == 0) {
					errorMsgs.add("請在常見問題的回答中填寫內容!");
				} else if(!answer.trim().matches(answerReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請在常見問題的回答中填寫內容，輸入1000以內的字數。");
	            }
				
				java.sql.Date update_Time = null;
				try {
					update_Time = java.sql.Date.valueOf(req.getParameter("update_Time").trim());
				} catch (IllegalArgumentException e) {
					update_Time=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				


				FaqVO faqVO = new FaqVO();
//				faqVO.setQuestion_No(question_No);
				faqVO.setQuestion(question);
				faqVO.setAnswer(answer);
				faqVO.setUpdate_Time(update_Time);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("faqVO", faqVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/faq/addFaq.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				FaqService faqSvc = new FaqService();
				faqVO = faqSvc.addFaq(question, answer, update_Time);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/faq/listAllFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllFaq.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/faq/addFaq.jsp");
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
				Integer question_No = new Integer(req.getParameter("question_No"));
				
				/***************************2.開始刪除資料***************************************/
				FaqService faqSvc = new FaqService();
				faqSvc.deleteQuestion(question_No);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/faq/listAllFaq.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/faq/listAllFaq.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
