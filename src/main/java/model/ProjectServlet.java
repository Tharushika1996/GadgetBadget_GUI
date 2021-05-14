package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectServlet {
	

	//A common method to connect to the DB
	private Connection connect() 
	 { 
	 Connection con = null; 
	 try
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 
	 //Provide the correct details: DBServer/DBName, username, password 
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/buyers", "root", ""); 
	 } 
	 catch (Exception e) 
	 {e.printStackTrace();} 
	 return con; 
	 } 
	
	
	//Insert buyer details
	public String insertDetails(String name, String gender, String address, String contactno, String email) 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for inserting."; } 
	 // create a prepared statement
	 String query = " insert into buyer_details  (`BuyerID`,`Name`,`Gender`,`Address`,`ContactNo`,`Email`)"
	 + " values (?, ?, ?, ?, ?,?)"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, 0); 
	 preparedStmt.setString(2, name); 
	 preparedStmt.setString(3, gender); 
	 preparedStmt.setString(4, address); 
	 preparedStmt.setString(5,contactno); 
	 preparedStmt.setString(6, email); 
	// execute the statement
	 
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Inserted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while inserting the item."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 

	
	//read buyer details
	public String readDetails() 
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for reading."; } 
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Name</th>" +
	 "<th>Gender</th>" +"<th>Address</th>"+
	 "<th>ContactNo</th>" +"<th>Email</th>"+
	 "<th>Update</th><th>Remove</th></tr>"; 
	 
	 String query = "select * from buyer_details"; 
	 Statement stmt = con.createStatement(); 
	 ResultSet rs = stmt.executeQuery(query); 
	 // iterate through the rows in the result set
	 while (rs.next()) 
	 { 
	 String buyerId = Integer.toString(rs.getInt("buyerId")); 
	 String name = rs.getString("name"); 
	 String gender = rs.getString("gender"); 
	 String address = rs.getString("address");
	 String contactno = rs.getString("contactno");
	 String email = rs.getString("email"); 
	 
	 
	 // Add into the html table
	 
	 output += "<td>" + name + "</td>"; 
	 output += "<td>" + gender + "</td>"; 
	 output += "<td>" + address + "</td>"; 
	 output += "<td>" + contactno + "</td>";
	 output += "<td>" + email + "</td>";	 
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
	 + "<input name='BuyerId' type='hidden' value='" + buyerId
	 + "'>" + "</form></td></tr>"; 
	 } 
	 con.close(); 
	 // Complete the html table
	 output += "</table>"; 
	 } 
	 catch (Exception e) 
	 { 
	 output = "Error while reading the items."; 
	 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 
	
	
	//update buyer details
	public String updateDetails(String id, String name, String gender, String address, String contactno, String email)
	{
		String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for updating."; } 
		 // create a prepared statement
		 String query = "UPDATE buyer_details SET Name=?,Gender=?,Address=?,ContactNo=?, Email=? WHERE BuyerID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, name); 
		 preparedStmt.setString(2, gender); 
		 preparedStmt.setString(3, address); 
		 preparedStmt.setString(4, contactno); 
		 preparedStmt.setString(5, email); 
		 preparedStmt.setInt(6, Integer.parseInt(id));
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Updated successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while updating the item."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 
	
	//delete buyer details
		public String deleteDetails(String id) 
		 { 
		 String output = ""; 
		 try
		 { 
		 Connection con = connect(); 
		 if (con == null) 
		 {return "Error while connecting to the database for deleting."; } 
		 // create a prepared statement
		 String query = "delete from buyer_details where BuyerID=?"; 
		 PreparedStatement preparedStmt = con.prepareStatement(query); 
		 // binding values
		 preparedStmt.setString(1, id);
		 // execute the statement
		 preparedStmt.execute(); 
		 con.close(); 
		 output = "Deleted successfully"; 
		 } 
		 catch (Exception e) 
		 { 
		 output = "Error while deleting the item."; 
		 System.err.println(e.getMessage()); 
		 } 
		 return output; 
		 } 

	

}

