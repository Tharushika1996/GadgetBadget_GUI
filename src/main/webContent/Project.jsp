<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<title>Buyer Management - GadgetBadget</title>
	
		<link href="css/stylsheet.css" rel="stylesheet" />
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="Components/jquery-3.5.0.min.js"></script>
		<script src="Components/Investment.js"></script>

	</head>
	
	<body>
		<div class="container">
	
			<p class="font-weight-bold">
				<center>
					<h1><b>Buyer Management - GadgetBadget</b></h1>
				</center>
			</p>
			<br><br>
			
			<fieldset>
					<form id="Buyer" name="Buyer" class="border border-light p-5">
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Name:</label>
						    <input type="text" id="Name" class="form-control" name="Name" placeholder="Enter Name..">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Gender:</label>
						    <input type="text" id="Gender" class="form-control" name="Gender" placeholder="Enter Gender..">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Address:</label>
						    <input type="text" id="Address" class="form-control" name="Address" placeholder="Enter Address..">						    
						</div>
						
						<div class="form-outline mb-4">
						    <label class="form-label" for="form6Example3" class="col-sm-2 col-form-label col-form-label-sm">Contact No:</label>
						    <input type="text" id="ContactNo" class="form-control" name="ContactNo" placeholder="Enter ContactNo">						    
						</div>
					
						 
						<div class="row mb-4">
						    <div class="col">
						      <div class="form-outline">
						        <label class="form-label" for="form6Example1" class="col-sm-2 col-form-label col-form-label-sm">Email:</label>
						        <input type="text" id="Email" class="form-control" name="Email" placeholder="Enter Email">						        
						      </div>
						    </div>
						    
						  </div>						
						<br> 
						
						<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary btn-lg btn-block"> 
						<input type="hidden" id="hidBuyerIDSave" name="hidBuyerIDSave" value="">
						<br>
						<br>
						<input type="reset"  id="btnClear" name="btnClear" class="btn btn-primary btn-lg btn-block">
					</form>
				
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>			
			</fieldset>
			
			<br> 
			
			<div class="container" id="BuyerGrid">
				<fieldset>
					<legend><b>View Buyer Details</b></legend>
					<form method="post" action="Project.jsp" class="table table-striped">
						<%
							ProjectServlet viewDetails = new ProjectServlet();
											out.print(viewDetails.readDetails());
						%>
					</form>
					<br>
				</fieldset>
			</div>
		</div>
	</body>
</html>


