package gvp.cse.team1.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	private String databaseUserName= "root";
	private String databasePassword = "root";
	private String databaseSchema = "OnlineMedicalAdvisor";
	
	public Connection createDatabaseConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection  con=DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/"+databaseSchema,databaseUserName,databasePassword);
		return con;
		}

}
