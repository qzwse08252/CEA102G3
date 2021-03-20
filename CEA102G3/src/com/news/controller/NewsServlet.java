package com.news.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import com.mysql.cj.Session;
import com.news.model.NewsService;
import com.news.model.NewsVO;



//@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
@MultipartConfig
public class NewsServlet extends HttpServlet {

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
				String str = req.getParameter("news_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入最新消息編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/select_news_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer news_No = null;
				try {
					news_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("最新消息編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/select_news_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				NewsService newsSvc = new NewsService();
				NewsVO newsVO = newsSvc.getOneNews(news_No);
				if (newsVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/select_news_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("newsVO", newsVO); // 資料庫取出的empVO物件,存入req
				String url = "/back-end/news/listOneNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneNews.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/select_news_page.jsp");
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
				Integer news_No = new Integer(req.getParameter("news_No"));
				
				/***************************2.開始查詢資料****************************************/
				NewsService newsSvc = new NewsService();
				NewsVO newsVO = newsSvc.getOneNews(news_No);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("newsVO", newsVO);         // 資料庫取出的empVO物件,存入req
				String url = "/back-end/news/update_news_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_news_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/listAllNews.jsp");
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
				Integer news_No = new Integer(req.getParameter("news_No").trim());
				
				String news_Title = req.getParameter("news_Title");
				String news_TitleReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,50}$";
				if (news_Title == null || news_Title.trim().length() == 0) {
					errorMsgs.add("請填寫最新消息標題!");
//				} else if(!news_Title.trim().matches(news_TitleReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("請在最新消息標題中，輸入3~50以內的字數。");
//	            }
				}
				
				String news_Content = req.getParameter("news_Content");
				String news_ContentReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (news_Content == null || news_Content.trim().length() == 0) {
					errorMsgs.add("請填寫最新消息內容!");
//				} else if(!news_Content.trim().matches(news_ContentReg)) { //以下練習正則(規)表示式(regular-expression)
//					errorMsgs.add("請在最新消息內容中，輸入3~1000以內的字數。");
//	            }
				}		
			
				java.sql.Date release_Date = null;
				try {
					release_Date = java.sql.Date.valueOf(req.getParameter("release_Date").trim());
				} catch (IllegalArgumentException e) {
					release_Date=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("請輸入日期!");
				}

				
				byte[] news_Pic=null;
				try {
					Part News_Pic = req.getPart("news_Pic");
					InputStream in = News_Pic.getInputStream();
					news_Pic = new byte[in.available()];
					in.read(news_Pic);
					in.close();
					if(News_Pic.getSize()==0) {
						System.out.println("no part!");
						NewsService newsSvc = new NewsService();
						NewsVO newsVO = newsSvc.getOneNews(news_No);
						news_Pic = newsVO.getNews_Pic();
					} 
					System.out.println("buffer length: " + news_Pic.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					errorMsgs.add("error");
				}
				System.out.println("news_Pic:"+news_Pic);
				
//				Part News_Pic = req.getPart("news_Pic"); //來自於上面的form表單
//				InputStream in = News_Pic.getInputStream();
//				byte[] news_Pic = new byte[in.available()];
//				in.read(news_Pic);
//				in.close();
//				System.out.println("buffer length: " + news_Pic.length);
				
				
//				byte[] news_Pic=null;
//				try {
//					Part News_Pic = req.getPart("news_Pic");
//					InputStream in = News_Pic.getInputStream();
//					news_Pic = new byte[in.available()];
//					in.read(news_Pic);
//					in.close();
//					System.out.println("buffer length: " + news_Pic.length);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					errorMsgs.add("error");
//				}
				
			
				NewsVO newsVO = new NewsVO();
				newsVO.setNews_No(news_No);
				newsVO.setNews_Content(news_Content);
				newsVO.setRelease_Date(release_Date);
				newsVO.setNews_Title(news_Title);
				newsVO.setNews_Pic(news_Pic);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("newsVO", newsVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/update_news_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				NewsService newsSvc = new NewsService();
				newsVO = newsSvc.updateNews(news_No, news_Content, release_Date, news_Title, news_Pic);
	
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("newsVO", newsVO); // 資料庫update成功後,正確的的empVO物件,存入req				
				String url = "/back-end/news/listOneNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneNews.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/update_news_input.jsp");
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
//				Integer news_No = new Integer(req.getParameter("news_No").trim());
				
				
				String news_Title = req.getParameter("news_Title");
				String news_TitleReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,50}$";
				if (news_Title == null || news_Title.trim().length() == 0) {
					errorMsgs.add("請填寫最新消息標題!");
				} else if(!news_Title.trim().matches(news_TitleReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請在最新消息標題中，輸入3~50以內的字數。");
	            }
				
				
				String news_Content = req.getParameter("news_Content");
				String news_ContentReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (news_Content == null || news_Content.trim().length() == 0) {
					errorMsgs.add("請填寫最新消息內容!");
				} else if(!news_Content.trim().matches(news_ContentReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("請在最新消息內容中，輸入3~1000以內的字數。");
	            }
			
				java.sql.Date release_Date = null;
				try {
					release_Date = java.sql.Date.valueOf(req.getParameter("release_Date").trim());
				} catch (IllegalArgumentException e) {
					release_Date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}

	
				
				byte[] news_Pic=null;
				try {
					Part News_Pic = req.getPart("news_Pic");
					InputStream in = News_Pic.getInputStream();
					news_Pic = new byte[in.available()];
					in.read(news_Pic);
					in.close();
					System.out.println("buffer length: " + news_Pic.length);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					errorMsgs.add("error");
				}
				
		

				NewsVO newsVO = new NewsVO();
//				newsVO.setNews_No(news_No);
				newsVO.setNews_Content(news_Content);
				newsVO.setRelease_Date(release_Date);
				newsVO.setNews_Title(news_Title);
				newsVO.setNews_Pic(news_Pic);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("newsVO", newsVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/addNews.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				NewsService newsSvc = new NewsService();
				newsVO = newsSvc.addNews(news_Content, release_Date, news_Title, news_Pic);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/back-end/news/listAllNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllNews.jsp
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/addNews.jsp");
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
				Integer news_No = new Integer(req.getParameter("news_No"));
				
				/***************************2.開始刪除資料***************************************/
				NewsService newsSvc = new NewsService();
				newsSvc.deleteNews(news_No);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/back-end/news/listAllNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
				
				/***************************其他可能的錯誤處理**********************************/
			} catch (Exception e) {
				errorMsgs.add("刪除資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/listAllNews.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
