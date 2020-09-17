package swingdemo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo03_BorderLayout extends JFrame{
	
	JTextField jtf=null;
	JTextArea jta=null;
	JButton jbgo=null;
	
	public Demo03_BorderLayout() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo03_BorderLayout(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		jtf=new JTextField(20);
		jtf.setText("����������");
		jta=new JTextArea(5, 20);
		jta.setText("�м������򣬿��Զ�������");
		jbgo=new JButton("������");
		
		Container jp=this.getContentPane();
		jp.setLayout(new BorderLayout());
		
		jp.add(jtf, BorderLayout.NORTH);
		jp.add(jta,BorderLayout.CENTER);
		//jp.add(jbgo,BorderLayout.SOUTH);
		jp.add(jbgo,BorderLayout.EAST);
		jp.add(new JButton("���߰�ť"),BorderLayout.WEST);
		
		this.setSize(400, 400);
		
		this.setLocation(200, 100);
		
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Demo03_BorderLayout("�߽粼��");
	}

}
