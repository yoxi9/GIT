package sss;
import java.util.Scanner;
public class cg {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int c=0;
		int x=32;
		int k=0;
		int l=0;
		
		while(l<10&&c<=250) {
			c=c+20;
			k=c*9/5+x;
			System.out.printf("%c摄氏度转化为%f\n华氏度",c,k);
			
			
			
		}
	}

}
