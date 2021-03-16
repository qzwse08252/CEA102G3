package com.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.model.EmployeeService;
import com.emp.model.EmployeeVO;


public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginOutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("login".equals(action)) {
			System.out.println("---in--action:" + action);
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				String account = req.getParameter("account").trim();
				if (account == null || account.isEmpty()) {
					errorMsgs.add("�п�J�b��");
				}
				String password = req.getParameter("password");
				if (password == null || password.isEmpty()) {
					errorMsgs.add("�п�J�K�X");
				}
				if (!errorMsgs.isEmpty()) {
					String url = "/front-end/Login.jsp";
					RequestDispatcher failureView = req.getRequestDispatcher(url);
					failureView.forward(req, res);
				}
				System.out.println("page---account:" + account);
				System.out.println("page---password:" + password);

				EmployeeService employeeSvc = new EmployeeService();
				EmployeeVO employeeVO = employeeSvc.getOneByAccount(account);
				System.out.println("employeeVO:" + employeeVO);
				System.out.println("db---account:" + employeeVO.getAccount());
				System.out.println("db---password:" + employeeVO.getPassword());

				String forwardUrl = "";
				if ((employeeVO == null) || ((employeeVO != null) && (!password.equals(employeeVO.getPassword())))) {
					System.out.println("employeeVO is null");
					forwardUrl = "/front-end/Login.jsp";
					errorMsgs.add("loginOutSer��63��");
				} else {
					System.out.println("employeeVO is not null");
					forwardUrl = "/front-end/Login.jsp";
					HttpSession session = req.getSession();
//					session.setAttribute("emploNo", employeeVO.getEmploNo());
					session.setAttribute("employeeVO", employeeVO);
					System.out.println("session_id:" + session.getId());
				}

				RequestDispatcher forwarPage = req.getRequestDispatcher(forwardUrl);
				forwarPage.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/Login.jsp");
				failureView.forward(req, res);
			}
//			�H�U�|���ק�
		} else if ("logout".equals(action)) {
			HttpSession session = req.getSession(false);
			System.out.println("session_id:" + session.getId());
			session.invalidate();
			System.out.println("loginOutSer��85��");

			String forwardUrl = "/front-end/index.jsp";
			RequestDispatcher forwardPage = req.getRequestDispatcher(forwardUrl);
			forwardPage.forward(req, res);
		} else if ("forgotPassword".equals(action)) {
			System.out.println("---in--action:" + action);
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			String account = req.getParameter("account").trim();
			if (account == null || account.isEmpty()) {
				errorMsgs.add("loginOutSer��97��!");
			}
			
			if (!errorMsgs.isEmpty()) {
				String url = "/front-end/RestPassword2.jsp";
				RequestDispatcher failureView = req.getRequestDispatcher(url);
				failureView.forward(req, res);
			}
			
			req.setAttribute("isRestPwd", true);
			
			ServletContext context = getServletContext();
			String configPath = context.getRealPath("/config.properties");
			String activatePagePath = context.getRealPath("/front-end/RestPasswordMailPage.html");
			HashMap<String, String> confMap = new HashMap<String, String>();
			confMap.put("configPath", configPath);
			confMap.put("activatePagePath", activatePagePath);
			confMap.put("contextPath", context.getContextPath());
//			confMap.put("imgUrl", context.getContextPath()+"/resources/img/logo.PNG");
			confMap.put("subject", "loginOutSer��116��");
			confMap.put("toAccount", account);
//			confMap.put("account", account);
			// 寄網??��?�碼??�信
//�����W		new util.MailUtil2().sendMail(confMap);
			
			String forwardUrl = "/front-end/RestPassword2.jsp";
//			String forwardUrl = "/front-end/member/AfterRestPwd.html";
			RequestDispatcher forwardPage = req.getRequestDispatcher(forwardUrl);
			forwardPage.forward(req, res);
		} else if ("returnLogin".equals(action)) {
			System.out.println("---in--action:" + action);
			req.removeAttribute("isRestPwd");
			String forwardUrl = "/front-end/index.jsp";
			RequestDispatcher forwardPage = req.getRequestDispatcher(forwardUrl);
			forwardPage.forward(req, res);
		} else if ("forgotPasswordCheck".equals(action)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
