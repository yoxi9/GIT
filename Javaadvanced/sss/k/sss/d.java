package sss;
import java.util.Arrays;
public class d {
	public static void main(String[] args) {
		double[] douarr = new double[] { 2.0, 4.0, 1.59, 13.5, 1.7 };
		for (int i = 0; i < douarr.length; i++) {
			System.out.print(" " + douarr[i]);
		}
		System.out.println();
				Arrays.sort(douarr);

		for (double x : douarr) {
			System.out.print(" " + x);
		}

		double temp = douarr[0];
		int index = 0;
		for (int i = 0; i < douarr.length; i++) {
			double min = douarr[i];
			index = i;
			int j = i + 1;

			if (i != douarr.length - 1) {
				for (; j < douarr.length; j++) {
					if (min > douarr[j]) {
						min = douarr[j];
						index = j;
					}
				}
				if (index != i) {
					double temp1 = douarr[i];
					douarr[i] = douarr[index];
					douarr[index] = temp1;
				}
			}
		}
		
		for (double x : douarr){ 
			System.out.print(" " + x); 
		}	
	}

}
