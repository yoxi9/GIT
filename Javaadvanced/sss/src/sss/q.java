package sss;
import java.util.Scanner;
public class q {    
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		boolean firstflag = true;
		int noo=0;
		int nos=5;
		int not=5;
		do {
			System.out.println("��ӭʹ��MyShopping����ϵͳ");
			System.out.println("1����½");
			System.out.println("2���˳�");
			System.out.println("��ѡ���������֣�");
			noo=scan.nextInt();
			switch(noo) {
			
			case 1:
				
				do {
					System.out.println("------------------");
					System.out.println("\t1:��Ʒ����");
					System.out.println("\t2:�������");
					System.out.println("\t3:�������");
					System.out.println("\t4:ע��");
					System.out.println("\t5:������һ���˵�");
					System.out.println("------------------");
					System.out.println("��ѡ���������֣�");
					nos=scan.nextInt();
					switch(nos) {
					
					case 1:
						System.out.println("������Ʒ����˵�");
						do {
							System.out.println("\t1.������Ʒ");
							System.out.println("\t2.ɾ����Ʒ");
							System.out.println("\t3.�޸���Ʒ");
							System.out.println("\t4.��ѯ��Ʒ");
							System.out.println("\t5.������һ���˵�");
							System.out.println("��ѡ����������:");
					not=scan.nextInt();
					switch(not) {
					case 1:
					    System.out.println("������Ʒ");
					        break;
					case 2:
						System.out.println("ɾ����Ʒ");
						    break;
					case 3:
						System.out.println("�޸���Ʒ");
						    break;
					case 4:
					    System.out.println("��ѯ��Ʒ");
					        break;
					case 5:
						
						    break;
					default:
						System.out.println("��������������1~5֮�����");
						    break;
						    
					}
						}
						while(not!=5);
						
					
					break;
				    case 2:
					System.out.println("�������");
					break;
					case 3:
					System.out.println("�������");
					break;
					case 4:
					System.out.println("ע��");
					break;
					case 5:
					System.out.println("������һ���˵�");
					nos=5;
					break;
					default:
					System.out.println("��������������1~5֮�����");
					
			}
				
				
			
			
		}
			while(nos!=5&&not==5);
			break;
			case 2:
				firstflag = false;
				break;
			default:
				System.out.println("����ò��ԣ�����������");
			
	}
		
		}while (firstflag == true && nos==5);
		System.out.println("������");
}
}		
