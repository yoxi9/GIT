package now;

public class Employee {
	
	private String name;
	private int age;
	private String sex;
	private int salary;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public Employee() {
		
	}
	
	public Employee(String name,int age,String sex,int salary) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		this.salary=salary;
	}
	
	public void printlncomebyMonth() {
		System.out.println("---------------------");
		System.out.println("������"+this.name);
		System.out.println("���䣺"+this.age+"��");
		System.out.println("�Ա�:"+this.sex);
		System.out.println("��н:"+this.salary*30+"Ԫ");
		
	}

}
