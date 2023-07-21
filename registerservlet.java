
package controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.registerbean;
import dao.registerdao;


public class registerservlet extends HttpServlet {
 
	 public registerservlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Copying all the input parameters in to local variables
		 String fullName = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		 
		 registerbean rb = new registerbean();
		//Using Java Beans - An easiest way to play with group of related data
		 rb.setFullName(fullName);
		 rb.setEmail(email);
		 rb.setUserName(userName);
		 rb.setPassword(password); 
		 
		 registerdao rd = new registerdao();
		 
		//The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = rd.registerUser(rb);
		 
		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		 }
	 }
}
