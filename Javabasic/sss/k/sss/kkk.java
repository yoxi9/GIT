package sss;
import java.util.Scanner;


public class kkk {
	

	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        int[] Num=new int[10];
	        int x=0;
	        int y=0;
	        int z=0;
	        int b=0;
	        Scanner scan=new Scanner(System.in);
	        System.out.println("请输入10个数字");
	        for(int i=0;i<Num.length;i++) {
	        	Num[i]=scan.nextInt();
	        }
	        for(int i=0;i<Num.length;i++)
	        {
	        switch (Num[i]) {
			case 1:
				x+=1;
				break;
			case 2:
				y+=1;
			    break;
			case 3:
				z+=1;
				break;
			default:
				b=10-x-y-z;
				break;
			}
	        }
	      	System.out.println("合法数字1的个数为："+x);
	      	System.out.println("合法数字2的个数为："+y);
	      	System.out.println("合法数字3的个数为："+z);
	      	System.out.println("非法数字的个数为："+b);
	  
		}

	}



