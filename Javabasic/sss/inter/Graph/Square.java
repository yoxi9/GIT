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
		System.out.println("�����α߳�Ϊ��"+this.getSide());
	}

	@Override
	public void Area() {
		// TODO Auto-generated method stub
		System.out.println("�����ε����Ϊ"+this.getSide()*this.getSide());
		
	}

	@Override
	public void SideLength() {
		// TODO Auto-generated method stub
		System.out.println("�����ε��ܳ�Ϊ"+this.getSide()*4);
		
	}

	

}
