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
	        
	        Phone[] phs=new Phone[] {new Phone("С��","3999"),
	        		new Phone("��Ϊ","4999"),
	        		new Phone("����","5999"),
	        		new Phone("ƻ��","6999")};
	        P=new JComboBox<>(phs);
	        P.addItemListener(new ItemListener() {
				
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					System.out.println("��ѡ���˵�"+P.getSelectedIndex()+
							"���ֻ���Ϊ"+P.getSelectedItem());	
					System.out.println(e.getStateChange());
				}
			});
	        
	        String[] strs=new String[] {"�й�","USA","�¹�","����"};
	        S=new JComboBox<>(strs);
	        
	        S.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("��ѡ���˵�"+S.getSelectedIndex()+
							"�����ң�Ϊ"+S.getSelectedItem());
				}
			});
	        
	        Box boxv = Box.createVerticalBox();
	        
	        JRadioButton jrb1=new JRadioButton("��");
	        
	        
	        boxv.add(S);
	        S.setBorder(BorderFactory.createTitledBorder("��ѡ�����"));
	        boxv.add(Box.createVerticalStrut(200));
	        
	        
	        Box boxv1 = Box.createVerticalBox();
	        boxv1.add(P);
	        S.setBorder(BorderFactory.createTitledBorder("��ѡ���ֻ����ͣ�"));
	        boxv1.add(Box.createVerticalStrut(200));

	       Box boxh=Box.createHorizontalBox();
	       boxh.add(boxv);
	       boxh.add(boxv1);
	        //��Box�����Ϊ���ڵ������
	        this.setContentPane(boxh);
	        
	        this.pack();
	        this.setLocation(900,400);
	        this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo9("��Ͽ�");
	}

}
