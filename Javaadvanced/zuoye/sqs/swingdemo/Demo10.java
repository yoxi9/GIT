package swingdemo;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Demo10 extends JFrame{
	
	public Demo10(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        //BoxLayout��������һ��ʵ�ַ�ʽ,��ߵ�һ��
        Box boxv1=Box.createVerticalBox();
        
        String[] strs=new String[]{"�ܲ�                 ","����                        ","���                      ",
        		                   "����                ","����                          "};
        JList<String> jl=new JList<>(strs);
        jl.setBorder(BorderFactory.createTitledBorder("��ѡ����ϲ�����˶�:"));
        jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );

        boxv1.add(jl);
		boxv1.add(Box.createVerticalStrut(20));
        jl.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int[] indices=jl.getSelectedIndices();
				List<String> list=jl.getSelectedValuesList();
				for(int i=0;i<list.size();i++){
					System.out.println("��"+indices[i]+"Ԫ��Ϊ"+list.get(i));
				}
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
		new Demo10("��Ͽ���ϰ");
	}
}