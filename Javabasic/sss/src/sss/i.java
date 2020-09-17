package sss;

public class i {
	public static void main(String[] args) {
		int x=0;
		int sum=0;
		for(;x<1000;x++) {
			if(x%3!=0) {
				continue;
			    
			}
			sum+=x;
			if(sum>5000) {
				break;
			}
			
		}System.out.println("ºÍÎª"+sum);
	}

}
