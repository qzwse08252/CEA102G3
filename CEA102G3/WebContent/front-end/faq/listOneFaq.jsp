<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.faq.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%-- ���X Concroller EmpServlet.java�w�s�Jrequest��EmpVO����--%>
<%FaqVO faqVO = (FaqVO) request.getAttribute("faqVO");%>



<html>
<head>
<title>���u��� - listOneFaq.jsp</title>

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

<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>���u��� - listOneFaq.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/faq/select_faq_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�`�����D�s��</th>
		<th>�`�����D</th>
		<th>�`�����D�^��</th>
		<th>�`�����D��s�ɶ�</th>

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