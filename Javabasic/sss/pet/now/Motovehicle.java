package now;

public abstract class Motovehicle {
	
	private String brand;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public Motovehicle() {
		
	}
	
	public Motovehicle(String brand) {
		this.brand=brand;
		
	}
	
	public abstract int calcRent(int days);

	
	
	
}