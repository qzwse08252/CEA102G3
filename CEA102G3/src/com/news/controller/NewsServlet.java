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
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_news_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("news_No");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�̷s�����s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/select_news_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer news_No = null;
				try {
					news_No = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("�̷s�����s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/select_news_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				NewsService newsSvc = new NewsService();
				NewsVO newsVO = newsSvc.getOneNews(news_No);
				if (newsVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/select_news_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("newsVO", newsVO); // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/front-end/news/listOneNews.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneNews.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/select_news_page.jsp");
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
				Integer news_No = new Integer(req.getParameter("news_No"));
				
				/***************************2.�}�l�d�߸��****************************************/
				NewsService newsSvc = new NewsService();
				NewsVO newsVO = newsSvc.getOneNews(news_No);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("newsVO", newsVO);         // ��Ʈw���X��empVO����,�s�Jreq
				String url = "/back-end/news/update_news_input2.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_news_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/listAllNews.jsp");
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
				Integer news_No = new Integer(req.getParameter("news_No").trim());
				
				String news_Title = req.getParameter("news_Title");
				String news_TitleReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,50}$";
				if (news_Title == null || news_Title.trim().length() == 0) {
					errorMsgs.add("�ж�g�̷s�������D!");
//				} else if(!news_Title.trim().matches(news_TitleReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("�Цb�̷s�������D���A��J3~50�H�����r�ơC");
//	            }
				}
				
				String news_Content = req.getParameter("news_Content");
				String news_ContentReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (news_Content == null || news_Content.trim().length() == 0) {
					errorMsgs.add("�ж�g�̷s�������e!");
//				} else if(!news_Content.trim().matches(news_ContentReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
//					errorMsgs.add("�Цb�̷s�������e���A��J3~1000�H�����r�ơC");
//	            }
				}		
			
				java.sql.Date release_Date = null;
				try {
					release_Date = java.sql.Date.valueOf(req.getParameter("release_Date").trim());
				} catch (IllegalArgumentException e) {
					release_Date=new java.sql.Date(System.currentTimeMillis());
//					errorMsgs.add("�п�J���!");
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
				
//				Part News_Pic = req.getPart("news_Pic"); //�Ӧ۩�W����form���
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
					req.setAttribute("newsVO", newsVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/update_news_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				NewsService newsSvc = new NewsService();
				newsVO = newsSvc.updateNews(news_No, news_Content, release_Date, news_Title, news_Pic);
	
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("newsVO", newsVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq				
				String url = "/back-end/news/listAllNews2.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneNews.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/update_news_input.jsp");
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
//				Integer news_No = new Integer(req.getParameter("news_No").trim());
				
				
				String news_Title = req.getParameter("news_Title");
				String news_TitleReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,50}$";
				if (news_Title == null || news_Title.trim().length() == 0) {
					errorMsgs.add("�ж�g�̷s�������D!");
				} else if(!news_Title.trim().matches(news_TitleReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�Цb�̷s�������D���A��J3~50�H�����r�ơC");
	            }
				
				
				String news_Content = req.getParameter("news_Content");
				String news_ContentReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,1000}$";
				if (news_Content == null || news_Content.trim().length() == 0) {
					errorMsgs.add("�ж�g�̷s�������e!");
				} else if(!news_Content.trim().matches(news_ContentReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�Цb�̷s�������e���A��J3~1000�H�����r�ơC");
	            }
			
				java.sql.Date release_Date = null;
				try {
					release_Date = java.sql.Date.valueOf(req.getParameter("release_Date").trim());
				} catch (IllegalArgumentException e) {
					release_Date=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
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
					req.setAttribute("newsVO", newsVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/back-end/news/addNews.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				NewsService newsSvc = new NewsService();
				newsVO = newsSvc.addNews(news_Content, release_Date, news_Title, news_Pic);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/back-end/news/listAllNews2.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllNews.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/addNews.jsp");
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
				Integer news_No = new Integer(req.getParameter("news_No"));
				
				/***************************2.�}�l�R�����***************************************/
				NewsService newsSvc = new NewsService();
				newsSvc.deleteNews(news_No);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/back-end/news/listAllNews2.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/news/listAllNews.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
