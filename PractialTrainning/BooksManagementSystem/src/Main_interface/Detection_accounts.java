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

public class Detection_accounts { // ����¼�˺������Ƿ���ȷ

	public int Detection_accounts(String zhanghao, String mima, Boolean jieyuezhe, Boolean guanliyuan) {
		// TODO Auto-generated method stub

		String zh = zhanghao;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		// 1. �õ����ݿ�����
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
			while (rs.next()) {// ʹ��next()ָ��ĳ��¼
				int borrowid = rs.getInt(1);
				String name = rs.getString(2);
				String user = rs.getString(3);
				String password = rs.getString(4);
				String sex = rs.getString(5);
				String grade = rs.getString(6);
				String admin = rs.getString(7);
				if (zhanghao.equals(user)) {
					if (mima.equals(password)) {

						if (jieyuezhe && "������".equals(admin)) {
							new Main_Borrower(zhanghao);
							System.out.println("�ǽ�����");
						} else if (jieyuezhe && "����Ա".equals(admin)) {
							JOptionPane.showMessageDialog(null, "�ʺ�����Ȩ����Ϣ����!��������ȷ���ʺ�����!ѡ����ȷ��Ȩ�ޣ�", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						} else if (guanliyuan && "����Ա".equals(admin)) {
							new Main_Administrator(zhanghao);
							System.out.println("�ǹ�����");
						} else {
							JOptionPane.showMessageDialog(null, "�ʺ�����Ȩ����Ϣ����!��������ȷ���ʺ�����!ѡ����ȷ��Ȩ�ޣ�", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "�ʺ�����Ȩ����Ϣ����!��������ȷ���ʺ�����!ѡ����ȷ��Ȩ�ޣ�", "��Ϣ��ʾ",
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
			JOptionPane.showMessageDialog(null, "�ʺ�����Ȩ����Ϣ����!��������ȷ���ʺ�����!ѡ����ȷ��Ȩ�ޣ�", "��Ϣ��ʾ",
					JOptionPane.INFORMATION_MESSAGE);

			System.out.println("�ʺŴ���");
		}

		return 0;
	}

	public static void testGetConnection() {
		Driver driver = null;
		try {
			// 1. ֱ������һ����������Ķ���ʵ��
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
			// 2. ���ö����connect�������������ݿ⣬��ȻҪ�������ݿ��url���Լ��û�����������Ϣ
			connection = driver.connect(url, info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(connection);

		if (connection != null) {
			try {
				// 3. �ر����ݿ�����
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
		// 1. ���������������
		try {
			// 1. �������������ൽ�������С�Class.forName(����)
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. DriverManagerֱ�ӿ���ʹ�ü��ع������������õ����ݿ�����
		try {
			// 2. ����DriverManager��getConnection�������õ���Ӧurl��ε����ݿ�����
			connection = DriverManager.getConnection(url, "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(connection);

		if (connection != null) {
			try {
				// 3. ʹ�����connection����Ҫ����close�����ر�����*
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
