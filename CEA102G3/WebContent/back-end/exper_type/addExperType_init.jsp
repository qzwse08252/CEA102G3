<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.exper_type.model.*"%>

<%
ExperTypeVO extypeVO = (ExperTypeVO) request.getAttribute("extypeVO");
%>

<html>

<head>
    <meta charset="utf-8">
<!--     <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no"> -->
    <title>Contact - Brand</title>
<%--     <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/bootstrap/css/bootstrap.min.css"> --%>
<!--     <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700"> -->
<!--     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css"> -->
<%--     <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/assets/css/untitled.css"> --%>
</head>

<body>
    <main class="page contact-page">
        <section class="portfolio-block contact">
            <div class="container">  
                <div class="heading">
                    <h1>新增體驗種類</h1>
                </div>
                <form class="form-horizontal" method="POST"
                action="<%=request.getContextPath()%>/ExperType/ExperType.do">
                <div>
                    <c:if test="${not empty errorMsgs}">
						<div class="container">
							<div class="alert alert-danger" role="alert">
								<strong>新增失敗，請修正以下錯誤:</strong>
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li>${message}
									</c:forEach>
								</ul>
							</div>
						</div>
					</c:if>
                </div>
                    <div class="form-group"><label for="exper_type_name">體驗種類名稱：</label><input class="form-control item" type="text" id="exper_type_name" name="exper_type_name" value="${extypeVO.exper_type_name}"></div>

                    <div class="form-group"><input type="hidden" name="action" value="insert"><button class="btn btn-primary btn-block btn-lg" type="submit">送出新增</button></div>
                </form>
            </div>
        </section>
    </main>
<%--     <script src="<%=request.getContextPath()%>/resources/assets/js/jquery.min.js"></script> --%>
<%--     <script src="<%=request.getContextPath()%>/resources/assets/bootstrap/js/bootstrap.min.js"></script> --%>
<!--     <script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script> -->
<%--     <script src="<%=request.getContextPath()%>/resources/assets/js/theme.js"></script> --%>
</body>

</html>