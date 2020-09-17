package swingdome;

public class Phone {
	
	private String brand;
	private String price;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Phone(String brand, String price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	@Override
	public String toString() {
		return this.getBrand()+"手机，价格"+this.getPrice();
	}
	
	
	
	

}
