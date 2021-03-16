<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Functions: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Functions: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Functions: Home</p>

<h3>��Ƭd��:</h3>
	
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllFunctions.jsp'>List</a> all Functions.  <br><br></li>
  
  
 <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/functions/functions.do" >
        <b>��J�\��s��:</b>
        <input type="text" name="funct_No">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="�e�X">
    </FORM>
  </li>
 
   <jsp:useBean id="funSvc" scope="page" class="com.functions.model.FunctionsService" />
    
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/functions/functions.do" >
       <b>��ܥ\��W��:</b>
       <select size="1" name="funct_No">
         <c:forEach var="functionsVO" items="${funSvc.all}" > 
          <option value="${functionsVO.funct_No}">${functionsVO.funct_Name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="�e�X">
     </FORM>
  </li>
</ul>


<h3>�\��޲z</h3>

<ul>
  <li><a href='addFunctions.jsp'>Add</a> a new Functions.</li>
</ul>

</body>
</html>