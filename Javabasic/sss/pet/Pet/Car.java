package Pet;

public class Car {
	private String brand;
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	private int num;
	private String strain;
	
	public Car() {
		
	}
	
	public Car(String brand,int num,String strain) {
		this.brand=brand;
		this.num=num;
		this.strain=strain;
	}
	
	public void print() {
		System.out.println("---------");
		System.out.println("Ʒ��"+this.brand);
		System.out.println("�ɳ�������"+this.num);
		System.out.println("��Դ����"+this.strain);
	}
	
	public void run() {
		System.out.println("����������");
	}

}
