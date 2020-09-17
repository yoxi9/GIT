package Daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.DBUtils;
import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		int code=0;
	    String sql="insert into users£¨(name,password£© values(?,?";
	    
	    code=DBUtils.update(sql, user.getName(),user.getPassword());
	    
		return code;
	}

	@Override
	public List<User> getUser(User user) {
		// TODO Auto-generated method stub
		String sql="select*from users wherer name=? andpassword=?";
		List<User> userlist=new ArrayList<User>();
		
		  List<Map<String, Object>> maplist= DBUtils.query(sql, user.getName(),user.getPassword());
		  for(Map<String, Object> map:maplist){
	            User U=new User();
	            U.setId((Integer) map.get("id"));
	            U.setName((String)(map.get("name")));
	            U.setName((String)(map.get("password")));

	            userlist.add(U);
		}
	return userlist;

}
}
