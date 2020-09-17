package Main_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import CS.DAO.DBUtils;

public class Admini_LookAll {// 查看所有管理员信息

	public Admini_LookAll() {

		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("全部管理员信息");
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel panel = new JPanel(new BorderLayout());

		Object[] columnNames = { "图书馆证件ID", "姓名", "性别", "班级", "权限" };

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;

		String quanxian = "管理员";
		Object[][] rowData = new Object[20][5];
		try {
			statement = connection.createStatement();
			sql = "select borrowid,name,sex,grade,admin from bookuser";
			rs = statement.executeQuery(sql);

			for (int i = 0; rs.next(); i++) {
				int borrowid = rs.getInt(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String grade = rs.getString(4);
				String admin = rs.getString(5);
				if (quanxian.equals(admin)) {
					rowData[i][0] = borrowid;
					rowData[i][1] = name;
					rowData[i][2] = sex;
					rowData[i][3] = grade;
					rowData[i][4] = admin;
				} else {
					i--;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement, rs);
		}

		JTable table = new JTable(rowData, columnNames);
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		panel.add(table, BorderLayout.CENTER);

		// 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
		table.setPreferredScrollableViewportSize(new Dimension(400, 300));

		// 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
		JScrollPane scrollPane = new JScrollPane(table);

		// 添加 滚动面板 到 内容面板
		panel.add(scrollPane);

		// 设置 内容面板 到 窗口

		jf.setContentPane(panel);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

	}
}
