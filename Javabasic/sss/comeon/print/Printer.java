package print;

public abstract class Printer {
	
	private String name; 
    private String strain;
    
	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}

	public Printer() {
		
	}
	
	public Printer(String name,String strain) {
		this.name=name;
		this.strain=strain;
		
	}
	
    public void Printer() {
    	
    	System.out.println("客户的姓名为"+this.name);
		
	}
	
	public abstract void print();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	

}
