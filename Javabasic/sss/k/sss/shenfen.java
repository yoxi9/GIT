package sss;
import java.util.Scanner;
public class shenfen {
	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("���������֤�ţ�");
	String identity=scan.next();
	String year=identity.substring(6,10);
	String month=identity.substring(10,12);
	String date=identity.substring(12,14);
	
	System.out.println("��������Ϊ"+year+"��"+month+"��"+date+"��");
   }
}