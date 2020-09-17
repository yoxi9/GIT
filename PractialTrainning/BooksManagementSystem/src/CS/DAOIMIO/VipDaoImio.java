package CS.DAOIMIO;

import java.util.List;

import CS.DAO.DBUtils;
import CS.DAO.VipDao;
import CS.Object.BorrowVip;

public class VipDaoImio implements VipDao{

	@Override
	public int add(BorrowVip borrowvip) {
		// TODO Auto-generated method stub
		String sql = "insert into vip(userid,starttime,overtime)value(?,?,?)";
		DBUtils.update(sql, borrowvip.getUserid(), borrowvip.getStarttime(), borrowvip.getOvertime());
		return 0;
	}

	@Override
	public int delete(BorrowVip borrowvip) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete1(BorrowVip borrowvip) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BorrowVip borrowvip) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BorrowVip getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowVip> getByType(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowVip> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
