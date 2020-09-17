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
	private JTable table;// ����һ��������
	private DefaultTableModel tableModel;// ����һ�����ģ�Ͷ���

	public BorrowBook(String zhanghao) {
		initialize(zhanghao);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		setTitle("����ͼ��");
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

		final JButton borrowButton = new JButton("����");
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int[] selectedRows = table.getSelectedRows();
				for (int row = 0; row < selectedRows.length; row++) {
					Book fp1 = new Book();
					fp1.setBookid((int) rowData[selectedRows[row]][0]);
					BorrowNumber5 BN5 = new BorrowNumber5();
					boolean a = BN5.BorrowNumber5(zhanghao);// �жϴ��������ĵ��鼮�����Ƿ񳬹�5��
			

					BorrowTimeOut bto = new BorrowTimeOut();
					boolean b = bto.BorrowTimeOut(zhanghao);// �жϴ��������ĵ��鼮�Ƿ���δ�黹��
				

					/* �ж�ԤԼ�����Ƿ��д��˵�ԤԼ���鼮 ����ԤԼ�������鼮 ɾ��ԤԼ���е���Ϣ���뵽���ı��� */
					/* �жϴ����Ƿ�ԤԼ������ */

					/** �����ж����� �ж���ԤԼ������� **/

					/*�ж��Ƿ������ͬ����*/
					Borrow_SameBook SBS = new Borrow_SameBook();
					boolean c = SBS.Borrow_SameBook((int) rowData[selectedRows[row]][0], zhanghao);

					// �ж��Ƿ�ԤԼ
					AppointmentSameBook ASB = new AppointmentSameBook();
					boolean d = ASB.AppointmentSameBook((int) rowData[selectedRows[row]][0], zhanghao);
					//�ж��Ƿ�Ϊ��Ա
					VIP_Judge vipjudge = new VIP_Judge();
					boolean f = vipjudge.VIP_Judge(zhanghao);
					
					//��Ա�ж��Ƿ񳬹�8��
					BorrowNumber8 BN8 = new BorrowNumber8();
					boolean g = BN8.BorrowNumber8(zhanghao);// �жϴ��������ĵ��鼮�����Ƿ񳬹�5��
					/**/

					/* �жϴ��������鼮���Ƿ�ʹ˴ν��ĵ��鱾��ͬ ��ͬ����ÿ����ֻ�ܽ�һ�� �����IDɾ ����һ���Խ���ͬid����ȫ������ */
					if ((int) rowData[selectedRows[row]][4] > 0) {            /** �ж�������Ƿ����� **/
						if (a) { /** �жϽ��������Ƿ����5�� **/
							if (b) { /** �жϽ������Ƿ񳬳�ʱ�� **/
								if (c) {
									/** �жϽ�����ͬ�� **/
									 JOptionPane.showMessageDialog(null, "���ѽ��Ĵ��飬�޷�������ͬ�鼮��", "��Ϣ��ʾ",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									if (d) {
										JOptionPane.showMessageDialog(null, "��Ϊ����ԤԼ�����������ĳɹ���", "��Ϣ��ʾ",
												JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
									} else {
										if(f) {
											fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
											JOptionPane.showMessageDialog(null, "��ϲ��ɹ����Ĵ���,�������ǻ�Ա�û���������Ϊ����������ʱ����", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
											new BorrowVIP_AddMessage(zhanghao, (int) rowData[selectedRows[row]][0]);
										}else {
											fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
											JOptionPane.showMessageDialog(null, "��ϲ��ɹ����Ĵ��飡", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
											new Borrow_AddMessage(zhanghao, (int) rowData[selectedRows[row]][0]);
										}	
									}
								}
							} else {
								JOptionPane.showMessageDialog(null, "�����鼮��������ʱ�䣬���Ȼ��飡", "��Ϣ��ʾ",
										JOptionPane.INFORMATION_MESSAGE);
								fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							}
						} else {/**����5�������Ա�ĸ����ж�***********************/
							if(f) { //�ж�Ϊ��Ա
								if(g) {//�ж�8��
									if(b) {//�ж��Ƿ�ʱ
										if(c) {//�ж��Ƿ���ͬ
											JOptionPane.showMessageDialog(null, "���ѽ��Ĵ��飬�޷�������ͬ�鼮��", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
											fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										}else {//�ж�ԤԼ
											if(d) {
												JOptionPane.showMessageDialog(null, "��Ϊ����ԤԼ�����������ĳɹ���", "��Ϣ��ʾ",
														JOptionPane.INFORMATION_MESSAGE);
												fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
												new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
											}else {
												fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
												JOptionPane.showMessageDialog(null, "��ϲ��ɹ����Ĵ���,�������ǻ�Ա�û���������Ϊ�����ӽ������ͽ���ʱ����", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
												new BorrowVIP_AddMessage(zhanghao, (int) rowData[selectedRows[row]][0]);
											}
										
										}
									}else {
										JOptionPane.showMessageDialog(null, "�����鼮��������ʱ�䣬���Ȼ��飡", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									}
									
								}else {
									JOptionPane.showMessageDialog(null, "����ĵ��鼮���������Ѿ��ﵽ��Ա���������ļ��ޣ�", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								}
							
							}else {
								JOptionPane.showMessageDialog(null, "�������鼮�������Ѿ��ﵽ��ͨ�û��ļ��ޣ����Կ�ͨ��Ա���������������ʧ�ܣ�", "��Ϣ��ʾ",
										JOptionPane.INFORMATION_MESSAGE);
								fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
							}
						/*	JOptionPane.showMessageDialog(null, "�����ĵ��鱾��������5���޷����ģ�", "��Ϣ��ʾ",
									JOptionPane.INFORMATION_MESSAGE);
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);*/

						}/*****����5�������Ա�ĸ����ж�**********************************/
					} else /* if ((int) rowData[selectedRows[row]][4] == 0) */ {//�����û���Ȿ����****************************
						if (d) {//ԤԼ��
							if(a) {//�ж��Ƿ���Ĵ���5��
								if(b) {//�ж��Ƿ����鼮��ʱδ�黹
									JOptionPane.showMessageDialog(null, "��Ϊ����ԤԼ�����������ĳɹ���", "��Ϣ��ʾ",
											JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
						
								}else {
									JOptionPane.showMessageDialog(null, "�����鼮��������ʱ�䣬���Ȼ��飡", "��Ϣ��ʾ",JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								}
								
							}else {//����5�������Ա���ж�
								if(f) {//�ǻ�Ա
									if(g) {//�ж�8��
										JOptionPane.showMessageDialog(null, "��Ϊ����ԤԼ�������ǻ�Ա�����������ĳɹ���", "��Ϣ��ʾ",
												JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
										new Appointment_DelTable(zhanghao, (int) rowData[selectedRows[row]][0]);
									}else {
										JOptionPane.showMessageDialog(null, "�������鼮�������Ѿ��ﵽ��ͨ�û��ļ��ޣ����Կ�ͨ��Ա���������������ʧ�ܣ�", "��Ϣ��ʾ",
												JOptionPane.INFORMATION_MESSAGE);
										fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
									}
								}else {
									JOptionPane.showMessageDialog(null, "�������鼮�������Ѿ��ﵽ��ͨ�û��ļ��ޣ����Կ�ͨ��Ա���������������ʧ�ܣ�", "��Ϣ��ʾ",
											JOptionPane.INFORMATION_MESSAGE);
									fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
								}
							
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "ͼ�����ʱû�д��飡", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
							fp1.setBooknumber((int) rowData[selectedRows[row]][4]);
						}

					}
					// fp1.setBooknumber((int)rowData[selectedRows[row]][4]-1);
					BookDaoImio daoImio = new BookDaoImio();
					daoImio.update1(fp1); // �޸��鼮������

					/*
					 * int bookid=0; bookid=Integer.parseInt(""+rowData[selectedRows[row]][0]);
					 */

					// new Borrow_AddMessage(zhanghao,(int)rowData[selectedRows[row]][0]);

					setVisible(false); // ���н��İ�ť�� ���رյ�ǰ���� ˢ�µ�ǰ�鼮ҳ��
					new BorrowBook(zhanghao);
				}
			}
		});

		panel.add(borrowButton);
		setVisible(true);
	}

}
