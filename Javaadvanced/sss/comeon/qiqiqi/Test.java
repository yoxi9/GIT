package qiqiqi;

public class Test {
	public static void main(String[] args) {
		
	Customer cut1=new Customer("����",134);
	System.out.println(cut1.toString());
	Customer cut2=new Customer("����",134);
	System.out.println(cut2.toString());
	
	
	
	if(cut1.equals(cut2)) {
		System.out.println("�����û���ͬһ��");
	}else {
		System.out.println("�����û�����ͬһ��");
	}
	
	

}
}