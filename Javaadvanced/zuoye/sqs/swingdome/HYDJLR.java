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
	String[] sf = { "��", "��" };
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
		
		jf=new JFrame("��Ա�Ǽ�¼��");

		jl=new JLabel("��Ա�Ǽ�¼��");
		jl.setFont(new Font("����", Font.BOLD, 20));
		jl.setForeground(Color.pink);
		jl1=new JLabel("����");
		jl2=new JLabel("�Ա�");
		jl3=new JLabel("��ϵ�绰");
		jl4=new JLabel("����");
		jl5=new JLabel("�ۿ�");
		jl6=new JLabel("�Ƿ��ʧ");
		jl7=new JLabel("������λ");
		
		jtf1=new JTextField("����ɽ");
		jtf2=new JTextField("��");
		jtf3=new JTextField("139xxxx7493");
		jtf4=new JTextField("CEO");
		jtf5=new JTextField("���");
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
		new HYDJLR("��Ա�Ǽ�");
	}

}
