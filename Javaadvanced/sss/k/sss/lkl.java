package sss;
import java.util.Random;
import java.util.Scanner;
public class lkl {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			Random rand = new Random();
			int k = (int) (2 * rand.nextDouble() + 3);
			double[][] arr= new double[5][k];
			double[] sum = new double[5];
			double[] average = new double[5];
			for (int i = 0; i < arr.length; i++) 
			{
				double max=0 ;
				double min=999;
				sum[i] = 0;
				average[i] = 0;
				for (int j = 0; j < arr[i].length; j++) 
				{
					System.out.println("请输入该班级第" + (i + 1) + "个学生;第" + (j + 1) + "门功课的成绩:");
					arr[i][j] = scan.nextInt();
					
					
					
					sum[i] += arr[i][j];
					
					average[i] = sum[i] / (arr[i].length);
					
					if (arr[i][j] >max) {
						max = arr[i][j];
					}
					
					if (arr[i][j] < min) {
						min = arr[i][j];
					}
				}
				System.out.println("第" + (i + 1) + "个学生的总分是" + sum[i] + "\t平均分数为" + average[i] + "\t最高分为" + max + "\t最低分为" + min);

			}
		}

	}



