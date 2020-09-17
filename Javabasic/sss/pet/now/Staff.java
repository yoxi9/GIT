package now;

public class Staff extends Employee{
	private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public Staff() {
		
	}
	
	public Staff(String name,int age,String sex,int salary,int money) {
		super(name,age,sex,salary);
		this.money=money;
	}

	@Override
	public void printlncomebyMonth() {
		// TODO Auto-generated method stub
		super.printlncomebyMonth();
		System.out.println("ÐÐÕþ²¹Ìù£º"+this.money+"Ôª");
	}
	
	
	
	
	

}
