package CS.DAOIMIO;

import java.util.List;

import CS.DAO.BookDAO;

import CS.DAO.BorrowDao;
import CS.DAO.DBUtils;
import CS.Object.Book;
import CS.Object.Borrow;

public class BorrowDaoImio implements BorrowDao {

	@Override
	public int add(Borrow borrow) {
		// TODO Auto-generated method stub
		String sql = "insert into borrow(userid,bookid,borrowdate,returndate)value(?,?,?,?)";
		DBUtils.update(sql, borrow.getUserid(), borrow.getBookid(), borrow.getBorrowdate(), borrow.getReturndate());
		return 0;
	}

	@Override
	public int delete(Borrow borrow) {
		// TODO Auto-generated method stub
		String sql = "delete from borrow where userid=? AND bookid=?";
		DBUtils.update(sql, borrow.getUserid(), borrow.getBookid());
		return 0;
	}

	@Override
	public int update(Borrow borrow) {
		// TODO Auto-generated method stub
		return 0;
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

}
