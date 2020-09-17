package sss;

public class yanghui {
	public static void main(String[] args) {
		/*Scanner scan=new Scanner(System.in);
		System.out.println("ÇëÊäÈëĞĞÊı£º");
		int r=scan.nextInt();*/
		int[][] yanghui=new int[4][];
		for(int i=0;i<yanghui.length;i++) {
			yanghui[i]=new int[i+1];
			for(int j=0;j<yanghui[i].length;j++) {
				if(j==0||j==yanghui[i].length-1) {
					yanghui[i][j]=1;
					
				}
				else {
					yanghui[i][j]=yanghui[i-1][j]+yanghui[i-1][j-1];
				}
				System.out.print(" e"+yanghui[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
