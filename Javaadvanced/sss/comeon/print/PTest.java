package print;

public class PTest {
	
	public static void main(String[] args) {
		
		
		
		Printer  black=new Black("SQS","�ڰ�ƽ���ӡ��");
		black.Printer();
		Customer cust=new Customer();
		cust.Submit(black);
		
		Printer  colour=new Black("SQS","��ɫ��ӡ��");
		cust.Submit(colour);
		
		Printer  trd=new Black("SQS","��ά��ɫ��ӡ��");
		cust.Submit(trd);
		
	}

}
