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
				System.out.println("������ð༶��" + (i + 1) + "��ѧ��;��" + (j + 1) + "�Ź��εĳɼ�:");
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
			System.out.println("��" + (i + 1) + "��ѧ�����ܷ���" + sum[i] + "\tƽ������Ϊ" + ave[i] + "\t��߷�Ϊ" + max + "\t��ͷ�Ϊ" + min);
			
		
	}

}
	
}
