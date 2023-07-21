
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import bean.registerbean;
import util.dbconnection;

public class registerdao { 
	 public String registerUser(registerbean rb)
	 {
		 String fullName = rb.getFullName();
		 String email = rb.getEmail();
		 String userName = rb.getUserName();
		 String password = rb.getPassword();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;		 
		 try
		 {
			 con = dbconnection.createConnection();
			 String query = "insert into users(SNo,fullName,Email,userName,password) values (NULL,?,?,?,?)"; //Insert user details into the table 'USERS'
			 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			 preparedStatement.setString(1, fullName);
			 preparedStatement.setString(2, email);
			 preparedStatement.setString(3, userName);
			 preparedStatement.setString(4, password);
			 
			 int i= preparedStatement.executeUpdate();
			 
			 if (i!=0)  //Just to ensure data has been inserted into the database
			 return "SUCCESS"; 
		 }
		 catch(SQLException e)
		 {
			e.printStackTrace();
		 }		 
		 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
         }}