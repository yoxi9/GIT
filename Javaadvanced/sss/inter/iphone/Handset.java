package iphone;

public abstract class Handset {
	
	private String brand;
	private String type;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Handset() {
		
	}
	
	public Handset(String brand,String type) {
		this.brand=brand;
		this.type=type;
	}
	
	public void handset() {
		System.out.println("这是一台"+this.getBrand()+"，型号为"+this.getType()+"。");
	}
	
	public abstract void sendInfo();
	
	public abstract void call();
	
    public abstract void info();


}
