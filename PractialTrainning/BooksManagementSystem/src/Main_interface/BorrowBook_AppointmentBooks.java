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
	private JTable table;// ����һ��������
	private DefaultTableModel tableModel;// ����һ�����ģ�Ͷ���

	public BorrowBook_AppointmentBooks(String zhanghao) {
		initialize(zhanghao);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		setTitle("ԤԼͼ��");
		setBounds(400, 150, 600, 600);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		final JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		Object[] columnNames = { "�鼮ID", "����", "�鼮������", "����", "����", "�۸�", "����", "���ʱ��" };
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
		table = new JTable(tableModel);// ���ñ��ģ�Ͷ��󴴽�������
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		final JButton appointmentbooks = new JButton("ԤԼ");
		appointmentbooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int[] selectedRows = table.getSelectedRows();
				for (int row = 0; row < selectedRows.length; row++) {
					Book fp1 = new Book();
					fp1.setBookid((int) rowData[selectedRows[row]][0]);

					AppointmentNumber3 AN3 = new AppointmentNumber3();
					boolean a = AN3.AppointmentNumber3(zhanghao);// �жϴ�����ԤԼ���鼮�Ƿ񳬹�3��

					/* �жϴ���ԤԼ���鼮�Ƿ���ͬid ��ͬidֻ��ԤԼһ�� */
					AppointmentSameBook ASB = new AppointmentSameBook();
					boolean b = ASB.AppointmentSameBook((int) rowData[selectedRows[row]][0], zhanghao);
					/* ����true��ΪԤԼ����ͬ���� ����false��Ϊ���Խ��� */

					/** �жϴ����Ƿ���Ĺ��˱��� ����������ô�޷�ԤԼ **/
					Borrow_SameBook SBS = new Borrow_SameBook();
					boolean c = SBS.Borrow_SameBook((int) rowData[selectedRows[row]][0], zhanghao);
					
					BorrowTimeOut bto = new BorrowTimeOut();
					boolean d = bto.BorrowTimeOut(zhanghao);// �жϴ��������ĵ��鼮�Ƿ���δ�黹��
				
					/*������Ƿ����*/
					BufferAppointmentSameBook BASB=new BufferAppointmentSameBook();
					boolean f=BASB.BufferAppointmentSameBook((int) rowData[selectedRows[row]][0], zhanghao);
					
					if ((int) rowData[selectedRows[row]][4] > 0) {
						if (a) {// �жϴ�����ԤԼ���鼮�Ƿ񳬹�3��
							if (!b) {/* �жϴ���ԤԼ���鼮�Ƿ���ͬid ��ͬidֻ��ԤԼһ�� */
								if (c) {	/** �жϴ����Ƿ���Ĺ��˱��� ����������ô�޷�ԤԼ **/
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									JOptionPane.showMessageDialog(null, "���ѽ��Ĺ����飬�޷���ԤԼ����", "��Ϣ��ʾ",
											JOptionPane.INFORMATION_MESSAGE);

								} else {
									if(d) {// �жϴ��������ĵ��鼮�Ƿ���δ�黹��
										fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
										JOptionPane.showMessageDialog(null, "��ϲ��ɹ�ԤԼ���飡", "��Ϣ��ʾ",
												JOptionPane.INFORMATION_MESSAGE);
										new Appointment_AddTable(zhanghao, (int) rowData[selectedRows[row]][0]);
										/* ��ԤԼ���鼮���뵽ԤԼ���� */
									}else {
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										JOptionPane.showMessageDialog(null, "�����鼮��������ʱ�䣬���Ȼ��飡", "��Ϣ��ʾ",
												JOptionPane.INFORMATION_MESSAGE);
									}
									
								}
							} else {
								fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								JOptionPane.showMessageDialog(null, "����ԤԼ�˴��飬�뾡����ģ�", "��Ϣ��ʾ",
										JOptionPane.INFORMATION_MESSAGE);
							}

						} else {
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							JOptionPane.showMessageDialog(null, "��ԤԼ���鼮����3�����޷���ԤԼ", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {//������д�������Ϊ0
						if(f) {
							JOptionPane.showMessageDialog(null, "���Ѿ�ԤԼ�������ˣ�", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							JOptionPane.showMessageDialog(null, "ͼ�������ʱû�д��飬��ԤԼ���飡", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
							new BufferAppointment_AddTable(zhanghao, (int) rowData[selectedRows[row]][0]);
						}
						
						}

					BookDaoImio daoImio = new BookDaoImio();
					daoImio.update1(fp1); // �޸��鼮������
					setVisible(false); // ���н��İ�ť�� ���رյ�ǰ���� ˢ�µ�ǰ�鼮ҳ��
					new BorrowBook_AppointmentBooks(zhanghao);
				}
			}
		});
		panel.add(appointmentbooks);
		setVisible(true);
	}

}
