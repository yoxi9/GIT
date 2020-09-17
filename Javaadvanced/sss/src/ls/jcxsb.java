package ls;
import java.util.Scanner;
public class jcxsb {
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入四位会员卡号");
		int eat=scan.nextInt();
		System.out.println("消费总金额为"+eat);
		
		int q=eat%10;
		int w=eat/10%10;
		int e=eat/100%10;
		int r=eat/1000;
		System.out.println("积分="+(int)((r*1000+e*100+w*10+q)*0.03));
		
		
		
		
	}

}
