package Pet;

public class ddog extends one{
	private String strain;

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	public ddog() {
		
	}
	
    public ddog(String name,int health,int love,String strain) {
    	super(name,health,love);
    	this.strain=strain;
    	
		
	}
    
    public void print() {
    	super.print();
    	
    /*	System.out.println(this.getName());
    	System.out.println(this.getHealth());
    	System.out.println(this.getLove());*/
    	System.out.println("品种为"+this.strain);
    	
    	
    	
    	
    }
    public void eatSomeing(String food) {
		System.out.println(this.getName()+"正在吃"+food);
		
	}

}
