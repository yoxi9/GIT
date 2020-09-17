package ls;
import java.util.Scanner;
public class q {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入月份：");
		int y=scan.nextInt();
		boolean f=y>4&&y<11&&y>=1&&y<=2;
		
		System.out.println("是否乘坐经济舱：是（7）/否（8）");
		int m=scan.nextInt();
		boolean j=m==7;
		double q=800.0,k=1500.0;
		
		if(f) {
			if(j) {System.out.println("票价为："+q*1.2);
			
			}else {System.out.println("票价为："+k*1.1);
			
			}
			
			
		}else {
			if(j) {System.out.println("票价为："+q*0.5);
		}else {System.out.println("票价为："+k*0.7);
		
		}
	}
	

	}
}