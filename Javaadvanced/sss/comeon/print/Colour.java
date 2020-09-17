package print;

public class Colour extends Printer{
	
	public Colour() {
		
	}
	
	public Colour(String name,String strain) {
		super(name,strain);
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this.getName()+"—°‘Ò¡À"+this.getStrain());
		
	}
	

}
