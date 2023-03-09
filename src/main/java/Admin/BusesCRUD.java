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

public class BusesCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BusCRUDButton = request.getParameter("BusCRUDButton" ); 
		String FormButton = request.getParameter("FormButton");
		System.out.println(FormButton);
		
		
		HttpSession session=request.getSession();  
		Connection con = new Connection().getDatabaseConnection();
		
		if("Create Bus".equals(BusCRUDButton)) {
			session.setAttribute("includeForm", "createBus");
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
		}else if("Update Bus".equals(BusCRUDButton)) {
			session.setAttribute("includeForm", "selectBus");
			ArrayList<Integer> BRNAL = new ArrayList<Integer>();
			try {
				PreparedStatement ps26 = con.prepareStatement("Select BUS_REGISTRATIONNUMBER from TRAVELAGENCY.BUS ");
				ResultSet rs26 = ps26.executeQuery();
				while(rs26.next()) {
					BRNAL.add(rs26.getInt(1));
				}
				session.setAttribute("BRNAL", BRNAL);

				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
		}else if("Delete Bus".equals(BusCRUDButton)) {
			session.setAttribute("includeForm", "deleteBus");
			ArrayList<Integer> BRNAL = new ArrayList<Integer>();
			try {
				PreparedStatement ps29 = con.prepareStatement("Select BUS_REGISTRATIONNUMBER from TRAVELAGENCY.BUS ");
				ResultSet rs29 = ps29.executeQuery();
				while(rs29.next()) {
					BRNAL.add(rs29.getInt(1));
				}
				session.setAttribute("BRNAL", BRNAL);

				response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	
		}
		
		
		
		
		if("createBus".equals(FormButton)) {
			int busRbusRegistrationNumber = Integer.parseInt(request.getParameter("busRegistrationNumber"));
			String busBrand = request.getParameter("busBrand");
			String busModel = request.getParameter("busModel");
			int busPlacesNumber = Integer.parseInt(request.getParameter("busPlacesNumber"));
			
			try {
				PreparedStatement ps25 = con.prepareStatement("insert into TRAVELAGENCY.BUS values(?, ?, ?, ?)");
				ps25.setInt(1, busRbusRegistrationNumber);
				ps25.setString(2, busBrand);
				ps25.setString(3, busModel);
				ps25.setInt(4, busPlacesNumber);
				ps25.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
			
		}else if("selectedToUpdateBus".equals(FormButton)) {
			int busRbusRegistrationNumber = Integer.parseInt(request.getParameter("busRegistrationNumber"));
			session.setAttribute("includeForm", "updateBus");
			ArrayList<String> BusInfos = new ArrayList<String>();
			try {
				PreparedStatement ps27 = con.prepareStatement("select * from TRAVELAGENCY.BUS where BUS_REGISTRATIONNUMBER=?");
				ps27.setInt(1, busRbusRegistrationNumber);
				ResultSet rs27 = ps27.executeQuery();
				while(rs27.next()) {
					BusInfos.add(Integer.toString(rs27.getInt(1)));
					BusInfos.add(rs27.getString(2));
					BusInfos.add(rs27.getString(3));
					BusInfos.add(Integer.toString(rs27.getInt(4)));
				}
				session.setAttribute("BusInfos", BusInfos);
				session.setAttribute("BRN", busRbusRegistrationNumber);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
		}else if("UpdateBus".equals(FormButton)) {
			
			String busBrand = request.getParameter("BB");
			String busModel = request.getParameter("BM");
			int busPlacesNumber = Integer.parseInt(request.getParameter("BPN"));

			try {
				PreparedStatement ps28 = con.prepareStatement("update TRAVELAGENCY.BUS set	BUS_BRAND= ?,	BUS_MODEL= ?,	BUS_PLACESNUMBER= ? where BUS_REGISTRATIONNUMBER=?");
				ps28.setString(1, busBrand);
				ps28.setString(2, busModel);
				ps28.setInt(3, busPlacesNumber);
				ps28.setInt(4, Integer.parseInt(session.getAttribute("BRN").toString()));
				ps28.executeQuery();

				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
		}else if("selectedToDeleteBus".equals(FormButton)) {
			

			int BRN = Integer.parseInt(request.getParameter("busRegistrationNumber"));

			try {
				PreparedStatement ps30 = con.prepareStatement("DELETE FROM TRAVELAGENCY.BUS where BUS_REGISTRATIONNUMBER=?");
				
				ps30.setInt(1, BRN);
				ps30.executeQuery();

				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Main/AdminMain/AdminMain.jsp");
			
		}
		
	}

}
