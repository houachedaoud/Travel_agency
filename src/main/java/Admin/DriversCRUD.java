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

public class DriversCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DriverCRUDButton = request.getParameter("DriverCRUDButton" ); 
		String FormButton = request.getParameter("FormButton");
		
		HttpSession session=request.getSession();  
		Connection con = new Connection().getDatabaseConnection();
		
		if("Create Driver".equals(DriverCRUDButton)) {
			
			session.setAttribute("includeForm", "createDriver");
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
			
		}else if("Select Driver".equals(DriverCRUDButton)) {
			
			session.setAttribute("includeForm", "selectDriver");
			
			ArrayList<Integer> driversIdsToDelete = new ArrayList<Integer>();
			try {
				PreparedStatement ps22 =con.prepareStatement("select DR_SECURITYNUMBER from TRAVELAGENCY.DRIVER ");
				ResultSet rs22 = ps22.executeQuery();
				while(rs22.next()) {
					driversIdsToDelete.add(rs22.getInt(1));
				}
				
				session.setAttribute("DriverIdsToDelete", driversIdsToDelete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
			
		}else if("Delete Driver".equals(DriverCRUDButton)) {
			
			session.setAttribute("includeForm", "deleteDriver");
			
			ArrayList<Integer> driversIdsToDelete = new ArrayList<Integer>();
			try {
				PreparedStatement ps24 =con.prepareStatement("select DR_SECURITYNUMBER from TRAVELAGENCY.DRIVER ");
				ResultSet rs24 = ps24.executeQuery();
				while(rs24.next()) {
					driversIdsToDelete.add(rs24.getInt(1));
				}
				
				session.setAttribute("driversIdsToDelete", driversIdsToDelete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
		}
		
		
		
		
		
		
		
		
		if("createDriver".equals(FormButton)) {
			String driverSecurityNumber = request.getParameter("driverSecurityNumber");
			String driverFirstname = request.getParameter("driverFirstname");
			String driverLastname = request.getParameter("driverLastname");
			String driverAddress = request.getParameter("driverAddress");
			try {
				PreparedStatement ps15 =con.prepareStatement("insert into TRAVELAGENCY.Driver(DR_SECURITYNUMBER, DR_FIRSTNAME, DR_LASTNAME, DR_ADDRESS)  values(?, ?, ?, ?)");
				ps15.setInt(1, Integer.parseInt(driverSecurityNumber));
				ps15.setString(2, driverFirstname);
				ps15.setString(3, driverLastname);
				ps15.setString(4, driverAddress);
				ps15.executeQuery();
				
				
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("selectedToUpdateDriver".equals(FormButton)) {
			int DriverSN = Integer.parseInt( request.getParameter("DriverIdsToUpdate"));
			session.setAttribute("oldID", DriverSN );
			
			try {
				PreparedStatement ps17 =con.prepareStatement("select * from TRAVELAGENCY.Driver where DR_SECURITYNUMBER=?");
				ps17.setInt(1, DriverSN);
				ResultSet rs17 = ps17.executeQuery();
				
				ArrayList<String> driverArrayList = new ArrayList<String>();
				while(rs17.next()) {
					driverArrayList.add(0, rs17.getString(2));
					driverArrayList.add(1, rs17.getString(3));
					driverArrayList.add(2, rs17.getString(4));
				
					//for(int i=1;i<5;i++)System.out.println(i+"="+driverArrayList.toArray()[i]);
					}
					
				session.setAttribute("includeForm", "UpdateDriver");
				session.setAttribute("driverArrayList", driverArrayList);
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if("UpdateDriver".equals(FormButton)) {
			
			String driverFirstname = request.getParameter("driverFirstname");
			String driverLastname = request.getParameter("driverLastname");
			String driverAddress = request.getParameter("driverAddress");
			int oldID = Integer.parseInt(session.getAttribute("oldID").toString());
			
			
			try {
				
					PreparedStatement ps21 =con.prepareStatement("update TRAVELAGENCY.DRIVER set DR_FIRSTNAME=?, DR_LASTNAME=?,	DR_ADDRESS=? where DR_SECURITYNUMBER=?");
					ps21.setString(1, driverFirstname);
					ps21.setString(2, driverLastname);
					ps21.setString(3, driverAddress);
					ps21.setInt(4, oldID);
					ps21.executeQuery();
					

					
				session.setAttribute("includeForm", "UpdateDriver");
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if("DeleteDriver".equals(FormButton)) {
			String driverSecurityNumber = request.getParameter("DriverIdsToDelete");

			try {
				PreparedStatement ps23 =con.prepareStatement("delete from TRAVELAGENCY.Driver where DR_SECURITYNUMBER=?");
				ps23.setInt(1, Integer.parseInt(driverSecurityNumber));
				ps23.executeQuery();
				
				
				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
