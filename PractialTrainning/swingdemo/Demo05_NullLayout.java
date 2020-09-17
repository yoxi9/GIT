package swingdemo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Demo05_NullLayout extends JFrame{
	
	JTextField jtf=null;
	JTextArea jta=null;
	JButton jbgo=null;
	
	public Demo05_NullLayout() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo05_NullLayout(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		jtf=new JTextField(20);
		jtf.setText("����������");
		jta=new JTextArea(20, 30);
		jta.setText("�м������򣬿��Զ�������");
		jbgo=new JButton("��һ����ť");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
		Container jp=this.getContentPane();
		jp.setLayout(null);//�������ʾ����null���֣���ôȱʡ����BorderLayout
		
		jp.add(jtf);
		jtf.setBounds(50, 20, 200, 50);
		jp.add(jta);
		jta.setBounds(50, 100,200,180);
		jp.add(jbgo);
		jbgo.setBounds(50, 300,100,60);
		
		
		this.setSize(400, 600);
		
		this.setLocation(200, 100);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Demo05_NullLayout("���񲼾�");
	}

}
