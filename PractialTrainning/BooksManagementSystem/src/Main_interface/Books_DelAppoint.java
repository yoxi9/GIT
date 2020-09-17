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

import CS.DAO.BookDAO;
import CS.DAO.UserDAO;

import CS.DAOIMIO.BookDaoImio;
import CS.Object.Book;
import CS.Object.User;

public class Books_DelAppoint implements ActionListener {
	private JFrame frame;
	private JTextField textField_1;
	private JButton btnRegister;

	public Books_DelAppoint() {
		// TODO Auto-generated constructor stub
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("ɾ��ָ���鼮��Ϣ");
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ɾ����Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 240, 280);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("��������Ҫɾ�����鼮��(���鼮��)��");
		jlb1.setBounds(24, 30, 220, 15);
		panel.add(jlb1);

		textField_1 = new JTextField(20);
		textField_1.setBounds(30, 100, 120, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);

		btnRegister = new JButton("ɾ��");
		btnRegister.setBounds(30, 210, 120, 22);
		btnRegister.addActionListener(this);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				/* �Ȳ�ѯ�Ӽ��̻�ȡ�����Ƿ��������� ����������ɾ���ɹ��Ի��� ����������������������д��ڵ� */
				Books_ExistYes BSY = new Books_ExistYes();
				boolean a = BSY.Books_ExistYes(textField_1.getText());

				if (a) {
					String str1 = "�ѳɹ�ɾ��" + textField_1.getText();
					JOptionPane.showMessageDialog(null, str1, "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

				} else {
					String str1 = "δ��������ҵ�" + textField_1.getText() + "��ɾ��ʧ�ܣ�";
					JOptionPane.showMessageDialog(null, str1, "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("ɾ��".equals(e.getActionCommand())) {
			Book book = new Book();
			book.setBookname(textField_1.getText());
			BookDAO dao = new BookDaoImio();
			dao.delete(book);
		}

	}

}
