package sss;

import java.util.Scanner;

public class administrator {
	String username;
	String password;
	
	
	public void printInfo() {
		System.out.println("---------");
		System.out.println("用户名:"+username);
		System.out.println("密码:"+password);
		System.out.println("---------");
		
	}		
		public void cprint() {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入用户名");
		String name=scan.next();
		
		System.out.println("请输入密码");
		String pass=scan.next();
		
		if(name.equals(username)&&pass.equals(password)) {
			System.out.println("请输入新密码");
			String repassword=scan.next();
			pass=repassword;
			System.out.println("密码没有输出成功");
		}else {
			System.out.println("密码米有成功");
		}
	}
	}

