package ls;

import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

public class sqs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "y";
		boolean firstflag = true;
		int secondNum=0;
		int thirdNum =0;
		do {
			System.out.println("������������������������");
			System.out.println("\t y.��¼ϵͳ");
			System.out.println("\t n.�˳�");
			System.out.println("����������������������");
			System.out.println("������y/n.");
			input = scan.next();

			switch (input) 
			{
			case "y":

				do 
				{
					System.out.println("------------");
					System.out.println("\t1.����ͻ�����˵�");
					System.out.println("\t2.����");
					System.out.println("\t3.�������");
					System.out.println("\t0.�����ϼ��˵�");
					System.out.println("������������֣�");
					secondNum = scan.nextInt();
					switch (secondNum) 
					{
					case 1:
						System.out.println("����ͻ�����˵�");
						do
						{
							System.out.println("\t1.������Ʒ");
							System.out.println("\t2.ɾ����Ʒ");
							System.out.println("\t3.�޸���Ʒ");
							System.out.println("\t4.��ѯ��Ʒ");
							System.out.println("\t0.�����ϼ��˵�");
							System.out.println("������������֣�");
							thirdNum=scan.nextInt();
							switch (thirdNum) 
							{
							case 0:
								System.out.println("������һ���˵�");
								thirdNum=0;
								break;
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
							default:
							System.out.println("��������������0-4֮�����");
							break;
									}
						}
						   while (thirdNum != 0);
							break;
					case 2:
						System.out.println("����");
						break;
					case 3:
						System.out.println("�������");
						break;
					case 0:
						System.out.println("�����ϼ��˵�");
						secondNum=0;
						break;
					default:
							System.out.println("��������������0-3֮�������");
				   }
 
				}while (secondNum!=0 && thirdNum==0);
				break;
			case "n":
				firstflag = false;
				break;
			default:
				System.out.println("����Ĳ���,�볢����������");
			}
		} while (firstflag == true && secondNum==0);
		System.out.println("������");
	}
}
