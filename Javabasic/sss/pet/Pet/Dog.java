package Pet;

public class Dog {
	
	private String name;
	private int age ;
	private int health;
	private String strian;
	
	public String getname() {
		
		return name;
		
	}
	
	public int getage() {
		
		return age;
		
	}
	
	public int gethealth() {
		
		return health;
		
	}
	
	public String getstrian() {
		
		return strian;
	}
	
	public void  setname(String name) {
		this.name=name;
	}
	
	public void setage(int age) {
		this.age=age;
	}
	
	
	
	public void sethealth(int health) {
		
		if(health>0||health>100) {
			System.out.println("请输入合法的数值0~100");
			this.health=60;
			return;
		}
		else {
			
		}
		
	}
	
	public void setstrian(String stria) {
	     this.strian=strian;
	
}
	
	

}
