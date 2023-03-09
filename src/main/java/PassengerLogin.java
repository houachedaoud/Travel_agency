

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class PassengerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		try{
			Connection con = new Connection().getDatabaseConnection();

			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select PS_password from TRAVELAGENCY.PASSENGER where PS_id="+id);
			
			if(rs.isBeforeFirst()){ 
				while(rs.next()) {
				if(password.equals(rs.getString(1))) { 
					response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
					HttpSession session=request.getSession();
					session.setAttribute("Passenger_ID",id);  

				}
			
			
			}}else 
					response.getWriter().append("acces denied ") ;
			
			
			
		}catch(Exception ex){ex.printStackTrace();}
	}

}
