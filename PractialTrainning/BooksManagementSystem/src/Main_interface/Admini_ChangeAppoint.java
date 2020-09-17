package Main_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import CS.DAO.DBUtils;
import CS.DAOIMIO.UserDaoImlo;
import CS.Object.User;

public class Admini_ChangeAppoint {

	public Admini_ChangeAppoint() {
		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("修改管理员信息(直接在表格中修改)");
		jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

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

		DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
		JTable table = new JTable(tableModel);
		tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int firstRow = e.getFirstRow();
				int lastRow = e.getLastRow();

				int column = e.getColumn();
				int type = e.getType();

				if (type == TableModelEvent.UPDATE) {

					for (int row = firstRow; row <= lastRow; row++) {

						Object nameObj = tableModel.getValueAt(row, 1);
						Object sexObj = tableModel.getValueAt(row, 2);
						Object gradeObj = tableModel.getValueAt(row, 3);

						User user = new User();
						user.setBorrowid((int) rowData[row][0]);
						user.setName((String) nameObj);
						user.setSex((String) sexObj);
						user.setGrade((String) gradeObj);

						UserDaoImlo userdao = new UserDaoImlo();

						userdao.update(user);

					}
				}
			}
		});

		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		// 把 表格内容 添加到容器中心
		panel.add(table, BorderLayout.CENTER);

		jf.setContentPane(panel);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}

}
