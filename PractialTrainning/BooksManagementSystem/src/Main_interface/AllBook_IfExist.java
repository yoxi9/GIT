package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class AllBook_IfExist {

	public boolean AllBook_IfExist(int hqbookid) {

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		boolean a = false;
		try {
			statement = connection.createStatement();
			sql = "select bookid,booknumber from books";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				int bookid = rs.getInt(1);
				int booknumber = rs.getInt(2);

				if (bookid == hqbookid && booknumber == 0) {
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
