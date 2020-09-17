package Main_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ChangePassword implements ActionListener {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JButton btnRegister;

	public ChangePassword() {
		initialize();
		frame.setVisible(true);

	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("������֤��Ϣ");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "������Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 300, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("����֤���ţ�");
		jlb1.setBounds(24, 30, 220, 15);
		panel.add(jlb1);
		JLabel jlb2 = new JLabel("������������");
		jlb2.setBounds(24, 55, 220, 15);
		panel.add(jlb2);
		JLabel jlb3 = new JLabel("�������ʺţ�");
		jlb3.setBounds(24, 80, 220, 15);
		panel.add(jlb3);

		JLabel jlb4 = new JLabel("ѡ���Ա�");
		jlb4.setBounds(24, 105, 220, 15);
		panel.add(jlb4);
		JLabel jlb5 = new JLabel("�����߰༶��");
		jlb5.setBounds(24, 130, 220, 15);
		panel.add(jlb5);
		JLabel jlb6 = new JLabel("ѡ��Ȩ�ޣ�");
		jlb6.setBounds(24, 155, 220, 15);
		panel.add(jlb6);

		textField = new JTextField(20);
		textField.setBounds(94, 27, 120, 22);
		textField.setColumns(10);
		panel.add(textField);

		textField_1 = new JTextField(20);
		textField_1.setColumns(10);
		textField_1.setBounds(94, 54, 120, 22);
		panel.add(textField_1);

		textField_2 = new JTextField(20);
		textField_2.setColumns(10);
		textField_2.setBounds(94, 79, 120, 22);
		panel.add(textField_2);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "��", "Ů" }));
		comboBox_2.setBounds(94, 104, 120, 22);
		panel.add(comboBox_2);

		textField_3 = new JTextField(20);
		textField_3.setColumns(10);
		textField_3.setBounds(94, 129, 120, 22);
		panel.add(textField_3);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "������", "����Ա" }));
		comboBox_1.setBounds(94, 154, 120, 22);
		panel.add(comboBox_1);

		btnRegister = new JButton("��֤��Ϣ");
		btnRegister.setBounds(94, 210, 120, 22);
		btnRegister.addActionListener(this);
		panel.add(btnRegister);

	}

	// ƥ����������������Ϣȫ����ȷ ����true
	/*
	 * ChangePasswordResults CPR=new ChangePasswordResults(); boolean a =
	 * CPR.ChangePasswordResults(textField.getText(),textField_1.getText(),
	 * textField_2.getText(),(String)comboBox_2.getSelectedItem(),textField_3.
	 * getText(),(String)comboBox_1.getSelectedItem());
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ChangePasswordResults CPR = new ChangePasswordResults();
		boolean a = CPR.ChangePasswordResults(textField.getText(), textField_1.getText(), textField_2.getText(),
				(String) comboBox_2.getSelectedItem(), textField_3.getText(), (String) comboBox_1.getSelectedItem());

		// TODO Auto-generated method stub
		if ("��֤��Ϣ".equals(e.getActionCommand())) {
			if (textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("")
					|| textField_3.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "�뽫��Ϣ��д������", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (a) {
					System.out.println("�����޸Ľ���");
				} else {
					JOptionPane.showMessageDialog(null, "���������Ϣ�����޷��޸����룡", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
