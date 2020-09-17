package CS.Object;

public class Coupon {

	private String id;
	private double prices;
	public Coupon() {		
	}
	public Coupon(String id, double prices) {
		super();
		this.id = id;
		this.prices = prices;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", prices=" + prices + "]";
	}
	
}
