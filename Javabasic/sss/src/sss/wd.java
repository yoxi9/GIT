package sss;
import java.util.Scanner;
public class wd {
	public static void main(String[] args) {
		
		
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入摄氏度");
		int s=scan.nextInt();
		System.out.println("摄氏度为"+s);
		
		int x=32;
		int h=(s*9/5)+x;
		
		System.out.println("华氏度为"+h);
		
	}
}
