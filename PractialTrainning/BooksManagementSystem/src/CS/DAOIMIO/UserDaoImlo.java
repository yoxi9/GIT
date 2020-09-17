package CS.DAOIMIO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CS.DAO.DBUtils;
import CS.DAO.UserDAO;
import CS.Object.User;

public class UserDaoImlo implements UserDAO {

	private static final String String = null;

	public int add(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into bookuser(borrowid,name,user,password,sex,grade,admin)value(?,?,?,?,?,?,?)";
		DBUtils.update(sql, user.getBorrowid(), user.getName(), user.getUser(), user.getPassword(), user.getSex(),
				user.getGrade(), user.getAdmin());
		return 0;
	}

	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		String sql = "delete from bookuser where borrowid=? AND admin=?";
		DBUtils.update(sql, user.getBorrowid(), user.getAdmin());
		return 0;
	}
	
	@Override
	public int delete1(User user) {
		String sql = "delete from bookuser where borrowid=?";
		DBUtils.update(sql, user.getBorrowid());
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		String sql = "update bookuser set name=?,sex=?,grade=? where borrowid=?";
		Object[] params = { user.getName(), user.getSex(), user.getGrade(), user.getBorrowid() };
		int line = 0;
		try {
			line = DBUtils.executeUpdate(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}

	@Override
	public List<User> getByType(int type) {
		// TODO Auto-generated method stub
		List<User> productlist = new ArrayList<User>();
		String sql = "select *from bookuser where admini=?";
		List<HashMap<String, Object>> maplist = DBUtils.executeQuery2(sql, type);
		for (int i = 0; i < maplist.size(); i++) {
			HashMap<String, Object> map = maplist.get(i);
			User user = new User();
			user.setBorrowid((int) map.get("borrowid"));
			user.setName((String) map.get("name"));
			user.setUser((String) map.get("user"));
			user.setPassword((String) map.get("password"));
			user.setSex((String) map.get("sex"));
			user.setGrade((String) map.get("grade"));
			user.setAdmin((String) map.get("admin"));

			productlist.add(user);

		}

		return productlist;
	}

	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
