package Main_interface;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import CS.DAO.DBUtils;

import CS.DAOIMIO.BookDaoImio;
import CS.Object.Book;
import CS.Object.User;

public class Books_ChangeMessage {

	public Books_ChangeMessage() {
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("修改书籍信息(直接在表格中修改)");
		jf.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		JPanel panel = new JPanel(new BorderLayout());
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
		DefaultTableModel tableModel = new DefaultTableModel(rowData, columnNames);
		JTable table = new JTable(tableModel);
		tableModel.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int firstRow = e.getFirstRow();
				int lastRow = e.getLastRow();

				int column = e.getColumn();
				int type = e.getType();

				if (type == TableModelEvent.UPDATE) {

					for (int row = firstRow; row <= lastRow; row++) {

						// Object bookidObj = tableModel.getValueAt(row, 1);
						Object booknameObj = tableModel.getValueAt(row, 1);
						Object provenanceObj = tableModel.getValueAt(row, 2);
						Object authorObj = tableModel.getValueAt(row, 3);
						Object booknumberObj = tableModel.getValueAt(row, 4);
						Object bookpriceObj = tableModel.getValueAt(row, 5);
						Object booktypeObj = tableModel.getValueAt(row, 6);
						Object entertimeObj = tableModel.getValueAt(row, 7);

						int booknumber = 0;
						booknumber = Integer.parseInt("" + booknumberObj);
						double bookprice = 0.0;
						bookprice = Double.parseDouble("" + bookpriceObj);
						Book book = new Book();
						book.setBookid((int) rowData[row][0]);
						book.setBookname((String) booknameObj);
						book.setProvenance((String) provenanceObj);
						book.setAuthor((String) authorObj);
						book.setBooknumber(booknumber);
						book.setBookprice(bookprice);
						book.setBooktype((String) booktypeObj);
						book.setEntertime((String) entertimeObj);
						BookDaoImio dao = new BookDaoImio();
						dao.update(book);

					}
				}
			}
		});
		panel.add(table.getTableHeader(), BorderLayout.NORTH);
		// 把 表格内容 添加到容器中心
		panel.add(table, BorderLayout.CENTER);

		jf.setContentPane(panel);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

	}

}
