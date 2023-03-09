package Admin;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.http.HttpServlet;




public class Connection extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private String DRIVER ="oracle.jdbc.driver.OracleDriver";
	private String URL ="jdbc:oracle:thin:@localhost:1521/XE";
	private String USERNAME ="system";
	private String PASSWORD ="Password";

	public Connection getDatabaseConnection(){	
		Connection connection = null;
		
		try {
			
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	

}
