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
 * 第一步，类实现ActionListener接口
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
	    //主面板获取
		Container jp=this.getContentPane();
		jp.setLayout(new BorderLayout());
		
		jtf=new JTextField("");
		jp.add(jtf, BorderLayout.NORTH);
		
		//生成一个子面板，作为数字键等
		JPanel keys=new JPanel();
		keys.setLayout(new GridLayout(5, 3, 5, 5));
		
		for(int i=0;i<10;i++){
			JButton jbtemp=new JButton(""+i);
			keys.add(jbtemp);
			
			/*
			 * 3）关联组件和事件监听器（addActionListener）。
			 * 因为本类已经实现了ActionListener接口，
			 * 所以 this可以作为一个ActionListener接口的
			 * 实现类使用多态传递给此接口引用可以传递。
			 */
			jbtemp.addActionListener(this);
			
		}
		JButton  jbdot=new JButton(".");
		keys.add(jbdot);
		jbdot.addActionListener(this);
		
		keys.add(new JButton("="));
		keys.add(new JButton("清空"));
		keys.add(new JButton("退格"));
		
		//将第一个子面板加入到主面板中间
		jp.add(keys,BorderLayout.CENTER);
		
		//生成另一个子面板，作为符号键
		JPanel symbols=new JPanel();
		symbols.setLayout(new GridLayout(4, 1, 5, 5));
		symbols.add(new JButton("  +  "));
		symbols.add(new JButton("  -  "));
		symbols.add(new JButton("  *  "));
		symbols.add(new JButton("  /  "));
		//将第二个子面板加入到主面板的东边
		jp.add(symbols,BorderLayout.EAST);
		
		this.setSize(400, 400);
		
		this.setLocation(200, 100);
		
		this.setVisible(true);
		
	}
	/*
	 * 2)在重写接口对应的方法中，增加对应的事件处理代码
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command=e.getActionCommand();
		if(command.equals("1")){
			jtf.setText("你敲了1");
		}else if(command.equals("2")){
			jtf.setText("你敲了2");
		}else if(command.equals("3")){
			jtf.setText("你敲了3");
		}else if(command.equals(".")){
			jtf.setText("你敲了.");
		}
	}

	public static void main(String[] args) {
		new Demo07_Calculator("计算机界面");
	}



}
