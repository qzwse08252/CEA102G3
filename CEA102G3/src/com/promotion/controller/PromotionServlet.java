package com.promotion.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.*;

import com.promotion.model.PromotionService;
import com.promotion.model.PromotionVO;


//@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@MultipartConfig
public class PromotionServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action==="+action);
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_promotion_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("promot_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入主打促銷編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/promotion/select_promotion_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer promot_No = null;
				try {
					promot_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("主打促銷編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/promotion/select_promotion_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				PromotionService proSvc = new PromotionService();
				PromotionVO promotionVO = proSvc.getOnePromotion(promot_No);
				if (promotionVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/promotion/select_promotion_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("promotionVO", promotionVO); // 資料庫取出的PromotionVO物件,存入req
				String url = "/front-end/promotion/listOnePromotion.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOnePromotion.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/promotion/select_promotion_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllPromotion.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer promot_No = new Integer(req.getParameter("promot_No"));
				
				/***************************2.開始查詢資料****************************************/
				PromotionService proSvc = new PromotionService();
				PromotionVO promotionVO = proSvc.getOnePromotion(promot_No);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("promotionVO", promotionVO);         // 資料庫取出的PromotionVO物件,存入req
				String url = "/back-end/promotion/update_promotion_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_promotion_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/promotion/listAllPromotion.jsp");
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
				Integer promot_No = new Integer(req.getParameter("promot_No").trim());
				
//				Integer promot_Product_No = new Integer(req.getParameter("promot_Product_No").trim());
				Integer promot_Product_No = null;
				try {
					promot_Product_No = new Integer(req.getParameter("promot_Product_No").trim());
				} catch (NumberFormatException e) {
					promot_Product_No = null;
					errorMsgs.add("請填入主打促銷的廣告商品編號!");
				}
				
				
				java.sql.Date promot_Start = null;
				try {
					promot_Start = java.sql.Date.valueOf(req.getParameter("promot_Start").trim());
				} catch (IllegalArgumentException e) {
					promot_Start = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入開始日期!");
				}
				System.out.println("promot_Start:"+promot_Start);
				
				
				java.sql.Date promot_End = null;
				try {
					promot_End = java.sql.Date.valueOf(req.getParameter("promot_End").trim());
				} catch (IllegalArgumentException e) {
					promot_End = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入結束日期!");
				}
				System.out.println("promot_End:"+promot_End);
				
				
				java.sql.Date release_Date = null;
				try {
					release_Date = java.sql.Date.valueOf(req.getParameter("release_Date").trim());
				} catch (IllegalArgumentException e) {
					release_Date = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入促銷上架日期!");
				}
				System.out.println("release_Date:"+release_Date);
				
				
				String promot_Product_Title = req.getParameter("promot_Product_Title");
				if (promot_Product_Title == null || promot_Product_Title.trim().length() == 0) {
					errorMsgs.add("主打促銷標題請勿空白!");
				}
				
				
				String promot_Content = req.getParameter("promot_Content");
				if (promot_Content == null || promot_Content.trim().length() == 0) {
					errorMsgs.add("主打促銷內容請勿空白!");
				}	
						
				
//				Integer promot_Product_Price = new Integer(req.getParameter("promot_Product_Price").trim());
				Integer promot_Product_Price = 0;
				try {
					promot_Product_Price = new Integer(req.getParameter("promot_Product_Price").trim());
					if(promot_Product_Price < 0) errorMsgs.add("請勿填寫負數金額!");
				} catch (NumberFormatException e) {
					promot_Product_Price = 0;
					errorMsgs.add("請填寫促銷金額!");
				}
				
		
				
				byte[] promot_Product_Pic=null;
				try {
					Part Promot_Product_Pic = req.getPart("promot_Product_Pic");
					InputStream in = Promot_Product_Pic.getInputStream();
					promot_Product_Pic = new byte[in.available()];
					in.read(promot_Product_Pic);
					in.close();
					if(Promot_Product_Pic.getSize()==0) {
						
						PromotionService promotionSvc = new PromotionService();
						PromotionVO promotionVO = promotionSvc.getOnePromotion(promot_No);
						promot_Product_Pic = promotionVO.getPromot_Product_Pic();
					} 
					System.out.println("buffer length: " + promot_Product_Pic.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					errorMsgs.add("error");
				}
				System.out.println("promot_Product_Pic:"+promot_Product_Pic);
				
		
				
				
				PromotionVO promotionVO = new PromotionVO();
				promotionVO.setPromot_No(promot_No);
				promotionVO.setPromot_Content(promot_Content);
				promotionVO.setPromot_Start(promot_Start);
				promotionVO.setPromot_End(promot_End);
				promotionVO.setRelease_Date(release_Date);
				promotionVO.setPromot_Product_No(promot_Product_No);
				promotionVO.setPromot_Product_Price(promot_Product_Price);
				promotionVO.setPromot_Product_Title(promot_Product_Title);
				promotionVO.setPromot_Product_Pic(promot_Product_Pic);



//				 Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("promotionVO", promotionVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/promotion/update_promotion_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}

				/***************************2.開始修改資料*****************************************/
				PromotionService proSvc = new PromotionService();
				proSvc.updatePromotion(promot_No, promot_Content, promot_Start, promot_End, release_Date, promot_Product_No, promot_Product_Price, promot_Product_Title, promot_Product_Pic);


				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("promotionVO", promotionVO); // 資料庫update成功後,正確的的empVO物件,存入req				
				String url = "/back-end/promotion/listOnePromotion.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneNews.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/promotion/update_promotion_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自addPromotioin.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
//				Integer promot_No = new Integer(req.getParameter("promot_No").trim());
				
//				Integer promot_Product_No = new Integer(req.getParameter("promot_Product_No").trim());
				Integer promot_Product_No = null;
				try {
					promot_Product_No = new Integer(req.getParameter("promot_Product_No").trim());
				} catch (NumberFormatException e) {
					promot_Product_No = null;
					errorMsgs.add("請填入主打促銷的廣告商品編號!");
				}
				
				
				java.sql.Date promot_Start = null;
				try {
					promot_Start = java.sql.Date.valueOf(req.getParameter("promot_Start").trim());
				} catch (IllegalArgumentException e) {
					promot_Start = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入開始日期!");
				}


				java.sql.Date promot_End = null;
				try {
					promot_End = java.sql.Date.valueOf(req.getParameter("promot_End").trim());
				} catch (IllegalArgumentException e) {
					promot_End = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入結束日期!");
				}
				

				java.sql.Date release_Date = null;
				try {
					release_Date = java.sql.Date.valueOf(req.getParameter("release_Date").trim());
				} catch (IllegalArgumentException e) {
					release_Date = new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入促銷上架日期!");
				}
				
				
				String promot_Product_Title = req.getParameter("promot_Product_Title");
				if (promot_Product_Title == null || promot_Product_Title.trim().length() == 0) {
					errorMsgs.add("主打促銷標題請勿空白!");
				}	
				
				
				String promot_Content = req.getParameter("promot_Content");
				if (promot_Content == null || promot_Content.trim().length() == 0) {
					errorMsgs.add("主打促銷內容請勿空白!");
				}	
				
					
//				Integer promot_Product_Price = new Integer(req.getParameter("promot_Product_Price").trim());
				Integer promot_Product_Price = 0;
				try {
					promot_Product_Price = new Integer(req.getParameter("promot_Product_Price").trim());
					if(promot_Product_Price < 0) errorMsgs.add("請勿填寫負數金額!");
				} catch (NumberFormatException e) {
					promot_Product_Price = 0;
					errorMsgs.add("請填寫促銷金額!");
				}
				
		
				byte[] promot_Product_Pic=null;
				try {
					Part Promot_Product_Pic = req.getPart("promot_Product_Pic");
					InputStream in = Promot_Product_Pic.getInputStream();
					promot_Product_Pic = new byte[in.available()];
					in.read(promot_Product_Pic);
					in.close();
					System.out.println("buffer length: " + promot_Product_Pic.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					errorMsgs.add("error");
				}

				
				PromotionVO promotionVO = new PromotionVO();
//				promotionVO.setPromot_No(promot_No);
				promotionVO.setPromot_Content(promot_Content);
				promotionVO.setPromot_Start(promot_Start);
				promotionVO.setPromot_End(promot_End);
				promotionVO.setRelease_Date(release_Date);
				promotionVO.setPromot_Product_No(promot_Product_No);
				promotionVO.setPromot_Product_Price(promot_Product_Price);
				promotionVO.setPromot_Product_Title(promot_Product_Title);
				promotionVO.setPromot_Product_Pic(promot_Product_Pic);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("promotionVO", promotionVO); // 含有輸入格式錯誤的PromotionVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/promotion/addPromotion.jsp");
					failureView.forward(req, res);
					return;
				}
				
				

				/***************************2.開始新增資料***************************************/
				PromotionService proSvc = new PromotionService();
				promotionVO = proSvc.addPromotion(promot_Content, promot_Start, promot_End, release_Date, promot_Product_No, promot_Product_Price, promot_Product_Title, promot_Product_Pic);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/promotion/listAllPromotion.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllPromotion.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/promotion/addPromotion.jsp");
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
				Integer promot_No = new Integer(req.getParameter("promot_No"));
				
				/***************************2.開始刪除資料***************************************/
				
				PromotionService proSvc = new PromotionService();
				proSvc.deletePromotion(promot_No);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/promotion/listAllPromotion.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/promotion/listAllPromotion.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
