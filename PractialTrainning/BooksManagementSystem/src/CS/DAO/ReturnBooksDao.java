package CS.DAO;

import java.util.List;

import CS.Object.Book;
import CS.Object.ReturnBooks;

public interface ReturnBooksDao {
	public int add(ReturnBooks returnbooks);

	public int delete(ReturnBooks returnbooks);

	public int update(ReturnBooks returnbooks);

	public int update1(ReturnBooks returnbooks);

	public ReturnBooks getById(int id);

	public List<ReturnBooks> getByType(int type);

	public List<ReturnBooks> getAll();
}
