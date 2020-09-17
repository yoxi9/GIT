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
        

        //BoxLayout��������һ��ʵ�ַ�ʽ,��ߵ�һ��
        Box boxv1=Box.createVerticalBox();
        
        JRadioButton jrb1=new JRadioButton("��");
        jrb1.setActionCommand("men");
        JRadioButton jrb2=new JRadioButton("Ů");
        jrb2.setActionCommand("women");
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        
        boxv1.add(new Label("��ѡ���Ա�:"));
		boxv1.add(jrb1);
		boxv1.add(jrb2);
		boxv1.add(Box.createVerticalStrut(100));
		jrb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
//				System.out.println(bg.getSelection().getActionCommand());
				System.out.println("�Ƿ�Ϊѡ��:"+jrb1.isSelected());
				
				System.out.println(e.getStateChange());	
			}
		});
		
		//�ұߵ�һ�������		
        Box boxv2=Box.createVerticalBox();
        boxv2.add(new Label("��ѡ���������ʽ:"));
        JCheckBox jcb1=new JCheckBox("����");
        jcb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
	            System.out.println("�Ƿ�Ϊѡ��:"+jcb1.isSelected());
				System.out.println(e.getStateChange());	
			}
		});

        JCheckBox jcb2=new JCheckBox("б��");
        
        jcb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		           System.out.println("�Ƿ�Ϊѡ��:"+jcb2.isSelected());
                   System.out.println(e.getActionCommand());
			}
		});
        
        boxv2.add(jcb1);
        boxv2.add(jcb2);
        boxv2.add(Box.createVerticalStrut(100));
        
	
		//����壬�����Box
        Box boxh1=Box.createHorizontalBox();
        boxh1.add(boxv1);
        boxh1.add(boxv2);
		
        
		//��Box�������Ϊ���ڵ������
		this.setContentPane(boxh1);
        
        this.pack();
        this.setLocation(200, 200);
        //һ��Ҫ���óɿɼ���
        this.setVisible(true);	
	}

	public static void main(String[] args) {
		new Demo11_JList("��Ͽ���ϰ");
	}
}
