package CS.DAOIMIO;

import java.util.List;

import CS.DAO.DBUtils;
import CS.DAO.ReturnBooksDao;
import CS.Object.ReturnBooks;

public class ReturnBooksDaoImio implements ReturnBooksDao {

	@Override
	public int add(ReturnBooks returnbooks) {
		// TODO Auto-generated method stub
		String sql = "insert into returnbook(userid,bookid,returntime)value(?,?,?)";
		DBUtils.update(sql, returnbooks.getUserid(), returnbooks.getBookid(), returnbooks.getReturntime());
		return 0;
	}

	@Override
	public int delete(ReturnBooks returnbooks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ReturnBooks returnbooks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update1(ReturnBooks returnbooks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReturnBooks getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReturnBooks> getByType(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReturnBooks> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
