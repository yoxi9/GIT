package Main_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.accessibility.AccessibleContext;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;
import com.sun.jdi.connect.Connector.BooleanArgument;

import CS.DAO.DBUtils;

public class Detection_accounts { // 检测登录账号密码是否正确

	public int Detection_accounts(String zhanghao, String mima, Boolean jieyuezhe, Boolean guanliyuan) {
		// TODO Auto-generated method stub

		String zh = zhanghao;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		// 1. 得到数据库连接
		connection = DBUtils.getConnection();
		String sql = null;
		int j = 0, k = 0;
		try {
			statement = connection.createStatement();
			sql = "select borrowid,name,user,password,sex,grade,admin from bookuser";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				j++;
			}
			rs.beforeFirst();
			while (rs.next()) {// 使用next()指向某记录
				int borrowid = rs.getInt(1);
				String name = rs.getString(2);
				String user = rs.getString(3);
				String password = rs.getString(4);
				String sex = rs.getString(5);
				String grade = rs.getString(6);
				String admin = rs.getString(7);
				if (zhanghao.equals(user)) {
					if (mima.equals(password)) {

						if (jieyuezhe && "借阅者".equals(admin)) {
							new Main_Borrower(zhanghao);
							System.out.println("是借阅者");
						} else if (jieyuezhe && "管理员".equals(admin)) {
							JOptionPane.showMessageDialog(null, "帐号密码权限信息错误!请输入正确的帐号密码!选择正确的权限！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
						} else if (guanliyuan && "管理员".equals(admin)) {
							new Main_Administrator(zhanghao);
							System.out.println("是管理者");
						} else {
							JOptionPane.showMessageDialog(null, "帐号密码权限信息错误!请输入正确的帐号密码!选择正确的权限！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "帐号密码权限信息错误!请输入正确的帐号密码!选择正确的权限！", "消息提示",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					k++;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement, rs);
		}
		if (k >= j) {
			JOptionPane.showMessageDialog(null, "帐号密码权限信息错误!请输入正确的帐号密码!选择正确的权限！", "消息提示",
					JOptionPane.INFORMATION_MESSAGE);

			System.out.println("帐号错误");
		}

		return 0;
	}

	public static void testGetConnection() {
		Driver driver = null;
		try {
			// 1. 直接生成一个驱动程序的对象实例
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
			// 2. 调用对象的connect方法来连接数据库，当然要给出数据库的url，以及用户名和密码信息
			connection = driver.connect(url, info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(connection);

		if (connection != null) {
			try {
				// 3. 关闭数据库连接
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void testDriverManager() {
		String url = "jdbc:mysql://localhost:3306/myjavadb3";

		Connection connection = null;
		// 1. 加载驱动程序的类
		try {
			// 1. 加载驱动程序类到缓冲区中。Class.forName(类名)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. DriverManager直接可以使用加载过的驱动类来得到数据库连接
		try {
			// 2. 调用DriverManager的getConnection方法，得到对应url入参的数据库连接
			connection = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(connection);

		if (connection != null) {
			try {
				// 3. 使用完后，connection对象要调用close方法关闭连接*
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
