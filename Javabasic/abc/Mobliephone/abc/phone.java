package abc;

public class phone {
	
	public void playMusic() {//��������

		System.out.println("�ֻ����ڲ�������");
		
	}
	public String downloadMusic() {//��������
		
		String songname="���տ���";
		
		System.out.println("�ֻ���������"+songname);
		
		return songname;
	}
	
	public void charge() {
		
		Battery  battery=new Battery();
		
		battery.brand="����";
		
		battery.getPower();
		
		System.out.println();
		
	}
	
	
	
	

}
