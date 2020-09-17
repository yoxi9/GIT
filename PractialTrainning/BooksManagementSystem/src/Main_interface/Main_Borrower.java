package Main_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main_Borrower extends JFrame {// �˺�����������ȷ��������߽���
	private JFrame frame;
	JMenuBar jmb = new JMenuBar();
	JMenu UserMessage = new JMenu("�û���Ϣ����");
	JMenu LogManage = new JMenu("������Ϣά��");
	JMenu BooksManage = new JMenu("ͼ����Ĺ���");
	JMenu VipSystem = new JMenu("��Աϵͳ");
	JMenu ShopBook = new JMenu("�����鼮");

	JMenuItem LookMyselfMessage = new JMenuItem("�鿴������Ϣ");
	JMenuItem ChangeMyselfMessage = new JMenuItem("�޸ĸ�����Ϣ");
	JMenuItem DelMyselfMessage = new JMenuItem("ע���˻�");

	JMenuItem BorrowBooks = new JMenuItem("�����鼮");
	JMenuItem ReturnBooks = new JMenuItem("�˻��鼮");
	JMenuItem AppointmentBooks = new JMenuItem("ԤԼͼ��");

	JMenuItem AllShopOne = new JMenuItem("�鿴�����鼮����");

	JMenuItem RechargeVIP = new JMenuItem("��ֵ��Ա");

	JMenuItem consult = new JMenuItem("��ѯƽ̨");
	JMenuItem jMenuExit = new JMenuItem("�˳�");

	public Main_Borrower(String zhanghao) {
		// TODO Auto-generated constructor stub
		initialize(zhanghao);
		frame.setVisible(true);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		frame = new JFrame("��ӭ�������߽���");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		ImageIcon icon = new ImageIcon("D:\\jieyuezhe.jpg");
		JLabel labpic = new JLabel(icon);
		Dimension dimension = new Dimension(800, 600);
		labpic.setPreferredSize(dimension);
		frame.add(labpic);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setJMenuBar(jmb);

		jmb.add(UserMessage);
		jmb.add(BooksManage);
		jmb.add(ShopBook);
		jmb.add(VipSystem); // ��Աϵͳ
		jmb.add(LogManage);

		ShopBook.add(AllShopOne);
		UserMessage.add(LookMyselfMessage);
		UserMessage.add(ChangeMyselfMessage);
		UserMessage.add(DelMyselfMessage);

		BooksManage.add(BorrowBooks);
		BooksManage.add(ReturnBooks);
		BooksManage.add(AppointmentBooks);

		VipSystem.add(RechargeVIP);

		LogManage.add(consult);
		LogManage.addSeparator();
		LogManage.add(jMenuExit);

		// frame.add(jmb);
		frame.setJMenuBar(jmb);
		this.pack();
		this.setLocationRelativeTo(null);

		LookMyselfMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_LookMySelf(zhanghao);
				System.out.println("�鿴������Ϣ");
			}
		});

		ChangeMyselfMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_ChangeAppointMyself(zhanghao);
				System.out.println("�޸ĸ�����Ϣ");
			}
		});
		BorrowBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BorrowBook(zhanghao);
				System.out.println("�����߽���");
			}
		});
		ReturnBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_ReturnBook(zhanghao);
				System.out.println("�����߻���");
			}
		});
		AppointmentBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BorrowBook_AppointmentBooks(zhanghao);
				System.out.println("������ԤԼ");
			}
		});
		DelMyselfMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ע���ʺ�");
				new Reader_LogOut(zhanghao);
				CancelAccountsBookNoReturn CABNR = new CancelAccountsBookNoReturn();
				boolean a = CABNR.CancelAccountsBookNoReturn(zhanghao);
				if (!a) {
					frame.dispose();
				}
			}
		});
		jMenuExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				System.out.println("�ɹ��˳�");
			}
		});
		consult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "����ϵ�ͷ���ϸ��ѯ��17826012341��", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		AllShopOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Borrow_ShopBook(zhanghao);
				System.out.println("�����鼮");
			}
		});

		RechargeVIP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_RechargeVIP(zhanghao);
				System.out.println("�ɹ���Ϊ��Ա");
			}
		});
	}
}
