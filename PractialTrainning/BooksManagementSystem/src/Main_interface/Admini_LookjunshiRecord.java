package Main_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import CS.DAO.DBUtils;

public class Admini_LookjunshiRecord {

	public Admini_LookjunshiRecord() {
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("�鿴����Ϊ����Ľ��ļ�¼");
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		JPanel panel = new JPanel(new BorderLayout());
		Object[] columnNames = { "�û�id", "�û�����", "�鼮id", "����", "����ʱ��" };

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		Object[][] rowData = new Object[20][5];

		try {
			statement = connection.createStatement();
			sql = "select userid,bookid,returntime from returnbook";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				int userid = rs.getInt(1);
				int bookid = rs.getInt(2);
				String returntime = rs.getString(3);

				if (bookid > 0 && bookid < 1001) {
					rowData[i][0] = userid;
					rowData[i][2] = bookid;
					rowData[i][4] = returntime;
				}else {
					i--;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement, rs);
		}
		for (int i = 0; i < rowData.length; i++) {
			if (rowData[i][0] != null) {
				UseridGetUserName useridGetUserName = new UseridGetUserName();
				rowData[i][1] = useridGetUserName.UseridGetUserName(String.valueOf(rowData[i][0]));
			}
			if (rowData[i][2] != null) {
				BookidGetBookName bookidGetBookName = new BookidGetBookName();
				rowData[i][3] = bookidGetBookName.BookidGetBookName(String.valueOf(rowData[i][2]));
			}
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
