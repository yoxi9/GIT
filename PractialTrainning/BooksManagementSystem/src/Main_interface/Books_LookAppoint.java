package Main_interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import CS.DAO.DBUtils;
import Main_interface.Admini_LookAppoint.Find;

public class Books_LookAppoint implements ActionListener {
	private JTextField textField_1;
	private JFrame frame;
	private JButton btnRegister;
	private JTextField textField;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public Books_LookAppoint() {
		initialize();
		frame.setVisible(true);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("查询指定图书信息");
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "查询信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 240, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("请输入书名(加书名号)：");
		jlb1.setBounds(24, 30, 200, 15);
		panel.add(jlb1);

		textField = new JTextField(20);
		textField.setBounds(30, 100, 120, 22);
		panel.add(textField);
		textField.setColumns(10);

		btnRegister = new JButton("查询");
		btnRegister.setBounds(30, 210, 120, 22);
		btnRegister.addActionListener(this);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Find Adminifind = new Find();
				Adminifind.Find(textField.getText());

			}
		});

	}

	public class Find extends JFrame {

		// TODO Auto-generated method stub
		public void Find(String name1) {
			JFrame jf = new JFrame("已查询到该书籍信息");
			jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JPanel panel = new JPanel(new BorderLayout());
			Object[] columnNames = { "书籍ID", "书名", "书籍出版社", "作者", "数量", "价格", "种类", "入库时间" };
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			connection = DBUtils.getConnection();

			String sql = null;
			Object[][] rowData = new Object[10][8];
			// int i = Integer.parseInt(id);
			// System.out.println(i);
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
					if (name1.equals(bookname)) {
						rowData[i][0] = bookid;
						rowData[i][1] = bookname;
						rowData[i][2] = provenance;
						rowData[i][3] = author;
						rowData[i][4] = booknumber;
						rowData[i][5] = bookprice;
						rowData[i][6] = booktype;
						rowData[i][7] = entertime;
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

			jf.setContentPane(panel);
			jf.pack();
			jf.setLocationRelativeTo(null);
			jf.setVisible(true);

		}
	}

}
