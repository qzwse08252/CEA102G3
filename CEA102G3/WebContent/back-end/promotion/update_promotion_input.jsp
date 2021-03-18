<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.promotion.model.*"%>

<%
	PromotionVO promotionVO = (PromotionVO) request.getAttribute("promotionVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>主打促銷資料修改 - update_promotion_input.jsp</title>

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
		 <h3>主打促銷資料修改 - update_promotion_input.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back-end/promotion/select_promotion_page.jsp">回首頁</a></h4>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" name="form1" enctype="multipart/form-data">
<table>

		  	<tr>
		<td>主打促銷編號:<font color=red><b></b></font></td>
		<td><%=promotionVO.getPromot_No()%></td>
	</tr>
	
			<tr>
		<td>主打促銷商品ID:<font color=red><b></b></font></td>
		<td><input type="TEXT" name="promot_Product_No" size="30" value="<%=promotionVO.getPromot_Product_No()%>" /></td>
	</tr>
	
		
			<tr>
		<td>主打促銷開始日期:</td>
		<td><input type="text" id="f_date1" size="6" name="promot_Start" value="<%=promotionVO.getPromot_Start()%>" /></td>
	</tr>
	
			<tr>
		<td>主打促銷截止日期:</td>
		<td><input type="text" id="f_date2" size="6" name="promot_End" value="<%=promotionVO.getPromot_End()%>" /></td>
	</tr>
	
			<tr>
		<td>廣告上架日期:</td>
		<td><input type="text" id="f_date3" size="6" name="release_Date" value="<%=promotionVO.getRelease_Date()%>" /></td>
	</tr>
	
	
				<tr>
		<td>主打促銷標題:</td>
		<td><input type="TEXT" name="promot_Product_Title" size="30"  value="<%=promotionVO.getPromot_Product_Title()%>" /></td>
	</tr>


				<tr>
		<td>主打促銷內容:</td>
		<td><input type="TEXT" name="promot_Content" size="30"  value="<%=promotionVO.getPromot_Content()%>" /></td>
	</tr>
	


			<tr>
		<td>促銷商品價格:</td>
		<td><input type="TEXT" name="promot_Product_Price" size="30" value="<%=promotionVO.getPromot_Product_Price()%>" /></td>
	</tr>
	
	
			<tr>
		<td>促銷商品照片:</td>
		<td>
    	<img id="preview_progressbarTW_img" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=promotion&column=Promot_Product_Pic&idname=Promot_No&id=<%=promotionVO.getPromot_No()%>" />
    	<input type="file" id="progressbarTWInput" name="promot_Product_Pic" accept="image/gif, image/jpeg, image/png">
    	</td>
	</tr>
	
	
		<jsp:useBean id="proSvc" scope="page" class="com.promotion.model.PromotionService" />

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="promot_No" value="<%=promotionVO.getPromot_No()%>">
<%-- <input type="hidden" name="promot_Product_No" value="<%=promotionVO.getPromot_Product_No()%>"> --%>
<input type="submit" value="送出修改"></FORM>


</body>

<!-- Promot_Start (主打促銷開始日期) -->
<% 
  java.sql.Date promot_Start  = null;
  try {
	  promot_Start = promotionVO.getPromot_Start();
   } catch (Exception e) {
	   promot_Start = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Promot_End (主打促銷截止日期) -->
<% 
  java.sql.Date promot_End = null;
  try {
	  promot_End = promotionVO.getPromot_End();
   } catch (Exception e) {
	   promot_End = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Release_Date (廣告上架日期) -->
<% 
  java.sql.Date release_Date = null;
  try {
	  release_Date = promotionVO.getRelease_Date();
   } catch (Exception e) {
	   release_Date = new java.sql.Date(System.currentTimeMillis());
   }
%>

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
<!-- Promot_Start (主打促銷開始日期) -->
$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_Start%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
   //startDate:	            '2017/07/10',  // 起始日
   minDate:               '-1970-01-01', // 去除今日(不含)之前
   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});

<!-- Promot_End (主打促銷截止日期) -->
$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_End%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
   //startDate:	            '2017/07/10',  // 起始日
   minDate:               '-1970-01-01', // 去除今日(不含)之前
   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});

<!-- Release_Date (廣告上架日期) -->
        $.datetimepicker.setLocale('zh');
        $('#f_date3').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=release_Date%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
   
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
        
// 以下是放照片上傳照片才會使用        
        $("#progressbarTWInput").change(function(){

  readURL(this);

});

 

function readURL(input){

  if(input.files && input.files[0]){

    var reader = new FileReader();

    reader.onload = function (e) {

       $("#preview_progressbarTW_img").attr('src', e.target.result);

    }

    reader.readAsDataURL(input.files[0]);

  }

}
        
        
        
</script>
</html>