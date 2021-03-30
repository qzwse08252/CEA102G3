<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.news.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    NewsService newsSvc = new NewsService();
    List<NewsVO> list = newsSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<!-- test -->
<title>最新消息資訊檢視</title>
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
	width:165px;
	height:180px;

   }
  
  .table_Content {
  	width:255px;
	height:187px;
  	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 7;
	-webkit-box-orient: vertical;
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
					<h3 class="m-0 font-weight-bold text-primary" style="margin-right:0 ;">最新消息資訊檢視</h3>
				</div>


			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered table-striped"
						id="dataTableAllAttraction" width="100%" cellspacing="0">
						<thead>
	<tr>
		<th>No.</th>
		<th>發佈日期</th>
		<th>標題</th>
		<th>內容介紹</th>
		<th>景點照片</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="newsVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${newsVO.news_No}</td>
			<td><fmt:formatDate value="${newsVO.release_Date}" pattern="yyyy-MM-dd"/></td>
			<td class="table_Title">${newsVO.news_Title}</td>
			<td class="table_Content">${newsVO.news_Content}</td>
			<td><img width="270" height="160" alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=news&column=News_Pic&idname=News_No&id=${newsVO.news_No}"/></td>
			


	
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/news/news.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="news_No"  value="${newsVO.news_No}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/news/news.do" style="margin-bottom: 0px;">
			     

			     
			     <input type="submit" value="刪除">
			     <input type="hidden"  name="news_No"  value="${newsVO.news_No}">
			     <input type="hidden"  name="action" value="delete"></FORM>
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