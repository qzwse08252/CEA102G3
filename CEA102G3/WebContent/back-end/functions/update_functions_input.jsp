<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.functions.model.*"%>

<%
	FunctionsVO functionsVO = (FunctionsVO) request.getAttribute("functionsVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>功能資料修改 - update_functions_input.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>功能資料修改 - update_functions_input.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/functions/select_functions_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="functions.do" name="form1">
<table>

		<tr>
		<td>功能編號:<font color=red><b></b></font></td>
		<td><%=functionsVO.getFunct_No()%></td>
	</tr>
	<tr>
	
	<tr>
		<td>功能名稱:</td>
		<td><input type="TEXT" name="funct_Name" size="40" value="<%=functionsVO.getFunct_Name()%>" /></td>
	</tr>


		<jsp:useBean id="funSvc" scope="page" class="com.functions.model.FunctionsService" />
	
<!-- 	<tr> -->
<!-- 		<td>常見問題照片:</td> -->
<!-- 		<td><input type="file" id="progressbarTWInput" accept="image/gif, image/jpeg, image/png" name="faqPic" -->
<%-- 		value="<%=faqVO==null ? "" : faqVO.getFaqPic() %>"> --%>
<!--     						<img id="preview_progressbarTW_img" src="" /></td> -->
<!-- 	</tr> -->



</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="funct_No" value="<%=functionsVO.getFunct_No()%>">
<input type="submit" value="送出修改"></FORM>


</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->


<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/resources/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
        
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
 
        
// 以下為上傳照片才會用到        
        
 
</script>
</html>