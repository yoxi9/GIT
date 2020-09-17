package commonclass;

import java.text.DecimalFormat;

public class TestNumber {
    public static void main(String[] args) {
        Integer in1=new Integer(100);
        System.out.println(in1);
/*        System.out.println(in1.MAX_VALUE);
        System.out.println(in1.SIZE);*/
        Integer in2=new Integer("123");
        System.out.println(in2);


        int i1=in1;   //自动拆箱
        int i2=new Integer(100000);
        System.out.println(i2);

        Integer in3=5999;//自动装箱

        System.out.println(in3);

        System.out.println(Integer.toHexString(in3));//16进制
        System.out.println(Integer.toBinaryString(in3));//2进制

        Double db1=new Double(12.57900);
        System.out.println(db1);
        DecimalFormat df=new DecimalFormat(".000000");
        System.out.println(df.format(db1));//显示后面的0000

        Number num1=new Double(12.444);
        Number num2=new Byte((byte)15);

        System.out.println(num1.intValue());//得到其整值

        System.out.println(Double.toHexString(db1));//数字转成16进制
    }
}
