package sss;

public class ccclion {
	String colour;
	
	public String getColour() {
		return colour;
	}
	
	public void run () {
		System.out.println("����");
	}
	
	public String bark() {
		String str=colour+"ɫ"+"��ʨ�����ںӱߴ��";
		return str;
	}
	public static void main(String[] sa) {
		ccclion el=new ccclion();
		el.colour="����";
		
		el.run();
		String str2=el.bark();
		System.out.println(str2);
	}

}
