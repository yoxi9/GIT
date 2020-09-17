package CS.Object;

public class User {

	private String id;
	private String user;
	private String password;
	private String admin;
	private double sum;
	private String name;
	private String sex;
	private int age;
	private String telephone;
	public User(){}
	public User(String  id, String user, String password, String admin, double sum, String name, String sex, int age,String telephone) 
	{
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.admin = admin;
		this.sum = sum;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.telephone = telephone;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", password=" + password + ", admin=" + admin + ", sum=" + sum
				+ ", name=" + name + ", sex=" + sex + ", age=" + age + ", telephone=" + telephone + "]";
	}
}
