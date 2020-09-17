package shishishi;

public class Wolf extends Animal{
	
	public Wolf() {
		
	}
	
	public Wolf(String strain) {
		super(strain);
	}

	@Override
	public void Running() {
		// TODO Auto-generated method stub
		
		System.out.println("狼群在草原上的奔跑");
		
	}

	@Override
	public void Eating() {
		// TODO Auto-generated method stub
		
		System.out.println("狼群在草原上捕猎");
		
	}
	
	

}
