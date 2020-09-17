package sss;
import java.util.Scanner;
public class bei {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int x=0;
		boolean d=false;
		do {
			d=false;
			System.out.println("欢迎，请输入指令1~7显示英文缩写");
			x=scan.nextInt();
			switch(x) {
			case 0:
				d=true;
				break;
			case 1:
				System.out.println("Mon");
				break;
			case 2:
				System.out.println("Tues");
				break;
			case 3:
				System.out.println("wed");
				break;
			case 4:
				System.out.println("Thur");
				break;
			case 5:
				System.out.println("Fir");
				break;
			case 6:
				System.out.println("Sat");
				break;
			case 7:
				System.out.println("Sun");
				break;
			default:
				System.out.println("输错了，请重新输入");
				break;
			}
			
		}while(d==false);
		System.out.println("退出");
		
	}
	

}
