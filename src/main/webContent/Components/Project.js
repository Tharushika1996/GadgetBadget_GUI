//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
	$("#alertError").hide();
	$("#hidBuyerIDSave").val("");
	$("#Project")[0].reset();
});

$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	// If valid------------------------
	var type = ($("#hidBuyerIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "ProjectAPI",
		type : type,
		data : $("#Project").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});

});

function onItemSaveComplete(response, status) {
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#InvestmentGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} 
	else if (status == "error") {
		
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	
	$("#hidByyerIDSave").val("");
	$("#Project")[0].reset();
}

$(document).on("click", ".btnRemove", function(event) {
	
	$.ajax({
		url : "ProjectAPI",
		type : "DELETE",
		data : "BuyerID=" + $(this).data("BuyerID"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status) {
	
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#InvestmentGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
		
	} else if (status == "error") {
		
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event)
		{
			$("#hidBuyerIDSave").val($(this).data("BuyerID"));
			$("#Name").val($(this).closest("tr").find('td:eq(0)').text());
			$("#Gender").val($(this).closest("tr").find('td:eq(1)').text());
			$("#Address").val($(this).closest("tr").find('td:eq(2)').text());
			$("#ContactNo").val($(this).closest("tr").find('td:eq(3)').text());
			$("#Email").val($(this).closest("tr").find('td:eq(4)').text());
					
		});


// CLIENTMODEL=========================================================================
function validateItemForm() {
	
	// Name
	if ($("#Name").val().trim() == "") {
		return "Please insert Name.";
	}
	
	// Gender
	if ($("#Gender").val().trim() == "") {
		return "Please insert Gender.";
	}
	
	// Address
	if ($("#Address").val().trim() == "") {
		return "Please insert Address.";
	}
	
	// contactno
	if ($("#iContactNo").val().trim() == "") {
		return "Please insert ContactNo.";
	}

	// Email
	if ($("#Email").val().trim() == "") {
		return "Please insert Email.";
	}
	
	
	
	return true;
}