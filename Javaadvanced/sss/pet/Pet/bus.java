package Pet;

public class bus extends Car{
	private int no;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public bus() {
		
	}
	
	public bus(String brand,int num,String strain,int no) {
		super(brand,num,strain);
		this.no=no;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("����������"+this.no);
	}
	
	
	
	public void run() {
		 System.out.println(this.no+"·�������ڳ��е�·����ʻ");
		}
	
	
	
	

}
