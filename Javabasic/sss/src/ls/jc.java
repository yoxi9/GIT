package ls;

public class jc {
	public static void main(String[] args) {
		int x=1;
		int y=1;
		
		for(;x>=1&&x<=10;x++) {
			y=y*x;
			
			if(y>400) {
				System.out.println("1��10�У��׳˴���400����Ȼ��Ϊ"+x);
				break;
			}
		}
	}

}
