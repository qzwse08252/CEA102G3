<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    EmployeeService empSvc = new EmployeeService();
    List<EmployeeVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<%
EmployeeVO employeeVO = (EmployeeVO) request.getAttribute("employeVO");
%>

<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>員工管理列表</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 15px;
	width:auto;

}
.table-responsive {
    margin: 30px 0;
    
}
.table-wrapper {
	background: #fff;
	padding: 15px 10px;
	border-radius: 3px;
	max-width:auto;
	box-shadow: 0 1px 1px rgba(0,0,0,.05);

}
.table-title {        
	padding-bottom: 15px;
	background: #435d7d;
	color: #fff;
	padding: 16px 30px;
	min-width: 100%;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}
.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
	color: yellow;
	
}

.table-title a {
	margin: 5px 0 0;

	color: yellow;
	
}




.table-title .btn-group {
	float: right;
}
.table-title .btn {
	color: #fff;
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}
.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}
.table-title .btn span {
	float: left;
	margin-top: 2px;
}
table.table tr th, table.table tr td {
	border-color: #e9e9e9;
	padding: 1px 1px;
	vertical-align: middle;
}
table.table tr th:first-child {
	width: auto;
}
table.table tr th:last-child {
	width: auto;
}
table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}
table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}
table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}	
table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}
table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
	outline: none !important;
}
table.table td a:hover {
	color: #2196F3;
}
table.table td a.edit {
	color: #FFC107;
}
table.table td a.delete {
	color: #F44336;
}
table.table td i {
	font-size: 19px;
}
table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}
.pagination {
	float: right;
	margin: 0 0 5px;
}
.pagination li a {
	border: none;
	font-size: 13px;
	min-width: 30px;
	min-height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 2px !important;
	text-align: center;
	padding: 0 6px;
}
.pagination li a:hover {
	color: #666;
}	
.pagination li.active a, .pagination li.active a.page-link {
	background: #03A9F4;
}
.pagination li.active a:hover {        
	background: #0397d6;
}
.pagination li.disabled i {
	color: #ccc;
}
.pagination li i {
	font-size: 16px;
	padding-top: 6px
}
.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
}    
/* Custom checkbox */
.custom-checkbox {
	position: relative;
}
.custom-checkbox input[type="checkbox"] {    
	opacity: 0;
	position: absolute;
	margin: 5px 0 0 3px;
	z-index: 9;
}
.custom-checkbox label:before{
	width: 18px;
	height: 18px;
}
.custom-checkbox label:before {
	content: '';
	margin-right: 10px;
	display: inline-block;
	vertical-align: text-top;
	background: white;
	border: 1px solid #bbb;
	border-radius: 2px;
	box-sizing: border-box;
	z-index: 2;
}
.custom-checkbox input[type="checkbox"]:checked + label:after {
	content: '';
	position: absolute;
	left: 6px;
	top: 3px;
	width: 6px;
	height: 11px;
	border: solid #000;
	border-width: 0 3px 3px 0;
	transform: inherit;
	z-index: 3;
	transform: rotateZ(45deg);
}
.custom-checkbox input[type="checkbox"]:checked + label:before {
	border-color: #03A9F4;
	background: #03A9F4;
}
.custom-checkbox input[type="checkbox"]:checked + label:after {
	border-color: #fff;
}
.custom-checkbox input[type="checkbox"]:disabled + label:before {
	color: #b8b8b8;
	cursor: auto;
	box-shadow: none;
	background: #ddd;
}
/* Modal styles */
.modal .modal-dialog {
	max-width: 400px;
}
.modal .modal-header, .modal .modal-body, .modal .modal-footer {
	padding: 20px 30px;
}
.modal .modal-content {
	border-radius: 3px;
	font-size: 14px;
}
.modal .modal-footer {
	background: #ecf0f1;
	border-radius: 0 0 3px 3px;
}
.modal .modal-title {
	display: inline-block;
}
.modal .form-control {
	border-radius: 2px;
	box-shadow: none;
	border-color: #dddddd;
}
.modal textarea.form-control {
	resize: vertical;
}
.modal .btn {
	border-radius: 2px;
	min-width: 100px;
}	
.modal form label {
	font-weight: normal;
}	



</style>
<script>
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox1"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
</script>
</head>

<!-- 套版  -->

