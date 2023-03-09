

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Enrollment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String psid = session.getAttribute("passengerID").toString();
		String trid = request.getParameter("idInput").toString();
		
		String action = request.getParameter("enrollButton");
		
		System.out.println(action);
		
		try {Connection con = new Connection().getDatabaseConnection();
		
		if(action.equals("Enrol")) {
		PreparedStatement ps0 =con.prepareStatement("select TR_ID, PS_ID from TRAVELAGENCY.DOES where TR_ID = ? AND PS_ID = ?");
		ps0.setInt(1, Integer.parseInt(trid));
		ps0.setInt(2, Integer.parseInt(psid));
		ResultSet rs = ps0.executeQuery();
		if(rs.next()) {
			
			session.setAttribute("Note","Already Enrolled"); 
			session.setAttribute("NoteColor", "Green");
			
			response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
			
		}else {

		PreparedStatement ps =con.prepareStatement("INSERT INTO TRAVELAGENCY.DOES (PS_id, TR_ID) VALUES (?,?)");		
	
		session.setAttribute("Note","Enrolled"); 
		session.setAttribute("NoteColor", "Green");  
		
		ps.setInt(1, Integer.parseInt(psid));
		ps.setInt(2, Integer.parseInt(trid)) ;
		
		ps.executeUpdate();
		con.close();
		response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
		}
		
		}else if (action.equals("Cancel")){
			PreparedStatement ps1 =con.prepareStatement("DELETE FROM TRAVELAGENCY.DOES WHERE TR_ID = ? AND PS_ID = ?");
			
			ps1.setInt(1, Integer.parseInt(trid));
			ps1.setInt(2, Integer.parseInt(psid));
			
			 
			
			ps1.executeUpdate();
			con.close();
			
			new ContentChanger().reload(request, response);
			
		}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
