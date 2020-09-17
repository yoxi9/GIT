package swingdome;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HYDJLR extends JFrame{
	
	JFrame jf=null;
	JLabel jl,jl1, jl2, jl3, jl4, jl5, jl6, jl7;
	String[] sf = { "是", "否" };
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6;
	JComboBox jcb1;

	public HYDJLR() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public HYDJLR(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		Container jp=this.getContentPane();
		jp.setLayout(new BorderLayout());
		
		JPanel jpTop = new JPanel();
		jpTop.setLayout(new FlowLayout());
		
		JPanel jpcenter = new JPanel();
		jpcenter.setLayout(new GridLayout(4, 2, 3, 2 ));
		
		JPanel jpbottom = new JPanel();
		jpbottom.setLayout(new GridLayout(3, 3, 3, 2));
		
		jf=new JFrame("会员登记录入");

		jl=new JLabel("会员登记录入");
		jl.setFont(new Font("粗体", Font.BOLD, 20));
		jl.setForeground(Color.pink);
		jl1=new JLabel("姓名");
		jl2=new JLabel("性别");
		jl3=new JLabel("联系电话");
		jl4=new JLabel("类型");
		jl5=new JLabel("折扣");
		jl6=new JLabel("是否挂失");
		jl7=new JLabel("工作单位");
		
		jtf1=new JTextField("璃·山");
		jtf2=new JTextField("男");
		jtf3=new JTextField("139xxxx7493");
		jtf4=new JTextField("CEO");
		jtf5=new JTextField("免费");
		jcb1 = new JComboBox(sf);
		jtf6=new JTextField("TIMI");
		
		jpTop.add(jl);
		jpcenter.add(jl1);
		jpcenter.add(jtf1);
		jpcenter.add(jl2);
		jpcenter.add(jtf2);
		jpcenter.add(jl3);
		jpcenter.add(jtf3);
		jpcenter.add(jl4);
		jpcenter.add(jtf4);
		jpcenter.add(jl5);
		jpcenter.add(jtf5);
		jpcenter.add(jl6);
		jpcenter.add(jcb1);
		jpcenter.add(jl7);
		jpcenter.add(jtf6);
		jp.add(jpTop, BorderLayout.NORTH);
		jp.add(jpcenter, BorderLayout.CENTER);
		jp.add(jpbottom, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.setSize(500, 200);
		this.setLocationRelativeTo(null);
		}

	public static void main(String[] args) {
		new HYDJLR("会员登记");
	}

}
