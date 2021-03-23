package com.notify.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.notify.model.NotifyService;
import com.notify.model.NotifyVO;

public class NotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NotifyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action---" + action);

		if ("addNotify".equals(action)) {
			System.out.println("---in--action:" + action);
			Integer loginNo = new Integer(req.getParameter("loginNo").trim());
			Integer notifyMemberNo = new Integer(req.getParameter("memberNo"));
			String notifyType = req.getParameter("notifyType");
//			String notifyContent = req.getParameter("notifyContent");
			
//			if (notifyMemberNo != null && notifyType != null && "addFriend".equals(notifyType)) {
//				NotifyService notifySvc = new NotifyService();
//				MemberService MemberSvc = new MemberService();
//				MemberVO loginMemberVO = MemberSvc.getOneMember(loginNo);
//				String notifyContent = loginMemberVO.getName() + " 要求加入好友";
//				notifySvc.addNotify(notifyMemberNo, notifyContent, new Timestamp(System.currentTimeMillis()));
//			}
			
		} else if ("listOneNotify".equals(action)) {
			System.out.println("---in--action:" + action);
//			Integer loginNo = new Integer(req.getParameter("loginNo").trim());
//			Integer notifyMemberNo = new Integer(req.getParameter("memberNo"));
			String notifyNoStr = req.getParameter("notifyNo");
//			Integer notifyNo = new Integer(req.getParameter("notifyNo"));
//			String notifyType = req.getParameter("notifyType");
//			String notifyContent = req.getParameter("notifyContent");
			JSONArray array = new JSONArray();
			
			if (notifyNoStr != null && !notifyNoStr.isEmpty()) {
				Integer notifyNo = new Integer(notifyNoStr);
				NotifyService notifySvc = new NotifyService();
				NotifyVO notifyVO = notifySvc.getOneNotify(notifyNo);
				
				try {
					System.out.println("NotifyNo:" + notifyVO.getNotifyNo());
					System.out.println("NotifyPerson:" + notifyVO.getNotifyPerson());
					System.out.println("NotifyContent:" + notifyVO.getNotifyContent());
					System.out.println("NotifyTime:" + notifyVO.getNotifyTime());
					System.out.println("----------------------");

					JSONObject obj = new JSONObject();
					obj.put("notifyNo", notifyVO.getNotifyNo());
					obj.put("notifyPerson", notifyVO.getNotifyPerson());
					obj.put("notifyContent", notifyVO.getNotifyContent());
					obj.put("notifyTime", notifyVO.getNotifyTime());
					array.put(obj);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
				//Bootstrap_modal
				boolean openListOneNotifyModal=true;
				req.setAttribute("openListOneNotifyModal",openListOneNotifyModal );
			}
			
			res.setContentType("text/plain");
			res.setCharacterEncoding("UTF-8");
			PrintWriter out = res.getWriter();
			out.write(array.toString());
			out.flush();
			out.close();
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
