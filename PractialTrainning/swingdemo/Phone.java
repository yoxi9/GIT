package swingdemo;

public class Phone {
	private String brand;
    private int price;
    
    
    
    public Phone() {
    }
    
    public Phone(String brand) {
		super();
		this.brand = brand;
		this.price=1000;
    }
    
     public Phone(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.brand+"牌手机，价格"+this.price;
	}
     
}
