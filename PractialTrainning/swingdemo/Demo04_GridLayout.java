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

public class Demo04_GridLayout extends JFrame{
	
	JTextField jtf=null;
	JTextArea jta=null;
	JButton jbgo=null;
	
	public Demo04_GridLayout() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo04_GridLayout(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		jtf=new JTextField(20);
		jtf.setText("����������");
		jta=new JTextArea(20, 30);
		jta.setText("�м������򣬿��Զ�������");
		jbgo=new JButton("��һ����ť");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
		Container jp=this.getContentPane();
		jp.setLayout(new GridLayout(3,2,10,10));
		
		/*jp.add(jtf);
		jp.add(jta);
		jp.add(jbgo);
		jp.add(new JButton("�ڶ�����ť"));*/
		
		for(int i=0;i<6;i++){
			jp.add(new JButton("��ť"+i));
		}
		
		this.setSize(300, 200);
		
		this.setLocation(200, 100);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Demo04_GridLayout("���񲼾�");
	}

}
