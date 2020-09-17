package abc;

public class phone {
	
	public void playMusic() {//播放音乐

		System.out.println("手机正在播放音乐");
		
	}
	public String downloadMusic() {//下载音乐
		
		String songname="生日快乐";
		
		System.out.println("手机正在下载"+songname);
		
		return songname;
	}
	
	public void charge() {
		
		Battery  battery=new Battery();
		
		battery.brand="南孚";
		
		battery.getPower();
		
		System.out.println();
		
	}
	
	
	
	

}
