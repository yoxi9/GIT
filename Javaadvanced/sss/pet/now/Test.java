package now;

public class Test {
	public static void main(String[] args) {
		
		Employee employee=new Employee("����",30,"��",200);
		employee.printlncomebyMonth();
		
		Staff staff=new Staff("����",35,"Ů",500,1000);
		staff.printlncomebyMonth();
		
		Manger manger=new Manger("����",50,"��",1000,2000,"10%�ɷ�");
		manger.printlncomebyMonth();
		
	}

}
