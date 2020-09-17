package abc;
import java.util.Scanner;
public class Menuplus {
	public static void main(String[] args){
		boolean flag=true;
	do{
		
	
	Menu menu=new Menu();
	
	menu.showLoginMenu();
	Scanner input=new Scanner(System.in);
	int no=input.nextInt();
	switch(no){
	case 1:
		menu.showMainMenu();
		break;
	case 2:
    	System.out.println("–ª–ª π”√");
       flag=false;
	}
	
	
	
	}while(flag);
	
	}

}
