package Main_interface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Main_Administrator extends JFrame implements ActionListener {// 账号密码输入正确后→管理员主界面
	private JFrame frame;
	JMenuBar jmb = new JMenuBar();
	JMenu AdministratorManage = new JMenu("管理员用户管理");

	JMenu ReaderManagenew = new JMenu("读者信息管理");
	JMenu BooksManagenew = new JMenu("图书信息管理");
	JMenu BorrowManage = new JMenu("图书借阅管理");
	JMenu BorrowRecord = new JMenu("借还记录");
	JMenu LogManage = new JMenu("基础信息维护");

	JMenuItem LookAllAdminiMessage = new JMenuItem("查看所有管理员信息");
	JMenuItem LookAppointAdminiMessage = new JMenuItem("查看指定管理员信息");
	JMenuItem ChangeAppointAdmini = new JMenuItem("修改管理员信息");

	JMenuItem LookAllReaderMessage = new JMenuItem("查看所有借阅者信息");
	JMenuItem LookAppointReaderMessage = new JMenuItem("查看指定借阅者信息");
	JMenuItem DelAppointReader = new JMenuItem("删除指定借阅者信息");
	JMenuItem ChangeAppointReader = new JMenuItem("修改借阅者信息");

	JMenuItem LookAlBooksMessage = new JMenuItem("查看所有书籍信息");
	JMenuItem LookAppointBooksMessage = new JMenuItem("查看指定书籍信息");
	JMenuItem AddBooksMessage = new JMenuItem("添加指定书籍信息");
	JMenuItem DelAppointBooks = new JMenuItem("删除指定书籍信息");
	JMenuItem ChangeAppointBooks = new JMenuItem("修改书籍信息");

	JMenuItem BorrowBooks = new JMenuItem("借阅书籍");
	JMenuItem ReturnBooks = new JMenuItem("退还书籍");
	JMenuItem AppointmentBooks = new JMenuItem("预约图书");
	JMenuItem HelpBorrowReturnBooks = new JMenuItem("帮助借阅者还书");
	JMenuItem HelpBorrowBooks = new JMenuItem("帮助借阅者借书");

	JMenuItem LookAllBorrowRecord = new JMenuItem("查看所有还书记录");
	JMenuItem LookAppointRecord = new JMenuItem("查看指定用户还书记录");
	JMenuItem BookToUserRecord = new JMenuItem("查看指定书籍的借阅情况");
	JMenu BookKindRecord = new JMenu("查看各类书籍借阅情况");
	JMenuItem jingdian = new JMenuItem("经典著作");
	JMenuItem junshi = new JMenuItem("军事科学");
	JMenuItem lishi = new JMenuItem("历史");
	JMenuItem caijing = new JMenuItem("财经管理");
	JMenuItem jisuanji = new JMenuItem("计算机技术");

	
	JMenuItem consult = new JMenuItem("咨询平台");
	JMenuItem jMenuExit = new JMenuItem("退出");

	public Main_Administrator(String zhanghao) {
		initialize(zhanghao);
		frame.setVisible(true);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub

		frame = new JFrame("欢迎进入管理员界面");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		// frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		ImageIcon icon = new ImageIcon("D:\\guanliyuan.jpg");
		JLabel labpic = new JLabel(icon);
		Dimension dimension = new Dimension(800, 600);
		labpic.setPreferredSize(dimension);
		frame.add(labpic);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setJMenuBar(jmb);
		jmb.add(AdministratorManage);
		jmb.add(ReaderManagenew);
		jmb.add(BooksManagenew);
		jmb.add(BorrowManage);
		jmb.add(BorrowRecord);
		jmb.add(LogManage);

		AdministratorManage.add(LookAllAdminiMessage);
		AdministratorManage.add(LookAppointAdminiMessage);

		AdministratorManage.add(ChangeAppointAdmini);

		ReaderManagenew.add(LookAllReaderMessage);
		ReaderManagenew.add(LookAppointReaderMessage);
		ReaderManagenew.add(DelAppointReader);
		ReaderManagenew.add(ChangeAppointReader);

		BooksManagenew.add(LookAlBooksMessage);
		BooksManagenew.add(LookAppointBooksMessage);
		BooksManagenew.add(AddBooksMessage);
		BooksManagenew.add(DelAppointBooks);
		BooksManagenew.add(ChangeAppointBooks);

		BorrowManage.add(BorrowBooks);
		BorrowManage.add(ReturnBooks);
		BorrowManage.add(AppointmentBooks);
		BorrowManage.add(HelpBorrowReturnBooks);
		BorrowManage.add(HelpBorrowBooks);

		BorrowRecord.add(LookAllBorrowRecord);
		BorrowRecord.add(LookAppointRecord);
		BorrowRecord.add(BookToUserRecord);
		BorrowRecord.add(BookKindRecord);

		BookKindRecord.add(jingdian);
		BookKindRecord.add(junshi);
		BookKindRecord.add(jingdian);
		BookKindRecord.add(lishi);
		BookKindRecord.add(caijing);
		BookKindRecord.add(jisuanji);

		LogManage.add(consult);
		LogManage.addSeparator();
		LogManage.add(jMenuExit);

		// frame.add(jmb);
		frame.setJMenuBar(jmb);
		/*
		 * JScrollPane jScrollPane = new JScrollPane(); setContentPane(jScrollPane); //
		 * 滚动条
		 */
		this.pack();
		this.setLocationRelativeTo(null);

		LookAllAdminiMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAll();
				System.out.println("查看了所有信息管理员的");
			}
		});

		LookAppointAdminiMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAppoint();
				System.out.println("查看了指定信息管理员的");
			}
		});

		ChangeAppointAdmini.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/** 修改自己的信息 **/
				new Admini_ChangeAppoint();
				System.out.println("修改了指定的信息管理员的");
			}
		});

		LookAllReaderMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_LookAll();
				System.out.println("查看所有读者信息");
			}
		});
		LookAppointReaderMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_LookAppoint();
				System.out.println("查看指定读者信息");
			}
		});
		DelAppointReader.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_DelAppoint();
				System.out.println("删除指定读者信息");
			}
		});
		ChangeAppointReader.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_ChangeAppoint();
				System.out.println("修改了指定读者信息");
			}
		});
		LookAlBooksMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_LookAll();
				System.out.println("查看所有书籍");
			}
		});
		LookAppointBooksMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_LookAppoint();
				System.out.println("查看指定书籍");
			}
		});
		AddBooksMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_Add();
				System.out.println("添加书籍");
			}
		});
		DelAppointBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_DelAppoint();
				System.out.println("删除指定书籍");
			}
		});
		ChangeAppointBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_ChangeMessage();
				System.out.println("修改指定书籍");
			}
		});
		BorrowBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BorrowBook(zhanghao);
				System.out.println("借书");
			}
		});
		ReturnBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_ReturnBook(zhanghao);
				System.out.println("还书");
			}
		});
		AppointmentBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BorrowBook_AppointmentBooks(zhanghao);
				System.out.println("预约图书");
				// TODO Auto-generated method stub

			}
		});
		HelpBorrowReturnBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_HelpBorrowReturnBooks();
				System.out.println("帮助借阅者还书 ");
			}
		});
		HelpBorrowBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_HelpBorrowBooks();
				System.out.println("帮助借阅者借书 ");
			}
		});
		LookAllBorrowRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAllBorrowRecord();
				System.out.println("查看所有借书记录");
			}
		});
		LookAppointRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAppointUserRecord();
				System.out.println("查看指定用户还书记录");
			}
		});
		BookToUserRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAppointBookRecord();
				System.out.println("查看指定书籍的借阅情况");
			}
		});
		jingdian.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("经典著作");
				new Admini_LookjingdianRceord();
			}
		});
		junshi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("军事科学");
				new Admini_LookjunshiRecord();
			}
		});
		lishi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("历史");
				new Admini_LooklishiRecord();
			}
		});
		caijing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookcaijingRecord();
				System.out.println("财经");
			}
		});
		jisuanji.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookjisuanjiRecord();
				System.out.println("计算机技术");
			}
		});
		consult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "请联系客服详细咨询：17826012341！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		jMenuExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
