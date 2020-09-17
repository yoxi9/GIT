package Graph;

public class Square implements Show{
	
	private int side;
	
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	public Square() {
		
	}
	
	public Square(int side) {
		this.side=side;	
	}
	
	public void Square() {
		System.out.println("正方形边长为："+this.getSide());
	}

	@Override
	public void Area() {
		// TODO Auto-generated method stub
		System.out.println("正方形的面积为"+this.getSide()*this.getSide());
		
	}

	@Override
	public void SideLength() {
		// TODO Auto-generated method stub
		System.out.println("正方形的周长为"+this.getSide()*4);
		
	}

	

}
