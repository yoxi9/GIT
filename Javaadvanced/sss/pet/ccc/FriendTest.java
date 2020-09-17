package ccc;

public class FriendTest {
	
	public static void main(String[] args) {
		Friend cn= new cnFriend("ÕÅÈı");
		Master master=new Master();
		master.Serving(cn);
		
		Friend fn= new fnFriend("Jack");
		master.Serving(fn);
		
		
		
		
		
	}

}
