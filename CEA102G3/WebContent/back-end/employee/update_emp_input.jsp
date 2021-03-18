<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>

<%
  EmployeeVO employeeVO = (EmployeeVO) request.getAttribute("employeeVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料修改 - update_emp_input.jsp</title>






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
		 <h3>員工資料修改 - update_emp_input.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/back-end/employee/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" name="form1" enctype="multipart/form-data">
<table>

		<tr>
		<td>員工編號:<font color=red><b></b></font></td>
		<td><%=employeeVO.getEmplo_No()%></td>
		</tr>
	
		<tr>
		<td>員工帳號:<font color=red><b></b></font></td>
		<td><%=employeeVO.getAccount()%></td>
		</tr>
	
<!-- 		<tr> -->
<!-- 		<td>員工密碼:<font color=red><b></b></font></td> -->
<%-- 		<td><%=employeeVO.getPassword()%></td> --%>
<!-- 		</tr> -->
	
	
		<tr>
		<td>員工姓名:<font color=red><b></b></font></td>
		<td><%=employeeVO.getName()%></td>
		</tr>
		
		<tr>
		<td>員工性別:<font color=red><b></b></font></td>
		<td>${employeeVO.sex==0?"女性":"男性" }</td>
		</tr>
		
		
	<tr>
		<td>電話:</td>
		<td><input type="TEXT" name="phone" size="20" value="<%=employeeVO.getPhone()%>" /></td>
	</tr>
	
		<tr>
		<td>電子信箱:</td>
		<td><input type="text" id="email" name="email" value="<%=employeeVO.getEmail()%>" /></td>
	</tr>
	
	
	
		<tr>
		<td>員工到職日:<font color=red><b></b></font></td>
		<td><%=employeeVO.getStart_From()%></td>
		</tr>
	
	
	<tr>
		<td>員工職位狀態:</td>
		<td><label><input type="radio"  id="emp_State" name="emp_State" value="1" checked>在職中 </label>
		<label><input type="radio"  id="emp_State" name="emp_State" value="0">已離職 </label></td>

	</tr>

    	
				<tr>
		<td>員工照片:</td>
		<td>
    	<img id="preview_progressbarTW_img" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=employee&column=Emp_Pic&idname=Emplo_No&id=<%=employeeVO.getEmplo_No()%>" />
    	<input type="file" id="progressbarTWInput" name="emp_Pic" accept="image/gif, image/jpeg, image/png">
    	</td>
	</tr>
	
	
	
	<jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmployeeService" />


</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="emplo_No" value="<%=employeeVO.getEmplo_No()%>">
<input type="hidden" name="account" value="<%=employeeVO.getAccount()%>">
<input type="hidden" name="name" value="<%=employeeVO.getName()%>">
<input type="hidden" name="sex" value="<%=employeeVO.getSex()%>">
<input type="hidden" name="start_From" value="<%=employeeVO.getStart_From()%>">
<input type="submit" value="送出修改"></FORM>


</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<% 
  java.sql.Date start_From = null;
  try {
	  start_From = employeeVO.getStart_From();
   } catch (Exception e) {
	   start_From = new java.sql.Date(System.currentTimeMillis());
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
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:false,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=employeeVO.getStart_From()%>', // value:   new Date(),
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