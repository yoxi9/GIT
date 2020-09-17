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
			System.out.println("————————————");
			System.out.println("\t y.登录系统");
			System.out.println("\t n.退出");
			System.out.println("———————————");
			System.out.println("请输入y/n.");
			input = scan.next();

			switch (input) 
			{
			case "y":

				do 
				{
					System.out.println("------------");
					System.out.println("\t1.进入客户管理菜单");
					System.out.println("\t2.结账");
					System.out.println("\t3.真情回馈");
					System.out.println("\t0.返回上级菜单");
					System.out.println("请输入相关数字：");
					secondNum = scan.nextInt();
					switch (secondNum) 
					{
					case 1:
						System.out.println("进入客户管理菜单");
						do
						{
							System.out.println("\t1.新增商品");
							System.out.println("\t2.删除商品");
							System.out.println("\t3.修改商品");
							System.out.println("\t4.查询商品");
							System.out.println("\t0.返回上级菜单");
							System.out.println("请输入相关数字：");
							thirdNum=scan.nextInt();
							switch (thirdNum) 
							{
							case 0:
								System.out.println("返回上一级菜单");
								thirdNum=0;
								break;
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
							default:
							System.out.println("输入有误，请输入0-4之间的数");
							break;
									}
						}
						   while (thirdNum != 0);
							break;
					case 2:
						System.out.println("结账");
						break;
					case 3:
						System.out.println("真情回馈");
						break;
					case 0:
						System.out.println("返回上级菜单");
						secondNum=0;
						break;
					default:
							System.out.println("输入有误，请输入0-3之间的数字");
				   }
 
				}while (secondNum!=0 && thirdNum==0);
				break;
			case "n":
				firstflag = false;
				break;
			default:
				System.out.println("你输的不对,请尝试重新输入");
			}
		} while (firstflag == true && secondNum==0);
		System.out.println("结束了");
	}
}
