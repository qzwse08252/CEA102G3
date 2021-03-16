<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
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
<title>Guideme�D���P�P��Ʒs�W</title>
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
                        
                        <%-- ���~��C --%>
						<c:if test="${not empty errorMsgs}">
							<font style="color:red">�Эץ��H�U���~:</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color:red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>

                            <div class="">
                                <h3 class="h1 text-gray-900 mb-4">Guideme�D���P�P��Ʒs�W--addPromotion</h3>
                            	<h4><a href="<%=request.getContextPath()%>/front-end/promotion/select_promotion_page.jsp">�^����</a></h4>
                            </div>
                            
                       
                            <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/promotion/promotion.do" name="form1" enctype="multipart/form-data">
                             <div class="">�D���P�PID
                           	<input type="text"  id="promot_No" name="promot_No" 
                            value="<%=promotionVO==null ? "" : promotionVO.getPromot_No() %>"></div>
                          
                          
                          
                            <div class="">�ӫ~ID
                           	<input type="text"  id="promot_Product_No" name="promot_Product_No" 
                            value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_No() %>"></div>
                          
                            <div class="">�P�P�}�l���
                           <input type="text"  id="f_date1" name="promot_Start">
                           </div>
                          
                           <div class="">�P�P�������
                           <input type="text"  id="f_date2" name="promot_End">
                           </div>
                        
                           <div class="">�s�i�W�[���
                           <input type="text"  id="f_date3" name="release_Date">
                           </div>
                          
                          <div class="user">�P�P���D
                            <input type="text"  id="promot_Product_Title" name="promot_Product_Title"
                            value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_Title() %>">
                            </div>
                                                    
                            <div class="user">�P�P���e
                            <input type="text"  id="promot_Content" name="promot_Content"
                            value="<%=promotionVO==null ? "" : promotionVO.getPromot_Content() %>">
                            </div>
                            
                            
                            <div class="user">�P�P����
                            <input type="text"  id="promot_Product_Price" name="promot_Product_Price"
                            value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_Price() %>">
                            </div>
      						                 						
                            <div class="">�P�P�ӫ~�Ӥ�
                            <input type="file" id="progressbarTWInput" accept="image/gif, image/jpeg, image/png" name="promot_Product_Pic" 
                            value="<%=promotionVO==null ? "" : promotionVO.getPromot_Product_Pic() %>">
    						<img id="preview_progressbarTW_img" src="" />
      						</div> 
      						
                              
                                
                                
<!--                             <div class="">�`�����D�Ӥ� -->
<!--                             <input type="file" id="progressbarTWInput" accept="image/gif, image/jpeg, image/png" name="empPic"  -->
<%--                             value="<%=employeeVO==null ? "" : employeeVO.getEmpPic() %>"> --%>
<!--     						<img id="preview_progressbarTW_img" src="" /> -->
<!--       						</div> -->
   
                            <input type="hidden" name="action" value="insert">
                            <input type="submit"  value="�e�X�s�W"></FORM>
                      
                        </div>
                    </div>
                </div>
            </div>
        </div>
             </div>


</body>


<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->
<!-- Promot_Start (�D���P�P�}�l���) -->
<% 
  java.sql.Date promot_Start  = null;
  try {
	  promot_Start = promotionVO.getPromot_Start();
   } catch (Exception e) {
	   promot_Start = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Promot_End (�D���P�P�I����) -->
<% 
  java.sql.Date promot_End = null;
  try {
	  promot_End = promotionVO.getPromot_End();
   } catch (Exception e) {
	   promot_End = new java.sql.Date(System.currentTimeMillis());
   }
%>

<!-- Release_Date (�s�i�W�[���) -->
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
<!-- Promot_Start (�D���P�P�}�l���) -->
$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_Start%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
   //startDate:	            '2017/07/10',  // �_�l��
   //minDate:               '-1970-01-01', // �h������(���t)���e
   //maxDate:               '+1970-01-01'  // �h������(���t)����
});

<!-- Promot_End (�D���P�P�I����) -->
$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:false,       //timepicker:true,
   step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
   format:'Y-m-d',         //format:'Y-m-d H:i:s',
   value: '<%=promot_End%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
   //startDate:	            '2017/07/10',  // �_�l��
   //minDate:               '-1970-01-01', // �h������(���t)���e
   //maxDate:               '+1970-01-01'  // �h������(���t)����
});

<!-- Release_Date (�s�i�W�[���) -->
        $.datetimepicker.setLocale('zh');
        $('#f_date3').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=release_Date%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
           //startDate:	            '2017/07/10',  // �_�l��
           //minDate:               '-1970-01-01', // �h������(���t)���e
           //maxDate:               '+1970-01-01'  // �h������(���t)����
        });
        
        
   
        // ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

        //      1.�H�U���Y�@�Ѥ��e������L�k���
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

        
        //      2.�H�U���Y�@�Ѥ��᪺����L�k���
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


        //      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
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
        
// �H�U�O��Ӥ��W�ǷӤ��~�|�ϥ�        
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