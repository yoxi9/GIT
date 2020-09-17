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
	private static Connection connection = null; // 链接对象
	private static PreparedStatement stmt = null; // 操作数据库的对象
	private static ResultSet rs = null; // 结果保存对象

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
		 * Statement接口，其中有： executeUpdate(sql)方法用于数据库的更新 executeQuery(sql)用于数据库的查询
		 */

		try {
			// 1.要有数据库连接
			connection = DBUtils.getConnection();
			System.out.println(connection);

			System.out.println(sql);
			// 3. 要使用连接创建Statement
			statement = connection.createStatement();
			// 4. 要调用statement的更新方法来运行sql语句
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement);
		}
	}

	public static int executeUpdate(String sql, Object[] params) throws Exception {
		int affectedLine = 0;// 受影响的行数
		/** 建立数据库连接 **/
		connection = getConnection();
		/** 操作数据库对象 **/
		stmt = connection.prepareStatement(sql); // 准备执行语句
		for (int i = 0; i < params.length; i++) {
			/** 用来给执行语句中的?'问号'赋值 **/
			stmt.setObject(i + 1, params[i]);
		}
		affectedLine = stmt.executeUpdate(); // 执行语句
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
			 * 1. 使用connection的preparedStatement()方法生成preparedStatement对象 将不完整的sql作为入参传入
			 */
			statement = connection.prepareStatement(sql);
			/* 2. 对各个？赋值 */
			for (int i = 0; i < objs.length; i++) {
				statement.setObject(i + 1, objs[i]);
			}

			rs = statement.executeQuery();
			rsmd = rs.getMetaData();
			int columnNum = rsmd.getColumnCount();
			/*
			 * System.out.println("共读取了如下的字段："); for (int i=0;i<columnNum;i++) {
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
			// 3. 关掉preparedstatement
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
		/** 关闭结果集对象 **/
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/** 关闭stmt对象 **/
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/** 关闭connection连接对象 **/
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
