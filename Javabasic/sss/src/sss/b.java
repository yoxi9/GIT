package sss;

public class b {
	public static void main(String[] args) {
		int sum=0;
		for(int j=1;j<5;j++) {
			sum=0;
			System.out.printf("%d,%d\n",j,sum);
			for(int i=0;i<=10;i++) {
				if(i%2!=0) {
					continue;
				}
				sum+=1;
				System.out.printf("%d,%d\n",j,sum);
				
			}
		}
	}

}
