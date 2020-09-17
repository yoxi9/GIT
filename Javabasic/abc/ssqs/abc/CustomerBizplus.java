package abc;

import java.util.Scanner;

public class CustomerBizplus {
	
	public static void main(String[] args) {
		
		boolean begin=true;
		CustomerBiz CB=new CustomerBiz();
		do {
			
			System.out.println("请输入客户姓名：");
			Scanner scan=new Scanner(System.in);
			String name=scan.next();
			CB.addnames(name);
			System.out.println("是否继续添加姓名Y/N：");
			Scanner input=new Scanner(System.in);
			String word=input.next();
			if(word.equals("N")) {
				begin=false;
			}
			
			
		}while(begin);
		CB.shownames();
	}
	
	

}
