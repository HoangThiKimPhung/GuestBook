package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import MODEL.GuestBookEntry;

public class DeleteEntryDB {
	
	public static void DeleteEntry(int ID) {
		Connection cnn = null;
		CallableStatement cstmt = null;

		try {
			cnn = ConnectDB.ConnectDataBase();
			if (cnn == null)
				return;
			//
			cstmt = cnn.prepareCall("{call spDeleteEntry(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			cstmt.setInt(1, ID);

			cstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstmt != null) {
					cstmt.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
