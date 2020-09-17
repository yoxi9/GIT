package Initial;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class JFmain extends JFrame implements ActionListener{
	
	    JLabel Name=new JLabel("登录系统");

	    JLabel jName=new JLabel("名                  字：");
	    JLabel jPassword=new JLabel("密                  码：");
	    JLabel jIdentity=new JLabel("请选择身份登入：");
	    String[] listData ={"超级管理员", "管理员","员工"};
	    JComboBox jcb1;



	    JTextField jtfName=new JTextField("",40);
	    JTextField jtfPassword=new JTextField("",40);

	    JButton jButtonInsert=new JButton("用户注册");
	    /*jButtonInsert.addActioner(new ActionListener() {
	    	public void actionPerformed1(ActionEvent e) {
	    		new InitialRegister();
	    	}
	    })*/
	    JButton jButtonDelete=new JButton("修改密码");
	    JButton jButtonSearch=new JButton("用户登录");

	    public JFmain(String title){
	        super(title);
	        Container container=this.getContentPane();

	        container.setLayout(null);
	        
	        Name.setBounds(180, 30, 110, 30);
	        
	        jName.setBounds(110, 90, 110, 30);
	        jtfName.setBounds(250, 90, 100, 30);

	        jPassword.setBounds(110, 130, 110, 30);
	        jtfPassword.setBounds(250, 130, 100, 30);

	        jIdentity.setBounds(110,170,110,30);
	        jcb1 = new JComboBox(listData);
	        jcb1.setBounds(250,170,100,30);  


	        jButtonInsert.setBounds(70, 220, 100, 40);
	        jButtonDelete.setBounds(180, 220,100, 40);
	        jButtonSearch.setBounds(290, 220,100, 40);
	        
	        container.add(Name);
	        Name.setFont(new Font("粗体",Font.BOLD,20));
	        Name.setForeground(Color.pink);

	        container.add(jName);
	        container.add(jtfName);

	        container.add(jPassword);
	        container.add(jtfPassword);

	        container.add(jIdentity);
	        container.add(jcb1);


	        container.add(jButtonInsert);
	        container.add(jButtonDelete);
	        container.add(jButtonSearch);
	        jButtonInsert.addActionListener(this);
	        jButtonDelete.addActionListener(this);
	        jButtonSearch.addActionListener(this);

	        this.setSize(500, 400);
	        this.setVisible(true);
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	    }

	    

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if("用户注册".equals(e.getActionCommand())) {
				new InitialRegister();
				dispose();
				
			}
			
		}
	}


public class main {
	public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        new JFmain("林丹丹公司管理");
	    }

}
