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

public class Admini_HelpBorrowBooks {
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnRegister;

	public Admini_HelpBorrowBooks() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame("帮助借阅者借书");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "输入信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 300, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("请输入借阅者用户id：");
		jlb1.setBounds(94, 50, 220, 15);
		panel.add(jlb1);

		textField_1 = new JTextField(20);
		textField_1.setBounds(94, 80, 120, 22);
		textField_1.setColumns(10);
		panel.add(textField_1);

		JLabel jlb2 = new JLabel("请输入要借的书的id：");
		jlb2.setBounds(94, 110, 220, 15);
		panel.add(jlb2);

		textField_2 = new JTextField(20);
		textField_2.setBounds(94, 140, 120, 22);
		textField_2.setColumns(10);
		panel.add(textField_2);

		btnRegister = new JButton("借书");
		btnRegister.setBounds(94, 210, 120, 22);
		panel.add(btnRegister);

		btnRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/* 判断此id是否为借阅者id 若是借阅者返回true */
				Admini_JudgeBorrow AJB = new Admini_JudgeBorrow();
				boolean a = AJB.Admini_JudgeBorrow(textField_1.getText());

				// 判断此人所借阅的书籍总数是否超过5本 小于5本返回true
				BorrowNumber5 BN5 = new BorrowNumber5();
				boolean b = BN5.BorrowNumber5(textField_1.getText());

				// 判断此人所借阅的书籍是否有未归还的 超时返回false
				BorrowTimeOut bto = new BorrowTimeOut();
				boolean c = bto.BorrowTimeOut(textField_1.getText());// 判断此人所借阅的书籍是否有未归还的

				// 判断此人是否借阅过此书 借阅过返回true
				Borrow_SameBook SBS = new Borrow_SameBook();
				boolean d = SBS.Borrow_SameBook(Integer.parseInt(textField_2.getText()), textField_1.getText());

				// 判断此人是否预约过 预约过返回true
				AppointmentSameBook ASB = new AppointmentSameBook();
				boolean f = ASB.AppointmentSameBook(Integer.parseInt(textField_2.getText()), textField_1.getText());

				// 判断书库中是否还有此书 若此书在书库中为0返回true
				AllBook_IfExist AIE = new AllBook_IfExist();
				boolean g = AIE.AllBook_IfExist(Integer.parseInt(textField_2.getText()));
				if (a) {// 判断是否为借阅者
					if (g) {// 判断书库中是否还有书 若此书在书库中为0返回true
							// 预约判断
						if (f) {
							JOptionPane.showMessageDialog(null, "因为此用户有预约过，所以借阅成功！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
							new Appointment_DelTable(textField_1.getText(), Integer.parseInt(textField_2.getText()));

						} else {
							JOptionPane.showMessageDialog(null, "图书馆暂时没有此书！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {// 有此书
						if (b) {// 判断他是否借阅超过5本
							if (c) {// 判断是否有超时的
								if (d) {// 判断是否借阅过
									JOptionPane.showMessageDialog(null, "此用户已经借阅过此书，无法借阅相同的书籍！", "消息提示",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									if (f) {// 判断是否预约过
										JOptionPane.showMessageDialog(null, "因为此用户有预约过，所以借阅成功！", "消息提示",
												JOptionPane.INFORMATION_MESSAGE);
										new Appointment_DelTable(textField_1.getText(),
												Integer.parseInt(textField_2.getText()));
									} else {
										JOptionPane.showMessageDialog(null, "恭喜你成功帮助此用户借阅！", "消息提示",
												JOptionPane.INFORMATION_MESSAGE);
										new Borrow_AddMessage(textField_1.getText(),
												Integer.parseInt(textField_2.getText()));
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "此用户有书籍超时未还书，请先还书！", "消息提示",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "此用户借阅数已达上限，无法再借阅！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入正确的用户id！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	
}
