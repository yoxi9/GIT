package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class BufferAppointment_SameBook {
	public boolean BufferAppointment_SameBook(int hqbookid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		boolean a = false;
		try {
			statement = connection.createStatement();
			sql = "select bookid from bufferappointment";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				
				int bookid = rs.getInt(1);
				if (hqbookid == bookid) {
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
