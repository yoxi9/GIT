package swingdome;

//设计会员登记录入界面
import java.awt.*;//引用
import javax.swing.*;


public class v {
public static void main(String[] args) {
JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10;// 声明标签组件
JComboBox cb1, cb2;
String[] sj = { "2017-12-10" };// 声明下拉列表框组件
String[] sf = { "是", "否" };// 声明下拉列表框组件
JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;// 声明文本组件
JFrame jf = new JFrame("会员登记录入");
jf.setVisible(true);// 设置窗体可见
jf.setSize(500, 200);// 设置窗口初显大小
jf.setLocationRelativeTo(null);


JPanel jp = new JPanel();
jp.setLayout(new BorderLayout(5, 0));// 构造一个边界布局
JPanel jpTop = new JPanel();
jpTop.setLayout(new FlowLayout());// 构造一个流布局


JPanel jpcenter = new JPanel();
jpcenter.setLayout(new GridLayout(4, 2, 5, 5));// 构造一个网格布局


JPanel jpbottom = new JPanel();
jpbottom.setLayout(new GridLayout(1, 2, 5, 5));// 构造一个网格布局


lb1 = new JLabel("会员登记录入");// 创建组件并赋值
lb2 = new JLabel("办卡日期");
lb3 = new JLabel("会员卡号条形码");
lb4 = new JLabel("姓名");
lb5 = new JLabel("性别");
lb6 = new JLabel("联系电话");
lb7 = new JLabel("类型");
lb8 = new JLabel("折扣");
lb9 = new JLabel("是否挂失");
lb10 = new JLabel("工作单位");


cb1 = new JComboBox(sj);
cb2 = new JComboBox(sf);


tf1 = new JTextField("199802225210");
tf2 = new JTextField("BOB");
tf3 = new JTextField("MAN");
tf4 = new JTextField("1955214555021");
tf5 = new JTextField("普通会员");
tf6 = new JTextField("0.9");
tf7 = new JTextField("东北公司");


jpTop.add(lb1);// 把组件添加到面板上
jpcenter.add(lb2);
jpcenter.add(cb1);
jpcenter.add(lb3);
jpcenter.add(tf1);
jpcenter.add(lb4);
jpcenter.add(tf2);
jpcenter.add(lb5);
jpcenter.add(tf3);
jpcenter.add(lb6);
jpcenter.add(tf4);
jpcenter.add(lb7);
jpcenter.add(tf5);
jpcenter.add(lb8);
jpcenter.add(tf6);
jpcenter.add(lb9);
jpcenter.add(cb2);
jpbottom.add(lb10);
jpbottom.add(tf7);
jp.add(jpTop, BorderLayout.NORTH);
jp.add(jpcenter, BorderLayout.CENTER);
jp.add(jpbottom, BorderLayout.SOUTH);
jf.add(jp);


}


}