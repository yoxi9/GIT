package abc;

import java.util.Scanner;

public class CustomerBizplus {
	
	public static void main(String[] args) {
		
		boolean begin=true;
		CustomerBiz CB=new CustomerBiz();
		do {
			
			System.out.println("������ͻ�������");
			Scanner scan=new Scanner(System.in);
			String name=scan.next();
			CB.addnames(name);
			System.out.println("�Ƿ�����������Y/N��");
			Scanner input=new Scanner(System.in);
			String word=input.next();
			if(word.equals("N")) {
				begin=false;
			}
			
			
		}while(begin);
		CB.shownames();
	}
	
	

}
