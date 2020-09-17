package zuoye;

import java.util.Date;

public class GenericsMethod {
	
	public static <E> E getExactOne(E[] arr,int index) {
		return arr[index];
	}
	
	public static void main(String[] args) {
		Date[] datearr=new Date[5];
		
		datearr[0]=new Date(01,4,7);
		datearr[1]=new Date(00,11,8);
		datearr[2]=new Date(00,12,17);
		
		GenericsMethod gm=new GenericsMethod();
		Date datetemp=gm.getExactOne(datearr, 0);
		System.out.println(datetemp);
		
		Integer[] intarr=new Integer[] {1,2,3,4,5};
		int temp=gm.getExactOne(intarr, 2);
		System.out.println(temp);
		
	}

}
