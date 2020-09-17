package swingdemo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Demo01_SimpleFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        JFrame jf=new JFrame("窗口1");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //获取jframe中的内容面板
        Container container=jf.getContentPane();
        //指定面板中组件的排列布局，流布局
        container.setLayout(new FlowLayout());
        //生成各组件
        JLabel jl1=new JLabel("加油费");
        JTextField jtf1=new JTextField(10);
        
        JLabel jl2=new JLabel("汽油价格");
        JTextField jtf2=new JTextField("5.98");
        
        JLabel jl3=new JLabel("行驶公里数");
        JTextField jtf3=new JTextField("200");
        
        JButton jb1=new JButton("计算");
        JLabel jl4=new JLabel("油耗为：");
        
        jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String total=jtf1.getText();
				double amount=Double.parseDouble(total);
				
				double price=Double.parseDouble(jtf2.getText());
				double kilos=Double.parseDouble(jtf3.getText());
				
				double value=amount/price/kilos*100;
				
				jl4.setText("油耗为："+value);
			}
		});
        
        //将所上的组件加入到面板中  
        container.add(jl1);
        container.add(jtf1);
        container.add(jl2);
        container.add(jtf2);
        container.add(jl3);
        container.add(jtf3);
        container.add(jb1);
        container.add(jl4);
        
        jf.setSize(300,200);
        jf.setLocation(200, 200);
        //一定要设置成可见的
        jf.setVisible(true);		
	}
}
