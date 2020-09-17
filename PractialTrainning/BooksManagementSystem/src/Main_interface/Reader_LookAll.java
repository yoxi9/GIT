package Main_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import CS.DAO.DBUtils;

public class Reader_LookAll {

	public Reader_LookAll() {
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("ȫ����������Ϣ");
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
		Object[] columnNames = { "ͼ���֤��ID", "����", "�Ա�", "�༶", "Ȩ��" };

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;

		String quanxian = "������";
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

		table.setPreferredScrollableViewportSize(new Dimension(400, 300));

		// �� ��� �ŵ� ������� �У���ͷ���Զ���ӵ�������嶥����
		JScrollPane scrollPane = new JScrollPane(table);

		// ��� ������� �� �������
		panel.add(scrollPane);

		// ���� ������� �� ����

		jf.setContentPane(panel);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
}
