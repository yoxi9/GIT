package swingdemo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 * ��һ������ʵ��ActionListener�ӿ�
 */
public class Demo07_Calculator extends JFrame implements ActionListener{
	JTextField jtf=null;
	
	public Demo07_Calculator() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo07_Calculator(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
	    //������ȡ
		Container jp=this.getContentPane();
		jp.setLayout(new BorderLayout());
		
		jtf=new JTextField("");
		jp.add(jtf, BorderLayout.NORTH);
		
		//����һ������壬��Ϊ���ּ���
		JPanel keys=new JPanel();
		keys.setLayout(new GridLayout(5, 3, 5, 5));
		
		for(int i=0;i<10;i++){
			JButton jbtemp=new JButton(""+i);
			keys.add(jbtemp);
			
			/*
			 * 3������������¼���������addActionListener����
			 * ��Ϊ�����Ѿ�ʵ����ActionListener�ӿڣ�
			 * ���� this������Ϊһ��ActionListener�ӿڵ�
			 * ʵ����ʹ�ö�̬���ݸ��˽ӿ����ÿ��Դ��ݡ�
			 */
			jbtemp.addActionListener(this);
			
		}
		JButton  jbdot=new JButton(".");
		keys.add(jbdot);
		jbdot.addActionListener(this);
		
		keys.add(new JButton("="));
		keys.add(new JButton("���"));
		keys.add(new JButton("�˸�"));
		
		//����һ���������뵽������м�
		jp.add(keys,BorderLayout.CENTER);
		
		//������һ������壬��Ϊ���ż�
		JPanel symbols=new JPanel();
		symbols.setLayout(new GridLayout(4, 1, 5, 5));
		symbols.add(new JButton("  +  "));
		symbols.add(new JButton("  -  "));
		symbols.add(new JButton("  *  "));
		symbols.add(new JButton("  /  "));
		//���ڶ����������뵽�����Ķ���
		jp.add(symbols,BorderLayout.EAST);
		
		this.setSize(400, 400);
		
		this.setLocation(200, 100);
		
		this.setVisible(true);
		
	}
	/*
	 * 2)����д�ӿڶ�Ӧ�ķ����У����Ӷ�Ӧ���¼��������
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("1")){
			jtf.setText("������1");
		}else if(command.equals("2")){
			jtf.setText("������2");
		}else if(command.equals("3")){
			jtf.setText("������3");
		}else if(command.equals(".")){
			jtf.setText("������.");
		}
	}

	public static void main(String[] args) {
		new Demo07_Calculator("���������");
	}



}
