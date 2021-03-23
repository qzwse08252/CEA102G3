<%@page import="com.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <jsp:useBean id="memberVO" scope="session" class="com.member.model.MemberVO"/> --%>



<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<%=request.getContextPath()%>/resources/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/slick.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/slick-theme.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/hamburgers.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/nav-bar.css">

    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.bundle.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/slick.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/nav-bar.js"></script>

    <style>
        .search {
            position: absolute;
            z-index: 9;
            top: 45%;
            left: 25%;
        }

        #carouselExampleIndicators {
            z-index: 0;
        }

        .banner-area {
            position: relative;
            margin-top: 70px;
        }


        .promote-area {
            width: 95%;
            margin: 0 auto;
        }

        .promote-area div {
            margin: 10px;
        }
        
        .news-area {
            width: 95%;
            margin: 0 auto;
        }

        .news-area div {
            margin: 10px;
        }
        
       

        .slick-prev:before,
        .slick-next:before {
            color: blue;
        }

        .text-p {
            margin: 30px;
            color: rgb(53, 12, 12);
        }

        .text-area {
            margin-left: 50px;
            line-height: 50px;
        }

        footer {
            background-color: #2E55C7;
            color: white;
        }

        .showmore {
            margin-left: 85%;
        }
    </style>
<script>
        $(document).ready(function () {

            $(".promote-area").slick({
                dots: true,
                infinite: true,
                slidesToShow: 3,
                slidesToScroll: 3,
                autoplay: true,
                centerMode: true,
                centerPadding: '100px',

                
            });
            $(".news-area").slick({
                dots: true,
                infinite: true,
                slidesToShow: 3,
                slidesToScroll: 3,
                autoplay: true,
                centerMode: true,
                centerPadding: '100px',
            });
            
            
        });

 </script>

</head>

<body>
    <!-- Topbar -->
    <div class="navbar navbar-expand navbar-light bg-white topbar fixed-top static-top shadow d-flex"
        style="height:70px">
        <!-- Nav Item - logo -->
        <div class=" logo">
        <a href="">
            <img src="<%=request.getContextPath()%>/resources/img/logo.PNG" style="height:70px">
        </a>
        </div>
        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">
            <li class="burger">
                <button class="hamburger hamburger--spring" type="button">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </button>

            </li>
            <li class="top-button">
                <a href="#">
                    <i class="fas fa-store"></i>
                    <span class="text">商城</span>
                </a>
            </li>
            <li class="top-button">
                <a href="#">
                    <i class="fas fa-map-pin"></i>
                    <span class="text">體驗</span>
                </a>
            </li>
            <li class="top-button">
                <a href="#">
                    <i class="fas fa-align-center"></i>
                    <span class="text">文章</span>
                </a>
            </li>
            <li class="top-button">
                <a href="#">
                    <i class="fas fa-edit"></i>
                    <span class="text">行程</span>
                </a>
            </li>
            
            
            
<!-- Nav Item - QA -->
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/faq/faq.do?action=getOne_For_Display&faq_No=${faqVO.faq_No}" class="btn btn-primary"  data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-question fa-lg"></i>
                </a>
            </li>
