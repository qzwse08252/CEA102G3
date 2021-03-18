<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.promotion.model.*"%>


<%
PromotionVO promotionVO = (PromotionVO) request.getAttribute("promotionVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

 <!-- Custom fonts for this template--> 
<%-- <link href="<%=request.getContextPath()%>/resources/css/all.min.css" rel="stylesheet" --%>
<!-- 	type="text/css"> -->
<!-- <link -->
<!-- 	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" -->
<!-- 	rel="stylesheet"> -->
<%-- <%-- <link href="<%=request.getContextPath()%>/resources/css/register.css" rel="stylesheet"> --%> 

<!-- Custom styles for this template-->
<%-- <link href="<%=request.getContextPath()%>/resources/css/sb-admin-2.min.css" rel="stylesheet"> --%>
<title>Guideme主打促銷資料新增</title>
</head>
<body class="bg-gradient-primary">

    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                        
                        <%-- 錯誤表列 --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color:red">請修正以下錯誤:</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color:red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>

                            <div class="">
                                <h3 class="h1 text-gray-900 mb-4">Guideme主打促銷資料新增--addPromotion</h3>
                            	<h4><a href="<%=request.getContextPath()%>/-end/promotion/select_promotion_page.jsp">回首頁</a></h4>
                            </div>
                            
                       
        <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" name="form1" enctype="multipart/form-data">
<!--              <div class="">主打促銷ID -->
<!--               	<input type="text"  id="promot_No" name="promot_No"  -->
<%--                     value="<%=promotionVO==null ? "" : promotionVO.getPromot_No() %>"></div> --%>
         

			<div class="">促銷廣告商品編號
            	 <input type="text"  id="promot_Product_No" name="promot_Product_No" 
                  	value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_No() %>"></div>
                                                  
            <div class="">促銷開始日期
                 <input type="text"  id="f_date1" name="promot_Start"></div>
                          
            <div class="">促銷結束日期
                 <input type="text"  id="f_date2" name="promot_End"></div>
                        
            <div class="">廣告上架日期
                 <input type="text"  id="f_date3" name="release_Date"></div>
                          
            <div class="user">促銷標題
                 <input type="text"  id="promot_Product_Title" name="promot_Product_Title"
                  value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_Title() %>"></div>
      						            
      		<div class="user">促銷內容
                 <input type="text"  id="promot_Content" name="promot_Content"
                     value="<%=promotionVO==null ? "" : promotionVO.getPromot_Content() %>"></div>                                                   
                            
            <div class="user">促銷價格
                 <input type="text"  id="promot_Product_Price" name="promot_Product_Price"
                  value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_Price() %>"></div>
                                                      						                 						
            <div class="">促銷商品照片
                 <input type="file" id="progressbarTWInput" accept="image/gif, image/jpeg, image/png" name="promot_Product_Pic" 
                  value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_Pic() %>">
    				<img id="preview_progressbarTW_img" src="" /></div> 
      						
  
                            <input type="hidden" name="action" value="insert">
                            <input type="submit"  value="送出新增"></FORM>
                      
                        </div>
                    </div>
                </div>
            </div>
        </div>
             </div>


</body>


<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
<!-- Promot_Start (主打促銷開始日期) -->
<% 
  java.sql.Date promot_Start  = null;
  try {
	  promot_Start = promotionVO.getPromot_Start();
   } catch (Exception e) {
	   promot_Start = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Promot_End (主打促銷截止日期) -->
<% 
  java.sql.Date promot_End = null;
  try {
	  promot_End = promotionVO.getPromot_End();
   } catch (Exception e) {
	   promot_End = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Release_Date (廣告上架日期) -->
<% 
  java.sql.Date release_Date = null;
  try {
	  release_Date = promotionVO.getRelease_Date();
   } catch (Exception e) {
	   release_Date = new java.sql.Date(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
<!-- Promot_Start (主打促銷開始日期) -->
$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_Start%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
   //startDate:	            '2017/07/10',  // 起始日
   minDate:               '-1970-01-01', // 去除今日(不含)之前
   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});

<!-- Promot_End (主打促銷截止日期) -->
$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_End%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
   //startDate:	            '2017/07/10',  // 起始日
   minDate:               '-1970-01-01', // 去除今日(不含)之前
   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});

<!-- Release_Date (廣告上架日期) -->
        $.datetimepicker.setLocale('zh');
        $('#f_date3').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=release_Date%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
// 以下是放照片上傳照片才會使用        
        $("#progressbarTWInput").change(function(){

  readURL(this);

});

 

function readURL(input){

  if(input.files && input.files[0]){

    var reader = new FileReader();

    reader.onload = function (e) {

       $("#preview_progressbarTW_img").attr('src', e.target.result);

    }

    reader.readAsDataURL(input.files[0]);

  }

}
        
        
        
</script>
</html>