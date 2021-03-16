<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>

<%
  EmployeeVO employeeVO = (EmployeeVO) request.getAttribute("employeeVO"); //EmpServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>���u��ƭק� - update_emp_input.jsp</title>

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
		 <h3>���u��ƭק� - update_emp_input.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/employee/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
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

<FORM METHOD="post" ACTION="employee.do" name="form1" enctype="multipart/form-data">
<table>

		<tr>
		<td>���u�s��:<font color=red><b></b></font></td>
		<td><%=employeeVO.getEmplo_No()%></td>
		</tr>
	
		<tr>
		<td>���u�b��:<font color=red><b></b></font></td>
		<td><%=employeeVO.getAccount()%></td>
		</tr>
	
<!-- 		<tr> -->
<!-- 		<td>���u�K�X:<font color=red><b></b></font></td> -->
<%-- 		<td><%=employeeVO.getPassword()%></td> --%>
<!-- 		</tr> -->
	
	
		<tr>
		<td>���u�m�W:<font color=red><b></b></font></td>
		<td><%=employeeVO.getName()%></td>
		</tr>
		
		<tr>
		<td>���u�ʧO:<font color=red><b></b></font></td>
		<td><%=employeeVO.getSex()%></td>
		</tr>
		
		
	<tr>
		<td>�q��:</td>
		<td><input type="TEXT" name="phone" size="20" value="<%=employeeVO.getPhone()%>" /></td>
	</tr>
	
		<tr>
		<td>�q�l�H�c:</td>
		<td><input type="text" id="email" name="email" value="<%=employeeVO.getEmail()%>" /></td>
	</tr>
	
	
	
		<tr>
		<td>���u��¾��:<font color=red><b></b></font></td>
		<td><%=employeeVO.getStart_From()%></td>
		</tr>
	
	
	<tr>
		<td>���u���A:</td>
		<td><input type="TEXT" name="emp_State" size="5"	value="<%=employeeVO.getEmp_State()%>" /></td>
	</tr>

	
	<tr>
		<td>���u�Ӥ�:</td>
		<td><input type="file" id="progressbarTWInput" name="news_Pic" accept="image/gif, image/jpeg, image/png">
    	<img id="preview_progressbarTW_img" src="" /></td>
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
<input type="submit" value="�e�X�ק�"></FORM>


</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->

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
 	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=employeeVO.getStart_From()%>', // value:   new Date(),
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