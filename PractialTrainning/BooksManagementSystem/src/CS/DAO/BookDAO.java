package CS.DAO;

import java.util.List;
import CS.Object.Book;

public interface BookDAO {
	public int add(Book book);

	public int delete(Book book);

	public int update(Book book);

	public int update1(Book book);

	public Book getById(int id);

	public List<Book> getByType(int type);

	public List<Book> getAll();
}
