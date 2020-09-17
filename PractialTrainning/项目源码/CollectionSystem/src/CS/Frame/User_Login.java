package CS.Frame;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import CS.Kit.Unit;
import CS.Mysql.UserMysql;
import CS.Object.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class User_Login implements ActionListener {

	private JFrame frmXxx;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnr;
	private JButton btnenter;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	
	/**创建数据库操作对象**/
	private UserMysql usermysql = new UserMysql();
	private JButton btnp;

	public static void main(String[] args) 
	{
		loadSkin();
		new User_Login();
	}

	private static void loadSkin()
	{
		InitGlobalFont(new Font("微软雅黑", Font.PLAIN,12));
		try 
		{
			BeautyEyeLNFHelper.frameBorderStyle =BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		}
		catch (Exception e) 
		{
			System.err.println("set skin fail!");
		}
	}
	
	private static void InitGlobalFont(Font font)
	{
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, fontRes);
			}
		}
	}

	public User_Login()
	{
		initialize();
		frmXxx.setVisible(true);
	}


	private void initialize() 
	{
		frmXxx = new JFrame();
		frmXxx.setTitle("XXX收银系统");
		frmXxx.setBounds(100, 100, 388, 251);
		frmXxx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmXxx.setLocationRelativeTo(null);
		frmXxx.getContentPane().setLayout(null);
		
		JPanel mainJPanel = new JPanel();
		mainJPanel.setBounds(10, 10, 352, 192);
		mainJPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u767B\u9646\u6536\u94F6\u7CFB\u7EDF", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frmXxx.getContentPane().add(mainJPanel);
		mainJPanel.setLayout(null);
		
		JLabel label = new JLabel("账  号：");
		label.setBounds(61, 38, 54, 15);
		mainJPanel.add(label);
		
		JLabel label_1 = new JLabel("密  码：");
		label_1.setBounds(61, 73, 54, 15);
		mainJPanel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(125, 36, 169, 22);
		mainJPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(125, 71, 169, 22);
		mainJPanel.add(textField_1);
		textField_1.setColumns(10);
		
		btnr = new JButton("注册账号(R)");
		btnr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User_Register();
			}
		});
		btnr.setBounds(10, 140, 100, 30);
		btnr.setMnemonic(KeyEvent.VK_R);
		mainJPanel.add(btnr);
		
		JLabel label_2 = new JLabel("类  型：");
		label_2.setBounds(61, 105, 54, 15);
		mainJPanel.add(label_2);
		
		btnp = new JButton("修改密码(P)");
		btnp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new User_RePassword();
			}
		});
		btnp.setBounds(242, 140, 100, 30);
		btnp.setMnemonic(KeyEvent.VK_P);
		mainJPanel.add(btnp);
		
		radioButton_1 = new JRadioButton("管理员");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton.setSelected(false);
			}
		});
		radioButton_1.setBounds(217, 105, 77, 23);
		mainJPanel.add(radioButton_1);
		
		radioButton = new JRadioButton("收银员");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_1.setSelected(false);
			}
		});
		radioButton.setSelected(true);
		radioButton.setBounds(125, 105, 83, 23);
		mainJPanel.add(radioButton);
		
		btnenter = new JButton("登陆系统(Enter)");
		btnenter.registerKeyboardAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		btnenter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				User user = new User();
				user.setUser(textField.getText());
				user.setPassword(textField_1.getText());
				if(radioButton.isSelected())
				{
					user.setAdmin("收银员");
				}
				else if(radioButton_1.isSelected())
				{
					user.setAdmin("管理员");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"请选择登陆权限","错误提示", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				user=usermysql.login(user);
				if(user==null)
				{
					JOptionPane.showMessageDialog(null,"登陆失败，请检查用户名密码的输入","错误提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					/******Debug调试信息******/
					Unit.putDebug(user);
					/***********************/
					Unit.nowUser=user;
					Unit.logmysql.Login(Unit.log.setLog());
					new Main();
					frmXxx.dispose();
				}
			}
		});
		btnenter.setBounds(114, 140, 123, 30);
		mainJPanel.add(btnenter);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnenter)
		{
			User user = new User();
			user.setUser(textField.getText());
			user.setPassword(textField_1.getText());
			if(radioButton.isSelected())
			{
				user.setAdmin("收银员");
			}
			else if(radioButton_1.isSelected())
			{
				user.setAdmin("管理员");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"请选择登陆权限","错误提示", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			user=usermysql.login(user);
			if(user==null)
			{
				JOptionPane.showMessageDialog(null,"登陆失败，请检查用户名密码的输入","错误提示", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				/******Debug调试信息******/
				Unit.putDebug(user);
				/***********************/
				Unit.nowUser=user;
				Unit.logmysql.Login(Unit.log.setLog());
				new Main();
				frmXxx.dispose();
			}
		}
	}
}
