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
		System.out.println("��������Ϊ"+this.weight+"��");
	}
	
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("����"+this.weight+"�Ŀ�����·����ʻ");
	}
}
