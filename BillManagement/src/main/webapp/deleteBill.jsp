<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Bill</title>

<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.1.min.js"></script>
<script src="Components/register.js"></script>

<link rel="stylesheet" href="Views/style.css" type="text/css"/>

</head>
<body>





	<div class="container">
		<h1 class="label">Delete Bill</h1>
		
		
		<form class="delete_bill" id="delete_bill" name="delete_bill">
				
		
		    <div class="font">Enter bill Id</div>
			<input id="bill_billId" name="bill_billId" type="text" class="form-control form-control-sm">
									
			
			
			<br><br>
			<input id="btnRemove" name="btnRemove" type="button" value="Delete" class="btn btn-primary"> 
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