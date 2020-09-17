package sss;
import java.util.Arrays;
public class mmm {
	
	

	

		public static void main(String[] args) {
		double[] x= {2.0, 4.0, 15.9, 13.5, 2.7,3.0,3.5,0.0};
	        int i=0;
	        System.out.println("原数组为：");
	    for(i=0;i<x.length;i++)
	    {
	        System.out.print(x[i]+" ");
	    }
		System.out.println("\n赋值后各元素值（逆序）：");
		for(int j=x.length-1;j>=0; j--) 
		{
			if(x[j]<0) {
				x[j]=0;
			}
			System.out.print(" "+x[j]);
		}
		}
	}


	

