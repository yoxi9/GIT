package Main_interface;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import CS.DAO.DBUtils;
import Main_interface.Admini_LookAppoint.Find;

public class Reader_LookMySelf {
	private JFrame frame;

	public Reader_LookMySelf(String zhanghao) {
		Find readermyself = new Find();

		readermyself.Find(zhanghao);
		frame.setVisible(true);

	}

	public class Find extends JFrame {
		public void Find(String id) {
			JFrame jf = new JFrame("已查询到个人信息");
			jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JPanel panel = new JPanel(new BorderLayout());
			Object[] columnNames = { "图书馆证件ID", "姓名", "性别", "班级", "权限" };
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			connection = DBUtils.getConnection();
			
			String sql = null;
			Object[][] rowData = new Object[1][5];
			int i = Integer.parseInt(id);
			try {
				statement = connection.createStatement();
				sql = "select borrowid,name,sex,grade,admin from bookuser";
				rs = statement.executeQuery(sql);
				while (rs.next()) {
					int borrowid = rs.getInt(1);
					String name = rs.getString(2);
					String sex = rs.getString(3);
					String grade = rs.getString(4);
					String admin = rs.getString(5);
					if (borrowid == i) {
						rowData[0][0] = borrowid;
						rowData[0][1] = name;
						rowData[0][2] = sex;
						rowData[0][3] = grade;
						rowData[0][4] = admin;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtils.closeResource(connection, statement, rs);
			}
			JTable table = new JTable(rowData, columnNames);
			panel.add(table.getTableHeader(), BorderLayout.NORTH);
			panel.add(table, BorderLayout.CENTER);
			jf.setContentPane(panel);
			jf.pack();
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);
		}
	}

}
