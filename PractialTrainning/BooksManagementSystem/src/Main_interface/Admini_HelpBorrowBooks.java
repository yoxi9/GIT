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
		frame = new JFrame("���������߽���");
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

		JLabel jlb2 = new JLabel("������Ҫ������id��");
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
				/* �жϴ�id�Ƿ�Ϊ������id ���ǽ����߷���true */
				Admini_JudgeBorrow AJB = new Admini_JudgeBorrow();
				boolean a = AJB.Admini_JudgeBorrow(textField_1.getText());

				// �жϴ��������ĵ��鼮�����Ƿ񳬹�5�� С��5������true
				BorrowNumber5 BN5 = new BorrowNumber5();
				boolean b = BN5.BorrowNumber5(textField_1.getText());

				// �жϴ��������ĵ��鼮�Ƿ���δ�黹�� ��ʱ����false
				BorrowTimeOut bto = new BorrowTimeOut();
				boolean c = bto.BorrowTimeOut(textField_1.getText());// �жϴ��������ĵ��鼮�Ƿ���δ�黹��

				// �жϴ����Ƿ���Ĺ����� ���Ĺ�����true
				Borrow_SameBook SBS = new Borrow_SameBook();
				boolean d = SBS.Borrow_SameBook(Integer.parseInt(textField_2.getText()), textField_1.getText());

				// �жϴ����Ƿ�ԤԼ�� ԤԼ������true
				AppointmentSameBook ASB = new AppointmentSameBook();
				boolean f = ASB.AppointmentSameBook(Integer.parseInt(textField_2.getText()), textField_1.getText());

				// �ж�������Ƿ��д��� �������������Ϊ0����true
				AllBook_IfExist AIE = new AllBook_IfExist();
				boolean g = AIE.AllBook_IfExist(Integer.parseInt(textField_2.getText()));
				if (a) {// �ж��Ƿ�Ϊ������
					if (g) {// �ж�������Ƿ����� �������������Ϊ0����true
							// ԤԼ�ж�
						if (f) {
							JOptionPane.showMessageDialog(null, "��Ϊ���û���ԤԼ�������Խ��ĳɹ���", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
							new Appointment_DelTable(textField_1.getText(), Integer.parseInt(textField_2.getText()));

						} else {
							JOptionPane.showMessageDialog(null, "ͼ�����ʱû�д��飡", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {// �д���
						if (b) {// �ж����Ƿ���ĳ���5��
							if (c) {// �ж��Ƿ��г�ʱ��
								if (d) {// �ж��Ƿ���Ĺ�
									JOptionPane.showMessageDialog(null, "���û��Ѿ����Ĺ����飬�޷�������ͬ���鼮��", "��Ϣ��ʾ",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									if (f) {// �ж��Ƿ�ԤԼ��
										JOptionPane.showMessageDialog(null, "��Ϊ���û���ԤԼ�������Խ��ĳɹ���", "��Ϣ��ʾ",
												JOptionPane.INFORMATION_MESSAGE);
										new Appointment_DelTable(textField_1.getText(),
												Integer.parseInt(textField_2.getText()));
									} else {
										JOptionPane.showMessageDialog(null, "��ϲ��ɹ��������û����ģ�", "��Ϣ��ʾ",
												JOptionPane.INFORMATION_MESSAGE);
										new Borrow_AddMessage(textField_1.getText(),
												Integer.parseInt(textField_2.getText()));
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "���û����鼮��ʱδ���飬���Ȼ��飡", "��Ϣ��ʾ",
										JOptionPane.INFORMATION_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "���û��������Ѵ����ޣ��޷��ٽ��ģ�", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "��������ȷ���û�id��", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}

	
}
