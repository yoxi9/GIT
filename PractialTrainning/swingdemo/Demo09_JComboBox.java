package swingdemo;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class Demo09_JComboBox extends JFrame{
	
	JComboBox<String> countries=null;
	JComboBox<Phone> phones=null;
	
	
	public Demo09_JComboBox(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //获取当前类的内容面板
 /*       Container container=this.getContentPane();
        container.setLayout(new GridLayout(1,2,10,10));*/

		String[] strs=new String[]{"中国","USA","德国","法国"};
        countries=new JComboBox<>(strs);
        
        countries.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("我选择了第"+countries.getSelectedIndex()+
						"个国家，为"+countries.getSelectedItem());
			}
		});
        
        Phone[] phs=new Phone[]{new Phone("小米", 1800),
        		                new Phone("华为", 3000),
        		                new Phone("iPhone", 5800),
        		                new Phone("OPPO", 1500)};
        
        phones=new JComboBox<Phone>(phs);
        phones.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				System.out.println("我选择了第"+phones.getSelectedIndex()+
						"个手机，为"+phones.getSelectedItem());	
				System.out.println(e.getStateChange());
			}
		});
        
        //BoxLayout面板的另外一种实现方式
        Box boxv1=Box.createVerticalBox();
        
		boxv1.add(countries);
		
		countries.setBorder(BorderFactory.createTitledBorder("请选择国别："));
		boxv1.add(Box.createVerticalStrut(200));
		
		//BoxLayout面板的另外一种实现方式
        Box boxv2=Box.createVerticalBox();
        
		boxv2.add(phones);
		phones.setBorder(BorderFactory.createTitledBorder("请选择手机品牌："));
		boxv2.add(Box.createVerticalStrut(200));
		
		
		//主面板，横向的Box
        Box boxh1=Box.createHorizontalBox();
        boxh1.add(boxv1);
        boxh1.add(boxv2);
        
		//将Box主面板设为窗口的主面板
		this.setContentPane(boxh1);
        
        this.pack();
        this.setLocation(200, 200);
        //一定要设置成可见的
        this.setVisible(true);	
	}

	public static void main(String[] args) {
		new Demo09_JComboBox("组合框练习");
	}
}
