package CS.DAO;

import java.util.List;

import CS.Object.Book;
import CS.Object.Borrow;

public interface BorrowDao {
	public int add(Borrow borrow);

	public int delete(Borrow borrow);

	public int update(Borrow borrow);

	public Book getById(int id);

	public List<Book> getByType(int type);

	public List<Book> getAll();
}
