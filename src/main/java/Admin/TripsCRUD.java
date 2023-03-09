package Admin;

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
import java.util.ArrayList;

public class TripsCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String includeForm = request.getParameter("TripCRUDButton");
		
		
		String FormButton = request.getParameter("FormButton");
		//System.out.println(includeForm+"\n"+FormButton);
		
		HttpSession session=request.getSession();  
		Connection con = new Connection().getDatabaseConnection();
		
		if("Create Trip".equals(includeForm)) {
			
			session.setAttribute("includeForm", "create");

			/* Destinations array list */
			ArrayList<String> DestinationsArrayList = new ArrayList<String>();
			try {
				PreparedStatement ps0 =con.prepareStatement("select DE_CITY from TRAVELAGENCY.DESTINATION ");
				ResultSet rs0 = ps0.executeQuery();
				while(rs0.next()) {
					//System.out.println(rs0.getString(1));
					DestinationsArrayList.add(rs0.getString(1));
					session.setAttribute("destinationArrayList", DestinationsArrayList);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/**************************************************************************************/
			
			/* Busess array list */
			ArrayList<Integer> BusesArrayList = new ArrayList<Integer>();
			
			try {
				PreparedStatement ps1 =con.prepareStatement("select BUS_REGISTRATIONNUMBER from TRAVELAGENCY.BUS ");
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					//System.out.println(rs1.getInt(1));
					BusesArrayList.add(rs1.getInt(1));
					session.setAttribute("BusesArrayList", BusesArrayList);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/**************************************************************************************/
			
			/* Drivers array list */
			ArrayList<Integer> DriversArrayList = new ArrayList<Integer>();
			
			try {
				PreparedStatement ps2 =con.prepareStatement("select DR_SECURITYNUMBER from TRAVELAGENCY.Driver ");
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()) {
					//System.out.println(rs2.getInt(1));
					DriversArrayList.add(rs2.getInt(1));
					session.setAttribute("DriversArrayList", DriversArrayList);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/**************************************************************************************/
		
			
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
		
		}else if("SelectIDToUpdate".equals(includeForm)) {
			session.setAttribute("includeForm", "selectidtoupdate");
			
			ArrayList<Integer> idsToUpdate = new ArrayList<Integer>();
			try {
				PreparedStatement ps8 =con.prepareStatement("select TR_ID from TRAVELAGENCY.TRIP ");
				ResultSet rs8 = ps8.executeQuery();
				while(rs8.next()) {
					idsToUpdate.add(rs8.getInt(1));
				}
				
				session.setAttribute("idsToUpdate", idsToUpdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
			
			
		}else if("Delete Trip".equals(includeForm)) {
			
			session.setAttribute("includeForm", "delete");
			ArrayList<Integer> ids = new ArrayList<Integer>();
			
			
			try {
				PreparedStatement ps6 =con.prepareStatement("select TR_ID from TRAVELAGENCY.TRIP ");
				ResultSet rs6 = ps6.executeQuery();
				while(rs6.next()) {
					ids.add(rs6.getInt(1));
				}
				
				session.setAttribute("idsToDelete", ids);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
			
		}
		
		
		
		
		
		
		
		
		
		if("Create".equals(FormButton)) {
			String DD = request.getParameter("departureDateInput");
			int Period = Integer.parseInt(request.getParameter("periodInput"));
			String Destination = request.getParameter("destinationInput");
			int BusRegistrationNumber = Integer.parseInt(request.getParameter("busInput"));
			int DriverSecutityNumber = Integer.parseInt(request.getParameter("driverInput"));
			//System.out.println(DD +" "+Period+" "+Destination+" "+BusRegistrationNumber+" "+DriverSecutityNumber);
			
			
			try {
				PreparedStatement ps4 =con.prepareStatement("SELECT MAX(TR_ID) FROM TRAVELAGENCY.TRIP");
				ResultSet rs4 = ps4.executeQuery();
				while(rs4.next()) { 
				int tripID = rs4.getInt(1) + 1;
				
				PreparedStatement ps3 =con.prepareStatement("INSERT INTO TRAVELAGENCY.TRIP(TR_ID, TR_DEPARTUREDATE, TR_PERIOD, BUS_REGISTRATIONNUMBER, DR_SECURITYNUMBER) VALUES(?, TO_DATE(?,'YYYY-MM-DD'), ?, ?, ?) ");
				ps3.setInt(1, tripID);
				ps3.setString(2, DD);
				ps3.setInt(3, Period);
				ps3.setInt(4, BusRegistrationNumber);
				ps3.setInt(5, DriverSecutityNumber);
				ps3.execute();

				PreparedStatement ps6 =con.prepareStatement("select DE_ID from TRAVELAGENCY.DESTINATION where DE_CITY= ?");
				ps6.setString(1, Destination);
				ResultSet rs6 = ps6.executeQuery();
				while(rs6.next()) { int DestinationID = rs6.getInt(1) ;
				
				PreparedStatement ps5 =con.prepareStatement("insert into TRAVELAGENCY.CONSTITUTE values(?, ?)");
				ps5.setInt(1, tripID);
				System.out.println("fff"+DestinationID);
				ps5.setInt(2, DestinationID);
				ps5.executeQuery();
				
				}}
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		}else if("Delete".equals(FormButton)) {
			int TripID = Integer.parseInt(request.getParameter("tripidInput"));
			
			try {
				PreparedStatement ps7 = con.prepareStatement("DELETE FROM TRAVELAGENCY.TRIP WHERE TR_ID= ?");
				ps7.setInt(1, TripID);
				ps7.execute();
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if("Select".equals(FormButton)) {
			int TripIDSelected = Integer.parseInt(request.getParameter("TripIDSelected"));
			session.setAttribute("TripIDSelected", TripIDSelected);
			
			try {
				PreparedStatement ps9 = con.prepareStatement("SELECT * FROM TRAVELAGENCY.TRIP WHERE TR_ID= ?");
				ps9.setInt(1, TripIDSelected);
				ResultSet rs9 = ps9.executeQuery();
				rs9.next();
				session.setAttribute("departureDate",rs9.getDate(2).toString());
				session.setAttribute("period",Integer.toString(rs9.getInt(3)));
				
				/* Destinations array list */
				ArrayList<String> DestinationsArrayList = new ArrayList<String>();
				try {
					PreparedStatement ps10 =con.prepareStatement("select DE_CITY from TRAVELAGENCY.DESTINATION ");
					ResultSet rs10 = ps10.executeQuery();
					while(rs10.next()) {
						//System.out.println(rs0.getString(1));
						DestinationsArrayList.add(rs10.getString(1));
						session.setAttribute("destinationArrayList", DestinationsArrayList);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**************************************************************************************/
				
				/* Busess array list */
				ArrayList<Integer> BusesArrayList = new ArrayList<Integer>();
				
				try {
					PreparedStatement ps11 =con.prepareStatement("select BUS_REGISTRATIONNUMBER from TRAVELAGENCY.BUS ");
					ResultSet rs11 = ps11.executeQuery();
					while(rs11.next()) {
						//System.out.println(rs1.getInt(1));
						BusesArrayList.add(rs11.getInt(1));
						
						session.setAttribute("BusesArrayList", BusesArrayList);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**************************************************************************************/
								
				/* Drivers array list */
				ArrayList<Integer> DriversArrayList = new ArrayList<Integer>();
				
				try {
					PreparedStatement ps11 =con.prepareStatement("select DR_SECURITYNUMBER from TRAVELAGENCY.DRIVER ");
					ResultSet rs11 = ps11.executeQuery();
					while(rs11.next()) {
						//System.out.println(rs1.getInt(1));
						DriversArrayList.add(rs11.getInt(1));
						
						session.setAttribute("DriversArrayList", DriversArrayList);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				session.setAttribute("includeForm", "Update");
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if("Update".equals(FormButton)) {
			String DD = request.getParameter("departureDateInput");
			int Period = Integer.parseInt(request.getParameter("periodInput"));
			int BusRegistrationNumber = Integer.parseInt(request.getParameter("busInput"));
			int driverSECURITYNUMBER = Integer.parseInt(request.getParameter("driverInput"));
			
			try {
				PreparedStatement ps13 =con.prepareStatement("UPDATE TRAVELAGENCY.TRIP SET TR_DEPARTUREDATE = to_date( ?, 'yyyy-mm-dd'), TR_PERIOD = ?, BUS_REGISTRATIONNUMBER=?, DR_SECURITYNUMBER=? where TR_ID = ?");
				ps13.setString(1, DD);
				ps13.setInt(2, Period);
				ps13.setInt(3, BusRegistrationNumber);
				ps13.setInt(4, driverSECURITYNUMBER);
				ps13.setInt(5, Integer.parseInt( session.getAttribute("TripIDSelected").toString()));
				
				//System.out.println(DD+" "+Period+" "+BusRegistrationNumber);
				ps13.executeQuery();
				
				String DestinationCity = request.getParameter("destinationInput");
				PreparedStatement ps14 =con.prepareStatement("UPDATE TRAVELAGENCY.CONSTITUTE set DE_ID=(SELECT DE_ID FROM TRAVELAGENCY.DESTINATION WHERE DE_CITY =? ) WHERE TR_ID = ?");
				ps14.setString(1, DestinationCity);
				//System.out.println(DestinationCity);
				ps14.setInt(2, Integer.parseInt( session.getAttribute("TripIDSelected").toString()));
				ps14.executeQuery();
				
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
