package sss;
import java.util.Scanner;
public class ww {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		double lqq=1000.0;
		int dqq=0;
		
		while(lqq>5) {
			lqq=lqq/2;
			dqq++;
			System.out.printf("第%d天的长度为%f\n",dqq,lqq);
			
		}
		System.out.printf("第%d天的长度为%f\n",dqq,lqq);
		
	}

}
