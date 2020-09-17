package homework;

public class Student {
	
	private String name;
	private String num;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num =num;
	}
	
	public Student() {
		
	}
	
	public Student(String name, String num) {
		this.name = name;
		this.num = num;
	}
	
	 @Override
	    public String toString() {
	       return "学生姓名：" + name + "\t学生学号：" + num;
	    }
	
	
	
}
