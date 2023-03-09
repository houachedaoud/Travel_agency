package Admin;

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
import java.sql.SQLException;
import java.util.ArrayList;


public class DestinationsCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DestinationCRUDButton = request.getParameter("DestinationCRUDButton" ); 
		String FormButton = request.getParameter("FormButton");
		
		System.out.println(FormButton);
		
		HttpSession session=request.getSession();  
		Connection con = new Connection().getDatabaseConnection();
		
		if("Create Destination".equals(DestinationCRUDButton)) {
			session.setAttribute("includeForm", "createDestination");
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
		}else if("Update Destination".equals(DestinationCRUDButton)) {
			session.setAttribute("includeForm", "selectUpdateDestination");
			
			ArrayList<Integer> DIDAL = new ArrayList<Integer>();
			try {
				PreparedStatement ps33 = con.prepareStatement("select DE_ID from TRAVELAGENCY.DESTINATION ");
				ResultSet rs33 = ps33.executeQuery();
				while(rs33.next()) {
					DIDAL.add(rs33.getInt(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("DIDAL", DIDAL);
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
		}else if("Delete Destination".equals(DestinationCRUDButton)) {
			session.setAttribute("includeForm", "deleteDestination");
			
			ArrayList<String> DC = new ArrayList<String>();
			try {
				PreparedStatement ps36 = con.prepareStatement("select DE_CITY from TRAVELAGENCY.DESTINATION ");
				ResultSet rs36 = ps36.executeQuery();
				while(rs36.next()) {
					DC.add(rs36.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("DC", DC);
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
		}
		
		
		
		
		
		if("createDestination".equals(FormButton)) {
			String DC = request.getParameter("destinationCity");
			
			
			try {
				PreparedStatement ps32 = con.prepareStatement("select max(DE_ID) from TRAVELAGENCY.DESTINATION ");
				ResultSet rs32 = ps32.executeQuery();
				while(rs32.next()) {
				int DID = rs32.getInt(1) + 1;
				System.out.println(DID+" "+DC);
			
				PreparedStatement ps31 = con.prepareStatement("insert into TRAVELAGENCY.DESTINATION values(?,?)");
				ps31.setInt(1, DID);
				ps31.setString(2, DC);
				ps31.executeQuery();
				}
	
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}else if("selectedToUpdateDestination".equals(FormButton)) {
			session.setAttribute("includeForm", "updateDestination");
			int DID = Integer.parseInt( request.getParameter("DestinationID").toString());
			session.setAttribute("DID", DID);
			
			try {
				PreparedStatement ps34 = con.prepareStatement("select DE_CITY from TRAVELAGENCY.DESTINATION where DE_ID= ?");
				ps34.setInt(1, DID);
				ResultSet rs34 = ps34.executeQuery();
				while(rs34.next()) {	session.setAttribute("DCity", rs34.getString(1));	};
	
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if("UpdateDestination".equals(FormButton)) {
			String DC = request.getParameter("DestinationCity");
			int DID = Integer.parseInt(session.getAttribute("DID").toString());
			
			try {
				PreparedStatement ps35 = con.prepareStatement("update TRAVELAGENCY.DESTINATION set DE_CITY= ? where DE_ID= ?");
				ps35.setString(1, DC);
				ps35.setInt(2, DID);
				ps35.executeQuery();
	
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if("selectedToDeleteDestination".equals(FormButton)) {
			String DC = request.getParameter("DestinationCityToDelete");
			System.out.println(DC);
			try {
				PreparedStatement ps36 = con.prepareStatement("Delete from TRAVELAGENCY.DESTINATION where DE_CITY= ?");
				ps36.setString(1, DC);
				ps36.executeQuery();
	
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}
	
}
