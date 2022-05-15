<%@page import="controller.BillDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bill</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.1.min.js"></script>
<script src="Components/register.js"></script>

<link rel="stylesheet" href="Views/style.css" type="text/css"/>

</head>
<body>





	<div class="container">
		<h1 class="label">Add Bill</h1>
		
		
		<form class="add_bill" id="addform" name="addbill">
		
		    <div class="font">Enter userId</div>
			<input id="bill_userId" name="bill_userId" type="text" class="form-control form-control-sm">
		
		    <div class="font">Enter billId</div>
			<input id="bill_billId" name="bill_billId" type="text" class="form-control form-control-sm">
									
			<div class="font">Enter date</div>
			<input id="bill_date" name="bill_date" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Enter arrears</div>
			<input id="bill_arrears" name="bill_arrears" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Enter amount</div>
			<input id="bill_amount" name="bill_amount" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Enter totalPayble</div>
			<input id="bill_totalPayble" name="bill_totalPayble" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Enter EmpID</div>
			<input id="bill_EmpID" name="bill_EmpID" type="text" class="form-control form-control-sm">
			
			<br><br>
			<input id="btnSave" name="btnSave" type="button" value="Add" class="btn btn-primary"> 
			<input type="hidden" id="hidIDSave" name="hidIDSave" value="">
			
			<br>
			<a href="home.jsp"><input type="button" value="Home page" class="btn btn-primary"></a>
			<br>
			
		</form>
		
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		

                


	</div>	







</body>
</html>