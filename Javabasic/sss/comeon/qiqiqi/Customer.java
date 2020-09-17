package qiqiqi;

public class Customer {
	
	private String name;
	private int num;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public Customer() {
		
	}
	
	public Customer(String name,int num) {
		this.name=name;
		this.num=num;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Customer) {
			Customer cut=(Customer)obj;
		if(this.getName().equals(cut.getName())
				&&this.getNum()==cut.getNum()) {
			return true;
			
		}
		return false;
		
		}
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "我叫"+this.getName()+"，我的电话号码是"+this.getNum();
	}
	
	
	
}
