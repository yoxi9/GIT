package sss;
import java.util.Scanner;
public class shengri {
	public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("请输入生日日期");
	String k=scan.next();
	String[] date=k.split("/");
	boolean no1=date[0].matches("\\d{2}");
	boolean no2=date[1].matches("\\d{2}");
	if(no1==true&&no2==true) {
		System.out.println("bingo");
	}else {
		System.out.println("sorry");
	}

}
}