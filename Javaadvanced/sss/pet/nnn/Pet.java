package nnn;

public abstract class Pet {
	
	private String strain;
	private int health;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	public Pet() {
		
	}
	
	public Pet(String strain,int health) {
		this.strain=strain;
		this.health=health;
	}
	
	public void Pet() {
		System.out.println("------------------");
		System.out.println("品种:"+this.strain);
		System.out.println("健康值为:"+this.health);
	}
	
	public abstract void Eat();

}
