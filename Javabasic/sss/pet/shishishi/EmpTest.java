package shishishi;

public class EmpTest{
	public static void main(String[] args) {
		
		Emp emp=new Emp("����",40,"��",6000);
		emp.printlncomebyMonth();
		emp.printIncomeFullYear();
		
		Manger manger=new Manger("����",55,"��",20000,300000);
		manger.printlncomebyMonth();
		manger.printIncomeFullYear();
	}
	
	
}
