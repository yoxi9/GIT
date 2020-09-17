package sss;

public class lv {
	String name;
	int age;
	
	
	public void buyticket() {
		int price=age>16? 30:15;
		System.out.println(name+",您购买的票价格为"+price);
	}

}
