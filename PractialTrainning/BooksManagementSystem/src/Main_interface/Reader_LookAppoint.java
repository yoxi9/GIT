package Main_interface;

import java.awt.BorderLayout;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import CS.DAO.DBUtils;
import Main_interface.Admini_LookAppoint.Find;

public class Reader_LookAppoint implements ActionListener {
	private JTextField textField_1;
	private JFrame frame;
	private JButton btnRegister;
	private JTextField textField;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public Reader_LookAppoint() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("查询指定借阅者信息");
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "查询信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 240, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("请输入借阅证id：");
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
		public void Find(String id) {
			JFrame jf = new JFrame("已查询到该借阅者信息");
			jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JPanel panel = new JPanel(new BorderLayout());
			Object[] columnNames = { "借阅证id", "姓名", "性别", "班级", "权限" };
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			connection = DBUtils.getConnection();

			String sql = null;
			Object[][] rowData = new Object[1][5];
			int i = Integer.parseInt(id);
			System.out.println(i);
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
