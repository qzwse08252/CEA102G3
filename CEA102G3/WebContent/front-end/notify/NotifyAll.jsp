<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.notify.model.*"%>
<jsp:useBean id="memberVO" scope="session" class="com.member.model.MemberVO"/>
<jsp:useBean id="notifySvc" scope="request" class="com.notify.model.NotifyService"/>

<%-- --${memberVO.memberNo}--memberVO.memberNo --%>
<% 
	System.out.println("MemberNo:"+memberVO.getMemberNo()); 
	java.util.List<NotifyVO> list = notifySvc.getOneNotifyByPerson(memberVO.getMemberNo());
	for (NotifyVO notifyVO : list) {
		System.out.println("NotifyNo:"+notifyVO.getNotifyNo());
		System.out.println("NotifyPerson:"+notifyVO.getNotifyPerson());
		System.out.println("NotifyContent:"+notifyVO.getNotifyContent());
		System.out.println("NotifyTime:"+notifyVO.getNotifyTime());
		System.out.println("---------");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List All Notify</title>
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"> -->
<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script> -->
<style>
	div.notifyAll{
		margin: 80px auto auto;
		max-width: 500px;
	}
</style>
</head>
<body>
	<c:import url="/front-end/NavPage2.jsp"></c:import>
	
	<div class="list-group notifyAll">
		<c:forEach var="notifyPer" items="${notifySvc.getOneNotifyByPerson(memberVO.memberNo)}" varStatus="varStatusName">
<%-- 			${notifyPer.notifyTime}  ${notifyPer.notifyContent} <br> --%>
			<a class="list-group-item list-group-item-action">
				<div class="d-flex w-100 justify-content-between">
	                <h5 class="mb-1">Notify Message${varStatusName.count}</h5>
	                <small><fmt:formatDate value="${notifyPer.notifyTime}" pattern="yyyy-MM-dd hh:mm:DD"/></small>
	            </div>
	            <p class="mb-1">${notifyPer.notifyContent}</p>
<!-- 	            <small>And some small print.</small> -->
            </a>
		</c:forEach>
	
<!--         <a class="list-group-item list-group-item-action"> -->
<!--             <div class="d-flex w-100 justify-content-between"> -->
<!--                 <h5 class="mb-1">List group item heading</h5> -->
<!--                 <small>3 days ago</small> -->
<!--             </div> -->
<!--             <p class="mb-1">Some placeholder content in a paragraph.</p> -->
<!--             <small>And some small print.</small> -->
<!--         </a> -->
    </div>
    
	
</body>
</html>