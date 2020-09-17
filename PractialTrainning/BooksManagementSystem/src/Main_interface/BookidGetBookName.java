package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class BookidGetBookName {
	public String BookidGetBookName(String zhanghao) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		
		try {
			statement = connection.createStatement();
			sql = "select bookid,bookname from books";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				int bookid = rs.getInt(1);
				String bookname = rs.getString(2);
				if (bookid == Integer.parseInt(zhanghao)) {
					return bookname;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeResource(connection, statement, rs);
		}
		
		
		
		return null;
	}
}
