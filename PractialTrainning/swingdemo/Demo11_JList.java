package swingdemo;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class Demo11_JList extends JFrame{
	
	public Demo11_JList(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        //BoxLayout面板的另外一种实现方式,左边的一个
        Box boxv1=Box.createVerticalBox();
        
        JRadioButton jrb1=new JRadioButton("男");
        jrb1.setActionCommand("men");
        JRadioButton jrb2=new JRadioButton("女");
        jrb2.setActionCommand("women");
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        
        boxv1.add(new Label("请选择性别:"));
		boxv1.add(jrb1);
		boxv1.add(jrb2);
		boxv1.add(Box.createVerticalStrut(100));
		jrb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(bg.getSelection().getActionCommand());
				System.out.println("是否为选中:"+jrb1.isSelected());
				
				System.out.println(e.getStateChange());	
			}
		});
		
		//右边的一个子面板		
        Box boxv2=Box.createVerticalBox();
        boxv2.add(new Label("请选择字体的样式:"));
        JCheckBox jcb1=new JCheckBox("黑体");
        jcb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
	            System.out.println("是否为选中:"+jcb1.isSelected());
				System.out.println(e.getStateChange());	
			}
		});

        JCheckBox jcb2=new JCheckBox("斜体");
        
        jcb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		           System.out.println("是否为选中:"+jcb2.isSelected());
                   System.out.println(e.getActionCommand());
			}
		});
        
        boxv2.add(jcb1);
        boxv2.add(jcb2);
        boxv2.add(Box.createVerticalStrut(100));
        
	
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
		new Demo11_JList("组合框练习");
	}
}
