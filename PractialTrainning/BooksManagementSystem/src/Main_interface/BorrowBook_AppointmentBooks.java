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

public class BorrowBook_AppointmentBooks extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;// 声明一个表格对象
	private DefaultTableModel tableModel;// 声明一个表格模型对象

	public BorrowBook_AppointmentBooks(String zhanghao) {
		initialize(zhanghao);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		setTitle("预约图书");
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
		final JButton appointmentbooks = new JButton("预约");
		appointmentbooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int[] selectedRows = table.getSelectedRows();
				for (int row = 0; row < selectedRows.length; row++) {
					Book fp1 = new Book();
					fp1.setBookid((int) rowData[selectedRows[row]][0]);

					AppointmentNumber3 AN3 = new AppointmentNumber3();
					boolean a = AN3.AppointmentNumber3(zhanghao);// 判断此人所预约的书籍是否超过3本

					/* 判断此人预约的书籍是否相同id 相同id只能预约一本 */
					AppointmentSameBook ASB = new AppointmentSameBook();
					boolean b = ASB.AppointmentSameBook((int) rowData[selectedRows[row]][0], zhanghao);
					/* 返回true则为预约了相同的书 返回false则为可以借阅 */

					/** 判断此人是否借阅过此本书 若借阅着那么无法预约 **/
					Borrow_SameBook SBS = new Borrow_SameBook();
					boolean c = SBS.Borrow_SameBook((int) rowData[selectedRows[row]][0], zhanghao);
					
					BorrowTimeOut bto = new BorrowTimeOut();
					boolean d = bto.BorrowTimeOut(zhanghao);// 判断此人所借阅的书籍是否有未归还的
				
					/*缓冲表是否存在*/
					BufferAppointmentSameBook BASB=new BufferAppointmentSameBook();
					boolean f=BASB.BufferAppointmentSameBook((int) rowData[selectedRows[row]][0], zhanghao);
					
					if ((int) rowData[selectedRows[row]][4] > 0) {
						if (a) {// 判断此人所预约的书籍是否超过3本
							if (!b) {/* 判断此人预约的书籍是否相同id 相同id只能预约一本 */
								if (c) {	/** 判断此人是否借阅过此本书 若借阅着那么无法预约 **/
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									JOptionPane.showMessageDialog(null, "您已借阅过此书，无法在预约此书", "消息提示",
											JOptionPane.INFORMATION_MESSAGE);

								} else {
									if(d) {// 判断此人所借阅的书籍是否有未归还的
										fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
										JOptionPane.showMessageDialog(null, "恭喜你成功预约此书！", "消息提示",
												JOptionPane.INFORMATION_MESSAGE);
										new Appointment_AddTable(zhanghao, (int) rowData[selectedRows[row]][0]);
										/* 将预约的书籍加入到预约表中 */
									}else {
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										JOptionPane.showMessageDialog(null, "您有书籍超出还书时间，请先还书！", "消息提示",
												JOptionPane.INFORMATION_MESSAGE);
									}
									
								}
							} else {
								fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								JOptionPane.showMessageDialog(null, "您已预约了此书，请尽快借阅！", "消息提示",
										JOptionPane.INFORMATION_MESSAGE);
							}

						} else {
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							JOptionPane.showMessageDialog(null, "您预约的书籍超过3本，无法再预约", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {//若书库中此书数量为0
						if(f) {
							JOptionPane.showMessageDialog(null, "您已经预约过此书了！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							JOptionPane.showMessageDialog(null, "图书馆中暂时没有此书，已预约此书！", "消息提示",
									JOptionPane.INFORMATION_MESSAGE);
							new BufferAppointment_AddTable(zhanghao, (int) rowData[selectedRows[row]][0]);
						}
						
						}

					BookDaoImio daoImio = new BookDaoImio();
					daoImio.update1(fp1); // 修改书籍的数量
					setVisible(false); // 进行借阅按钮后 即关闭当前窗口 刷新当前书籍页面
					new BorrowBook_AppointmentBooks(zhanghao);
				}
			}
		});
		panel.add(appointmentbooks);
		setVisible(true);
	}

}
