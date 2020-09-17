package CS.Object;

import java.util.Date;

import CS.Kit.Unit;

public class Log {

	private Date date;
	private String type;
	private String userId;
	private String itemId;
	private double count;
	private String note;
	public Log(Date date, String type, String userId, String itemId, double count, String note) {
		super();
		this.date = date;
		this.type = type;
		this.userId = userId;
		this.itemId = itemId;
		this.count = count;
		this.note = note;
	}
	public Log(){}
	
	public Date getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public String getUserId() {
		return userId;
	}

	public String getItemId() {
		return itemId;
	}

	public double getCount() {
		return count;
	}

	public String getNote() {
		return note;
	}
	
	public Log setLog(String note)
	{
		this.date=new Date();
		this.userId=Unit.nowUser.getId();
		this.note=note;
		return this;
	}
	
	public Log setLog(String itemId,double count,String note)
	{
		this.date=new Date();
		this.userId=Unit.nowUser.getId();
		this.itemId=itemId;
		this.count=count;
		this.note=note;
		return this;
	}
	public Log setLog()
	{
		this.date=new Date();
		this.userId=Unit.nowUser.getId();
		return this;
	}
}
