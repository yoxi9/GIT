package CS.Mysql;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import CS.DAO.JDBCUtil;
import CS.DAO.VIPDAO;
import CS.Object.VIP;

public class VIPMysql extends JDBCUtil implements VIPDAO
{
	//会员的信息
	public int add(VIP vip)
	{
		String sql="insert into vip(id,user,name,count,telephone,date) values(?,?,?,?,?,?)";
	    Object[] params={vip.getId(),vip.getUser(),vip.getName(),0,vip.getTelephone(),vip.getDate()};
	    int line=0;
	    try
	    {
			line=this.executeUpdate(sql, params);
		}
	    catch (Exception e) 
	    {
			e.printStackTrace();
		}
		return line;
	}
	
	public int delete(VIP vip) throws Exception
	{
		String sql = "DELETE FROM vip WHERE id = ?;";
		Object params[]={vip.getId()};
		int line = this.executeUpdate(sql,params);
		return line;
	}
	
	public int update(VIP vip) throws Exception
	{
		String sql = "update vip set USER=?,NAME=?,COUNT=?,TELEPHONE=? where id=?";
		Object params[]={vip.getUser(),vip.getName(),vip.getCount(),vip.getTelephone(),vip.getId()};
		int line = this.executeUpdate(sql,params);
		return line;
	}
	
	public VIP getById(String id)
	{
	    String sql="select * from vip where id=?";
	    List<HashMap> listVip=new ArrayList<HashMap>();
	    Object params[]={id};
	    listVip=this.executeQuery(sql,params);
		
		if(listVip.isEmpty())
		{
			return null;
		}
		else
		{
		    VIP vip = new VIP();
		    vip.setId((String)listVip.get(0).get("ID"));
		    vip.setUser((String)listVip.get(0).get("USER"));
		    vip.setName((String)listVip.get(0).get("NAME"));
		    vip.setCount((int)listVip.get(0).get("COUNT"));
		    vip.setTelephone((String)listVip.get(0).get("TELEPHONE"));
		    vip.setDate((Date)listVip.get(0).get("DATE"));
			return vip;
		}
	}
	
	public  List<HashMap> getAll()
	{
	    String sql="select * from vip";
	    List<HashMap> listVip=new ArrayList<HashMap>();
	    listVip=this.executeQuery(sql);
		return  listVip;
	}
	
	public int addCount(VIP vip,int count)
	{
		String sql = "update vip set COUNT=COUNT+? where id=?";
		Object params[]={count,vip.getId()};
		int line=0;
		try 
		{
			line = this.executeUpdate(sql,params);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return line;
	}
}

