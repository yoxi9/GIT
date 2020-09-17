package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class AppointmentNumber3 {

	public boolean AppointmentNumber3(String zhanghao) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		int j = 0;
		try {
			statement = connection.createStatement();
			sql = "select userid from appointment";
			rs = statement.executeQuery(sql);

			for (int i = 0; rs.next(); i++) {
				String userid = rs.getString(1);
				if (zhanghao.equals(userid)) {
					j++;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement, rs);
		}

		return j < 3;

	}
}
