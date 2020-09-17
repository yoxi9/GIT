package CS.Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import CS.Kit.Unit;
import CS.Mysql.UserMysql;
import CS.Object.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class User_Register implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	private UserMysql usermysql = new UserMysql();

	public User_Register() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 277, 361);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6536\u94F6\u7CFB\u7EDF\u6CE8\u518C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 241, 302);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblid = new JLabel("用户ID：");
		lblid.setBounds(24, 29, 68, 15);
		panel.add(lblid);
		
		JLabel label = new JLabel("用户账户：");
		label.setBounds(24, 54, 68, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("用户密码：");
		label_1.setBounds(24, 79, 68, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("用户姓名：");
		label_2.setBounds(24, 104, 68, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("用户年龄：");
		label_3.setBounds(24, 129, 68, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("用户性别：");
		label_4.setBounds(24, 154, 68, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("联系方式：");
		label_5.setBounds(24, 179, 68, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("用户权限：");
		label_6.setBounds(24, 204, 68, 15);
		panel.add(label_6);
		
		textField = new JTextField();
		textField.setBounds(94, 27, 120, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 54, 120, 22);
		panel.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 79, 120, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 104, 120, 22);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(94, 129, 120, 22);
		panel.add(textField_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(94, 179, 120, 22);
		panel.add(textField_6);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setBounds(94, 154, 120, 18);
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"收银员", "管理员"}));
		comboBox_1.setBounds(94, 204, 120, 18);
		panel.add(comboBox_1);
		
		btnNewButton = new JButton("注册账户(Enter)");
		btnNewButton.registerKeyboardAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(textField.getText().equals("")||textField_1.getText().equals("")
						||textField_2.getText().equals("")||textField_3.getText().equals("")
						||textField_4.getText().equals("")||textField_6.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,"注册失败，请将信息填写完整","错误提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						User user = new User(textField.getText(),textField_1.getText(),textField_2.getText(),
								(String)comboBox_1.getSelectedItem(),0,textField_3.getText(),
								(String)comboBox.getSelectedItem(),Integer.valueOf(textField_4.getText()), textField_6.getText());
					
						if(usermysql.add(user)==0)
						{
							JOptionPane.showMessageDialog(null,"注册失败，请检查填写是否有误","错误提示", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"注册成功！请登录！","消息提示", JOptionPane.INFORMATION_MESSAGE);
							Unit.nowUser=usermysql.login(user);
							Unit.logmysql.register(Unit.log.setLog());
							frame.dispose();
						}
					}
			}
		});
		btnNewButton.setBounds(24, 229, 190, 63);
		panel.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnNewButton)
		{
			if(textField.getText().equals("")||textField_1.getText().equals("")
				||textField_2.getText().equals("")||textField_3.getText().equals("")
				||textField_4.getText().equals("")||textField_6.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"注册失败，请将信息填写完整","错误提示", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				User user = new User(textField.getText(),textField_1.getText(),textField_2.getText(),
						(String)comboBox_1.getSelectedItem(),0,textField_3.getText(),
						(String)comboBox.getSelectedItem(),Integer.valueOf(textField_4.getText()), textField_6.getText());
			
				if(usermysql.add(user)==0)
				{
					JOptionPane.showMessageDialog(null,"注册失败，请检查填写是否有误","错误提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"注册成功！请登录！","消息提示", JOptionPane.INFORMATION_MESSAGE);
					Unit.nowUser=usermysql.login(user);
					Unit.logmysql.register(Unit.log.setLog());
					frame.dispose();
				}
			}
		}
		
	}
}
