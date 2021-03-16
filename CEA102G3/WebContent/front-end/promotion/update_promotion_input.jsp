<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.promotion.model.*"%>

<%
	PromotionVO promotionVO = (PromotionVO) request.getAttribute("promotionVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�D���P�P��ƭק� - update_promotion_input.jsp</title>

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
		 <h3>�D���P�P��ƭק� - update_promotion_input.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/promotion/select_promotion_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="promotion.do" name="form1" enctype="multipart/form-data">
<table>

		  	<tr>
		<td>�D���P�P�s��:<font color=red><b></b></font></td>
		<td><%=promotionVO.getPromot_No()%></td>
	</tr>
	
			<tr>
		<td>�D���P�P���e:</td>
		<td><input type="TEXT" name="promot_Content" size="30"  value="<%=promotionVO.getPromot_Content()%>" /></td>
	</tr>
	
			<tr>
		<td>�D���P�P�}�l���:</td>
		<td><input type="text" id="f_date1" size="6" name="promot_Start" value="<%=promotionVO.getPromot_Start()%>" /></td>
	</tr>
	
			<tr>
		<td>�D���P�P�I����:</td>
		<td><input type="text" id="f_date2" size="6" name="promot_End" value="<%=promotionVO.getPromot_End()%>" /></td>
	</tr>
	
			<tr>
		<td>�s�i�W�[���:</td>
		<td><input type="text" id="f_date3" size="6" name="release_Date" value="<%=promotionVO.getRelease_Date()%>" /></td>
	</tr>
	
		
<!-- 			<tr> -->
<!-- 		<td>�D���P�P�ӫ~ID:<font color=red><b></b></font></td> -->
<%-- 		<td><%=promotionVO.getPromot_Product_No()%></td> --%>
<!-- 	</tr> -->
	
				<tr>
		<td>�D���P�P�ӫ~ID:<font color=red><b></b></font></td>
		<td><input type="TEXT" name="promot_Product_No" size="30" value="<%=promotionVO.getPromot_Product_No()%>" /></td>
	</tr>
	
	

			<tr>
		<td>�P�P�ӫ~����:</td>
		<td><input type="TEXT" name="promot_Product_Price" size="30" value="<%=promotionVO.getPromot_Product_Price()%>" /></td>
	</tr>
	
	
			<tr>
		<td>�D���P�P���D:</td>
		<td><input type="TEXT" name="promot_Product_Title" size="30"  value="<%=promotionVO.getPromot_Product_Title()%>" /></td>
	</tr>
	
	
	
			<tr>
		<td>�P�P�ӫ~�Ӥ�:</td>
		<td><input type="file" id="progressbarTWInput" name="promot_Product_Pic" accept="image/gif, image/jpeg, image/png">
    	<img id="preview_progressbarTW_img" src="" /></td>
	</tr>
	
	
		<jsp:useBean id="proSvc" scope="page" class="com.promotion.model.PromotionService" />

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="promot_No" value="<%=promotionVO.getPromot_No()%>">
<%-- <input type="hidden" name="promot_Product_No" value="<%=promotionVO.getPromot_Product_No()%>"> --%>
<input type="submit" value="�e�X�ק�"></FORM>


</body>

<!-- Promot_Start (�D���P�P�}�l���) -->
<% 
  java.sql.Date promot_Start  = null;
  try {
	  promot_Start = promotionVO.getPromot_Start();
   } catch (Exception e) {
	   promot_Start = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Promot_End (�D���P�P�I����) -->
<% 
  java.sql.Date promot_End = null;
  try {
	  promot_End = promotionVO.getPromot_End();
   } catch (Exception e) {
	   promot_End = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Release_Date (�s�i�W�[���) -->
<% 
  java.sql.Date release_Date = null;
  try {
	  release_Date = promotionVO.getRelease_Date();
   } catch (Exception e) {
	   release_Date = new java.sql.Date(System.currentTimeMillis());
   }
%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
<!-- Promot_Start (�D���P�P�}�l���) -->
$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_Start%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
   //startDate:	            '2017/07/10',  // �_�l��
   //minDate:               '-1970-01-01', // �h������(���t)���e
   //maxDate:               '+1970-01-01'  // �h������(���t)����
});

<!-- Promot_End (�D���P�P�I����) -->
$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_End%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
   //startDate:	            '2017/07/10',  // �_�l��
   //minDate:               '-1970-01-01', // �h������(���t)���e
   //maxDate:               '+1970-01-01'  // �h������(���t)����
});

<!-- Release_Date (�s�i�W�[���) -->
        $.datetimepicker.setLocale('zh');
        $('#f_date3').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=release_Date%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           //maxDate:               '+1970-01-01'  // �h������(���t)����
        });
        
        
   
        // ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

        //      1.�H�U���Y�@�Ѥ��e������L�k���
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

        
        //      2.�H�U���Y�@�Ѥ��᪺����L�k���
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


        //      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
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
        
// �H�U�O��Ӥ��W�ǷӤ��~�|�ϥ�        
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