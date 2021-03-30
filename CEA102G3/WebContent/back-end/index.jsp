<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>back-end index</title>

<!-- Custom fonts for this template-->
<link href="<%=request.getContextPath()%>/resources/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min_backend.css" rel="stylesheet">

<style>
    .bg-gradient-primary{
        background-color: #009ab9;
        background-image: none;
    }
    .collapse-bg{
        /* background-color: #5cd0ff; */
    }
    
    
/* <!-- img --> */
/*     .container-fluid { */
/*    	 background-color:#f5f5f5; */
/* 	background-image: url('https://i1.wp.com/www.tripresso.com/blog/wp-content/uploads/2020/02/shutterstock_256863688.jpg?resize=800%2C400&ssl=1'); */
/* 	no-repeat;  */
/* 	height:550px; */
/* 	background-size:cover; */
/*     } */
    
/* <!-- img --> */

    
.video-wrap {
  position: relative;


}
p {
  font-family: serif;          
  font-size: 50%;
  width:800px;
  height:80px;
  position: absolute;
  left: 10%;
  top: 20px;
  z-index: 1;
}
    
    
    
    
</style>
    
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       		<jsp:include page="/back-end/sideBar.jsp"/>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content" >

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow" >

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="<%=request.getContextPath()%>/back-end/index.jsp" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${employeeVO.name}</span>
                                <img class="img-profile rounded-circle" src="<%=request.getContextPath()%>/PicFinder?pic=1&table=employee&column=Emp_Pic&idname=Emplo_No&id=${employeeVO.emplo_No}">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="<%=request.getContextPath()%>/front-end/index.jsp">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Home Page
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid" >
				
                    <!-- Page Heading -->
<!--                     <div class="d-sm-flex align-items-center justify-content-between mb-4" > -->
<%--                         <h1 class="h3 mb-0 text-gray-800">歡迎GuideMe員工:<font color="#ffd700">${employeeVO.name}</font>進入管理頁面!</h1> --%>
                     	
<!--                     </div> -->
<!-- 						<div><h2 class="h3 mb-0 text-gray-800">請點選左側進行功能操作，謝謝!</h2> -->
<!-- 						</div> -->
						
<!-- video -->
<div class="video-wrap" >
 <p class="d-sm-flex align-items-center justify-content-between mb-4"  >
<p class="h3 mb-0 text-gray-800 " style="height:100px; width:800px" ><font color="#FF5F5F" >歡</font><font color="#FF5F5F">迎</font><font color="#3B3BFF	">G</font></font><font color="#D6D6FF">uide</font><font color="#3B3BFF">M</font></font><font color="#D6D6FF">e</font><font color="#FF2626" >員工:</font><strong><font color="#ffd700" >${employeeVO.name}</font></strong><font color="#FF2626" >登入!</font></br><font color="#FFFF26" >請點選左側進行功能操作!</font></p>
<video style="width:1080px" src="https://assets.mixkit.co/videos/preview/mixkit-tokyo-night-street-with-fast-traffic-and-tower-20077-large.mp4" autoplay loop muted>
<!--   <img src="http://webcreatorbox.com/sample/images/jewellery.jpg" alt="Placeholder"> -->
</video>
</div>
<!-- video -->		
					
			
                    <!-- Content Row -->
                    <div class="row" >

                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; GuideMe 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Logout Modal-->
    <jsp:include page="/back-end/logoutModal.jsp"/>

    <!-- Bootstrap core JavaScript-->
    <script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="<%=request.getContextPath()%>/resources/js/sb-admin-2.min.js"></script>

</body>

</html>