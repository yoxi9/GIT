package CS.Object;

import java.util.Date;

public class VIP {
 private String  id;
 private String user;
 private String name;
 private int count;
 private String telephone;
 private Date date;
 public VIP(){}
public VIP(String  id, String user, String name, int count ,String telephone, Date date) {
	super();
	this.id = id;
	this.user = user;
	this.name = name;
	this.count = count;
	this.telephone = telephone;
	this.date = date;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String  getId() {
	return id;
}
public void setId(String  id) {
	this.id = id;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "VIP [id=" + id + ", user=" + user + ", name=" + name + ", count=" + count + ", telephone=" + telephone
			+ ", date=" + date + "]";
}
 
}
