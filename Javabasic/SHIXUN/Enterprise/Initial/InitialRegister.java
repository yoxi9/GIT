package Initial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Register extends JFrame implements ActionListener{
	
	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	
	JLabel jl1= new JLabel("用户ID：");
	JLabel jl2= new JLabel("用户账户：");
	JLabel jl3= new JLabel("用户密码：");
	JLabel jl4= new JLabel("用户姓名：");
	JLabel jl5= new JLabel("用户年龄：");
	JLabel jl6= new JLabel("用户性别：");
	JLabel jl7= new JLabel("联系方式：");
	JLabel jl8= new JLabel("用户权限：");
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class InitialRegister {
	
	

}
