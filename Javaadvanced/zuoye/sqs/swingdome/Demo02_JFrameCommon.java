package swingdome;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Demo02_JFrameCommon extends JFrame implements ActionListener{
	
	 private JLabel jl1=null;//=new JLabel("加油费");
	 private JTextField jtf1=null;//=new JTextField(10);
     
	 private JLabel jl2=null;//=new JLabel("汽油价格");
	 private JTextField jtf2=null;//=new JTextField("5.98");
     
	 private JLabel jl3=null;//=new JLabel("行驶公里数");
	 private JTextField jtf3=null;//=new JTextField("200");
     
	 private JButton jb1=null;//=new JButton("计算");
	 private JLabel jl4=null;//=new JLabel("油耗为：");
	 

	 
	 
	public Demo02_JFrameCommon() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Demo02_JFrameCommon(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //获取当前类的内容面板
        Container container=this.getContentPane();
        //指定面板中组件的排列布局，流布局
        container.setLayout(new FlowLayout());
        //生成各组件
        jl1=new JLabel("加油费");
        jtf1=new JTextField("10");
        
        jl2=new JLabel("汽油价格");
        jtf2=new JTextField("5.98");
        
        jl3=new JLabel("行驶公里数");
        jtf3=new JTextField("200");
        
        jb1=new JButton("计算");
        jl4=new JLabel("油耗为：");
        
        jb1.addActionListener(this);
        
        //将所上的组件加入到面板中  
        container.add(jl1);
        container.add(jtf1);
        container.add(jl2);
        container.add(jtf2);
        container.add(jl3);
        container.add(jtf3);
        container.add(jb1);
        container.add(jl4);
        
        this.setSize(300,200);
        this.setLocation(200, 200);
        //一定要设置成可见的
        this.setVisible(true);		
	}


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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Demo02_JFrameCommon("计算油耗");
	}
	
	
}