<body>
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>GuideMe員工管理列表</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>新增員工</span></a>
						<a href="#deleteEmployeeModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>刪除</span></a>						
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>

					<tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
							<th>員工編號</th>
							<th>員工帳號</th>
							<th>姓名</th>
							<th>性別</th>
							<th>聯絡電話</th>
							<th>電子信箱</th>
							<th>就職日</th>
							<th>狀態</th>
							<th>員工照片</th>
							<th>修改/刪除</th>

					</tr>
				</thead>
				<tbody>

			<%@ include file="page1.file" %> 
				<form METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" name="form1" class="deleteform" >
					<c:forEach var="employeeVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">				
						<tr>
							<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox1" name="emplo_No" value="${employeeVO.emplo_No}">
								<label for="checkbox1"></label>
							</span>
						
							<td>${employeeVO.emplo_No}</td>
							<td>${employeeVO.account}</td>
							<td>${employeeVO.name}</td>
				<%-- 			<td>${employeeVO.sex}</td> --%>
							<td>${employeeVO.sex==0?"女性":"男性" }</td>
							<td>${employeeVO.phone}</td>
							<td>${employeeVO.email}</td>
							<td><fmt:formatDate value="${employeeVO.start_From}" pattern="yyyy-MM-dd"/></td>
				<%-- 			<td>${employeeVO.emp_State}</td> --%>
							<td>${employeeVO.emp_State==0?"離職":"在職中" }</td>
							<td><img width="100" height="70" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=employee&column=Emp_Pic&idname=Emplo_No&id=${employeeVO.emplo_No}"/></td>
						
							
						<td>
							<a href="#editEmployeeModal" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit" >&#xE254;</i></a>
							<a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						</td>
					</tr>				
	</c:forEach>
		<input type="hidden" class="btn btn-danger" name="action"  value="delete">
			</form>
					
				</tbody>
			</table>
<%@ include file="page2.file" %>

<!-- 			<div class="clearfix"> -->
<!-- 				<div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div> -->
<!-- 				<ul class="pagination"> -->
<!-- 					<li class="page-item disabled"><a href="#">Previous</a></li> -->
<!-- 					<li class="page-item"><a href="#" class="page-link">1</a></li> -->
<!-- 					<li class="page-item"><a href="#" class="page-link">2</a></li> -->
<!-- 					<li class="page-item active"><a href="#" class="page-link">3</a></li> -->
<!-- 					<li class="page-item"><a href="#" class="page-link">4</a></li> -->
<!-- 					<li class="page-item"><a href="#" class="page-link">5</a></li> -->
<!-- 					<li class="page-item"><a href="#" class="page-link">Next</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
		</div>
	</div>        
</div>
<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" name="form1" enctype="multipart/form-data">
				<div class="modal-header">						
					<h4 class="modal-title">Add Employee</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
	
				
				
				<div class="modal-body">				
					<div class="form-group">
						</div>
                    
					<div class="">
						<label>員工帳號</label>
                          <input type="text"  id="account" placeholder="請輸入 3~10位英文與數字 !" name="account" oninvalid="alert('Oh! 沒有填寫員工帳號!');" required
                          value="<%=employeeVO==null ? "" : employeeVO.getAccount() %>">
                          </div>
                          
					<div class="">
						<label>員工密碼</label>
                           <input type="password"  id="password" placeholder="請輸入3~10位英文與數字 !" name="password" oninvalid="alert('Oh! 沒有填寫員工密碼!');" required
                            value="<%=employeeVO==null ? "" : employeeVO.getPassword() %>">
                           </div>
                           
                           
					<div class="">
						<label>姓名</label>
                           <input type="text"  id="name" name="name" placeholder="請輸入2~10位英文或中文 !" oninvalid="alert('Oh! 沒有填寫員工姓名!');" required
                            value="<%=employeeVO==null ? "" : employeeVO.getName() %>">
                           </div>
					
					
					<div class="">
						<label>性別</label> 
                           <input type="radio"  id="sex" name="sex" 
                            value="1">男性
                            <input type="radio"  id="sex" name="sex"
                            value="0">女性
                            </div>
					
					<div class="">
						<label>電話</label>
                            <input type="text"   id="phone" placeholder="請填寫手機或家裡電話 !" name="phone" oninvalid="alert('Oh! 沒有填寫電話!');" required
                            value="<%=employeeVO==null ? "" : employeeVO.getPhone() %>">
                            </div>
                            
					<div class="">
						<label>電子信箱</label>
                            <input type="text"   id="email" name="email" placeholder="請填寫常用電子信箱!"  oninvalid="alert('Oh! 沒有填寫電子信箱!');" required
                            value="<%=employeeVO==null ? "" : employeeVO.getEmail() %>">
                            </div>
                            
					<div class="">
						<label>到職日</label>
                            <input type="text"  id="f_date1" name="start_From">
                            </div>
					
					<div class="">
						<label>員工狀態</label>
                           <input type="radio"  id="emp_State" name="emp_State"
                            value="1" checked>在職中

                            </div> 
					
					<div class="">
						<label>員工照片</label>
                            <input type="file" class="progressbarTWInput" accept="image/gif, image/jpeg, image/png" name="emp_Pic" 
                            oninvalid="alert('Oh! 照片沒有上傳!');" required value="<%=employeeVO==null ? "" : employeeVO.getEmp_Pic() %>">
    						<img class="preview_progressbarTW_img"  width="150px" height="112px"/>
      						</div>
		
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="取消">
					<input type="submit" class="btn btn-success" value="送出新增"></div>
					<input type="hidden"  class="btn btn-success" name="action" value="insert"></div>
					 </form>	
				</div>
			</div>
		</div>

