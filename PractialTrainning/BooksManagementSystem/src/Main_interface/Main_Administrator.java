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

public class Main_Administrator extends JFrame implements ActionListener {// �˺�����������ȷ�������Ա������
	private JFrame frame;
	JMenuBar jmb = new JMenuBar();
	JMenu AdministratorManage = new JMenu("����Ա�û�����");

	JMenu ReaderManagenew = new JMenu("������Ϣ����");
	JMenu BooksManagenew = new JMenu("ͼ����Ϣ����");
	JMenu BorrowManage = new JMenu("ͼ����Ĺ���");
	JMenu BorrowRecord = new JMenu("�軹��¼");
	JMenu LogManage = new JMenu("������Ϣά��");

	JMenuItem LookAllAdminiMessage = new JMenuItem("�鿴���й���Ա��Ϣ");
	JMenuItem LookAppointAdminiMessage = new JMenuItem("�鿴ָ������Ա��Ϣ");
	JMenuItem ChangeAppointAdmini = new JMenuItem("�޸Ĺ���Ա��Ϣ");

	JMenuItem LookAllReaderMessage = new JMenuItem("�鿴���н�������Ϣ");
	JMenuItem LookAppointReaderMessage = new JMenuItem("�鿴ָ����������Ϣ");
	JMenuItem DelAppointReader = new JMenuItem("ɾ��ָ����������Ϣ");
	JMenuItem ChangeAppointReader = new JMenuItem("�޸Ľ�������Ϣ");

	JMenuItem LookAlBooksMessage = new JMenuItem("�鿴�����鼮��Ϣ");
	JMenuItem LookAppointBooksMessage = new JMenuItem("�鿴ָ���鼮��Ϣ");
	JMenuItem AddBooksMessage = new JMenuItem("���ָ���鼮��Ϣ");
	JMenuItem DelAppointBooks = new JMenuItem("ɾ��ָ���鼮��Ϣ");
	JMenuItem ChangeAppointBooks = new JMenuItem("�޸��鼮��Ϣ");

	JMenuItem BorrowBooks = new JMenuItem("�����鼮");
	JMenuItem ReturnBooks = new JMenuItem("�˻��鼮");
	JMenuItem AppointmentBooks = new JMenuItem("ԤԼͼ��");
	JMenuItem HelpBorrowReturnBooks = new JMenuItem("���������߻���");
	JMenuItem HelpBorrowBooks = new JMenuItem("���������߽���");

	JMenuItem LookAllBorrowRecord = new JMenuItem("�鿴���л����¼");
	JMenuItem LookAppointRecord = new JMenuItem("�鿴ָ���û������¼");
	JMenuItem BookToUserRecord = new JMenuItem("�鿴ָ���鼮�Ľ������");
	JMenu BookKindRecord = new JMenu("�鿴�����鼮�������");
	JMenuItem jingdian = new JMenuItem("��������");
	JMenuItem junshi = new JMenuItem("���¿�ѧ");
	JMenuItem lishi = new JMenuItem("��ʷ");
	JMenuItem caijing = new JMenuItem("�ƾ�����");
	JMenuItem jisuanji = new JMenuItem("���������");

	
	JMenuItem consult = new JMenuItem("��ѯƽ̨");
	JMenuItem jMenuExit = new JMenuItem("�˳�");

	public Main_Administrator(String zhanghao) {
		initialize(zhanghao);
		frame.setVisible(true);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub

		frame = new JFrame("��ӭ�������Ա����");
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
		 * ������
		 */
		this.pack();
		this.setLocationRelativeTo(null);

		LookAllAdminiMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAll();
				System.out.println("�鿴��������Ϣ����Ա��");
			}
		});

		LookAppointAdminiMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAppoint();
				System.out.println("�鿴��ָ����Ϣ����Ա��");
			}
		});

		ChangeAppointAdmini.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/** �޸��Լ�����Ϣ **/
				new Admini_ChangeAppoint();
				System.out.println("�޸���ָ������Ϣ����Ա��");
			}
		});

		LookAllReaderMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_LookAll();
				System.out.println("�鿴���ж�����Ϣ");
			}
		});
		LookAppointReaderMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_LookAppoint();
				System.out.println("�鿴ָ��������Ϣ");
			}
		});
		DelAppointReader.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_DelAppoint();
				System.out.println("ɾ��ָ��������Ϣ");
			}
		});
		ChangeAppointReader.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Reader_ChangeAppoint();
				System.out.println("�޸���ָ��������Ϣ");
			}
		});
		LookAlBooksMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_LookAll();
				System.out.println("�鿴�����鼮");
			}
		});
		LookAppointBooksMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_LookAppoint();
				System.out.println("�鿴ָ���鼮");
			}
		});
		AddBooksMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_Add();
				System.out.println("����鼮");
			}
		});
		DelAppointBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_DelAppoint();
				System.out.println("ɾ��ָ���鼮");
			}
		});
		ChangeAppointBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Books_ChangeMessage();
				System.out.println("�޸�ָ���鼮");
			}
		});
		BorrowBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BorrowBook(zhanghao);
				System.out.println("����");
			}
		});
		ReturnBooks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_ReturnBook(zhanghao);
				System.out.println("����");
			}
		});
		AppointmentBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BorrowBook_AppointmentBooks(zhanghao);
				System.out.println("ԤԼͼ��");
				// TODO Auto-generated method stub

			}
		});
		HelpBorrowReturnBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_HelpBorrowReturnBooks();
				System.out.println("���������߻��� ");
			}
		});
		HelpBorrowBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_HelpBorrowBooks();
				System.out.println("���������߽��� ");
			}
		});
		LookAllBorrowRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAllBorrowRecord();
				System.out.println("�鿴���н����¼");
			}
		});
		LookAppointRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAppointUserRecord();
				System.out.println("�鿴ָ���û������¼");
			}
		});
		BookToUserRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookAppointBookRecord();
				System.out.println("�鿴ָ���鼮�Ľ������");
			}
		});
		jingdian.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("��������");
				new Admini_LookjingdianRceord();
			}
		});
		junshi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���¿�ѧ");
				new Admini_LookjunshiRecord();
			}
		});
		lishi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ʷ");
				new Admini_LooklishiRecord();
			}
		});
		caijing.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookcaijingRecord();
				System.out.println("�ƾ�");
			}
		});
		jisuanji.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Admini_LookjisuanjiRecord();
				System.out.println("���������");
			}
		});
		consult.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "����ϵ�ͷ���ϸ��ѯ��17826012341��", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
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
