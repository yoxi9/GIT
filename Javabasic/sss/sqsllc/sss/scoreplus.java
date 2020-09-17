package sss;

import java.util.Scanner;

public class scoreplus {
	
public static void mian(String[] args) {
		
		score score1=new score();//定义对象
		
		Scanner scan=new Scanner(System.in);//从屏幕读入字符
		
		System.out.println("请输入a成绩：");
		
		score1.ascore=scan.nextFloat();//读入a成绩
		
        System.out.println("请输入b成绩：");
		
		score1.bscore=scan.nextFloat();//读入b成绩
		
        System.out.println("请输入c成绩：");
		
		score1.cscore=scan.nextFloat();//读入c成绩
		
		score1.sum();
		score1.ave();
		score1.showsum();
		score1.showave();

}
}
