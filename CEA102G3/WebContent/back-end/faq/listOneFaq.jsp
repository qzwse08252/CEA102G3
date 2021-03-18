<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.faq.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%FaqVO faqVO = (FaqVO) request.getAttribute("faqVO");%>



<html>
<head>
<title>員工資料 - listOneFaq.jsp</title>

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
		 <h3>員工資料 - listOneFaq.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/faq/select_faq_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>常見問題編號</th>
		<th>常見問題</th>
		<th>常見問題回覆</th>
		<th>常見問題更新時間</th>

	</tr>
	<tr>
		<td><%=faqVO.getQuestion_No()%></td>
		<td><%=faqVO.getQuestion()%></td>
		<td><%=faqVO.getAnswer()%></td>
		<td><%=faqVO.getUpdate_Time()%></td>


	</tr>
</table>

</body>
</html>