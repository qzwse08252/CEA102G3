<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.functions.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%
	FunctionsVO functionsVO = (FunctionsVO) request.getAttribute("functionsVO");
%>



<html>
<head>
<title>功能資料 - listOneFunction.jsp</title>

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
		 <h3>功能資料 - listOneFunctios.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/functions/select_functions_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>功能編號</th>
		<th>功能名稱</th>


	</tr>
	<tr>
		<td><%=functionsVO.getFunct_No()%></td>
		<td><%=functionsVO.getFunct_Name()%></td>


	</tr>
</table>

</body>
</html>