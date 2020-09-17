package ccc;

public class Master {
	
	public void Serving(Friend fd) {
		
		if(fd instanceof cnFriend) {
			cnFriend china=(cnFriend)fd;
			china.sayHello();
			
		}else if(fd instanceof fnFriend) {
			fnFriend forgien=(fnFriend)fd;
			forgien.sayHello();
		
			
		}
		
		
	}
	
	

}
