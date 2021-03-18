<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.promotion.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%PromotionVO promotionVO = (PromotionVO) request.getAttribute("promotionVO");%>



<html>
<head>
<title>主打促銷資料 - listOnePromotion.jsp</title>

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
		 <h3>員工資料 - listOnePromotion.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back-end/promotion/select_promotion_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>主打促銷消息ID</th>
		<th>商品ID</th>
		<th>主打促銷開始日期</th>
		<th>主打促銷截止日期</th>
		<th>廣告上架日期</th>
		<th>促銷商品標題</th>
		<th>主打促銷內容</th>
		<th>促銷商品價格</th>
		<th>促銷商品照片</th>
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