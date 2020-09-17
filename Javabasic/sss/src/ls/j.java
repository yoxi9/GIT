package ls;
import java.util.Scanner;
public class j {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入成绩：");
		int s=scan.nextInt();
		
		if(s>=85) {
			System.out.println("成绩优秀，奖励出国旅游一次");
		}else if(s>=80) {
			System.out.println("成绩良好，奖励电影票两张");
		}else if(s>=70) {
			System.out.println("成绩中等，奖励习题一本");
		}else if(s>=60) {
			System.out.println("成绩及格，奖励试卷一套");
		}else {
			System.out.println("成绩不及格，奖励一个大耳刮子");
			
		}
		
	}

}
