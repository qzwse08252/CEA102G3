<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.promotion.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%-- ���X Concroller EmpServlet.java�w�s�Jrequest��EmpVO����--%>
<%PromotionVO promotionVO = (PromotionVO) request.getAttribute("promotionVO");%>



<html>
<head>
<title>�D���P�P��� - listOnePromotion.jsp</title>

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
		 <h3>���u��� - listOnePromotion.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/promotion/select_promotion_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�D���P�P����ID</th>
		<th>�ӫ~ID</th>
		<th>�D���P�P�}�l���</th>
		<th>�D���P�P�I����</th>
		<th>�s�i�W�[���</th>
		<th>�P�P�ӫ~���D</th>
		<th>�D���P�P���e</th>
		<th>�P�P�ӫ~����</th>
		<th>�P�P�ӫ~�Ӥ�</th>
	</tr>
	<tr>
			<td>${promotionVO.promot_No}</td>
			<td>${promotionVO.promot_Product_No}</td>
			<td>${promotionVO.promot_Start}</td>
			<td>${promotionVO.promot_End}</td>
			<td>${promotionVO.release_Date}</td>
			<td>${promotionVO.promot_Product_Title}</td>
			<td>${promotionVO.promot_Content}</td>
			<td>${promotionVO.promot_Product_Price}</td>
			<td><img width="400" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=promotion&column=Promot_Product_Pic&idname=Promot_No&id=${promotionVO.promot_No}"/></td>

	</tr>
</table>

</body>
</html>