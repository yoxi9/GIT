package CS.DAO;

import java.util.List;

import CS.Object.Borrow;
import CS.Object.BorrowVip;
import CS.Object.User;

public interface VipDao {
	public int add(BorrowVip borrowvip);

	public int delete(BorrowVip borrowvip);
	
	public int delete1(BorrowVip borrowvip);

	public int update(BorrowVip borrowvip);

	public BorrowVip getById(int id);

	public List<BorrowVip> getByType(int type);

	public List<BorrowVip> getAll();
}
