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
import Main_interface.Admini_LookAppointUserRecord.Find;

public class Admini_LookAppointBookRecord {
	private JTextField textField_1;
	private JFrame frame;
	private JButton btnRegister;
	private JTextField textField;
	public Admini_LookAppointBookRecord() {
		initialize();
		frame.setVisible(true);

	}
	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("��ѯָ���鼮�Ľ��������Ϣ");
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "��ѯ��Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 240, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel jlb1 = new JLabel("�������鼮ID��");
		jlb1.setBounds(24, 30, 200, 15);
		panel.add(jlb1);
		
		textField = new JTextField(20);
		textField.setBounds(30, 100, 120, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		btnRegister = new JButton("��ѯ");
		btnRegister.setBounds(30, 210, 120, 22);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Find lookappuser = new Find();
				lookappuser.Find(textField.getText());

			}
		});
	}
	public class Find extends JFrame {
		public void Find(String id) {
			JFrame jf = new JFrame("�鿴ָ���û��Ľ��������Ϣ");
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
					if(bookid==Integer.parseInt(id)) {
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
			}finally {
				DBUtils.closeResource(connection, statement, rs);
			}
			
			for(int i=0;i<rowData.length;i++) {
				if(rowData[i][0]!=null) {
					UseridGetUserName useridGetUserName=new UseridGetUserName();
			        rowData[i][1]=useridGetUserName.UseridGetUserName(String.valueOf(rowData[i][0]));
				}
				if (rowData[i][2]!=null) {
					BookidGetBookName bookidGetBookName=new BookidGetBookName();
			        rowData[i][3]=bookidGetBookName.BookidGetBookName(String.valueOf(rowData[i][2]));
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
}
