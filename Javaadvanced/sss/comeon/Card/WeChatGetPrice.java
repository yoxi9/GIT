package Card;

import java.util.Random;

public class WeChatGetPrice {
	
	public static void main(String[] args) {
		
		int[] weights=new int[40];
		
		Random R=new Random();
		
		int sum=0;
		
		for(int i=0;i<weights.length;i++) {
		    weights[i]=R.nextInt(50);
		    sum+=weights[i];
		    System.out.println(sum);
		}
		
		for(int x=0;x<weights.length;x++) {
			double price=Math.floor((double)weights[x]/(double)sum*50*100)/100;
			
			System.out.println(price);
		}
	}/*"第"+(x+1)+"位同学抢到金额为"+*/

}
