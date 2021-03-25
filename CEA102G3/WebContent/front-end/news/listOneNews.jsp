<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.news.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%-- 取出 Concroller EmpServlet.java已存入request的EmpVO物件--%>
<%NewsVO newsVO = (NewsVO) request.getAttribute("newsVO");%>
<!DOCTYPE html>


<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">



    <title>GuideMe - 最新消息</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min_L.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fonts/ionicons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Article-Clean.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Footer-Basic.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Footer-Clean.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Simple-Slider.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">







    <!-- Custom fonts for this template-->
    <link href="<%=request.getContextPath()%>/resources/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/nav-bar.css">

    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/owl.carousel.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin-2.min.js"></script>

    <!-- 最新消息 -->

    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min_L.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Article-Clean.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Simple-Slider.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">


    <!-- 最新消息 -->

<style>
  .page-header {
  
	width: 1250px;
	font-size: 100px;
	color:gray;
	font-weight:bold;
    text-align: center;
  }
  
/*  .content { */
/*   font-family: 'Noto Sans TC', sans-serif, Arial, Microsoft JhengHei !important; */
/*   font-size: 40px; */
/*   line-height: 48px; */
/*   color: black; */
/*   height:300px; */
/*   width: 1080px; */
/*   letter-spacing:8px; */
/*   font-weight: 300; */

/* } */
</style>







</head>
   <!-- Topbar -->
    <c:import url="/front-end/myNavBar.jsp"/>
    <!-- End of Topbar -->


<table>

<div class="page-header">
    <h1>${newsVO.news_Title}</h1>
</div>
<div class="article-clean">
       <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-12 offset-lg-1 offset-xl-0" style="font-size: 13px;">
                    <div class="text-center intro" style="width: 1120px;margin-top: 10px;">    <!-- margin-top: 100px 往下移動 -->
                        
                        
                        
                        <p class="text-left"><span class="by"></span> <span class="text-left date" style="text-align: left;font-size: 15px;"><strong>發布時間 : ${newsVO.release_Date}&nbsp; &nbsp; &nbsp;&nbsp;</strong></span></p>
                    
                    </div><img class="rounded" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=news&column=News_Pic&idname=News_No&id=${newsVO.news_No}" width="1000" style="border-width: 6px;height: 560px;margin: 0px;padding: 4px;padding-top: 2px;padding-right: 0px;width: 1100px;margin-left: 2px;">                     
                    <div class="text" style="width: 1100px;padding-right: 13px;padding-left: 18px;text-align: justify;font-size: 15px;">
                       
                       
                       <div class="content"><h2>本文相關介紹</h2>
                        <p style="margin-left: 0px; font-size:25px ;color:gray; border-style: none;">${newsVO.news_Content}</p></div>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
   <div class="footer-dark" style="padding: 0px;margin: 15px;width: 1400px;">
        <footer style="width: 1200px;height: 238px;margin: 70px;padding: 6px; ">
            <div class="container">
                <div class="row" style="height: 183px;">
                    <div class="col-sm-6 col-md-3 item">
                        <h3>Services</h3>
                        <ul>
                            <li><a href="#">Guideme - 主打促銷</a></li>
                            <li><a href="#">Guideme - 常見問題</a></li>
                            <li><a href="#">Guideme - 行程規劃</a></li>
                            <li><a href="#">Guideme - 評價體驗</a></li>
                            <li><a href="#">Guideme - 客服訊息</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-6 col-md-3 item">
                        <h3>About</h3>
                        <ul>
                            <li><a href="#">Guidme Co., Ltd.</a></li>
                            <li><a href="#">CEA102#3 Guidme 團隊開發</a></li>
                            <li><a href="#">ソフトバンクグループ株式会社</a></li>
                        </ul>
                    </div>
                    <div class="col-md-6 item text">
                        <h3>GuideMe</h3>
                        <p>ソフトバンク株式会社および株式会社ウィルコム沖縄（以下総称して「当社」）は、情報漏えいリスクに対し抜本的、かつ高度な対策を講じることにより、お客さまをはじめ社会からの信頼を常に得られるよう、「情報セキュリティポリシー」を策定しました。</p>
                    </div>
                    <div class="col item social" style="height: 25px;"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a></div>
                </div>
                <p class="copyright">Copyright &copy; GuideMe 2021</p>
            </div>
        </footer>
    </div>
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/Simple-Slider.js"></script>
</body>
</html>