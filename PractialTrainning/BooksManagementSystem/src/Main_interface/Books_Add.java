package Main_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import CS.DAO.BookDAO;
import CS.DAOIMIO.BookDaoImio;
import CS.Object.Book;

public class Books_Add implements ActionListener {
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox comboBox_1;
	private JButton btnRegister;

	public Books_Add() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("添加书籍");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "添加书籍信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 300, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("书   籍  I  D：");
		jlb1.setBounds(24, 30, 85, 15);
		panel.add(jlb1);
		JLabel jlb2 = new JLabel("书            名：");
		jlb2.setBounds(24, 55, 85, 15);
		panel.add(jlb2);
		JLabel jlb3 = new JLabel("书籍出版社：");
		jlb3.setBounds(24, 80, 85, 15);
		panel.add(jlb3);
		JLabel jlb4 = new JLabel("作           者：");
		jlb4.setBounds(24, 105, 85, 15);
		panel.add(jlb4);
		JLabel jlb5 = new JLabel("数           量：");
		jlb5.setBounds(24, 130, 85, 15);
		panel.add(jlb5);
		JLabel jlb6 = new JLabel("价           格：");
		jlb6.setBounds(24, 155, 85, 15);
		panel.add(jlb6);
		JLabel jlb7 = new JLabel("种           类：");
		jlb7.setBounds(24, 180, 85, 15);
		panel.add(jlb7);
		JLabel jlb8 = new JLabel("入 库 时 间：");
		jlb8.setBounds(24, 205, 85, 15);
		panel.add(jlb8);

		textField_1 = new JTextField(20);
		textField_1.setBounds(94, 27, 120, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField(20);
		textField_2.setColumns(10);
		textField_2.setBounds(94, 54, 120, 22);
		panel.add(textField_2);

		textField_3 = new JTextField(20);
		textField_3.setColumns(10);
		textField_3.setBounds(94, 79, 120, 22);
		panel.add(textField_3);

		textField_4 = new JTextField(20);
		textField_4.setColumns(10);
		textField_4.setBounds(94, 104, 120, 22);
		panel.add(textField_4);

		textField_5 = new JTextField(20);
		textField_5.setColumns(10);
		textField_5.setBounds(94, 129, 120, 22);
		panel.add(textField_5);

		textField_6 = new JTextField(20);
		textField_6.setColumns(10);
		textField_6.setBounds(94, 154, 120, 22);
		panel.add(textField_6);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "经典著作", "军事科学", "历史", "财经管理", "计算机技术" }));
		comboBox_1.setBounds(94, 179, 120, 22);
		panel.add(comboBox_1);

		textField_8 = new JTextField(20);
		textField_8.setEnabled(false);
		textField_8.setHorizontalAlignment(SwingConstants.LEFT);
		textField_8.setColumns(10);
		textField_8.setBounds(94, 204, 120, 22);
		panel.add(textField_8);
		String date = new Date().toString();
		textField_8.setText(date);
		/*
		 * textField_8 = new JTextField(20); textField_8.setColumns(10);
		 * textField_8.setBounds(94, 204, 120, 22); panel.add(textField_8);
		 */

		btnRegister = new JButton("添加");
		btnRegister.setBounds(94, 230, 120, 22);
		btnRegister.addActionListener(this);
		panel.add(btnRegister);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("添加".equals(e.getActionCommand())) {
			if (textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("")
					|| textField_4.getText().equals("") || textField_5.getText().equals("")
					|| textField_6.getText().equals("") || textField_8.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "书籍添加成功", "消息提示", JOptionPane.INFORMATION_MESSAGE);

				Date date1 = new Date();
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
				String str1 = df1.format(date1);
				System.out.println(str1);
				Book book = new Book();
				book.setBookid(Integer.parseInt(textField_1.getText()));
				book.setBookname(textField_2.getText());
				book.setProvenance(textField_3.getText());
				book.setAuthor(textField_4.getText());
				book.setBooknumber(Integer.parseInt(textField_5.getText()));
				book.setBookprice(Double.parseDouble(textField_6.getText()));
				book.setBooktype((String) comboBox_1.getSelectedItem());
				book.setEntertime(str1);

				BookDAO dao = new BookDaoImio();
				dao.add(book);
			}
		}
	}
}
