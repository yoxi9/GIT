package abc;

import java.util.Scanner;

public class Menu {
	
	public void showLoginMenu() {//��ʾ��¼ҳ�淽��
		
		System.out.println("��ӭ��½�����׹�����ϵͳ\n");
		System.out.println("\t1.��½ϵͳ");
		System.out.println("\t2.�˳�");
		System.out.println("***********************");
		System.out.print("��ѡ����������");
		boolean input;
		Scanner scanner=new Scanner(System.in);
		int ck=scanner.nextInt();
		do {
			input=false;
			if(ck==1) {
				showMainMenu();
			}
			else if(ck==2){
				
				System.out.println("лл����ʹ�á�");
				
			}
			
		}while(input=true);

	}
	
	
	public void showMainMenu() {
		
		System.out.println("��ӭ��½�����׹����˵�/n");
		System.out.println("***********************");
		System.out.println("\t1.�ͻ���Ϣ����");
		System.out.println("\t2.�������");
		System.out.println("***********************");
		System.out.print("��ѡ���������ֻ�0������һ���˵�");
		boolean flag;

		do {
			
			flag=false;
			Scanner scan=new Scanner(System.in);
			int no=scan.nextInt();//ѡ��ҳ��
			
			if(no==1) {
				
				showCustMenu();
				
			}
			else if(no==2) {
				
				showSendMenu();
			
			}
			else if(no==0) {
				
				showLoginMenu();
				
			}
			else {
				Scanner input=new Scanner(System.in); 
				System.out.print("����������������롣");
				
				flag=true;
			}
			
			
		}while(flag=true);
			
		
	}
	public void showCustMenu() {
		System.out.println("***********************");
		System.out.println("\t1.��ѯ�ͻ���Ϣ");
		System.out.println("\t2.�޸Ŀͻ���Ϣ");
		System.out.println("\t3.�����ͻ���Ϣ");
		System.out.println("\t4.ɾ���ͻ���Ϣ");
		System.out.println("***********************");
		System.out.println("��ѡ���������֣�");
		boolean lkl;
		
		do {
			lkl=false;
			
			Scanner jjj=new Scanner(System.in);
			int no=jjj.nextInt();
			
			if(no==1) {
				System.out.println("ִ�в�ѯ�ͻ���Ϣ����");
			}
			else if(no==2) {
				System.out.println("ִ���޸Ŀͻ���Ϣ����");
			}
			else if(no==3) {
				System.out.println("ִ�������ͻ���Ϣ����");
			}
			else if(no==4) {
				System.out.println("ִ��ɾ���ͻ���Ϣ����");
			}
			
		}while(lkl=true);
		
		
	
		}
	public void showSendMenu() {
		System.out.println("***********************");
		System.out.println("\t1.���˳齱");
		System.out.println("\t2.���տ���");
		System.out.println("***********************");
		System.out.println("��ѡ���������֣�");
		boolean one;
		
		do {
			
			one=false ;
			Scanner k=new Scanner(System.in);
			int in=k.nextInt();
			
			if(in==1) {
				System.out.println("ִ�����˳齱����");
			}
			else if(in==2) {
				System.out.println("ִ�����տ��ֲ���");
			}
			
		}while(one=true);
		
		
		
	
	}
	
	
	


	
}
