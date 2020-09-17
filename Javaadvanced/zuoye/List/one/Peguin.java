package one;

public class Peguin implements Comparable<Peguin> {
	
	private int no;
	private int age;
	
	public Peguin() {
		super();
	}
 
	public Peguin(int no, int age) {
		super();
		this.no = no;
		this.age = age;
	}
 
	public int getNo() {
		return no;
	}
 
	public void setNo(int no) {
		this.no = no;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peguin other = (Peguin) obj;
		return true;
	}
	
	@Override
	public String toString() {
		return "Peguin [no=" + no + ", age=" + age + "]";
	}
 
	@Override
	public int compareTo(Peguin o) {
		// TODO Auto-generated method stub
		return this.no - o.no;
	}



}
