package Main_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import CS.DAO.BorrowDao;
import CS.DAO.ReturnBooksDao;
import CS.DAOIMIO.BorrowDaoImio;
import CS.DAOIMIO.ReturnBooksDaoImio;
import CS.Object.Borrow;
import CS.Object.ReturnBooks;

public class Admini_HelpBorrowReturnBooks  {
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnRegister;

	public Admini_HelpBorrowReturnBooks() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("���������߻���");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "������Ϣ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 300, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("������������û�id��");
		jlb1.setBounds(94, 50, 220, 15);
		panel.add(jlb1);

		textField_1 = new JTextField(20);
		textField_1.setBounds(94, 80, 120, 22);
		textField_1.setColumns(10);
		panel.add(textField_1);

		JLabel jlb2 = new JLabel("������Ҫ�������id��");
		jlb2.setBounds(94, 110, 220, 15);
		panel.add(jlb2);

		textField_2 = new JTextField(20);
		textField_2.setBounds(94, 140, 120, 22);
		textField_2.setColumns(10);
		panel.add(textField_2);

		btnRegister = new JButton("����");
		btnRegister.setBounds(94, 210, 120, 22);
		panel.add(btnRegister);

		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/* 1.�����жϴ����Ƿ�Ϊ������ */

				/* 2.�ж��û�id��ͼ��id�Ƿ��ڽ��ı��� */
				String borrowusers = textField_1.getText();
				int bookid = Integer.parseInt(textField_2.getText());
				Borrow_SameBook SBS = new Borrow_SameBook();
				boolean a = SBS.Borrow_SameBook(bookid, borrowusers);

				Admini_JudgeBorrow AJB = new Admini_JudgeBorrow();
				boolean b = AJB.Admini_JudgeBorrow(textField_1.getText());
				if ("����".equals(e.getActionCommand())) {
					if (textField_1.getText().equals("") || textField_2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "�뽫��Ϣ��д������", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (b) {
							if (a) {
								Borrow borrow = new Borrow();
								borrow.setUserid(Integer.parseInt(textField_1.getText()));
								borrow.setBookid(Integer.parseInt(textField_2.getText()));
								BorrowDao dao = new BorrowDaoImio();
								dao.delete(borrow);
								JOptionPane.showMessageDialog(null, "��ϲ��ɹ������û�Ϊ��" + textField_1.getText() + "����",
										"��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

								Date date = new Date();
								DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
								String str1 = df1.format(date);

								ReturnBooks returnBooks = new ReturnBooks();
								returnBooks.setUserid(Integer.parseInt(textField_1.getText()));
								returnBooks.setBookid(Integer.parseInt(textField_2.getText()));
								returnBooks.setReturntime(str1);
								ReturnBooksDao dao1 = new ReturnBooksDaoImio();
								dao1.add(returnBooks);
							} else {
								JOptionPane.showMessageDialog(null, "���û�δ���Ĵ˱��飡", "��Ϣ��ʾ",
										JOptionPane.INFORMATION_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(null, "��������û�id����", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

						}
					}
				}

			}
		});

	}

	

}
