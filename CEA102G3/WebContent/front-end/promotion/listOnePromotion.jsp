<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.promotion.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% PromotionVO promotionVO = (PromotionVO) request.getAttribute("promotionVO");%>

<!DOCTYPE html>


<html>
<head>

<!-- 導覽列模板  -->
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>GuideMe - 主打促銷</title>

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
    <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>

<!-- 導覽列模板  -->




<!-- 模板  -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap_L.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/fonts/ionicons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Article-Clean.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/Simple-Slider.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css">
<!-- 模板  -->

<style>
  .page-header {
  
	width: 1350px;
	font-size: 100px;
	color:gray;
	font-weight:bold;
    text-align: center;
  }


</style>


</head>
<body>

   <!-- Topbar -->
        <c:import url="/front-end/myNavBar.jsp"/>
    <!-- End of Topbar -->





<!-- 最新消息模板  -->


<div class="page-header">
    <h1>${promotionVO.promot_Product_Title}</h1>
</div>
<div class="article-clean">
       <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-12 offset-lg-1 offset-xl-0" style="font-size: 13px;">
                    <div class="text-center intro" style="width: 1120px;margin-top: 10px;">    <!-- margin-top: 100px 往下移動 -->
    				</div>                   
   	 			</div>
   			 </div>
    	</div>
    </div>

<body style="height: 1000px;">
<div class="page-header">
    <h2>${promotionVO.promot_Product_Title}</h2>
</div>
    <!-- Start: Article Clean -->
    <div class="visible article-clean">
        <div class="container">
            <div class="row" style="padding: 0px;padding-right: 0px;padding-left: 0px;">
                <div class="col-lg-10 col-xl-12 offset-lg-1 offset-xl-0" style="font-size: 13px;">
                    <!-- Start: Intro -->
                    <div class="text-center intro" style="width: 1120px;margin: 0px;">
<%--                         <h1 class="text-left border rounded" style="border-top-width: 1px;border-top-style: none;width: 1110px;height: 85px;">${promotionVO.promot_Product_Title}&nbsp;</h1> --%>
                        <!-- Start: Date and Author -->
                        <p class="text-left"><span class="by"></span> <span class="text-left date" style="text-align: left;font-size: 15px;"><strong>發布時間 : ${promotionVO.release_Date}&nbsp; &nbsp; &nbsp;&nbsp;</strong></span><img src="<%=request.getContextPath()%>/PicFinder?pic=1&table=promotion&column=Promot_Product_Pic&idname=Promot_No&id=${promotionVO.promot_No}" width="1110px"></p>
                        <!-- End: Date and Author -->
                    </div>
                    <!-- End: Intro -->
                </div>
            </div>
        </div>
    </div>
    <!-- End: Article Clean -->
    <!-- Start: 1 Row 2 Columns -->
    <div>
        <h3 style="width: 1000px;margin: 0px;margin-right: 0px;margin-left: 120px;border-style: none;padding-top: 3px;margin-top: 0px;padding-right: 1px;"><span style="text-decoration: underline;">主打促銷日期與價格</span></h3>
        <div class="container">
            <div class="row" style="width: 1280px;padding: 0px;margin: 0px;margin-left: -109px;margin-right: 0px;padding-top: -1px;padding-right: 0px;padding-left: 10px;height: 103px;border-style: none;">
                <div class="col" style="margin: 20px;margin-left: 100px;border-radius: 0px;height: 102px;margin-top: 10px;padding: 0px;margin-right: 680px;font-size: 15px;text-align: left;width: 500px;border-style: dashed;padding-right: 80px;padding-left: 0px;">
                    <h5 style="margin: 10px;margin-left: 18px;height: 35px;margin-right: 10px;width: 350px;padding-top: 1px;">商品促銷<strong style="color:blue">開始日期</strong>:&nbsp; &nbsp; <span style="text-decoration: underline;">${promotionVO.promot_Start}</span></h5>
                    <h5 style="margin-left: 18px;width: 350px;margin-right: 22px;padding-top: -10px;">商品促銷<strong  style="color:blue">結束日期:</strong>&nbsp; &nbsp; <span style="text-decoration: underline;">${promotionVO.promot_End}</span><br></h5>
                </div>
                <div class="col" style="margin: 0px;margin-left: -655px;height: 100px;margin-top: 12px;margin-right: -30px;padding: 1px;margin-bottom: 0px;padding-right: 268px;padding-left: 0px;padding-bottom: 0px;border-style: dashed;width: 605px;">
                    <h5 style="height: 35px;margin-top: 9px;margin-left: 14px;margin-right: 0px;width: 660px;">${promotionVO.promot_Product_Title}<br></h5>
                    <h5 style="height: 43px;margin: 0px;margin-left: 14px;padding: 0px;margin-bottom: 0px;margin-top: -13px;width: 350px;padding-top: 17px; color:red;">促銷商品優惠價格 (NTD) :${promotionVO.promot_Product_Price}&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</h5>
                </div>
                <div class="col" style="height: 102px;padding: 0px;padding-right: 0px;padding-left: 0px;padding-bottom: 0px;padding-top: 22px;width: 0px;margin: 0px;border-style: none;margin-right: 0px;"><a class="btn btn-primary text-monospace text-center border rounded" role="button" href="<%=request.getContextPath()%>/front-end/product/listSearchAllProduct.jsp?" style="font-size: 22px;height: 44px;margin: 25px;margin-right: 20px;margin-left: -150px;margin-top: 35px;margin-bottom: 42px;padding: 5px;text-align: center;width: 120px;padding-top: 5px;padding-right: 1px;padding-left: 3px;">商城訂購!</a></div>
            </div>
        </div>
    </div>
    <!-- End: 1 Row 2 Columns -->
    <!-- Start: 2 Rows 1+1 Columns -->
    <div></div>
    <!-- End: 2 Rows 1+1 Columns -->
    <!-- Start: 1 Row 2 Columns -->
    <div style="width: 1075px;">
        <!-- Start: Text -->
        <div class="text" style="width: 1100px;padding-right: 13px;padding-left: 18px;text-align: justify;font-size: 15px;margin-left: 100px;">
            <h3 style="margin-left: 0px;height: 32px;margin-top: 40px;"><span style="text-decoration: underline;">主打促銷介紹</span></h3>
            <p style="margin-left: 40px;font-size: 25px; border-style: none;">${promotionVO.promot_Content}</p>
        </div>
        <!-- End: Text -->
    </div>
    <!-- End: 1 Row 2 Columns -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
    <script src="/assets/js/script.min.js?h=b1342a01b7d7006769f48460d915530f"></script>





<!-- Bootstrap FAQ - END -->
   <div class="footer-dark" style="padding: 0px;margin: 15px;width: 1410px;">
        <footer style="width: 1200px;height: 238px;margin: 100px;padding: 6px; ">
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
                            <li><a href="#">CEA102#3 四人團隊</a></li>
                            <li><a href="#">CEA102#3 團隊開發</a></li>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
<%--     <script src="<%=request.getContextPath()%>/resources/js/Simple-Slider.js"></script> --%>
</body>
</html>
          
