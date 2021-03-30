<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.faq.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    FaqService faqSvc = new FaqService();
    List<FaqVO> list = faqSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<!-- test -->
<title>常見問題資訊檢視</title>
<!-- Bootstrap core JavaScript-->
<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript -->
<script
 	src="<%=request.getContextPath()%>/resources/js/jquery.easing.min.js"></script> 

<!-- Custom scripts for all pages-->
<script
	src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>
<!-- Page level plugins -->
<script
	src="<%=request.getContextPath()%>/resources/js/jquery.dataTables.min.js"></script> 
<script
 	src="<%=request.getContextPath()%>/resources/js/dataTables.bootstrap4.min.js"></script> 

<!-- Page level custom scripts -->
<script src="<%=request.getContextPath()%>/resources/js/nav-bar.js"></script>
<!-- <script -->
<!-- test -->


<style>
tbody>tr {
	max-height: 300px;
	overflow-y: auto;
	
}

td {
	max-height: 300px;
	overflow: hidden;
	
}

  .table_Title {
	width:180px;
	height:50px;

   }
  
  .table_Content {
  	width:600px;
	height:5px;

    }

   .table_date{
	text-align:center;
  	width:1px;
  	}
  	
	th{
	text-align:center;
	}  

   .table td{
     vertical-align:middle;
   }
</style>
<!-- test -->

</head>
	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="row" style="margin:0 auto; width:4180px">
				<div class="col-3 card-header py-3">
					<h3 class="m-0 font-weight-bold text-primary" style="margin-right:0 ;">常見問題資訊檢視</h3>
				</div>


			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered table-striped"
						id="dataTableAllAttraction" width="100%" cellspacing="0">
						<thead>
	
	<tr>
		<th>No.</th>
		<th>常見問題</th>
		<th>問題回覆</th>
		<th>更新日期</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="faqVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${faqVO.question_No}</td>
			<td class="table_Title">${faqVO.question}</td>
			<td class="table_Content">${faqVO.answer}</td>
			<td><fmt:formatDate value="${faqVO.update_Time}" pattern="yyyy-MM-dd"/></td>
			


	
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/faq/faq.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="question_No"  value="${faqVO.question_No}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/faq/faq.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="question_No"  value="${faqVO.question_No}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
		</tbody>
</table>
<%@ include file="page2.file" %>
	</div>
		</div>
			</div>
				</div>
</body>
</html>