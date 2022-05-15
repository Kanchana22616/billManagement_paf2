<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Bill</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.1.min.js"></script>
<script src="Components/register.js"></script>

<link rel="stylesheet" href="Views/style.css" type="text/css"/>

</head>
<body>





	<div class="container">
		<h1 class="label">Update Bill</h1>
		
		
		<form class="update_bill" id="update_bill" name="update_bill">
		
		  
		
		    <div class="font">Enter bill Id</div>
			<input id="bill_billId" name="bill_billId" type="text" class="form-control form-control-sm">
									
			<div class="font">Enter new date</div>
			<input id="bill_date" name="bill_date" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Enter new arrears</div>
			<input id="bill_arrears" name="bill_arrears" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Enter new amount</div>
			<input id="bill_amount" name="bill_amount" type="text" class="form-control form-control-sm">
			
			<div class="font font2">Enter new totalPayble</div>
			<input id="bill_totalPayble" name="bill_totalPayble" type="text" class="form-control form-control-sm">
			
			
			<br><br>
			<input id="btnUpdate" name="btnUpdate" type="button" value="Update" class="btn btn-primary"> 
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