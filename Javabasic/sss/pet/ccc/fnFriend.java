package ccc;

public class fnFriend extends Friend{
	
    public fnFriend() {
		
	}
	
    public fnFriend(String name) {
    	
    	super(name);
		
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("外国朋友：");
		System.out.println("你对"+this.getName()+"说“Hello”");
		
	}
	
	

}
