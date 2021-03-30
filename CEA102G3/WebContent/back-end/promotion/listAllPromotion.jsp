<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.promotion.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	PromotionService proSvc = new PromotionService();
    List<PromotionVO> list = proSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html>
<head>
<!-- test -->
<title>主打促銷資訊檢視</title>
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
	text-align:center;
	}


	th{
	text-align:center;
	}
	.table_Price{
	width:1px;
	height:180px;
	}

  .table_Title {
	width:155px;
	height:180px;

   }
  
  .table_Content {
  	width:255px;
	height:185px;
  	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 7;
	-webkit-box-orient: vertical;
    }

   .table_date{
	text-align:center;
  	width:1px;
  

   }
   .table td{
     vertical-align:middle;
   }
</style>

<!-- test -->


</head>
	<!-- Begin Page Content -->
	<div class="container-fluid" style="width:1130px">

		<!-- DataTales Example -->
		<div class="card shadow mb-4" >
			<div class="row" style="margin:0 auto; width:4320px" >
				<div class="col-3 card-header py-3" style="width=100px;height=100px">
					<h3 class="m-0 font-weight-bold text-primary" style="margin-right:0 ;">主打促銷資訊檢視</h3>
				</div>


			</div>
			<div class="card-body" >
				<div class="table-responsive" >
					<table class="table table-bordered table-striped" 
						id="dataTableAllAttraction" width="100%" cellspacing="0">
						<thead>
	<tr>
<!-- 		<th>主打促銷消息ID</th> -->
<!-- 		<th>商品ID</th> -->
		<th>促銷開始</th>
		<th>促銷截止</th>
		<th>促銷上架</th>
		<th>商品標題</th>
		<th>主打促銷內容</th>
		<th>價格(NTD)</th>
		<th>商品照片</th>
		<th>修改And刪除</th>
<!-- 		<th>刪除</th> -->
	</tr>
	
	
	
	<%@ include file="page1.file" %> 
	<c:forEach var="promotionVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
<%-- 			<td>${promotionVO.promot_No}</td> --%>
<%-- 			<td>${promotionVO.promot_Product_No}</td> --%>
			<td class="table_date"><fmt:formatDate value="${promotionVO.promot_Start}"  pattern="yyyy-MM-dd"/></td>
			<td class="table_date"><fmt:formatDate value="${promotionVO.promot_End}" pattern="yyyy-MM-dd"/></td>
			<td class="table_date"><fmt:formatDate value="${promotionVO.release_Date}" pattern="yyyy-MM-dd"/></td>
			<td class="table_Title">${promotionVO.promot_Product_Title}</td>
			<td class="table_Content">${promotionVO.promot_Content}</td>
<%-- 			<td class="table_Title">${promotionVO.promot_Product_Title}</td> --%>
			<td class="table_Price">${promotionVO.promot_Product_Price}</td>
			<td><img width="230" height="155"  alt="" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=promotion&column=Promot_Product_Pic&idname=Promot_No&id=${promotionVO.promot_No}"/></td>

			<td>
			  <FORM METHOD="post"  ACTION="<%=request.getContextPath()%>/promotion/promotion.do" style="margin-bottom: 0px;">
			     <input type="submit"  value="修改">
			     <input type="hidden" name="promot_No"  value="${promotionVO.promot_No}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
<!-- 			</td> -->
<!-- 			<td> -->
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" style="margin-bottom: 0px;">
			     <input type="submit"  value="刪除">
			     <input type="hidden" name="promot_No"  value="${promotionVO.promot_No}">
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