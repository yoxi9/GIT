package now;

public class Bus extends Motovehicle{
	
	private int seats;
	
    public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public Bus() {
		
	}
	
    public Bus(int seats) {
    	this.seats=seats;
	}
	
	@Override
	public int calcRent(int days) {
		// TODO Auto-generated method stub
		int rentfee=0;
		if(this.seats<=16) {
			rentfee=days*800;
		}else {
			rentfee=days*1500;
		}
		return rentfee;
	}
	
	

	
	
	
	

	

}
