package DAO;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection connect = null;
	
	public static Connection ConnectDataBase() {	
				
		try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connect=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LTW_GuestBook;user=sa;password=12345678");            
            
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
        return connect;
	}

}
