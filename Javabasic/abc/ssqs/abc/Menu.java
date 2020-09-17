package abc;

import java.util.Scanner;

public class Menu {
	
	public void showLoginMenu() {//显示登录页面方法
		
		System.out.println("欢迎登陆苏宁易购购物系统\n");
		System.out.println("\t1.登陆系统");
		System.out.println("\t2.退出");
		System.out.println("***********************");
		System.out.print("请选择，输入数字");
		boolean input;
		Scanner scanner=new Scanner(System.in);
		int ck=scanner.nextInt();
		do {
			input=false;
			if(ck==1) {
				showMainMenu();
			}
			else if(ck==2){
				
				System.out.println("谢谢您的使用。");
				
			}
			
		}while(input=true);

	}
	
	
	public void showMainMenu() {
		
		System.out.println("欢迎登陆苏宁易购主菜单/n");
		System.out.println("***********************");
		System.out.println("\t1.客户信息管理");
		System.out.println("\t2.真情回馈");
		System.out.println("***********************");
		System.out.print("请选择，输入数字或按0返回上一级菜单");
		boolean flag;

		do {
			
			flag=false;
			Scanner scan=new Scanner(System.in);
			int no=scan.nextInt();//选择页面
			
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
				System.out.print("输入错误，请重新输入。");
				
				flag=true;
			}
			
			
		}while(flag=true);
			
		
	}
	public void showCustMenu() {
		System.out.println("***********************");
		System.out.println("\t1.查询客户信息");
		System.out.println("\t2.修改客户信息");
		System.out.println("\t3.新增客户信息");
		System.out.println("\t4.删除客户信息");
		System.out.println("***********************");
		System.out.println("请选择，输入数字：");
		boolean lkl;
		
		do {
			lkl=false;
			
			Scanner jjj=new Scanner(System.in);
			int no=jjj.nextInt();
			
			if(no==1) {
				System.out.println("执行查询客户信息操作");
			}
			else if(no==2) {
				System.out.println("执行修改客户信息操作");
			}
			else if(no==3) {
				System.out.println("执行新增客户信息操作");
			}
			else if(no==4) {
				System.out.println("执行删除客户信息操作");
			}
			
		}while(lkl=true);
		
		
	
		}
	public void showSendMenu() {
		System.out.println("***********************");
		System.out.println("\t1.幸运抽奖");
		System.out.println("\t2.生日快乐");
		System.out.println("***********************");
		System.out.println("请选择，输入数字：");
		boolean one;
		
		do {
			
			one=false ;
			Scanner k=new Scanner(System.in);
			int in=k.nextInt();
			
			if(in==1) {
				System.out.println("执行幸运抽奖操作");
			}
			else if(in==2) {
				System.out.println("执行生日快乐操作");
			}
			
		}while(one=true);
		
		
		
	
	}
	
	
	


	
}
