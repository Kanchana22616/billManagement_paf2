<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>

	<!-- font awasome icon -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!--font awesom CDN-->
    <script src="https://kit.fontawesome.com/2a0f6dfc30.js" crossorigin="anonymous"></script>
    
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
</head>




<body>
<%@include file="/header.jsp" %>

<br>

<div style="background-color:#B0C4DE;text-align: center;">

<a href="addBill.jsp"><button type="button" class="btn btn-primary btn-lg btn-block">ADD BILL</button></a><br><br>
<a href="viewBill.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">VIEW BILL</button></a><br><br>
<a href="updateBill.jsp"><button type="button" class="btn btn-primary btn-lg btn-block">UPDATE BILL</button></a><br><br>
<a href="deleteBill.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">DELETE BILL</button></a>


</div>

<br>




 <%@include file="/footer.jsp" %>

</body>
</html>