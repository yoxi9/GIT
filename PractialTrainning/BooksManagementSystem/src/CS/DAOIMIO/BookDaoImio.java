package CS.DAOIMIO;

import java.util.List;

import CS.DAO.BookDAO;
import CS.DAO.DBUtils;
import CS.DAO.UserDAO;
import CS.Object.Book;
import CS.Object.User;

public class BookDaoImio implements BookDAO {
	private static final String String = null;

	public int add(Book book) {
		// TODO Auto-generated method stub
		String sql = "insert into books(bookid,bookname,provenance,author,booknumber,bookprice,booktype,entertime)value(?,?,?,?,?,?,?,?)";
		DBUtils.update(sql, book.getBookid(), book.getBookname(), book.getProvenance(), book.getAuthor(),
				book.getBooknumber(), book.getBookprice(), book.getBooktype(), book.getEntertime());
		return 0;
	}

	@Override
	public int delete(Book book) {
		// TODO Auto-generated method stub
		String sql = "delete from books where bookname=?";
		DBUtils.update(sql, book.getBookname());
		return 0;

	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		String sql = "update books set bookname=?,provenance=?,author=?,booknumber=?,bookprice=?,booktype=?,entertime=? where bookid=?";
		Object[] params = { book.getBookname(), book.getProvenance(), book.getAuthor(), book.getBooknumber(),
				book.getBookprice(), book.getBooktype(), book.getEntertime(), book.getBookid() };
		int line = 0;
		try {
			line = DBUtils.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	@Override
	public Book getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByType(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update1(Book book) {
		// TODO Auto-generated method stub
		String sql = "update books set booknumber=? where bookid=?";
		Object[] params = { book.getBooknumber(), book.getBookid() };
		int line = 0;
		try {
			line = DBUtils.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

}
