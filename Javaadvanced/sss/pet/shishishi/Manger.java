package shishishi;

public class Manger extends Employee{
	
	private int share;

	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}

	public Manger() {
		
	}
	
	public Manger(String name,int age,String sex,int salary,int share) {
		super(name,age,sex,salary);
		this.share=share;
	}
	
	
	
	@Override
	public void printlncomebyMonth() {
		// TODO Auto-generated method stub
		super.printlncomebyMonth();
		System.out.println("ÿ�ɷֺ�:"+this.share+"Ԫ");
	}
	@Override
	public void printIncomeFullYear() {
		// TODO Auto-generated method stub
		System.out.println("��н:"+(super.getSalary()*12+this.share)+"Ԫ");
		
		
		
		
	}
	
	}
