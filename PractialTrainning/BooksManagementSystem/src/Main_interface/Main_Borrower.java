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

public class Main_Borrower extends JFrame {// 账号密码输入正确后→借阅者界面
	private JFrame frame;
	JMenuBar jmb = new JMenuBar();
	JMenu UserMessage = new JMenu("用户信息管理");
	JMenu LogManage = new JMenu("基础信息维护");
	JMenu BooksManage = new JMenu("图书借阅管理");
	JMenu VipSystem = new JMenu("会员系统");
	JMenu ShopBook = new JMenu("购买书籍");

	JMenuItem LookMyselfMessage = new JMenuItem("查看个人信息");
	JMenuItem ChangeMyselfMessage = new JMenuItem("修改个人信息");
	JMenuItem DelMyselfMessage = new JMenuItem("注销账户");

	JMenuItem BorrowBooks = new JMenuItem("借阅书籍");
	JMenuItem ReturnBooks = new JMenuItem("退还书籍");
	JMenuItem AppointmentBooks = new JMenuItem("预约图书");

	JMenuItem AllShopOne = new JMenuItem("查看所有书籍后购买");

	JMenuItem RechargeVIP = new JMenuItem("充值会员");

	JMenuItem consult = new JMenuItem("咨询平台");
	JMenuItem jMenuExit = new JMenuItem("退出");

	public Main_Borrower(String zhanghao) {
		// TODO Auto-generated constructor stub
		initialize(zhanghao);
		frame.setVisible(true);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		frame = new JFrame("欢迎进入阅者界面");
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
		jmb.add(VipSystem); // 会员系统
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
				System.out.println("查看个人信息");
			}
		});

		ChangeMyselfMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_ChangeAppointMyself(zhanghao);
				System.out.println("修改个人信息");
			}
		});
		BorrowBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BorrowBook(zhanghao);
				System.out.println("借阅者借书");
			}
		});
		ReturnBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_ReturnBook(zhanghao);
				System.out.println("借阅者还书");
			}
		});
		AppointmentBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BorrowBook_AppointmentBooks(zhanghao);
				System.out.println("借阅者预约");
			}
		});
		DelMyselfMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("注销帐号");
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
				System.out.println("成功退出");
			}
		});
		consult.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "请联系客服详细咨询：17826012341！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		AllShopOne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Borrow_ShopBook(zhanghao);
				System.out.println("购买书籍");
			}
		});

		RechargeVIP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_RechargeVIP(zhanghao);
				System.out.println("成功成为会员");
			}
		});
	}
}
