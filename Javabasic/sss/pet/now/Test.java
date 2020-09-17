package now;

public class Test {
	public static void main(String[] args) {
		
		Employee employee=new Employee("张三",30,"男",200);
		employee.printlncomebyMonth();
		
		Staff staff=new Staff("李四",35,"女",500,1000);
		staff.printlncomebyMonth();
		
		Manger manger=new Manger("刘能",50,"男",1000,2000,"10%股份");
		manger.printlncomebyMonth();
		
	}

}
