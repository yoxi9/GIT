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
		System.out.println("����ʹ��"+this.getBrand()+"����");
		
	}

	@Override
	public void takepictures() {
		// TODO Auto-generated method stub
		System.out.println("����ʹ��"+this.getBrand()+"����");
		
	}

	@Override
	public void sendInfo() {
		// TODO Auto-generated method stub
		System.out.println("ʹ��"+this.getBrand()+"������Ϣ��xx");
		
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("����ʹ��"+this.getBrand()+"��绰��xx");
		
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("ʹ��"+this.getBrand()+"����xx����Ϣ");
		
		
	}
	

}
