package swingdome;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo3 extends JFrame{
	
	JTextField jtf=null;
	JTextArea jta=null;
	JButton jb=null;
	
	public Demo3() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo3(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		jtf=new JTextField(20);
		jtf.setText("����������");
		jta=new JTextArea(20,30);
		jtf.setText("�м������򣬿��Զ�������");
		jb=new JButton("������");
		
		Container jp=this.getContentPane();
		jp.setLayout(new BorderLayout());
		
		 jp.add(jtf, BorderLayout.NORTH);
	     jp.add(jta,BorderLayout.CENTER);
	     //jp.add(jb,BorderLayout.SOUTH);
	     jp.add(jb,BorderLayout.EAST);
	     //jp.add(new JButton("���߰�ť"),BorderLayout.WEST);

	     this.setSize(400,400);
	     this.setLocation(200,100);
	     this.setVisible(true);
	}
	     public static void main(String[] args) {
	 		// TODO Auto-generated method stub
	         new Demo3("s");
	 	}
	
}

