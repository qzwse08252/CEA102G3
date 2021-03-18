<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  EmployeeVO employeeVO = (EmployeeVO) request.getAttribute("employeeVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

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
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - ListOneEmp.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back-end/employee/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>員工編號</th>
		<th>員工帳號</th>
		<th>姓名</th>
		<th>性別</th>
		<th>電話</th>
		<th>電子信箱</th>
		<th>到職日</th>
		<th>員工狀態</th>
		<th>員工照片</th>
	</tr>
	<tr>
		<td><%=employeeVO.getEmplo_No()%></td>
		<td><%=employeeVO.getAccount()%></td>
		<td><%=employeeVO.getName()%></td>
<%-- 		<td><%=employeeVO.getSex()%></td> --%>
		<td>${employeeVO.sex==0?"女性":"男性" }</td>
		<td><%=employeeVO.getPhone()%></td>
		<td><%=employeeVO.getEmail()%></td>
		<td><%=employeeVO.getStart_From()%></td>
<%-- 		<td><%=employeeVO.getEmp_State()%></td> --%>
		<td>${employeeVO.emp_State==0?"離職":"在職中" }</td>
		<td><img width="400" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=employee&column=Emp_Pic&idname=Emplo_No&id=${employeeVO.emplo_No}"/></td>
	</tr>
</table>

</body>
</html>