package ls;
import java.util.Scanner;
public class j {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("������ɼ���");
		int s=scan.nextInt();
		
		if(s>=85) {
			System.out.println("�ɼ����㣬������������һ��");
		}else if(s>=80) {
			System.out.println("�ɼ����ã�������ӰƱ����");
		}else if(s>=70) {
			System.out.println("�ɼ��еȣ�����ϰ��һ��");
		}else if(s>=60) {
			System.out.println("�ɼ����񣬽����Ծ�һ��");
		}else {
			System.out.println("�ɼ������񣬽���һ���������");
			
		}
		
	}

}
