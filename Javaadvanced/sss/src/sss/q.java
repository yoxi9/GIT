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
			System.out.println("欢迎使用MyShopping管理系统");
			System.out.println("1：登陆");
			System.out.println("2：退出");
			System.out.println("请选择，输入数字：");
			noo=scan.nextInt();
			switch(noo) {
			
			case 1:
				
				do {
					System.out.println("------------------");
					System.out.println("\t1:商品管理");
					System.out.println("\t2:购物结算");
					System.out.println("\t3:真情回馈");
					System.out.println("\t4:注销");
					System.out.println("\t5:返回上一级菜单");
					System.out.println("------------------");
					System.out.println("请选择，输入数字：");
					nos=scan.nextInt();
					switch(nos) {
					
					case 1:
						System.out.println("进入商品管理菜单");
						do {
							System.out.println("\t1.新增商品");
							System.out.println("\t2.删除商品");
							System.out.println("\t3.修改商品");
							System.out.println("\t4.查询商品");
							System.out.println("\t5.返回上一级菜单");
							System.out.println("请选择，输入数字:");
					not=scan.nextInt();
					switch(not) {
					case 1:
					    System.out.println("新增商品");
					        break;
					case 2:
						System.out.println("删除商品");
						    break;
					case 3:
						System.out.println("修改商品");
						    break;
					case 4:
					    System.out.println("查询商品");
					        break;
					case 5:
						
						    break;
					default:
						System.out.println("输入有误，请输入1~5之间的数");
						    break;
						    
					}
						}
						while(not!=5);
						
					
					break;
				    case 2:
					System.out.println("购物结算");
					break;
					case 3:
					System.out.println("真情回馈");
					break;
					case 4:
					System.out.println("注销");
					break;
					case 5:
					System.out.println("返回上一级菜单");
					nos=5;
					break;
					default:
					System.out.println("输入有误，请输入1~5之间的数");
					
			}
				
				
			
			
		}
			while(nos!=5&&not==5);
			break;
			case 2:
				firstflag = false;
				break;
			default:
				System.out.println("你输得不对，请重新输入");
			
	}
		
		}while (firstflag == true && nos==5);
		System.out.println("结束了");
}
}		
