package sss;
import java.util.Scanner;
import java.util.Random;
public class chengji {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		Random rand=new Random();
		int k=(int) (2 * rand.nextDouble() + 3);
		int [][] scores=new int[5][k];
		double sum[]=new double[5];
		double ave[]=new double[5];
		for(int i=0;i<scores.length;i++) {
			double max=0 ;
			double min=999;
			sum[i] = 0;
			ave[i] = 0;
			for(int j=0;j<scores[i].length;j++) {
				System.out.println("请输入该班级第" + (i + 1) + "个学生;第" + (j + 1) + "门功课的成绩:");
				scores[i][j] = scan.nextInt();
				sum[i]+=scores[i][j];
				ave[i]=sum[i]/(scores.length);
				
				if (scores[i][j] >max) {
					max = scores[i][j];
				}
				
				if (scores[i][j] < min) {
					min = scores[i][j];
				}
			}	
			System.out.println("第" + (i + 1) + "个学生的总分是" + sum[i] + "\t平均分数为" + ave[i] + "\t最高分为" + max + "\t最低分为" + min);
			
		
	}

}
	
}
