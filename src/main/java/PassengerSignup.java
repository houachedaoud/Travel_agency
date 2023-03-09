

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class PassengerSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("fname");
		String lastname=request.getParameter("lname");
		String email=request.getParameter("email");
		String phoneNumber=request.getParameter("phoneNumber");
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		System.out.println(email +" "+ phoneNumber);
		
		try{
			Connection con = new Connection().getDatabaseConnection();
			
			session.setAttribute("EmailError", null); 
			session.setAttribute("PhoneNumberError", null);
		
			Statement stmt0 = con.createStatement();
			ResultSet rs0 = stmt0.executeQuery("SELECT * FROM TRAVELAGENCY.PASSENGER WHERE PS_EMAIL= '"+email+"' ");
			
			Statement stmt1 = con.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM TRAVELAGENCY.PASSENGER WHERE PS_PHONENUMBER= '"+phoneNumber+"' ");
			
			Boolean bool1 = rs1.next();
			Boolean bool0 = rs0.next();
			System.out.println(bool1 +" "+ bool0);
			
			if(bool1 && bool0) {
				session.setAttribute("PhoneNumberError", "Phone Number is already used");
				session.setAttribute("EmailError", "email is already used"); 
				response.sendRedirect("LoginAndSignupForms/Passenger/Signup/PassengerSignup.jsp");
				
			}else if (bool0) { session.setAttribute("EmailError", "email is already used"); 
			response.sendRedirect("LoginAndSignupForms/Passenger/Signup/PassengerSignup.jsp");
			}else if(bool1) { session.setAttribute("PhoneNumberError", "Phone Number is already used"); 
			response.sendRedirect("LoginAndSignupForms/Passenger/Signup/PassengerSignup.jsp");
			
			}else {
				
			
			PreparedStatement preparedStatement =con.prepareStatement("SELECT MAX( PS_ID ) FROM TRAVELAGENCY.PASSENGER");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int maxID = rs.getInt(1) ;
				System.out.println(maxID);
			PreparedStatement ps =con.prepareStatement("INSERT INTO TRAVELAGENCY.PASSENGER (PS_id, PS_firstname, PS_lastname, PS_EMAIL, PS_PHONENUMBER, PS_password) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, maxID +1);
			ps.setString(2,firstname);
			ps.setString(3,lastname);
			ps.setString(4,email);
			ps.setString(5,phoneNumber);
			ps.setString(6,password);
			
			ps.executeUpdate();
			con.close();
			response.sendRedirect("LoginAndSignupForms/Passenger/Login/PassengerLogin.jsp");
		}}
			
		
		}catch(Exception ex){ex.printStackTrace();}
			
		
	}

}
