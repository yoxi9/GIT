package shishishi;
import java.text.SimpleDateFormat;
	import java.util.Date;

	

	public class Test13 {
	    public static void main(String[] args) {
	        Date now = new Date(); // ����һ��Date���󣬻�ȡ��ǰʱ��
	        // ָ����ʽ����ʽ
	        SimpleDateFormat f = new SimpleDateFormat("yyyy�� MM �� dd �� E HH �� mm �� ss ��");
	        System.out.println(f.format(now)); // ����ǰʱ����ʽ��Ϊָ���ĸ�ʽ
	    }


}
