package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class Admini_ExistYes {
	public boolean Admini_ExistYes(int hquserid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		boolean a = false;

		try {
			statement = connection.createStatement();
			sql = "select borrowid,admin from bookuser";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				int borrowid = rs.getInt(1);
				String admin = rs.getString(2);
				if (hquserid == borrowid && "π‹¿Ì‘±".equals(admin)) {
					a = true;
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement, rs);
		}
		return a;

	}
}
