package iphone;

public class CommonHandset extends Handset implements PlayWiring{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("正在使用"+this.getBrand()+"播放"+PlayWiring.Music);
		
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
