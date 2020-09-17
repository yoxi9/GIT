package CS.Mysql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CS.DAO.ItemDAO;
import CS.DAO.JDBCUtil;
import CS.Object.Item;
import CS.Object.User;

public class ItemMysql extends JDBCUtil implements ItemDAO
{
	public int add(Item item)
	{
		String sql="insert into item(id,name,prices,count,note) values(?,?,?,?,?)";
		Object[] params={item.getId(),item.getName(),item.getPrices(),item.getCount(),item.getNote()};
		int line=0;
		try
		{
			line=this.executeUpdate(sql,params);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return line;
	
	}
	
	public int delete(Item item)
	{	
		String sql="delete from item  where id=?";
		Object[] params={item.getId()};
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
	
	public int update(Item item)
	{
		String sql="update item set name=?,prices=?,count=?,note=? where id=?";
		Object[] params={item.getName(),item.getPrices(),item.getCount(),item.getNote(),item.getId()};
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
	
	//根据物品ID查询返回的是一个对象
	public Item getById(String id)
	{	
		String sql="select * from item where id=?";
		Object[]params={id};
		List<HashMap> listItem=new ArrayList<HashMap>();
		listItem=this.executeQuery(sql, params);
		if(listItem==null)
		{
			return null;
		}
		else
		{
			Item item = new Item();
			item.setId((String)listItem.get(0).get("id"));
			item.setName((String)listItem.get(0).get("name"));
			item.setPrices((float)listItem.get(0).get("prices"));
			item.setCount((int)(listItem.get(0).get("count")));
			item.setNote((String)listItem.get(0).get("note"));
			return item;
		}
	}
	
	public int subCount(int count,Item item)
	{	
		String sql="update item set count=count-? where id=?";
		Object[] params={count,item.getId()};
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
	
	//根据物品名称查询返回的是一个对象
	public Item getByName(String name)
	{	
		String sql="select * from item where name=?";
		Object[]params={name};
		List<HashMap> listItem=new ArrayList<HashMap>();
		listItem=this.executeQuery(sql, params);
		
		if(listItem.isEmpty())
		{
			return null;
		}
		else
		{
			Item item = new Item();
			item.setId((String)listItem.get(0).get("id"));
			item.setName((String)listItem.get(0).get("name"));
			item.setPrices((float)listItem.get(0).get("prices"));
			item.setCount((int)(listItem.get(0).get("count")));
			item.setNote((String)listItem.get(0).get("note"));
			return item;
		}
		
	}

	//返回的是一个表
	public List<HashMap> getAll(){
		String sql="select * from item";
		List<HashMap> listItem=new ArrayList<HashMap>();
		listItem=this.executeQuery(sql);
		return listItem;
	}
}
