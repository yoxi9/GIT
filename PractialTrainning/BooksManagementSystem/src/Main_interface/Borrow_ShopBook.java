package Main_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

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

public class Borrow_ShopBook extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;// ����һ��������
	private DefaultTableModel tableModel;// ����һ�����ģ�Ͷ���

	public Borrow_ShopBook(String zhanghao) {
		initialize(zhanghao);
	}

	private void initialize(String zhanghao) {
		// TODO Auto-generated method stub
		setTitle("�����鼮");
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
		/**�и��п�**/
		table.setRowHeight(25);
	    table.getColumnModel().getColumn(1).setPreferredWidth(130);

		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);

		final JButton borrowButton = new JButton("����");
		borrowButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int[] selectedRows = table.getSelectedRows();
				for (int row = 0; row < selectedRows.length; row++) {
					Book fp1 = new Book();
					fp1.setBookid((int) rowData[selectedRows[row]][0]);
					/* �ж��Ƿ�Ϊvip */
					VIP_Judge vipjudge = new VIP_Judge();
					boolean a = vipjudge.VIP_Judge(zhanghao);
					System.out.println(a);
					// ����vip����true
					if ((int) rowData[selectedRows[row]][4] > 0) { /** �ж�������Ƿ����� **/
						if (a) {
							DecimalFormat    df   = new DecimalFormat("######0.00");  
							Double money=((Double) rowData[selectedRows[row]][5])*0.8;
					
							fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
							JOptionPane.showMessageDialog(
									null, "��ϲ��ɹ�����" + rowData[selectedRows[row]][1] + ",�������ǻ�Ա���������Ѵ�8�ۣ�������"
											+ df.format(money) + "Ԫ",
									"��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
						} else {
							fp1.setBooknumber((int) rowData[selectedRows[row]][4] - 1);
							JOptionPane.showMessageDialog(
									null, "��ϲ��ɹ�����" + rowData[selectedRows[row]][1] + ",������"
											+ rowData[selectedRows[row]][5] + "Ԫ",
									"��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "�������ʱû�д��飬�޷�����", "��Ϣ��ʾ", JOptionPane.INFORMATION_MESSAGE);

					}
					BookDaoImio daoImio = new BookDaoImio();
					daoImio.update1(fp1);
					setVisible(false); // ���н��İ�ť�� ���رյ�ǰ���� ˢ�µ�ǰ�鼮ҳ��
					new Borrow_ShopBook(zhanghao);
				}
			}
		});
		panel.add(borrowButton);
		setVisible(true);
	}

}
