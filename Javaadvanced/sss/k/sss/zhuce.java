package sss;
import java.util.Scanner;
public class zhuce {
	public static void mian(String[] args) {
		Scanner k=new Scanner(System.in);
		String name=null,pw=null,repw=null;
		System.out.println("请输入用户名：");
		name=k.next();
		if(name.length()>3) {
			System.out.print("请输入密码");
			pw=k.next();
			if(pw.length()>=6) {
				System.out.println("请再次输入密码：");
				
				repw=k.next();
	        if(pw.equals(repw)) {
	        	System.out.println("注册成功");
	        }
				
			}System.out.println("");
		}else {
			System.out.print("密码不同，注册失败");
		}
		
		
		
		
		
		
		
		
	}
	
	

}
