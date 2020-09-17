package Pet;

public class truck extends Car{
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	} 
	
	public truck() {
		
	}
	
	public truck(String brand,int num,String strain,int weight) {
		super(brand,num,strain);
		this.weight=weight;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("卡车载重为"+this.weight+"吨");
	}
	
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("载重"+this.weight+"的卡车在路上行驶");
	}
}
