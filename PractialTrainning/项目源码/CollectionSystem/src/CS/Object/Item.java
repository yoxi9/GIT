package CS.Object;

public class Item {

	private String id;
	private String name;
	private double prices;
	private int count;
	private String note;
	public Item(String  id, String name, double prices, int count, String note) {
		super();
		this.id = id;
		this.name = name;
		this.prices = prices;
		this.count = count;
		this.note = note;
	}
	public Item(){}
	public String  getId() {
		return id;
	}
	public void setId(String  id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", prices=" + prices + ", count=" + count + ", note=" + note + "]";
	}
	
}
