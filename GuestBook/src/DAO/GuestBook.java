package DAO;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import MODEL.GuestBookEntry;

public class GuestBook {
	
	
	public static List<GuestBookEntry> SelectEntry() {
		Connection cnn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();

		try {
			cnn = ConnectDB.ConnectDataBase();
			if (cnn == null)
				return null;
			//
			stmt = cnn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM GUESTBOOK");

			while (rs.next()) {
				GuestBookEntry entry = new GuestBookEntry(
						rs.getInt("ID"), 
						rs.getString("name"),
						rs.getString("message"));
				entries.add(entry);
			}
			return entries;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public static int InsertEntryGuestBook(String name, String message) throws ServletException{
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=ConnectDB.ConnectDataBase();
		if(conn == null)
			return 0;
		try {
			
			String sql= "{call spInserEntryGuestBook(?,?)}";
			cstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, name);
			cstmt.setString(2, message);	
			
			int k = cstmt.executeUpdate();
			if (k >= 1)
                return k;
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (cstmt != null) {
                	cstmt.close();
                }
            } catch (SQLException e) {
            	throw new ServletException(e);
            }
        }
		return 0;
	}
}
