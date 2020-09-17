package sss;

public class ccclion {
	String colour;
	
	public String getColour() {
		return colour;
	}
	
	public void run () {
		System.out.println("跑来");
	}
	
	public String bark() {
		String str=colour+"色"+"的狮子正在河边大吼";
		return str;
	}
	public static void main(String[] sa) {
		ccclion el=new ccclion();
		el.colour="土黄";
		
		el.run();
		String str2=el.bark();
		System.out.println(str2);
	}

}
