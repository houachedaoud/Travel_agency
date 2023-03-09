

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
import java.sql.Statement;
import java.util.ArrayList;




public class ContentChanger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PageContent = request.getParameter("btn");
		
		HttpSession session=request.getSession();  
		
		//System.out.println(PageContent);
		
		
		if("About".equals(PageContent)) {
			 
			session.setAttribute("Content",PageContent); 
			session.setAttribute("Note", null); 
			response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
		
			
			
		}else if("Profile".equals(PageContent)) {
			
			session.setAttribute("Content",PageContent); 
			session.setAttribute("Note", null); 
			Connection con = new Connection().getDatabaseConnection();
			try {
				
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select PS_FIRSTNAME, PS_LASTNAME, PS_PHONENUMBER, PS_EMAIL	 from TRAVELAGENCY.PASSENGER where PS_id="+session.getAttribute("Passenger_ID"));
			while(rs.next()) {
				session.setAttribute("Passenger_ID",session.getAttribute("Passenger_ID"));
				
				session.setAttribute("firstname",rs.getString(1)); 
				session.setAttribute("lastname",rs.getString(2));
				session.setAttribute("phoneNumber",rs.getString(3));
				session.setAttribute("email",rs.getString(4));
				
			}
			response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}else if("Trips".equals(PageContent)) {
	        session.setAttribute("Content",PageContent);  
	        session.setAttribute("passengerID",session.getAttribute("Passenger_ID"));
	        session.setAttribute("title","All Trips");  
	        session.setAttribute("ButtonValue","Enrol"); 
	        session.setAttribute("Note", null);
	        
	        ArrayList<com.Trip> tripList = new ArrayList<com.Trip>();
	        
	        try (Connection con = new Connection().getDatabaseConnection()) {
	            try (PreparedStatement ps1 = con.prepareStatement("select * from TRAVELAGENCY.TRIP")) {
	                try (ResultSet rs1 = ps1.executeQuery()) {
	                    while (rs1.next()) {
	                        int id = rs1.getInt(1);
	                        String departureDate = rs1.getDate(2).toString();
	                        int period = rs1.getInt(3);
	                        String destinationCity = null;
	                        int enrollersNumber = 0;
	                        int busPlacesNumber = 0;
	                        int freeSitsNumber = 0;
	                        String driverFirstname = null;
	                        String driverLastname = null;
	                        
	                        try (PreparedStatement ps2 = con.prepareStatement("select DE_CITY from TRAVELAGENCY.DESTINATION where DE_ID in (select DE_ID from TRAVELAGENCY.CONSTITUTE where TR_ID= ?) ")) {
	                            ps2.setInt(1, id);
	                            try (ResultSet rs2 = ps2.executeQuery()) {
	                                if (rs2.next()) {
	                                    destinationCity = rs2.getString(1);
	                                }
	                            }
	                        }
	                       
	                        
	                        try (PreparedStatement ps3 = con.prepareStatement("select count(*) from TRAVELAGENCY.DOES where TR_ID= ? ")) {
	                            ps3.setInt(1, id);
	                            try (ResultSet rs3 = ps3.executeQuery()) {
	                                if (rs3.next()) {
	                                    enrollersNumber = rs3.getInt(1);
	                                }
	                            }
	                        }
	                        
	                        try (PreparedStatement ps3_5 = con.prepareStatement("select BUS_PLACESNUMBER from TRAVELAGENCY.BUS where BUS_REGISTRATIONNUMBER in( select BUS_REGISTRATIONNUMBER from TRAVELAGENCY.TRIP where TR_ID= ? )")) {
	                            ps3_5.setInt(1, id);
	                            try (ResultSet rs3_5 = ps3_5.executeQuery()) {
	                                if (rs3_5.next()) {
	                                    busPlacesNumber = rs3_5.getInt(1);
	                                }
	                            }
	                        }
	                        
	                        freeSitsNumber = busPlacesNumber - enrollersNumber;
	                        
	                        try (PreparedStatement ps4 = con.prepareStatement("select DR_FIRSTNAME, DR_LASTNAME from TRAVELAGENCY.DRIVER where DR_SECURITYNUMBER in (select DR_SECURITYNUMBER from TRAVELAGENCY.TRIP where TR_ID= ? ) ")) {
	                            ps4.setInt(1, id);
	                            try (ResultSet rs4 = ps4.executeQuery()) {
	                                if (rs4.next()) {
	                                    driverFirstname = rs4.getString(1);
	                                    driverLastname = rs4.getString(2);
	                                }
	                            }
	                        }
	                        
	                        
	                        tripList.add(new com.Trip(id, departureDate, period, destinationCity, freeSitsNumber, driverFirstname, driverLastname));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            // handle the SQLException
	        }
	    
	        session.setAttribute("tripData", tripList);
			response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
			
			
		}else if("My Trips".equals(PageContent)) {
				session.setAttribute("Content",PageContent);  
				session.setAttribute("passengerID",session.getAttribute("Passenger_ID"));
				session.setAttribute("title","Your Trips");
				session.setAttribute("ButtonValue","Cancel"); 
				session.setAttribute("Note", null); 
				
				ArrayList<com.Trip> tripList = new ArrayList<com.Trip>();

				Connection con = new Connection().getDatabaseConnection();
				try {
					
					PreparedStatement preparedStatement;
					preparedStatement = con.prepareStatement("select * from TRAVELAGENCY.TRIP where TR_ID IN (select TR_ID from TRAVELAGENCY.DOES where PS_ID= "+session.getAttribute("Passenger_ID")+")");
					ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()) {
					int id = rs.getInt(1);
					String departureDate =rs.getDate(2).toString() ;
					int period = rs.getInt(3);
					int freeSitsNumber = 0;
					int busPlacesNumber = 0;
					int enrollersNumber = 0;
					
					
					preparedStatement = con.prepareStatement("select count(*) from TRAVELAGENCY.DOES where TR_ID ="+id);
					ResultSet rs4 = preparedStatement.executeQuery( );
					while(rs4.next()) {
						
						enrollersNumber = rs4.getInt(1);
						
						
					PreparedStatement ps4_5 = con.prepareStatement("select BUS_PLACESNUMBER from TRAVELAGENCY.BUS where BUS_REGISTRATIONNUMBER in( select BUS_REGISTRATIONNUMBER from TRAVELAGENCY.TRIP where TR_ID= ? )");
	                       ps4_5.setInt(1, id);
	                            ResultSet rs4_5 = ps4_5.executeQuery();
	                                while(rs4_5.next()){
	                                    busPlacesNumber = rs4_5.getInt(1);
	                                    
	                                
	                                 	 
	                        
						
				preparedStatement = con.prepareStatement("SELECT DR_FIRSTNAME, DR_LASTNAME FROM TRAVELAGENCY.DRIVER WHERE DR_SECURITYNUMBER IN ( SELECT DR_SECURITYNUMBER FROM TRAVELAGENCY.TRIP where TR_ID= "+id+" )");
				ResultSet rs3 = preparedStatement.executeQuery( );
				
				while(rs3.next()) {
				
				 String driverFirstname = rs3.getString(1);
				 String driverLastname = rs3.getString(2);
				 
				 preparedStatement = con.prepareStatement("SELECT DE_city FROM TRAVELAGENCY.DESTINATION WHERE DE_id IN ( SELECT DE_id FROM TRAVELAGENCY.CONSTITUTE WHERE TR_id IN (SELECT TR_id FROM TRAVELAGENCY.TRIP WHERE TR_id ="+id+" ))");
					ResultSet rs2 = preparedStatement.executeQuery();
					
				while(rs2.next()) {
					 String destinationCity = rs2.getString(1);
					 freeSitsNumber =  busPlacesNumber - enrollersNumber;
					tripList.add(new com.Trip(id,departureDate,period,destinationCity,freeSitsNumber,driverFirstname,driverLastname));
				} 
				}
				}
	            }
				}

				session.setAttribute("tripData", tripList);
				response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else if("Home".equals(PageContent)) {
				
				session.setAttribute("Content",PageContent);  
				session.setAttribute("passengerID",session.getAttribute("Passenger_ID"));
				session.setAttribute("Note", null); 
				
				response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");

				
			}else if("Logout".equals(PageContent)) {
				session.setAttribute("Note", null); 
			session.setAttribute("Passenger_ID",null);
			response.sendRedirect("LoginAndSignupForms/Passenger/Login/PassengerLogin.jsp");
			}
		
		
	
	
	
}
	
	public void reload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		
		session.setAttribute("Content","My Trips");  
		session.setAttribute("passengerID",session.getAttribute("Passenger_ID"));
		session.setAttribute("title","Your Trips");
		session.setAttribute("ButtonValue","Cancel"); 
		
		session.setAttribute("Note", "Deleted"); 
		session.setAttribute("NoteColor", "Red"); 
		
		ArrayList<com.Trip> tripList = new ArrayList<com.Trip>();

		Connection con = new Connection().getDatabaseConnection();
		try {
			
			PreparedStatement preparedStatement;
			preparedStatement = con.prepareStatement("select * from TRAVELAGENCY.TRIP where TR_ID IN (select TR_ID from TRAVELAGENCY.DOES where PS_ID= "+session.getAttribute("Passenger_ID")+")");
			ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String departureDate =rs.getDate(2).toString() ;
			int period = rs.getInt(3);
			
			
			preparedStatement = con.prepareStatement("select count(*) from TRAVELAGENCY.DOES where TR_ID ="+id);
			ResultSet rs4 = preparedStatement.executeQuery( );
			while(rs4.next()) {
				
				int enrollersNumber = rs4.getInt(1);
				
		preparedStatement = con.prepareStatement("SELECT DR_FIRSTNAME, DR_LASTNAME FROM TRAVELAGENCY.DRIVER WHERE DR_SECURITYNUMBER IN ( SELECT DR_SECURITYNUMBER FROM TRAVELAGENCY.DRIVE WHERE BUS_REGISTRATIONNUMBER IN ( SELECT BUS_REGISTRATIONNUMBER FROM TRAVELAGENCY.BUS WHERE BUS_REGISTRATIONNUMBER IN( SELECT BUS_REGISTRATIONNUMBER FROM TRAVELAGENCY.TRIP WHERE BUS_REGISTRATIONNUMBER = "+rs.getInt(4)+" )))");
		ResultSet rs3 = preparedStatement.executeQuery( );
		
		while(rs3.next()) {
		
		 String driverFirstname = rs3.getString(1);
		 String driverLastname = rs3.getString(2);
		 
		 preparedStatement = con.prepareStatement("SELECT DE_city FROM TRAVELAGENCY.DESTINATION WHERE DE_id IN ( SELECT DE_id FROM TRAVELAGENCY.CONSTITUTE WHERE TR_id IN (SELECT TR_id FROM TRAVELAGENCY.TRIP WHERE TR_id ="+id+" ))");
			ResultSet rs2 = preparedStatement.executeQuery();
			
		while(rs2.next()) {
			 String destinationCity = rs2.getString(1);
			tripList.add(new com.Trip(id,departureDate,period,destinationCity,enrollersNumber,driverFirstname,driverLastname));
		} 
		}
			}
		}

		session.setAttribute("tripData", tripList);
		response.sendRedirect("Main/PassengerMain/PassengerMain.jsp");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
