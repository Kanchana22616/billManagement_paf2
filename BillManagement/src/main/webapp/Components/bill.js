$(document).ready(function()
{
	if ($("#alertSuccess").text().trim() == "")
	 {
	 $("#alertSuccess").hide();
	 }
	 $("#alertError").hide();
});



 // SAVE ============================================
   
$(document).on("click", "#btnSave", function(event)
	{
		
		// Clear alerts---------------------
		
		 $("#alertSuccess").text("");
		 $("#alertSuccess").hide();
		 $("#alertError").text("");
		 $("#alertError").hide();
		 
		// Form validation-------------------
	
		var status = validateItemForm();
		if (status != true)
	  {
		 $("#alertError").text(status);
		 $("#alertError").show();
		 return;
	   }
	
		
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	
	$.ajax( 
			{ 
				 url : "BillApi", 
				 type : type, 
				 data : $("#add_bill").serialize(), 
				 dataType : "text", 
				 complete : function(response, status) 
			 { 
				 onbillSaveComplete(response.responseText, status); 
			 } 
		});
		
	});
	
	
	
	//billsavecomplefunction
	

	function onbillSaveComplete(response, status) 
	{ 
	  if (status == "success") 
	   { 
				 var resultSet = JSON.parse(response); 
				 
				 if (resultSet.status.trim() == "success") 
				 
				 { 
					 $("#alertSuccess").text("Successfully saved."); 
					 $("#alertSuccess").show(); 
					 $("#divItemsGrid").html(resultSet.data); 
					 
				 } else if (resultSet.status.trim() == "error") 
				 
				 { 
					 $("#alertError").text(resultSet.data); 
					 $("#alertError").show();
					  
				 } 
		 
		 } else if (status == "error") 
		 
		 { 
			 $("#alertError").text("Error while saving."); 
			 $("#alertError").show(); 
			 
		 } else
		 
		 { 
			 $("#alertError").text("Unknown error while saving.."); 
			 $("#alertError").show(); 
			 
		 } 
		
	
		 $("#hidItemIDSave").val(""); 
		 $("#add_bill")[0].reset(); 
	}
	

	
	
// update
	
	$(document).on("click", ".btnUpdate", function(event) 
	{ 
		
		 $("#bill_date").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#bill_arrears").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#bill_amount").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#bill_totalPayble").val($(this).closest("tr").find('td:eq(3)').text()); 
	});
	
	
	
//delete
	
$(document).on("click", ".btnRemove", function(event) 
	{ 
		 $.ajax( 
			 { 
					 url : "BillApi", 
					 type : "DELETE", 
					 data : "itemID=" + $(this).data("billid"),
					 dataType : "text", 
					 complete : function(response, status) 
				 { 
			     onbillDeleteComplete(response.responseText, status); 
			     } 
		 }); 
	});
	


//deletecompletion

function onbillDeleteComplete(response, status) 
{ 
	  if (status == "success") 
	 { 
		 var resultSet = JSON.parse(response); 
		 
			 if (resultSet.status.trim() == "success") 
				 { 
					 $("#alertSuccess").text("Successfully deleted."); 
					 $("#alertSuccess").show(); 
					 
					
			 } else if (resultSet.status.trim() == "error") 
				 
			 { 
				 $("#alertError").text(resultSet.data); 
				 $("#alertError").show(); 
			 } 
			 
	} else if (status == "error") 
			 
	{ 
	     $("#alertError").text("Error while deleting."); 
		 $("#alertError").show(); 
	} else
			 
	 { 
	     $("#alertError").text("Unknown error while deleting.."); 
		 $("#alertError").show(); 
	 } 
		
		
	}	
	
	
	
		
	function validateProjectForm() {
	
	if ($("#user_id").val().trim() == "") {
		return "Insert User ID:";
	}

	
	if ($("#date").val().trim() == "") {
		return "Insert Date:";
	}
	
	
	
	
	var tmparreears = $("#arreears").val().trim();
	 if (!$.isNumeric(tmpunit_usage)) 
	 {
		 return "Insert arreears.";
	 }

	
	 var tmpamount = $("#amount").val().trim();
	 if (!$.isNumeric(tmpamount)) 
	 {
		 return "Insert amount.";
	 }
	 
	 var tmptotalpayble = $("#totalpayble").val().trim();
	 if (!$.isNumeric(tmptotalpayble)) 
	 {
		 return "Insert totalpayble.";
	 }


	return true;
}


