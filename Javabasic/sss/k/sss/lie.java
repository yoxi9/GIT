package sss;

public class lie {
	public static void main(String[] args) {
		int[][] x=new int[10][5];
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<x[0].length;j++) {
				x[i][j]= (int)(100*Math.random());
			}
		}
	    
		x[9][4]=94;
		System.out.println(x);
		System.out.println(x[9]);
		System.out.println(x[9][4]);
		
		//二维数组的遍历
		//第一层，遍历的是，指向一维型数组的每个引用
		
		for(int[] row:x) {
			for(int element:row) {
				System.out.print(" "+element);
			}
			System.out.println("");
		}
	}

}
