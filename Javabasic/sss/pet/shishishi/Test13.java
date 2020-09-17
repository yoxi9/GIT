package shishishi;
import java.text.SimpleDateFormat;
	import java.util.Date;

	

	public class Test13 {
	    public static void main(String[] args) {
	        Date now = new Date(); // 创建一个Date对象，获取当前时间
	        // 指定格式化格式
	        SimpleDateFormat f = new SimpleDateFormat("yyyy年 MM 月 dd 日 E HH 点 mm 分 ss 秒");
	        System.out.println(f.format(now)); // 将当前时间袼式化为指定的格式
	    }


}
