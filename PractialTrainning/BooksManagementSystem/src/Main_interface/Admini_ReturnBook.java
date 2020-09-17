package Main_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import CS.DAO.BufferAppointmentDao;
import CS.DAO.DBUtils;
import CS.DAO.ReturnBooksDao;
import CS.DAOIMIO.BookDaoImio;
import CS.DAOIMIO.BorrowDaoImio;
import CS.DAOIMIO.BufferAppointmentDaoImio;
import CS.DAOIMIO.ReturnBooksDaoImio;
import CS.Object.Book;
import CS.Object.Borrow;
import CS.Object.BufferAppointment;
import CS.Object.ReturnBooks;

public class Admini_ReturnBook  {
	private JFrame frame;
	private JTextField textField_1;
	private JButton btnRegister;

	public Admini_ReturnBook(String zhanghao) {
		initialize(zhanghao);
		frame.setVisible(true);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		frame = new JFrame("正在还书");
		frame.setBounds(100, 100, 350, 450);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "输入书籍id", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 300, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel jlb1 = new JLabel("请输入要还的书的id：");
		jlb1.setBounds(94, 50, 220, 15);
		panel.add(jlb1);

		textField_1 = new JTextField(20);
		textField_1.setBounds(94, 100, 120, 22);
		textField_1.setColumns(10);
		panel.add(textField_1);

		btnRegister = new JButton("还书");
		btnRegister.setBounds(94, 210, 120, 22);

		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {

			/* 查找输入的图书id是否在借阅表中存在 */
			/*
			 * int adusers=Integer.parseInt(textField_1.getText()); Borrow_SameBook SBS =
			 * new Borrow_SameBook(); boolean a = SBS.Borrow_SameBook(adusers, zhanghao);
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int adusers = Integer.parseInt(textField_1.getText()); //书籍id
				
				Borrow_SameBook SBS = new Borrow_SameBook();//判断是否借了这本书
				boolean a = SBS.Borrow_SameBook(adusers, zhanghao);
				
				BufferAppointment_SameBook BAS=new BufferAppointment_SameBook();
				boolean b=BAS.BufferAppointment_SameBook(adusers);
				//预约缓冲表存在 true
				
				if ("还书".equals(e.getActionCommand())) {
					if (textField_1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "请将信息填写完整！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (a) {
							if(b) {//判断此书是否在缓冲表
								Borrow borrow = new Borrow();
								borrow.setUserid(Integer.parseInt(zhanghao));
								borrow.setBookid(Integer.parseInt(textField_1.getText()));
								BorrowDao dao = new BorrowDaoImio();
								dao.delete(borrow);
								JOptionPane.showMessageDialog(null, "恭喜你还书成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
								/* 并将信息加入到还书表中 */
								Date date = new Date();
								DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
								String str1 = df1.format(date);

								ReturnBooks returnBooks = new ReturnBooks();
								returnBooks.setUserid(Integer.parseInt(zhanghao));
								returnBooks.setBookid(Integer.parseInt(textField_1.getText()));
								returnBooks.setReturntime(str1);

								ReturnBooksDao dao1 = new ReturnBooksDaoImio();
								dao1.add(returnBooks);
								/* 加入预约表*/
								String zhanghao1=null;
								Connection connection = null;
								Statement statement = null;
								ResultSet rs = null;
								connection = DBUtils.getConnection();
								String sql = null;
								try {
									statement = connection.createStatement();
									sql = "select userid,bookid from bufferappointment";
									rs = statement.executeQuery(sql);
									for (int i = 0; rs.next(); i++) {
										String userid = rs.getString(1);
										int bookid = rs.getInt(2);
										if (bookid==Integer.parseInt(textField_1.getText())) {
											zhanghao1=userid;
										} else {
											i--;
										}
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}finally {
									DBUtils.closeResource(connection, statement, rs);
								}
								new Appointment_AddTable(zhanghao1, adusers);
								
								/*删除缓冲表 */
								BufferAppointment bufferAppointment=new BufferAppointment();
								bufferAppointment.setBookid(Integer.parseInt(textField_1.getText()));
								BufferAppointmentDao dao2=new BufferAppointmentDaoImio();
								dao2.delete(bufferAppointment);
								
								
								
							}else {
								Borrow borrow = new Borrow();
								borrow.setUserid(Integer.parseInt(zhanghao));
								borrow.setBookid(Integer.parseInt(textField_1.getText()));
								BorrowDao dao = new BorrowDaoImio();
								dao.delete(borrow);
								JOptionPane.showMessageDialog(null, "恭喜你还书成功！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
								/* 并将信息加入到还书表中 */
								Date date = new Date();
								DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
								String str1 = df1.format(date);

								ReturnBooks returnBooks = new ReturnBooks();
								returnBooks.setUserid(Integer.parseInt(zhanghao));
								returnBooks.setBookid(Integer.parseInt(textField_1.getText()));
								returnBooks.setReturntime(str1);

								ReturnBooksDao dao1 = new ReturnBooksDaoImio();
								dao1.add(returnBooks);
								
								
								int number=0;
								Connection connection = null;
								Statement statement = null;
								ResultSet rs = null;
								connection = DBUtils.getConnection();
								String sql = null;
								try {
									statement = connection.createStatement();
									sql = "select bookid,booknumber from books";
									rs = statement.executeQuery(sql);
									for (int i = 0; rs.next(); i++) {
										int bookid = rs.getInt(1);
										int booknumber = rs.getInt(2);
										if (bookid==Integer.parseInt(textField_1.getText())) {
											number=booknumber+1;
										} else {
											i--;
										}
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}finally {
									DBUtils.closeResource(connection, statement, rs);
								}
									
								Book book=new  Book();
								book.setBookid(Integer.parseInt(textField_1.getText()));
								book.setBooknumber(number);
								
								BookDaoImio bookdao=new BookDaoImio();
								bookdao.update1(book);
							}
							
							

						} else {
							JOptionPane.showMessageDialog(null, "您未借阅此书，还书失败！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			}
		});

	}

}
