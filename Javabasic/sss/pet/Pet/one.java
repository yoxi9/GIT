package Pet;

public class one {
	
	private String name;
	private int health;
	private int love;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	
	public one() {
		
	}
	
	public one(String name,int health,int love) {
		this.name=name;
		this.health=health;
		this.love=love;
		
	}
	
	public void print() {
		System.out.println("---------------");
		System.out.println("Ãû³Æ"+this.name);
		System.out.println("½¡¿µ"+this.health);
		System.out.println("¿É°®"+this.love);
		System.out.println("---------------");
	}
	
	
	public int getLegs() {
		return 0;
		
	}

}
