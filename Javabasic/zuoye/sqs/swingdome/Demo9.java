package swingdome;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Demo9 extends JFrame{
	
	JComboBox<String> S=null;
	JComboBox<Phone> P=null;
	
	public Demo9(String title) {
		super(title);
		
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        Container con = this.getContentPane();
	        
	        Phone[] phs=new Phone[] {new Phone("小米","3999"),
	        		new Phone("华为","4999"),
	        		new Phone("三星","5999"),
	        		new Phone("苹果","6999")};
	        P=new JComboBox<>(phs);
	        P.addItemListener(new ItemListener() {
				
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					System.out.println("我选择了第"+P.getSelectedIndex()+
							"个手机，为"+P.getSelectedItem());	
					System.out.println(e.getStateChange());
				}
			});
	        
	        String[] strs=new String[] {"中国","USA","德国","法国"};
	        S=new JComboBox<>(strs);
	        
	        S.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("我选择了第"+S.getSelectedIndex()+
							"个国家，为"+S.getSelectedItem());
				}
			});
	        
	        Box boxv = Box.createVerticalBox();
	        
	        JRadioButton jrb1=new JRadioButton("男");
	        
	        
	        boxv.add(S);
	        S.setBorder(BorderFactory.createTitledBorder("请选择国别："));
	        boxv.add(Box.createVerticalStrut(200));
	        
	        
	        Box boxv1 = Box.createVerticalBox();
	        boxv1.add(P);
	        S.setBorder(BorderFactory.createTitledBorder("请选择手机类型："));
	        boxv1.add(Box.createVerticalStrut(200));

	       Box boxh=Box.createHorizontalBox();
	       boxh.add(boxv);
	       boxh.add(boxv1);
	        //将Box面板设为窗口的主面板
	        this.setContentPane(boxh);
	        
	        this.pack();
	        this.setLocation(900,400);
	        this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo9("组合框");
	}

}
