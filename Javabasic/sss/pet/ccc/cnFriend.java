package ccc;

public class cnFriend extends Friend{
	
	public cnFriend() {
		
	}
	
    public cnFriend(String name) {
    	
    	super(name);
		
	}
	
	

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("中国朋友：");
		System.out.println("你对"+this.getName()+"说“你好”");
		
	}
	
	
	
	

}
