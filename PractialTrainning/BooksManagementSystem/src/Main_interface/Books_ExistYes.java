package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class Books_ExistYes {
	public boolean Books_ExistYes(String hqbookname) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		boolean a = false;

		try {
			statement = connection.createStatement();
			sql = "select bookname from books";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				String bookname = rs.getString(1);

				if (hqbookname.equals(bookname)) {
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
