<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    EmployeeService empSvc = new EmployeeService();
    List<EmployeeVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>



<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>

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


<table id="table-1">
	<tr><td>
		 <h3>Guidme員工資料-listAllEmp.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back-end/employee/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

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
		<th>修改</th>
		<th>刪除</th>
 
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="employeeVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
				<tr>
		
			<td>${employeeVO.emplo_No}</td>
			<td>${employeeVO.account}</td>
			<td>${employeeVO.name}</td>
<%-- 			<td>${employeeVO.sex}</td> --%>
			<td>${employeeVO.sex==0?"女性":"男性" }</td>
			<td>${employeeVO.phone}</td>
			<td>${employeeVO.email}</td>
			<td><fmt:formatDate value="${employeeVO.start_From}" pattern="yyyy-MM-dd"/></td>
<%-- 			<td>${employeeVO.emp_State}</td> --%>
			<td>${employeeVO.emp_State==0?"離職":"在職中" }</td>
			<td><img width="400" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=employee&column=Emp_Pic&idname=Emplo_No&id=${employeeVO.emplo_No}"/></td>
			
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="emplo_No"  value="${employeeVO.emplo_No}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="emplo_No"  value="${employeeVO.emplo_No}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>