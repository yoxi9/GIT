package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class ChangePasswordResults {

	public boolean ChangePasswordResults(String hqborrowid, String hqname, String hquser, String hqsex, String hqgrade,
			String hqadmin) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		boolean a = false;
		try {
			statement = connection.createStatement();
			sql = "select borrowid,name,user,sex,grade,admin from bookuser";
			rs = statement.executeQuery(sql);
			int hqbookid1 = Integer.parseInt(hqborrowid);
			for (int i = 0; rs.next(); i++) {
				int borrowid = rs.getInt(1);
				String name = rs.getString(2);
				String user = rs.getString(3);
				String sex = rs.getString(4);
				String grade = rs.getString(5);
				String admin = rs.getString(6);
				if (hqbookid1 == borrowid && hqname.equals(name) && hquser.equals(user) && hqsex.equals(sex)
						&& hqgrade.equals(grade) && hqadmin.equals(admin)) {
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
