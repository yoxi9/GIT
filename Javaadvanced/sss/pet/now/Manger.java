package now;

public class Manger extends Staff{
	
	private String share;

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}
	
	public Manger() {
		
	}
	
	public Manger(String name,int age,String sex,int salary,int money,String share) {
		super(name,age,sex,salary,money);
		this.share=share;
		
	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return super.getMoney();
	}

	@Override
	public void setMoney(int money) {
		// TODO Auto-generated method stub
		super.setMoney(money);
	}

	@Override
	public void printlncomebyMonth() {
		// TODO Auto-generated method stub
		super.printlncomebyMonth();
		System.out.println("�ɷݷֺ죺"+this.share);
	}
	
	
		
		
	
	
	
	

}
