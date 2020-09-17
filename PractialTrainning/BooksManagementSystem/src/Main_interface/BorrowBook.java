package Main_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import CS.DAO.DBUtils;
import CS.DAOIMIO.BookDaoImio;
import CS.Object.Book;

public class BorrowBook extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;// 声明一个表格对象
	private DefaultTableModel tableModel;// 声明一个表格模型对象

	public BorrowBook(String zhanghao) {
		initialize(zhanghao);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		setTitle("借阅图书");
		setBounds(400, 150, 600, 600);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		final JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		Object[] columnNames = { "书籍ID", "书名", "书籍出版社", "作者", "数量", "价格", "种类", "入库时间" };
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		Object[][] rowData = new Object[30][8];
		try {
			statement = connection.createStatement();
			sql = "select bookid,bookname,provenance,author,booknumber,bookprice,booktype,entertime from books";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				int bookid = rs.getInt(1);
				String bookname = rs.getString(2);
				String provenance = rs.getString(3);
				String author = rs.getString(4);
				int booknumber = rs.getInt(5);
				Double bookprice = rs.getDouble(6);
				String booktype = rs.getString(7);
				String entertime = rs.getString(8);
				rowData[i][0] = bookid;
				rowData[i][1] = bookname;
				rowData[i][2] = provenance;
				rowData[i][3] = author;
				rowData[i][4] = booknumber;
				rowData[i][5] = bookprice;
				rowData[i][6] = booktype;
				rowData[i][7] = entertime;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement, rs);
		}
		tableModel = new DefaultTableModel(rowData, columnNames);
		table = new JTable(tableModel);// 利用表格模型对象创建表格对象
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		final JButton borrowButton = new JButton("借阅");
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] selectedRows = table.getSelectedRows();
				for (int row = 0; row < selectedRows.length; row++) {
					Book fp1 = new Book();
					fp1.setBookid((int) rowData[selectedRows[row]][0]);
					BorrowNumber5 BN5 = new BorrowNumber5();
					boolean a = BN5.BorrowNumber5(zhanghao);// 判断此人所借阅的书籍总数是否超过5本
			

					BorrowTimeOut bto = new BorrowTimeOut();
					boolean b = bto.BorrowTimeOut(zhanghao);// 判断此人所借阅的书籍是否有未归还的
				

					/* 判断预约表中是否有此人的预约的书籍 如有预约所借阅书籍 删除预约表中的信息加入到借阅表中 */
					/* 判断此人是否预约过此书 */

					/** 这里判断有误 判断是预约表里面的 **/

					/*判断是否借阅相同的书*/
					Borrow_SameBook SBS = new Borrow_SameBook();
					boolean c = SBS.Borrow_SameBook((int) rowData[selectedRows[row]][0], zhanghao);

					// 判断是否预约
					AppointmentSameBook ASB = new AppointmentSameBook();
					boolean d = ASB.AppointmentSameBook((int) rowData[selectedRows[row]][0], zhanghao);
					//判断是否为会员
					VIP_Judge vipjudge = new VIP_Judge();
					boolean f = vipjudge.VIP_Judge(zhanghao);
					
					//会员判断是否超过8本
					BorrowNumber8 BN8 = new BorrowNumber8();
					boolean g = BN8.BorrowNumber8(zhanghao);// 判断此人所借阅的书籍总数是否超过5本
					/**/

					/* 判断此人所借书籍中是否和此次借阅的书本相同 相同的书每个人只能借一本 还书查ID删 否则一次性将相同id的书全给还了 */
					if ((int) rowData[selectedRows[row]][4] > 0) {            /** 判断书库中是否还有书 **/
						if (a) { /** 判断借阅数量是否大于5本 **/
							if (b) { /** 判断借阅者是否超出时间 **/
								if (c) {
									/** 判断借阅相同书 **/
									 JOptionPane.showMessageDialog(null, "您已借阅此书，无法借阅相同书籍！", "消息提示",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									if (d) {
										JOptionPane.showMessageDialog(null, "因为你有预约，所以您借阅成功！", "消息提示",
												JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
									} else {
										if(f) {
											fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
											JOptionPane.showMessageDialog(null, "恭喜你成功借阅此书,由于您是会员用户，所以已为您增长借阅时长！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
											new BorrowVIP_AddMessage(zhanghao, (int) rowData[selectedRows[row]][0]);
										}else {
											fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
											JOptionPane.showMessageDialog(null, "恭喜你成功借阅此书！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
											new Borrow_AddMessage(zhanghao, (int) rowData[selectedRows[row]][0]);
										}	
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "您有书籍超出还书时间，请先还书！", "消息提示",
										JOptionPane.INFORMATION_MESSAGE);
								fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							}
						} else {/**大于5本进入会员的各种判断***********************/
							if(f) { //判断为会员
								if(g) {//判断8本
									if(b) {//判断是否超时
										if(c) {//判断是否相同
											JOptionPane.showMessageDialog(null, "您已借阅此书，无法借阅相同书籍！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
											fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										}else {//判断预约
											if(d) {
												JOptionPane.showMessageDialog(null, "因为你有预约，所以您借阅成功！", "消息提示",
														JOptionPane.INFORMATION_MESSAGE);
												fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
												new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
											}else {
												fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
												JOptionPane.showMessageDialog(null, "恭喜你成功借阅此书,由于您是会员用户，所以已为您增加借书量和借阅时长！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
												new BorrowVIP_AddMessage(zhanghao, (int) rowData[selectedRows[row]][0]);
											}
										
										}
									}else {
										JOptionPane.showMessageDialog(null, "您有书籍超出还书时间，请先还书！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									}
									
								}else {
									JOptionPane.showMessageDialog(null, "你借阅的书籍本的数量已经达到会员借阅数量的极限！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								}
							
							}else {
								JOptionPane.showMessageDialog(null, "您借阅书籍的数量已经达到普通用户的极限，可以开通会员增大借阅量，借阅失败！", "消息提示",
										JOptionPane.INFORMATION_MESSAGE);
								fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							}
						/*	JOptionPane.showMessageDialog(null, "您借阅的书本数量大于5，无法借阅！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);*/

						}/*****大于5本进入会员的各种判断**********************************/
					} else /* if ((int) rowData[selectedRows[row]][4] == 0) */ {//书库中没有这本书了****************************
						if (d) {//预约了
							if(a) {//判断是否借阅大于5本
								if(b) {//判断是否有书籍超时未归还
									JOptionPane.showMessageDialog(null, "因为你有预约，所以您借阅成功！", "消息提示",
											JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
						
								}else {
									JOptionPane.showMessageDialog(null, "您有书籍超出还书时间，请先还书！", "消息提示",JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								}
								
							}else {//大于5本进入会员的判断
								if(f) {//是会员
									if(g) {//判断8本
										JOptionPane.showMessageDialog(null, "因为你有预约并且你是会员，所以您借阅成功！", "消息提示",
												JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
									}else {
										JOptionPane.showMessageDialog(null, "您借阅书籍的数量已经达到普通用户的极限，可以开通会员增大借阅量，借阅失败！", "消息提示",
												JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									}
								}else {
									JOptionPane.showMessageDialog(null, "您借阅书籍的数量已经达到普通用户的极限，可以开通会员增大借阅量，借阅失败！", "消息提示",
											JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								}
							
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "图书馆暂时没有此书！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
						}

					}
					// fp1.setBooknumber((int)rowData[selectedRows[row]][4]-1);
					BookDaoImio daoImio = new BookDaoImio();
					daoImio.update1(fp1); // 修改书籍的数量

					/*
					 * int bookid=0; bookid=Integer.parseInt(""+rowData[selectedRows[row]][0]);
					 */

					// new Borrow_AddMessage(zhanghao,(int)rowData[selectedRows[row]][0]);

					setVisible(false); // 进行借阅按钮后 即关闭当前窗口 刷新当前书籍页面
					new BorrowBook(zhanghao);
				}
			}
		});

		panel.add(borrowButton);
		setVisible(true);
	}

}
