<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.emp.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
  EmployeeVO employeeVO = (EmployeeVO) request.getAttribute("employeeVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>���u��� - listOneEmp.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>���u��� - ListOneEmp.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/employee/select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>���u�s��</th>
		<th>���u�b��</th>
		<th>�m�W</th>
		<th>�ʧO</th>
		<th>�q��</th>
		<th>�q�l�H�c</th>
		<th>��¾��</th>
		<th>���u���A</th>
		<th>���u�Ӥ�</th>
	</tr>
	<tr>
		<td><%=employeeVO.getEmplo_No()%></td>
		<td><%=employeeVO.getAccount()%></td>
		<td><%=employeeVO.getName()%></td>
		<td><%=employeeVO.getSex()%></td>
		<td><%=employeeVO.getPhone()%></td>
		<td><%=employeeVO.getEmail()%></td>
		<td><%=employeeVO.getStart_From()%></td>
		<td><%=employeeVO.getEmp_State()%></td>
		<td><img width="400" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=employee&column=Emp_Pic&idname=Emplo_No&id=${employeeVO.emplo_No}"/></td>
	</tr>
</table>

</body>
</html>