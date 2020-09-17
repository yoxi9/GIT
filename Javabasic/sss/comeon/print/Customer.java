package print;

public class Customer {
	
	public void Submit(Printer pt) {
		
		if(pt instanceof Black) {
			
			Black B=(Black)pt;
			B.print();
			
		}else
			
		if(pt instanceof Colour) {
			
			Colour C=(Colour)pt;
			C.print();
			
		}else 
			
		if(pt instanceof Trd) {
			Trd T=(Trd)pt;
			T.print();
			
			
			
			
		}
	}

}
