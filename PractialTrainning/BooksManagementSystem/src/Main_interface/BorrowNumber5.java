package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CS.DAO.DBUtils;

public class BorrowNumber5 {
	public boolean BorrowNumber5(String zhanghao) {// �жϴ��������ĵ��鼮���Ƿ��г�ʱ��
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		int j = 0;
		try {
			statement = connection.createStatement();
			sql = "select userid from borrow";
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

		return j < 5;

	}
}
