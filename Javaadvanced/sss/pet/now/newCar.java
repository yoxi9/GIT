package now;

public class newCar extends Motovehicle{
	
	private String type;
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public newCar() {
		
	}
	
	
	public newCar(String brand,String type) {
		super(brand);
		this.type=type;
	}
	
	public int calcRent(int days) {
		
		int rentfee=0;
		
		if("�����".equals(this.type)&&"���".equals(this.getBrand())) {
			rentfee=600*days;
		}else if("550".equals(this.type)&&"����".equals(this.getBrand())){
			rentfee=500*days;
			
		}else if("������".equals(this.type)&&"���".equals(this.getBrand())){
			rentfee=300*days;
			
		}else if("550".equals(this.type)&&"����".equals(this.getBrand())){
			rentfee=500*days;
			
		}else {
			rentfee=0;
			System.out.println("����");
		}
		
		return rentfee;
		
		
	}

}
