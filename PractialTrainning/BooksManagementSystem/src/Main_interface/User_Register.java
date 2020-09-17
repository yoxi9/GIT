package Main_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;

import CS.DAO.UserDAO;
import CS.DAOIMIO.UserDaoImlo;
import CS.Object.User;

public class User_Register implements ActionListener {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	private JButton btnRegister;

	public User_Register() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("�û�ע��");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "�û�ע��", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 300, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("����֤���ţ�");
		jlb1.setBounds(24, 30, 85, 15);
		panel.add(jlb1);
		JLabel jlb2 = new JLabel("������������");
		jlb2.setBounds(24, 55, 85, 15);
		panel.add(jlb2);
		JLabel jlb3 = new JLabel("�������ʺţ�");
		jlb3.setBounds(24, 80, 85, 15);
		panel.add(jlb3);
		JLabel jlb4 = new JLabel("���������룺");
		jlb4.setBounds(24, 105, 85, 15);
		panel.add(jlb4);
		JLabel jlb5 = new JLabel("�������Ա�");
		jlb5.setBounds(24, 130, 85, 15);
		panel.add(jlb5);
		JLabel jlb6 = new JLabel("�����߰༶��");
		jlb6.setBounds(24, 155, 85, 15);
		panel.add(jlb6);
		JLabel jlb7 = new JLabel("������Ȩ�ޣ�");
		jlb7.setBounds(24, 180, 85, 15);
		panel.add(jlb7);

		/* ע�����Ա��Կ�ж� */
		JLabel jlb8 = new JLabel("ע�����Ա����д��Կ");
		jlb8.setBounds(90, 250, 200, 15);
		panel.add(jlb8);

		textField_6 = new JTextField(20);
		textField_6.setBounds(94, 280, 120, 22);
		panel.add(textField_6);
		textField_6.setColumns(10);

		textField = new JTextField(20);
		textField.setBounds(94, 27, 120, 22);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(20);
		textField_1.setColumns(10);
		textField_1.setBounds(94, 54, 120, 22);
		panel.add(textField_1);

		textField_2 = new JTextField(20);
		textField_2.setColumns(10);
		textField_2.setBounds(94, 79, 120, 22);
		panel.add(textField_2);

		textField_3 = new JPasswordField(20);
		textField_3.setColumns(10);
		textField_3.setBounds(94, 104, 120, 22);
		panel.add(textField_3);

		/*
		 * textField_4 = new JTextField(20); textField_4.setColumns(10);
		 * textField_4.setBounds(94, 129, 120, 22); panel.add(textField_4);
		 */
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "��", "Ů" }));
		comboBox_2.setBounds(94, 129, 120, 22);
		panel.add(comboBox_2);

		textField_5 = new JTextField(20);
		textField_5.setColumns(10);
		textField_5.setBounds(94, 154, 120, 22);
		panel.add(textField_5);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "������", "����Ա" }));
		comboBox_1.setBounds(94, 179, 120, 22);
		panel.add(comboBox_1);

		btnRegister = new JButton("ע���˺�");
		btnRegister.setBounds(94, 210, 120, 22);
		btnRegister.addActionListener(this);
		panel.add(btnRegister);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if ("ע���˺�".equals(e.getActionCommand())) {
			if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")
					|| textField_3.getText().equals("") || textField_5.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�뽫��Ϣ��д������", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if ("������".equals((String) comboBox_1.getSelectedItem())) {

					User user = new User();
					user.setBorrowid(Integer.parseInt(textField.getText()));
					user.setName(textField_1.getText());
					user.setUser(textField_2.getText());
					user.setPassword(textField_3.getText());
					user.setSex((String) comboBox_2.getSelectedItem());
					user.setGrade(textField_5.getText());
					user.setAdmin((String) comboBox_1.getSelectedItem());
					UserDAO dao = new UserDaoImlo();
					dao.add(user);

					JOptionPane.showMessageDialog(null, "��ϲ��ɹ�ע��Ϊ�����ߣ�", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

				} else if ("����Ա".equals((String) comboBox_1.getSelectedItem())
						&& "888888".equals(textField_6.getText())) {
					User user = new User();
					user.setBorrowid(Integer.parseInt(textField.getText()));
					user.setName(textField_1.getText());
					user.setUser(textField_2.getText());
					user.setPassword(textField_3.getText());
					user.setSex((String) comboBox_2.getSelectedItem());
					user.setGrade(textField_5.getText());
					user.setAdmin((String) comboBox_1.getSelectedItem());
					UserDAO dao = new UserDaoImlo();
					dao.add(user);

					JOptionPane.showMessageDialog(null, "��ϲ��ɹ�ע��Ϊ����Ա��", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "����Ա��Կ�������ע��ʧ�ܣ�", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

				}

			}

		}
	}
}
