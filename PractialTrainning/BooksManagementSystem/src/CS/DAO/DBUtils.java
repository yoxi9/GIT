package CS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DBUtils {
	private static Connection connection = null; // ���Ӷ���
	private static PreparedStatement stmt = null; // �������ݿ�Ķ���
	private static ResultSet rs = null; // ����������

	public static Connection getConnection() {
		Driver driver = null;
		try {
			//
			driver = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/myjavadb3";

		Properties info = new Properties();
		info.put("user", "root");
		info.put("password", "root");

		Connection connection = null;
		try {
			connection = driver.connect(url, info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeResource(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void update(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;

		connection = getConnection();
		try {
			statement = connection.prepareStatement(sql);

			for (int i = 0; i < objects.length; i++) {
				statement.setObject(i + 1, objects[i]);
			}
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(connection, statement);
		}
	}

	public static void update(String sql) {
		Connection connection = null;
		Statement statement = null;
		/*
		 * Statement�ӿڣ������У� executeUpdate(sql)�����������ݿ�ĸ��� executeQuery(sql)�������ݿ�Ĳ�ѯ
		 */

		try {
			// 1.Ҫ�����ݿ�����
			connection = DBUtils.getConnection();
			System.out.println(connection);

			System.out.println(sql);
			// 3. Ҫʹ�����Ӵ���Statement
			statement = connection.createStatement();
			// 4. Ҫ����statement�ĸ��·���������sql���
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement);
		}
	}

	public static int executeUpdate(String sql, Object[] params) throws Exception {
		int affectedLine = 0;// ��Ӱ�������
		/** �������ݿ����� **/
		connection = getConnection();
		/** �������ݿ���� **/
		stmt = connection.prepareStatement(sql); // ׼��ִ�����
		for (int i = 0; i < params.length; i++) {
			/** ������ִ������е�?'�ʺ�'��ֵ **/
			stmt.setObject(i + 1, params[i]);
		}
		affectedLine = stmt.executeUpdate(); // ִ�����
		closeAll();
		return affectedLine;
	}

	public static int executeUpdate2(String sql, Object... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		int flag = 0;

		connection = getConnection();
		try {
			statement = connection.prepareStatement(sql);

			for (int i = 0; i < objects.length; i++) {
				statement.setObject(i + 1, objects[i]);
			}
			flag = statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource(connection, statement);
		}
		return flag;
	}

	public static List<HashMap<String, Object>> executeQuery2(String sql, Object... objs) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		connection = DBUtils.getConnection();
		try {
			/*
			 * 1. ʹ��connection��preparedStatement()��������preparedStatement���� ����������sql��Ϊ��δ���
			 */
			statement = connection.prepareStatement(sql);
			/* 2. �Ը�������ֵ */
			for (int i = 0; i < objs.length; i++) {
				statement.setObject(i + 1, objs[i]);
			}

			rs = statement.executeQuery();
			rsmd = rs.getMetaData();
			int columnNum = rsmd.getColumnCount();
			/*
			 * System.out.println("����ȡ�����µ��ֶΣ�"); for (int i=0;i<columnNum;i++) {
			 * System.out.println(rsmd.getColumnLabel(i+1)); }
			 */
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < columnNum; i++) {
					map.put(rsmd.getColumnLabel(i + 1), rs.getObject(i + 1));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. �ص�preparedstatement
			DBUtils.closeResource(connection, statement, rs);
		}
		return list;
	}

	public static void closeResource(Connection connection, Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeResource(Connection connection, Statement statement, ResultSet resultset) {
		if (resultset != null) {
			try {
				resultset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void closeAll() {
		/** �رս�������� **/
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/** �ر�stmt���� **/
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/** �ر�connection���Ӷ��� **/
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
