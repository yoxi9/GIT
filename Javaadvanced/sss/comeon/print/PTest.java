package print;

public class PTest {
	
	public static void main(String[] args) {
		
		
		
		Printer  black=new Black("SQS","黑白平面打印机");
		black.Printer();
		Customer cust=new Customer();
		cust.Submit(black);
		
		Printer  colour=new Black("SQS","彩色打印机");
		cust.Submit(colour);
		
		Printer  trd=new Black("SQS","三维彩色打印机");
		cust.Submit(trd);
		
	}

}
