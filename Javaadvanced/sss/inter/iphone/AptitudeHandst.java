package iphone;

public class AptitudeHandst extends Handset implements TakePictures,Network{
	
	public AptitudeHandst() {
		
	}
	
	public AptitudeHandst(String brand,String type) {
		super(brand,type);
	}

	@Override
	public void network() {
		// TODO Auto-generated method stub
		System.out.println("正在使用"+this.getBrand()+"上网");
		
	}

	@Override
	public void takepictures() {
		// TODO Auto-generated method stub
		System.out.println("正在使用"+this.getBrand()+"拍照");
		
	}

	@Override
	public void sendInfo() {
		// TODO Auto-generated method stub
		System.out.println("使用"+this.getBrand()+"发送信息给xx");
		
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("正在使用"+this.getBrand()+"打电话给xx");
		
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("使用"+this.getBrand()+"接收xx的信息");
		
		
	}
	

}
