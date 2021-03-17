<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.member.model.*"%>
<%@page import="com.friendList.model.*"%>

<jsp:useBean id="memberVO" scope="session" class="com.member.model.MemberVO" />
<jsp:useBean id="memberSvc" scope="session" class="com.member.model.MemberService" />
<jsp:useBean id="friendListSvc" class="com.friendList.model.FriendListService" />
--memberVO.memberNo--${memberVO.memberNo}

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
	.friendList {
            width: 500px;
            border: 1px solid #f00;
            margin-top: 80px;
            margin-left: auto;
            margin-right: auto;
        }
</style>
<title>Insert title here</title>
</head>
<body>
	<c:import url="/front-end/NavPage2.jsp"></c:import>
	
	<div class="friendList">
		<table id="friendTable">
			<thead>朋友列表
			</thead>
			<tr>
				<td colspan="2">
						<input type="text" name="searchMember" id="searchMember" placeholder="搜尋好友"> 
				</td>
			</tr>
		</table>
	</div>

	<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/friendList/friendListServlet.do",
			type : "POSt",
			data : {
				action : "listAllFriend",
				memNO : '${memberVO.memberNo}'
			},
			dataType: "json",
			success : function(data) {
				clearFriend();
				$(data).each(function(i, item){
					console.log("memberNo:"+item.memberNo);
					console.log("name:"+item.name);
					console.log("IMG:"+item.imgTag);
					console.log("#########init#############");
					$('#friendTable').append("<tr><td>"+item.imgTag+" "+item.name
							+" <input type='hidden' name='"+item.memberNo+"' id='"+item.memberNo+"'> </td></tr>");
				});
			},
			error: function(){alert("AJAX-發生錯誤囉!")}
		});
		
		$("#searchMember").keyup(function() {
			$.ajax({
				url : "<%=request.getContextPath()%>/friendList/friendListServlet.do",
				type : "POSt",
				data : {
					searchMember : $("#searchMember").val(),
					action : "queryFriend",
					memNO : '${memberVO.memberNo}'
				},
				dataType: "json",
				success : function(data) {
					clearFriend();
					$(data).each(function(i, item){
						console.log("memberNo:"+item.memberNo);
						console.log("name:"+item.name);
						console.log("IMG:"+item.imgTag);
						console.log("#########queryFriend############");
						$('#friendTable').append("<tr><td>"+item.imgTag+" "+item.name
								+" <input type='hidden' name='"+item.memberNo+"' id='"+item.memberNo+"'> </td></tr>");
					});
				},
				error: function(){alert("AJAX-發生錯誤囉!")}
			});
		});
	});
	
	function clearFriend(){
		for (let index = $("#friendTable tr").length-1; index >= 1; index--) {
            $("#friendTable tr")[index].remove();
        }
	}
	
	</script>

</body>
</html>