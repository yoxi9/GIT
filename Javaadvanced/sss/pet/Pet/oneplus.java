package Pet;

public class oneplus {
	public static void main(String[] args) {
		ddog dog1=new ddog("����",90,80,"����");
		dog1.print();
		
		dog1.setHealth(60);
		dog1.setLove(70);
		
		dog1.print();
		
		Penguin penguin=new Penguin("���",100,100,"��");
		penguin.print();
		
		penguin.setHealth(60);
		penguin.setLove(60);
		
		penguin.print();
		
		
	}

}
