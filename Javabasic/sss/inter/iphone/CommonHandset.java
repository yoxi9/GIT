package iphone;

public class CommonHandset extends Handset implements PlayWiring{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("����ʹ��"+this.getBrand()+"����"+PlayWiring.Music);
		
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
