package CS.Object;

public class User {
	public int getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(int borrowid) {
		this.borrowid = borrowid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public User() {
		super();
		this.borrowid = borrowid;
		this.name = name;
		this.user = user;
		this.password = password;
		this.admin = admin;
		this.sex = sex;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "User [borrowid=" + borrowid + ", name=" + name + ", user=" + user + ", password=" + password
				+ ", admin=" + admin + ", sex=" + sex + ", grade=" + grade + "]";
	}

	public User(int borrowid, String name, String user, String password, String sex, String grade, String admin) {
		super();
		this.borrowid = borrowid;
		this.name = name;
		this.user = user;
		this.password = password;
		this.sex = sex;
		this.grade = grade;
		this.admin = admin;
	}

	private int borrowid; // ������ID
	private String name; // ����������
	private String user; // �ʺ�
	private String password; // ����
	private String sex; // �Ա�
	private String grade; // �༶
	private String admin; // Ȩ��

}
