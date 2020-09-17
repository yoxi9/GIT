package ls;

public class jc {
	public static void main(String[] args) {
		int x=1;
		int y=1;
		
		for(;x>=1&&x<=10;x++) {
			y=y*x;
			
			if(y>400) {
				System.out.println("1到10中，阶乘大于400的自然数为"+x);
				break;
			}
		}
	}

}
