package sss;
import java.util.Scanner;
public class h {
	
	

	
	

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scan =new Scanner(System.in);
	int num1=0;
	
	do {
	System.out.println("��ӭ����xx����ϵͳ��");
	System.out.println("y:��½");
	System.out.println("n:�˳�");
	String str=scan.next();
	switch(str)
	{
	case "y":
	int num2=0,num3=0;
	do {
	System.out.println("-----------------------------");
	System.out.println("1:��Ʒ����");
	System.out.println("2:�û�����");
	System.out.println("3:����");
	System.out.println("4:�齱");
	System.out.println("5:������һ���˵�");
	System.out.println("-----------------------------");
	num2=scan.nextInt();
	switch(num2)
	{
	case 1:

	{
	do {
	System.out.println("1:������Ʒ"); 
	System.out.println("3:�޸���Ʒ");
	System.out.println("4:��ѯ��Ʒ");
	System.out.println("5:������һ���˵�");
	num3=scan.nextInt();
	switch(num3)
	{
	case 1:
	System.out.println("1:������Ʒ");
	break;
	case 2:
	System.out.println("2:ɾ����Ʒ");
	break;
	case 3:
	System.out.println("3:�޸���Ʒ");
	break;
	case 4:
	System.out.println("4:��ѯ��Ʒ");
	break;
	case 5:
	System.out.println("5:������һ���˵�");
	break;
	}
	}while(num3!=0);
	}
	break;
	case 2:
	System.out.println("ִ�����û��������");
	break;
	case 3:
	System.out.println("ִ������˲���");
	break;
	case 4:
	System.out.println("ִ����齱����");
	break;
	case 5:
	System.out.println("���Ϸ�����һ���˵�");
	break;
	default:
	System.out.println("�������ֻ����1-5֮�������");
	}

	}
	while(num2!=0);
	break;
	case "n":
	break;
	default:
	System.out.println("������ˣ�ֻ������y/n");}
	}while(num1==0);
	}
	}


