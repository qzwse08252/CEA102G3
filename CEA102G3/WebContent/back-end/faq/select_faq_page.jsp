<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>GuideMe - 常見管理列表</title>

<style>
  table#table-1 {
	width: 516px;
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

   <tr><td><h3>GuideMe - 常見管理列表</h3></td></tr>
</table>
<div style="border-width:3px; width:500px;border-style:dashed;border-color:#FFAC55;padding:5px;"> 

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
  <li><a href='listAllFaq.jsp'>List</a> all Emps.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/faq/faq.do" >
        <b>輸入常見問題標題:</b>
        <input type="text" name="question_No">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="faqSvc" scope="page" class="com.faq.model.FaqService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/faq/faq.do" >
       <b>選擇常見問題:</b>
       <select size="1" name="question_No">
         <c:forEach var="faqVO" items="${faqSvc.all}" > 
          <option value="${faqVO.question_No}">${faqVO.question}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  

</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addFaq.jsp'>Add</a> a new Emp.</li>
</ul>
</div>
</body>
</html>