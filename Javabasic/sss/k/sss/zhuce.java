package sss;
import java.util.Scanner;
public class zhuce {
	public static void mian(String[] args) {
		Scanner k=new Scanner(System.in);
		String name=null,pw=null,repw=null;
		System.out.println("�������û�����");
		name=k.next();
		if(name.length()>3) {
			System.out.print("����������");
			pw=k.next();
			if(pw.length()>=6) {
				System.out.println("���ٴ��������룺");
				
				repw=k.next();
	        if(pw.equals(repw)) {
	        	System.out.println("ע��ɹ�");
	        }
				
			}System.out.println("");
		}else {
			System.out.print("���벻ͬ��ע��ʧ��");
		}
		
		
		
		
		
		
		
		
	}
	
	

}