<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" enctype="multipart/form-data">
				<div class="modal-header">						
					<h4 class="modal-title">Edit Employee</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">					
					<div class="">
						<label>電話</label>
                            <input type="text"   id="phone" name="phone"  placeholder="請輸入變更電話!"
                            value="<%=employeeVO==null ? "" : employeeVO.getPhone() %>">
                            </div>
                            
					<div class="">
						<label>電子信箱</label>
                            <input type="text"   id="email" name="email"  placeholder="請輸入變更信箱!"
                            value="<%=employeeVO==null ? "" : employeeVO.getEmail() %>">
                            </div>
                            
<!-- 					<div class=""> -->
<!-- 						<label>到職日</label> -->
<!--                             <input type="date"  id="f_date1" name="start_From"> -->
<!--                             </div> -->
					
					<div class="">
						<label>員工狀態</label>
                           <input type="radio"  id="emp_State" name="emp_State"
                            value="0" checked>離職
 						<input type="radio"  id="emp_State" name="emp_State"
                            value="1" checked>在職中
                            </div> 
					
					<div class="">
						<label>員工照片</label>
                            <input type="file" class="progressbarTWInput" accept="image/gif, image/jpeg, image/png" name="emp_Pic" 
                            value="<%=employeeVO==null ? "" : employeeVO.getEmp_Pic() %>">
    						<img class="preview_progressbarTW_img"  width="150px" height="112px"/>
      						</div>
			
				</div>
				<div class="modal-footer">
					<input type="hidden" id="emplo_No" name="emplo_No" value="";>
					<input type="hidden" name="action" value="update">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-info" value="Save">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
		
<%-- 			<form METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" style="margin-bottom: 0px;"> --%>
				<div class="modal-header">						
					<h4 class="modal-title">Delete</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">					
					<p class="text-danger">注意:請確認是否執行移除員工的選項。</p>
					<p class="text-danger">執行刪除之後，不能還原!</p>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="取消">
					<input type="button" class="btn btn-danger delete" value="刪除">
					<input type="hidden" class="btn btn-danger" name="action"  value="delete">
				</div>
<!-- 			</form> -->
	
		</div>
	</div>
</div>


<!-- 範本  -->
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/employee/employee.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->
<%-- 			     <input type="hidden" name="emplo_No"  value="${employeeVO.emplo_No}"> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
<!-- 範本  -->







<!-- 套版  -->


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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/resources/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources//datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<!-- Emp -->
<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=start_From%>', // value:   new Date(),
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
        
        
        $(".progressbarTWInput").change(function(){
			
  readURL(this);

});

 

function readURL(input){
  if(input.files && input.files[0]){

    var reader = new FileReader();

    reader.onload = function (e) {
       $(".preview_progressbarTW_img").attr('src', e.target.result);
	

    }

    reader.readAsDataURL(input.files[0]);

  }

}
	
	$(".edit").click(function(){
		console.log($(this).closest('tr').find('td:nth-child(2)').text());
		$('#emplo_No').val($(this).closest('tr').find('td:nth-child(2)').text());
	})
	
	

</script>
<script>
 $(document).on("click",".delete",function(){
	 console.log("aaa");
	$(".deleteform").submit();
 });
</script>
<!-- addEmp -->


</html>