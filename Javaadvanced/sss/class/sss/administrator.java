package sss;

import java.util.Scanner;

public class administrator {
	String username;
	String password;
	
	
	public void printInfo() {
		System.out.println("---------");
		System.out.println("�û���:"+username);
		System.out.println("����:"+password);
		System.out.println("---------");
		
	}		
		public void cprint() {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("�������û���");
		String name=scan.next();
		
		System.out.println("����������");
		String pass=scan.next();
		
		if(name.equals(username)&&pass.equals(password)) {
			System.out.println("������������");
			String repassword=scan.next();
			pass=repassword;
			System.out.println("����û������ɹ�");
		}else {
			System.out.println("�������гɹ�");
		}
	}
	}

