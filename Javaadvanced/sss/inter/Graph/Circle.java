package Graph;

public class Circle implements Show{
	
	private int rad;
	
	public int getRad() {
		return rad;
	}

	public void setRad(int rad) {
		this.rad = rad;
	}
	
	public Circle() {
		
	}

	public Circle(int rad) {
		this.rad=rad;
	}
	
	public void Circle() {
		System.out.println("圆的半径："+this.getRad());
	}
	
	@Override
	public void Area() {
		// TODO Auto-generated method stub
		System.out.println("圆的面积："+3.14*this.getRad()*this.getRad());
		
	}

	@Override
	public void SideLength() {
		// TODO Auto-generated method stub
		System.out.println("圆的周长："+2*3.14*this.getRad());
		
	}

	
	 

}
