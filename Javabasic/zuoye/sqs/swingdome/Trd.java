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

public class Trd extends JFrame implements ActionListener{
	
	JLabel jl=null;
	JTextField jtf=null;
	
	JButton jb=null;
    JLabel jl1=null;
	
	
	public Trd() throws HeadlessException {
		super();
	}

	public Trd(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		  //��ȡ��ǰ����������
        Container container=this.getContentPane();
        //ָ���������������в��֣�������
        container.setLayout(new FlowLayout());
        
        jl=new JLabel("����������");
        jtf=new JTextField("10");
        jb=new JButton("����");
        jl1=new JLabel("������Ϊ");
        
        jb.addActionListener(this);
        
        container.add(jl);
        container.add(jtf);
        container.add(jb);
        container.add(jl1);
        
        this.setSize(300,200);
        this.setLocation(300,300);
        //һ��Ҫ���óɿɼ���
        this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		double number=Double.parseDouble(jtf.getText());
		
		double last=number*number*number;
		
		jl1.setText("������Ϊ"+last);
	}
	
	public static void main(String[] args) {
		new Trd("����������");
	}
	
}
