package sss;

import java.util.Scanner;

public class scoreplus {
	
public static void mian(String[] args) {
		
		score score1=new score();//�������
		
		Scanner scan=new Scanner(System.in);//����Ļ�����ַ�
		
		System.out.println("������a�ɼ���");
		
		score1.ascore=scan.nextFloat();//����a�ɼ�
		
        System.out.println("������b�ɼ���");
		
		score1.bscore=scan.nextFloat();//����b�ɼ�
		
        System.out.println("������c�ɼ���");
		
		score1.cscore=scan.nextFloat();//����c�ɼ�
		
		score1.sum();
		score1.ave();
		score1.showsum();
		score1.showave();

}
}
