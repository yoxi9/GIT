package shishishi;

public class EmpTest{
	public static void main(String[] args) {
		
		Emp emp=new Emp("张三",40,"男",6000);
		emp.printlncomebyMonth();
		emp.printIncomeFullYear();
		
		Manger manger=new Manger("李四",55,"男",20000,300000);
		manger.printlncomebyMonth();
		manger.printIncomeFullYear();
	}
	
	
}
