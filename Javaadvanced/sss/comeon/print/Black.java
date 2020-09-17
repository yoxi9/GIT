package print;

public class Black extends Printer{
	
	public Black() {
		
	}
	
	public Black(String name,String strain) {
		super(name,strain);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"—°‘Ò¡À"+this.getStrain());
		
		
	}
	
	

}
