package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class AppointmentSameBook {
	public boolean AppointmentSameBook(int hqbookid, String zhanghao) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		boolean a = false;

		try {
			statement = connection.createStatement();
			sql = "select userid,bookid from appointment";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				String userid = rs.getString(1);
				int bookid = rs.getInt(2);
				if (zhanghao.equals(userid) && hqbookid == bookid) {
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
