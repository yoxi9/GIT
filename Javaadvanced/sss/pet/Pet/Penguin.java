package Pet;

public class Penguin extends one{
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Penguin() {
		
	}
	
	public Penguin(String name,int health,int love,String sex) {
		super(name,health,love);
		this.sex=sex;
		System.out.println();
	}
	
}
