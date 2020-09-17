package shishishi;

public class Goat extends Animal{
	
	public Goat() {
		
	}
	
	public Goat(String strain) {
		super(strain);
	}

    @Override
	public void Running() {
		// TODO Auto-generated method stub
		
		System.out.println("山羊在草原上悠闲的奔跑");
		
	}

	@Override
	public void Eating() {
		// TODO Auto-generated method stub
		
		System.out.println("山羊在草原上吃草");
		
	}
	
	
	
	

}
