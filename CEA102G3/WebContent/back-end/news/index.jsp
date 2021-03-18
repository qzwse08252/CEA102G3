<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

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

    <!-- 最新消息 -->

    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="assets/css/Article-Clean.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/css/swiper.min.css">
    <link rel="stylesheet" href="assets/css/Simple-Slider.css">
    <link rel="stylesheet" href="assets/css/styles.css">


    <!-- 最新消息 -->

</head>

<body>
    <!-- Topbar -->
    <div class="navbar navbar-expand navbar-light bg-white topbar fixed-top static-top shadow d-flex"
        style="height:70px">
        <!-- Nav Item - logo -->
        <div class=" o-hidden">
            <img src="<%=request.getContextPath()%>/resources/img/logo.PNG" style="height:70px">
        </div>
        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

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
            <!-- Nav Item - QA -->
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-question fa-lg"></i>
                </a>
            </li>
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
                    <img class="img-profile rounded-circle w-auto h-100" src="<%=request.getContextPath()%>/resources/img/undraw_profile.svg">
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
    <!-- End of Topbar -->



    <!-- 最新消息 -->

    <div class="article-clean">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-xl-12 offset-lg-1 offset-xl-0" style="font-size: 13px;">
                    <div class="text-center intro" style="width: 1120px;margin-top: 100px;">    <!-- margin-top: 100px 往下移動 -->
                        
                        
                        <h1 class="text-left border rounded" style="border-top-width: 1px;border-top-style: none;width: 1110px;height: 90px;">日本東京 | 六本木之森夜景之旅</h1>
                        
                        
                        <p class="text-left"><span class="by"></span> <span class="text-left date" style="text-align: left;font-size: 15px;"><strong>發布時間 : 2021年3月18日&nbsp; &nbsp; &nbsp;&nbsp;</strong></span></p>
                    </div><img class="rounded" src="<%=request.getContextPath()%>/resources/img/nature-wallpaper4.jpg" width="1000" style="border-width: 6px;height: 560px;margin: 0px;padding: 4px;padding-top: 2px;padding-right: 0px;width: 1100px;margin-left: 2px;">
                    <div class="text" style="width: 1100px;padding-right: 13px;padding-left: 18px;text-align: justify;font-size: 15px;">
                        <h2>Aliquam In Arcu </h2>
                        <p>Sed lobortis mi. Suspendisse vel placerat ligula. <span style="text-decoration: underline;">Vivamus</span> ac sem lac. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in
                            justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
                        <p>Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus ac lacus. <strong>Ut vehicula rhoncus</strong> elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit <em>pulvinar dict</em> vel in justo. Vestibulum
                            ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae.</p>
                        <p>Suspendisse vel placerat ligula. Vivamus ac sem lac. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices
                            posuere cubilia Curae.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.3.1/js/swiper.jquery.min.js"></script>
    <script src="assets/js/Simple-Slider.js"></script>
        <!-- 最新消息 -->
</body>

 <!-- 最新消息(相關分享連接) -->



 <!-- 最新消息(相關分享連接) -->

</html>