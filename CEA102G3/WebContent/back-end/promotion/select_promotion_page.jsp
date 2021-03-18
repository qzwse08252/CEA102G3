<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Promotion: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM PromotionVO: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM PromotionVO: Home</p>

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
  <li><a href='listAllPromotion.jsp'>List</a> all Promotion.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" >
        <b>促銷標題編號:</b>
        <input type="text" name="promot_No">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="proSvc" scope="page" class="com.promotion.model.PromotionService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" >
       <b>選擇促銷標題:</b>
       <select size="1" name="promot_No">
         <c:forEach var="promotionVO" items="${proSvc.all}" > 
          <option value="${promotionVO.promot_No}">${promotionVO.promot_Product_Title}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
</ul>


<h3>主打促銷管理</h3>

<ul>
  <li><a href='addPromotion.jsp'>Add</a> a new Promotion.</li>
</ul>

</body>
</html>