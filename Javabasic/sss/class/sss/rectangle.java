package sss;
import java.util.Scanner;
public class rectangle {
	
	
	public void inprint() {
		Scanner scan=new Scanner(System.in);
		System.out.print("请输入长方形的长:");
		int chang=scan.nextInt();
		
		System.out.print("请输入长方形的宽:");
		int kuan=scan.nextInt();
		
		System.out.println("面积="+chang*kuan);
		
		
	}

}
