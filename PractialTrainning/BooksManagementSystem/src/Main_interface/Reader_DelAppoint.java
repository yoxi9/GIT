package Main_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import CS.DAO.UserDAO;
import CS.DAOIMIO.UserDaoImlo;
import CS.Object.User;

public class Reader_DelAppoint /*implements ActionListener*/ {
	private JFrame frame;
	private JTextField textField_1;
	private JButton btnRegister;

	public Reader_DelAppoint() {
		// TODO Auto-generated constructor stub
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("ɾ��ָ����������Ϣ");
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ɾ����Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 240, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("�����뽫ɾ���Ľ�����֤�ţ�");
		jlb1.setBounds(24, 30, 220, 15);
		panel.add(jlb1);

		textField_1 = new JTextField(20);
		textField_1.setBounds(30, 100, 120, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnRegister = new JButton("ɾ��");
		btnRegister.setBounds(30, 210, 120, 22);
	/*	btnRegister.addActionListener(this);*/
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Reader_ExistYes REY = new Reader_ExistYes();
				boolean a = REY.Reader_ExistYes(Integer.parseInt(textField_1.getText()));

				CancelAccountsBookNoReturn CABNR = new CancelAccountsBookNoReturn();
				boolean b = CABNR.CancelAccountsBookNoReturn(textField_1.getText());
				
				if (a) {
					if(b) {
						JOptionPane.showMessageDialog(null, "�û�"+textField_1.getText()+"���鼮δ�黹���޷�ɾ�����û���", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

					}else {
						String str1 = "�ѳɹ�ɾ��idΪ��" + textField_1.getText() + "�Ľ�����";
						JOptionPane.showMessageDialog(null, str1, "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					
						User user = new User();
						user.setBorrowid(Integer.parseInt(textField_1.getText()));
						user.setAdmin("������");
						UserDAO dao = new UserDaoImlo();
						dao.delete(user);
					}
					
				} else {
					String str1 = "δ���ҵ�idΪ��" + textField_1.getText() + "�Ľ����ߣ�ɾ��ʧ�ܣ�";
					JOptionPane.showMessageDialog(null, str1, "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
				
				/*User user = new User();
				user.setBorrowid(Integer.parseInt(textField_1.getText()));
				user.setAdmin("������");
				UserDAO dao = new UserDaoImlo();
				dao.delete(user);*/
			}
		});

	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("ɾ��".equals(e.getActionCommand())) {
			User user = new User();
			user.setBorrowid(Integer.parseInt(textField_1.getText()));
			user.setAdmin("������");
			UserDAO dao = new UserDaoImlo();
			dao.delete(user);
		}

	}*/
}
