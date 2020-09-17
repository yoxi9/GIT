package CS.Mysql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CS.DAO.JDBCUtil;
import CS.DAO.UserDAO;
import CS.Kit.Unit;
import CS.Object.User;

public class UserMysql extends JDBCUtil implements UserDAO{

	JDBCUtil jdbcutil=JDBCUtil.getInitJDBCUtil();
	//注冊
	public int add(User user)
	{
		String sql="insert into user(id,user,password,admin,sum,name,sex,age,telephone) values(?,?,?,?,?,?,?,?,?)";
		Object[] params={user.getId(),user.getUser(),user.getPassword(),user.getAdmin(),user.getSum(),user.getName(),user.getSex(),user.getAge(),user.getTelephone()};
		int line=0;
		try
		{
			line = this.executeUpdate(sql, params);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return line;
	}
	
	public User login(User user)
	{
		String sql="select * from user where user=? and password=? and admin=?";
		Object[]params={user.getUser(),user.getPassword(),user.getAdmin()};
		List<HashMap> listUser=new ArrayList<HashMap>();
		listUser=this.executeQuery(sql, params);
		
		if(listUser.isEmpty())
		{
			return null;
		}
		else
		{
			Unit.putDebug(listUser.get(0));

			User loginUser = new User();
			loginUser.setId((String)listUser.get(0).get("ID"));
			loginUser.setUser((String)listUser.get(0).get("USER"));
			loginUser.setPassword((String)listUser.get(0).get("PASSWORD"));
			loginUser.setName((String)listUser.get(0).get("NAME"));
			loginUser.setSex((String)listUser.get(0).get("SEX"));
			loginUser.setAge((int)(listUser.get(0).get("AGE")));
			loginUser.setTelephone((String)listUser.get(0).get("TELEPHONE"));
			loginUser.setAdmin((String)listUser.get(0).get("ADMIN"));
			loginUser.setSum((float)(listUser.get(0).get("SUM")));
			return loginUser;
		}
	}

	public int addSum(User user,int sum)
	{
		String sql="update user set SUM=SUM+? where id=?";
		Object[]params={sum,user.getId()};
		int line = 0;
		try 
		{
			line = this.executeUpdate(sql, params);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return line;
	}
	
	public User getByUser(String user)
	{
		String sql="select * from user where user=?";
		Object[]params={user};
		List<HashMap> listUser=new ArrayList<HashMap>();
		listUser=this.executeQuery(sql, params);
		
		if(listUser.isEmpty())
		{
			return null;
		}
		else
		{
			Unit.putDebug(listUser.get(0));
			
			User login = new User();
			login.setId((String)listUser.get(0).get("ID"));
			login.setUser((String)listUser.get(0).get("USER"));
			login.setPassword((String)listUser.get(0).get("PASSWORD"));
			login.setName((String)listUser.get(0).get("NAME"));
			login.setSex((String)listUser.get(0).get("SEX"));
			login.setAge((int)(listUser.get(0).get("AGE")));
			login.setTelephone((String)listUser.get(0).get("TELEPHONE"));
			login.setAdmin((String)listUser.get(0).get("ADMIN"));
			login.setSum((float)(listUser.get(0).get("SUM")));

			return login;
		}
	}
	
	public int rePassword(User user,String newPassword)
	{
		String sql="update user set PASSWORD=? where USER=?";
		Object[]params={newPassword,user.getUser()};
		int line = 0;
		try 
		{
			line = this.executeUpdate(sql, params);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return line;
	}
}
