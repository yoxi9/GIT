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
	
	 private JLabel jl1=null;//=new JLabel("���ͷ�");
	 private JTextField jtf1=null;//=new JTextField(10);
     
	 private JLabel jl2=null;//=new JLabel("���ͼ۸�");
	 private JTextField jtf2=null;//=new JTextField("5.98");
     
	 private JLabel jl3=null;//=new JLabel("��ʻ������");
	 private JTextField jtf3=null;//=new JTextField("200");
     
	 private JButton jb1=null;//=new JButton("����");
	 private JLabel jl4=null;//=new JLabel("�ͺ�Ϊ��");
	 

	 
	 
	public Demo02_JFrameCommon() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Demo02_JFrameCommon(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //��ȡ��ǰ����������
        Container container=this.getContentPane();
        //ָ���������������в��֣�������
        container.setLayout(new FlowLayout());
        //���ɸ����
        jl1=new JLabel("���ͷ�");
        jtf1=new JTextField("10");
        
        jl2=new JLabel("���ͼ۸�");
        jtf2=new JTextField("5.98");
        
        jl3=new JLabel("��ʻ������");
        jtf3=new JTextField("200");
        
        jb1=new JButton("����");
        jl4=new JLabel("�ͺ�Ϊ��");
        
        jb1.addActionListener(this);
        
        //�����ϵ�������뵽�����  
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
        //һ��Ҫ���óɿɼ���
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
		
		jl4.setText("�ͺ�Ϊ��"+value);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Demo02_JFrameCommon("�����ͺ�");
	}
	
	
}