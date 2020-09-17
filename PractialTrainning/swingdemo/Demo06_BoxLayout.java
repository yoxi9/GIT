package swingdemo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Demo06_BoxLayout extends JFrame{
	
	JTextField jtf=null;
	JTextArea jta=null;
	JButton jbgo=null;
	JButton jbtake=null;
	
	public Demo06_BoxLayout() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Demo06_BoxLayout(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		jtf=new JTextField(20);
		jtf.setText("上面的输入框");
		jta=new JTextArea(20, 30);
		jta.setText("中间的输入框，可以多行输入");
		jbgo=new JButton("出发");
		jbtake=new JButton("行动");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
		Container jp=this.getContentPane();
		jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));//如果不显示设置null布局，那么缺省的是BorderLayout
		
		/*
		 * 生成主面板的两个子面板，子面板里面加上纵向排列的对应组件
		 */
		JPanel jp1=new JPanel();
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		
		jp1.add(jtf);
		jp1.add(jbgo);
				
		JPanel jp2=new JPanel();
		jp2.setLayout(new BoxLayout(jp2, BoxLayout.Y_AXIS));

		jp2.add(jta);
		jp2.add(jbtake);
		
		//子面板作为一个普通组件一样加到主面板里面去。横向的排列
		jp.add(jp1);
		jp.add(jp2);
		
		this.setSize(400, 300);
		
		this.setLocation(200, 100);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Demo06_BoxLayout("网格布局");
	}

}
