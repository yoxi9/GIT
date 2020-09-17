package ls;

public class jt {
	public static void main(String[] args) {
		int t=1;
		int j=1;
		int c=94;
		for(;t<35&&j<35;t++) {
			j=35-t;
			c=2*j+4*t;
			if((t+j)==35&&4*t+2*j==94) {
				break;
				
			}
		}
		System.out.println("鸡有"+j+"只"+"兔有"+t+"只");
		
	}

}
