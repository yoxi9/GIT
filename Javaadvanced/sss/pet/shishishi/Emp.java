package shishishi;

public class Emp extends Employee{
	
	public Emp() {
		
	}
	
	public Emp(String name,int age,String sex,int salary) {
		super(name,age,sex,salary);
	}
	
	

	@Override
	public void printlncomebyMonth() {
		// TODO Auto-generated method stub
		super.printlncomebyMonth();
	}

	@Override
	public void printIncomeFullYear() {
		// TODO Auto-generated method stub
		System.out.println("ÄêÐ½:"+super.getSalary()*12+"Ôª");
		
	}

}