<!-- Nav Item - QA -->
            
            
            <!-- Nav Item - Cart -->
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-shopping-cart fa-lg"></i>
                    <!-- Counter - Alerts -->
                    <span class="badge badge-danger badge-counter">3+</span>
                </a>
            </li>

            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-bell fa-fw fa-lg"></i>
                    
                    
                    
                    <!-- Counter - Alerts -->
                    <span class="badge badge-danger badge-counter">3+</span>
                </a>
                <!-- Dropdown - Alerts -->
                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                    aria-labelledby="alertsDropdown">
                    <h6 class="dropdown-header">
                        Alerts Center
                    </h6>
                    <a class="dropdown-item d-flex align-items-center" href="#">
                        <div class="mr-3">
                            <div class="icon-circle bg-primary">
                                <i class="fas fa-file-alt text-white"></i>
                            </div>
                        </div>
                        <div>
                            <div class="small text-gray-500">December 12, 2019</div>
                            <span class="font-weight-bold">A new monthly report is ready to download!</span>
                        </div>
                    </a>
                    <a class="dropdown-item d-flex align-items-center" href="#">
                        <div class="mr-3">
                            <div class="icon-circle bg-success">
                                <i class="fas fa-donate text-white"></i>
                            </div>
                        </div>
                        <div>
                            <div class="small text-gray-500">December 7, 2019</div>
                            $290.29 has been deposited into your account!
                        </div>
                    </a>
                    <a class="dropdown-item d-flex align-items-center" href="#">
                        <div class="mr-3">
                            <div class="icon-circle bg-warning">
                                <i class="fas fa-exclamation-triangle text-white"></i>
                            </div>
                        </div>
                        <div>
                            <div class="small text-gray-500">December 2, 2019</div>
                            Spending Alert: We've noticed unusually high spending for your account.
                        </div>
                    </a>
                    <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                </div>
            </li>

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <span class="mr-2 d-none d-lg-inline text-gray-600 medium">Jason Li</span>
                    <img class="img-profile rounded-circle " src="<%=request.getContextPath()%>/resources/img/undraw_profile.svg">
                </a>
                <!-- Dropdown - User Information -->
                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-gifts fa-md fa-fw mr-2 text-gray-400"></i>
                        商品
                    </a>
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-running fa-md fa-fw mr-2 text-gray-400"></i>
                        體驗
                    </a>
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-user fa-md fa-fw mr-2 text-gray-400"></i>
                        好友
                    </a>
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-envelope fa-md fa-fw mr-2 text-gray-400"></i>
                        訊息
                    </a>
                    <a class="dropdown-item" href="#">
                        <i class="fas fa-cog fa-md fa-fw mr-2 text-gray-400"></i>
                        帳號
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                        <i class="fas fa-sign-out-alt fa-md fa-fw mr-2 text-gray-400"></i>
                        登出
                    </a>
                </div>
            </li>
        </ul>
    </div>
    <!-- media query -->
    <div class="nav-bar second-nav-bar fixed-top">
        <div class="top-button">
            <a href="#">
                <i class="fas fa-store"></i>
                <span class="text">商城</span>
            </a>
        </div>
        <div class="top-button">
            <a href="#">
                <i class="fas fa-map-pin"></i>
                <span class="text">體驗</span>
            </a>
        </div>
        <div class="top-button">
            <a href="#">
                <i class="fas fa-align-center"></i>
                <span class="text">文章</span>
            </a>
        </div>
        <div class="top-button">
            <a href="#">
                <i class="fas fa-edit"></i>
                <span class="text">行程</span>
            </a>
        </div>
    </div>
    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">確定離開?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">選擇確定如果你真的要登出您的帳戶
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">取消</button>
                    <a class="btn btn-primary" href="login.html">確定</a>
                </div>
            </div>
        </div>
    </div>
    <!-- End of Topbar -->


    <!-- Begin Page Content -->
    <div class="banner-area">
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="https://picsum.photos/id/684/1200/500" class="d-block w-100" alt="...">
                </div>
                <div class="carousel-item">
                    <img src="https://picsum.photos/id/100/1200/500" class="d-block w-100" alt="">
                </div>
                <div class="carousel-item">
                    <img src="https://picsum.photos/id/120/1200/500" class="d-block w-100" alt="">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <!-- End of Page Wrapper -->
        <!-- Searchbar -->
        <form class="search w-50 h-50 mx-auto">
            <div class="input-group">
                <input type="text" class="form-control bg-white border-0 small" placeholder="搜尋你最愛的..."
                    aria-label="Search" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>
 <!-- News -->
    <div class="text-p">
        <h3><b>最新消息</b></h3>
    </div>
    <div class="news-area">       
           <jsp:useBean id="newsSvc" scope="page" class="com.news.model.NewsService"/>     
        <c:forEach var="newsVO" items="${newsSvc.getAll()}" begin="0" end="6">
        <div class="card" style="width: 18rem;">
            <img src="<%=request.getContextPath()%>/PicFinder?pic=1&table=news&column=News_Pic&idname=News_No&id=${newsVO.news_No}" alt="" width="180px" height="200px"  class="card-img-top">
            <div class="card-body">
                <p class="card-text">${newsVO.getNews_Title()}</p>
                <a href="<%=request.getContextPath()%>/news/news.do?action=getOne_For_Display&news_No=${newsVO.news_No}" class="btn btn-primary">查看詳情</a>
            </div>
        </div>
         </c:forEach>
           </div>     
<!-- News -->    
    
    
    
<!-- Promotion -->   
    <div class="text-p">
        <h3><b>主打促銷</b></h3>
    </div>
    <div class="promote-area">
            <jsp:useBean id="promotionSvc" scope="page" class="com.promotion.model.PromotionService"/>     
        <c:forEach var="promotionVO" items="${promotionSvc.getAll()}" begin="0" end="6">
        <div class="card" style="width: 18rem;">
            <img src="<%=request.getContextPath()%>/PicFinder?pic=1&table=promotion&column=Promot_Product_Pic&idname=Promot_No&id=${promotionVO.promot_No}" alt=""  width="180px" height="200px" class="card-img-top">
            <div class="card-body">
                <p class="card-text">${promotionVO.getPromot_Product_Title()}</p>
                <a href="<%=request.getContextPath()%>/promotion/promotion.do?action=getOne_For_Display&promot_No=${promotionVO.promot_No}" class="btn btn-primary">查看詳情</a>
            </div>
        </div>
         </c:forEach>
              </div>
<!-- Promotion -->   

    <!-- Footer -->
    <footer class="sticky-footer">
        <div class="container my-auto">
            <div class="copyright text-center my-auto">
                <span>Copyright &copy; Guide Me 2021</span>
            </div>
        </div>
    </footer>
    <!-- End of Footer -->
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>



</body>

</html>