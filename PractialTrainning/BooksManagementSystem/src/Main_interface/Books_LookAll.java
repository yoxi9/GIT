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

public class Books_LookAll {// �鿴�����鼮��Ϣ

	public Books_LookAll() {
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("ͼ���ȫ���鼮��Ϣ");
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());

		Object[] columnNames = { "�鼮ID", "����", "�鼮������", "����", "����", "�۸�", "����", "���ʱ��" };
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		Object[][] rowData = new Object[30][8];

		try {
			statement = connection.createStatement();
			sql = "select bookid,bookname,provenance,author,booknumber,bookprice,booktype,entertime from books";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				int bookid = rs.getInt(1);
				String bookname = rs.getString(2);
				String provenance = rs.getString(3);
				String author = rs.getString(4);
				int booknumber = rs.getInt(5);
				Double bookprice = rs.getDouble(6);
				String booktype = rs.getString(7);
				String entertime = rs.getString(8);
				rowData[i][0] = bookid;
				rowData[i][1] = bookname;
				rowData[i][2] = provenance;
				rowData[i][3] = author;
				rowData[i][4] = booknumber;
				rowData[i][5] = bookprice;
				rowData[i][6] = booktype;
				rowData[i][7] = entertime;
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
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);

		jf.setContentPane(panel);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

	}
}
