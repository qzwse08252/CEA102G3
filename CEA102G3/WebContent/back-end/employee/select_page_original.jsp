<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>員工管理列表</title>
<style>
  table#table-1 {
	width: 800px;
	background-color: black;
	margin-top: 0px;
	margin-bottom: 10px;
    border: 3px ridge Gray;

    text-align: center;
    color:white;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 0px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>GuideMe - 員工管理列表</h3></td></tr>
</table>


<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li>GuideMe <a href='listAllEmp.jsp'>所有員工列表</a></li>
  
  
<!--   <li> -->
<%--     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" > --%>
<!--         <b>輸入員工編號:</b> -->
<!--         <input type="text" name="emplo_No"> -->
<!--         <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--         <input type="submit" value="送出"> -->
<!--     </FORM> -->
<!--   </li> -->

  <jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmployeeService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" >
       <b>選擇員工編號:</b>
       <select size="1" name="emplo_No">
         <c:forEach var="employeeVO" items="${empSvc.all}" > 
          <option value="${employeeVO.emplo_No}">${employeeVO.emplo_No}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" >
       <b>選擇員工姓名:</b>
       <select size="1" name="emplo_No">
         <c:forEach var="employeeVO" items="${empSvc.all}" > 
          <option value="${employeeVO.emplo_No}">${employeeVO.name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addEmp.jsp'>Add</a> a new Emp.</li>
</ul>

</body>
</html>