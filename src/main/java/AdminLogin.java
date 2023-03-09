

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		try{
			Connection con = new Connection().getDatabaseConnection();

			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select ADMIN_password from TRAVELAGENCY.ADMIN where ADMIN_id="+id);
			
			if(!rs.isBeforeFirst()){ response.getWriter().append("acces denied because the id is wrong");}else {
			while(rs.next()) {
				
				if(password.equals(rs.getString(1))) { 
					
					response.sendRedirect("Main/AdminMain/AdminMain.jsp"); ;

				}else 
					response.getWriter().append("acces denied because the password is wrong") ;
			}}
			
			
			
		}catch(Exception ex){ex.printStackTrace();}
	}

}
