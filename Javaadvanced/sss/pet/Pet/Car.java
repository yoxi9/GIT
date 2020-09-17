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
		System.out.println("品牌"+this.brand);
		System.out.println("可乘坐人数"+this.num);
		System.out.println("能源类型"+this.strain);
	}
	
	public void run() {
		System.out.println("车跑起来了");
	}

}
