<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.news.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%NewsVO newsVO = (NewsVO) request.getAttribute("newsVO");%>
<!DOCTYPE html>


<html>
<head>
<title>員工資料 - listOneNews.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 1250px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: left;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>最新消息資料 - listOneNews.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back-end/news/select_news_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>最新消息ID</th>
		<th>最新消息發佈日期</th>
		<th>最新消息標題</th>
		<th>最新消息內容</th>
		<th>最新消息照片</th>
	</tr>
	<tr>
	
	
		<td>${newsVO.news_No}</td>
		<td>${newsVO.release_Date}</td>
		<td>${newsVO.news_Title}</td>
		<td>${newsVO.news_Content}</td>
		
		
<%-- 		<td><%=newsVO.getNews_No()%></td> --%>
<%-- 		<td><%=newsVO.getRelease_Date()%></td> --%>
<%-- 		<td><%=newsVO.getNews_Title()%></td> --%>
<%-- 		<td><%=newsVO.getNews_Content()%></td> --%>
		<td><img width="400" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=news&column=News_Pic&idname=News_No&id=${newsVO.news_No}"/></td>

	</tr>
</table>

</body>
</html>