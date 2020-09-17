package sss;
import java.util.Scanner;
public class h {
	
	

	
	

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner scan =new Scanner(System.in);
	int num1=0;
	
	do {
	System.out.println("欢迎进入xx购物系统！");
	System.out.println("y:登陆");
	System.out.println("n:退出");
	String str=scan.next();
	switch(str)
	{
	case "y":
	int num2=0,num3=0;
	do {
	System.out.println("-----------------------------");
	System.out.println("1:商品管理");
	System.out.println("2:用户管理");
	System.out.println("3:结账");
	System.out.println("4:抽奖");
	System.out.println("5:返回上一级菜单");
	System.out.println("-----------------------------");
	num2=scan.nextInt();
	switch(num2)
	{
	case 1:

	{
	do {
	System.out.println("1:新增商品"); 
	System.out.println("3:修改商品");
	System.out.println("4:查询商品");
	System.out.println("5:返回上一级菜单");
	num3=scan.nextInt();
	switch(num3)
	{
	case 1:
	System.out.println("1:新增商品");
	break;
	case 2:
	System.out.println("2:删除商品");
	break;
	case 3:
	System.out.println("3:修改商品");
	break;
	case 4:
	System.out.println("4:查询商品");
	break;
	case 5:
	System.out.println("5:返回上一级菜单");
	break;
	}
	}while(num3!=0);
	}
	break;
	case 2:
	System.out.println("执行完用户管理操作");
	break;
	case 3:
	System.out.println("执行完结账操作");
	break;
	case 4:
	System.out.println("执行完抽奖操作");
	break;
	case 5:
	System.out.println("马上返回上一级菜单");
	break;
	default:
	System.out.println("输入错误，只能是1-5之间的数字");
	}

	}
	while(num2!=0);
	break;
	case "n":
	break;
	default:
	System.out.println("你输错了，只能输入y/n");}
	}while(num1==0);
	}
	}


