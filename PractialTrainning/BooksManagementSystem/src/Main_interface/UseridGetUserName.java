package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class UseridGetUserName {
	public String UseridGetUserName(String zhanghao) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		
		try {
			statement = connection.createStatement();
			sql = "select borrowid,name from bookuser";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				int borrowid = rs.getInt(1);
				String name = rs.getString(2);
				if (borrowid == Integer.parseInt(zhanghao)) {
					return name;
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
