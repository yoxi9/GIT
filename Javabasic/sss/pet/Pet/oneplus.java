package Pet;

public class oneplus {
	public static void main(String[] args) {
		ddog dog1=new ddog("Íú²Æ",90,80,"¾©°Í");
		dog1.print();
		
		dog1.setHealth(60);
		dog1.setLove(70);
		
		dog1.print();
		
		Penguin penguin=new Penguin("Æó¶ì",100,100,"ÄÐ");
		penguin.print();
		
		penguin.setHealth(60);
		penguin.setLove(60);
		
		penguin.print();
		
		
	}

}
