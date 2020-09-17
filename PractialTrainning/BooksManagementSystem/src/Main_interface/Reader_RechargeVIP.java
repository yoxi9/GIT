package Main_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Reader_RechargeVIP {
	private JFrame frame;
	private JTextField textField_8;
	private JButton btnRegister;

	public Reader_RechargeVIP(String zhanghao) {
		initialize(zhanghao);
		frame.setVisible(true);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		frame = new JFrame("ע���Ա");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "�û���֪", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 300, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("ע���Ա��ͨһ����");
		jlb1.setBounds(24, 30, 200, 15);
		panel.add(jlb1);
		JLabel jlb2 = new JLabel("��ͨ��");
		jlb2.setBounds(24, 55, 200, 15);
		panel.add(jlb2);
		JLabel jlb3 = new JLabel("��������ʱ��");
		jlb3.setBounds(24, 80, 200, 15);
		panel.add(jlb3);
		JLabel jlb4 = new JLabel("���������鱾��");
		jlb4.setBounds(24, 105, 200, 15);
		panel.add(jlb4);
		JLabel jlb5 = new JLabel("�����鼮���ܴ����Ż�");
		jlb5.setBounds(24, 130, 200, 15);
		panel.add(jlb5);
		JLabel jlb6 = new JLabel("��ͨʱ��Ϊ��");
		jlb6.setBounds(24, 155, 85, 15);
		panel.add(jlb6);

		textField_8 = new JTextField(20);
		textField_8.setEnabled(false);
		textField_8.setHorizontalAlignment(SwingConstants.LEFT);
		textField_8.setColumns(10);
		textField_8.setBounds(94, 154, 180, 22);
		panel.add(textField_8);
		String date = new Date().toString();
		textField_8.setText(date);

		JLabel jlb7 = new JLabel("�Ƿ�ȷ�Ͽ�ͨ��");
		jlb7.setBounds(24, 250, 200, 15);
		panel.add(jlb7);
		btnRegister = new JButton("��ͨ");
		btnRegister.setBounds(94, 280, 120, 22);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "��������10Ԫ�ɹ�Ϊ�û���" + zhanghao + "��ֵΪ��Ա", "��Ϣ��ʾ",
						JOptionPane.INFORMATION_MESSAGE);
				new VIP_Date(zhanghao);
			}
		});

	}

}
