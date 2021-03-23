<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.promotion.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	PromotionService proSvc = new PromotionService();
    List<PromotionVO> list = proSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有主打促銷問題資料 - listAllPromotion.jsp</title>

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
	width: 1200px;
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


<table id="table-1">
	<tr><td>
		 <h3>所有主打促銷消息資料 - listAllPromotion.jsp</h3>
 <h4><a href="<%=request.getContextPath()%>/back-end/promotion/select_promotion_page.jsp">回首頁</a></h4>
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
<!-- 		<th>主打促銷消息ID</th> -->
<!-- 		<th>商品ID</th> -->
		<th>主打促銷開始日期</th>
		<th>主打促銷截止日期</th>
		<th>廣告上架日期</th>
		<th>促銷商品標題</th>
		<th>主打促銷內容</th>
		<th>促銷商品價格</th>
		<th>促銷商品照片</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	
	
	
	<%@ include file="page1.file" %> 
	<c:forEach var="promotionVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
<%-- 			<td>${promotionVO.promot_No}</td> --%>
<%-- 			<td>${promotionVO.promot_Product_No}</td> --%>
			<td><fmt:formatDate value="${promotionVO.promot_Start}" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${promotionVO.promot_End}" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${promotionVO.release_Date}" pattern="yyyy-MM-dd"/></td>
			<td>${promotionVO.promot_Content}</td>
			<td>${promotionVO.promot_Product_Title}</td>
			<td>${promotionVO.promot_Product_Price}</td>
			<td><img  width="400px" height="280px" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=promotion&column=Promot_Product_Pic&idname=Promot_No&id=${promotionVO.promot_No}"/></td>

						<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="promot_No"  value="${promotionVO.promot_No}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="promot_No"  value="${promotionVO.promot_No}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>

		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>