package shishishi;

public abstract class Animal {
	
	private String strain;

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	public Animal() {
		
	}
	
	public Animal(String strain) {
		this.strain=strain;
		
	}
	
	public void Animal() {
		System.out.println("¶¯ÎïÃû³Æ£º"+this.strain);
		
	}
	
	public abstract void Running();
	
	public abstract void Eating();
	

}
