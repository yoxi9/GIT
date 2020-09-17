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
        
        //��ȡ��ǰ����������
 /*       Container container=this.getContentPane();
        container.setLayout(new GridLayout(1,2,10,10));*/

		String[] strs=new String[]{"�й�","USA","�¹�","����"};
        countries=new JComboBox<>(strs);
        
        countries.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ѡ���˵�"+countries.getSelectedIndex()+
						"�����ң�Ϊ"+countries.getSelectedItem());
			}
		});
        
        Phone[] phs=new Phone[]{new Phone("С��", 1800),
        		                new Phone("��Ϊ", 3000),
        		                new Phone("iPhone", 5800),
        		                new Phone("OPPO", 1500)};
        
        phones=new JComboBox<Phone>(phs);
        phones.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ѡ���˵�"+phones.getSelectedIndex()+
						"���ֻ���Ϊ"+phones.getSelectedItem());	
				System.out.println(e.getStateChange());
			}
		});
        
        //BoxLayout��������һ��ʵ�ַ�ʽ
        Box boxv1=Box.createVerticalBox();
        
		boxv1.add(countries);
		
		countries.setBorder(BorderFactory.createTitledBorder("��ѡ�����"));
		boxv1.add(Box.createVerticalStrut(200));
		
		//BoxLayout��������һ��ʵ�ַ�ʽ
        Box boxv2=Box.createVerticalBox();
        
		boxv2.add(phones);
		phones.setBorder(BorderFactory.createTitledBorder("��ѡ���ֻ�Ʒ�ƣ�"));
		boxv2.add(Box.createVerticalStrut(200));
		
		
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
		new Demo09_JComboBox("��Ͽ���ϰ");
	}
}
