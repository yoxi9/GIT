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
        JFrame jf=new JFrame("����1");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //��ȡjframe�е��������
        Container container=jf.getContentPane();
        //ָ���������������в��֣�������
        container.setLayout(new FlowLayout());
        //���ɸ����
        JLabel jl1=new JLabel("���ͷ�");
        JTextField jtf1=new JTextField(10);
        
        JLabel jl2=new JLabel("���ͼ۸�");
        JTextField jtf2=new JTextField("5.98");
        
        JLabel jl3=new JLabel("��ʻ������");
        JTextField jtf3=new JTextField("200");
        
        JButton jb1=new JButton("����");
        JLabel jl4=new JLabel("�ͺ�Ϊ��");
        
        jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String total=jtf1.getText();
				double amount=Double.parseDouble(total);
				
				double price=Double.parseDouble(jtf2.getText());
				double kilos=Double.parseDouble(jtf3.getText());
				
				double value=amount/price/kilos*100;
				
				jl4.setText("�ͺ�Ϊ��"+value);
			}
		});
        
        //�����ϵ�������뵽�����  
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
        //һ��Ҫ���óɿɼ���
        jf.setVisible(true);		
	}
}
