package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateEntryDB {

	public static void UpdateEntry(int ID, String name, String message) {
		Connection cnn = null;
		CallableStatement cstmt = null;

		try {
			cnn = ConnectDB.ConnectDataBase();
			if (cnn == null)
				return;
			//
			cstmt = cnn.prepareCall("{call spUpdateEntry(?,?,?)}", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			cstmt.setInt(1, ID);
			cstmt.setString(2, name);
			cstmt.setString(3, message);

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
