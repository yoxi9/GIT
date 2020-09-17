package sss;

public class hh {
	 public static void main(String[] args)
	 {
	  int[][] pas = new int[6][];
	  for(int i = 0; i < pas.length; i++)
	  {
	   pas[i] = new int[i + 1];
	   pas[i][0] = 1;
	   pas[i][i] = 1;
	   for(int j = 0; j < pas[i].length - 1; j++)
	   {

	    if(j >= 1 && i > 1)
	    {
	     pas[i][j] = pas[i - 1][j - 1] + pas[i - 1][j];
	    }

	   }
	  }
	  for(int i = 0; i < pas.length; i++)
	  {
	   for(int j = 0; j < pas.length - pas[i].length; j++)
	   {
	    System.out.print(" ");
	   }
	   for(int j = 0; j < pas[i].length; j++)
	   {
	    System.out.print(pas[i][j]);
	    System.out.print(" ");

	   }
	   System.out.println();

	  }
	 }

}
