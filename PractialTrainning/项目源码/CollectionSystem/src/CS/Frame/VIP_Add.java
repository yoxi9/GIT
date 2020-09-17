package CS.Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import CS.Kit.Unit;
import CS.Mysql.VIPMysql;
import CS.Object.VIP;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VIP_Add implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnenter;

	private VIPMysql vipmysql = new VIPMysql();
	/**
	 * Create the application.
	 */
	public VIP_Add() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 257, 248);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6DFB\u52A0VIP\u4F1A\u5458", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 225, 195);
		frame.getContentPane().add(panel);
		
		JLabel lblid = new JLabel("会员ID：");
		lblid.setBounds(10, 23, 59, 15);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(81, 20, 132, 21);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(81, 48, 132, 21);
		panel.add(textField_1);
		
		JLabel label_1 = new JLabel("会员账号：");
		label_1.setBounds(10, 51, 72, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("会员姓名：");
		label_2.setBounds(10, 82, 72, 15);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(81, 79, 132, 21);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("联系方式：");
		label_3.setBounds(10, 110, 72, 15);
		panel.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(81, 107, 132, 21);
		panel.add(textField_3);
		
		JLabel label_4 = new JLabel("注册时间：");
		label_4.setBounds(10, 138, 72, 15);
		panel.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(81, 135, 132, 21);
		panel.add(textField_4);
		String date = new Date().toString();
		textField_4.setText(date);
		
		btnenter = new JButton("添加(Enter)");
		btnenter.registerKeyboardAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0),JComponent.WHEN_IN_FOCUSED_WINDOW);
		btnenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(textField.getText().equals("")||textField_1.getText().equals("")
					||textField_2.getText().equals("")||textField_3.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"请将信息填写完整！","消息提示", JOptionPane.INFORMATION_MESSAGE);					
				}
		 		else
				{
					VIP vip = new VIP(textField.getText(),textField_1.getText(),textField_2.getText(),0,textField_3.getText(),new Date());
					vipmysql.add(vip);
					Unit.putDebug(vip);
					JOptionPane.showMessageDialog(null,"注册会员成功！","消息提示", JOptionPane.INFORMATION_MESSAGE);					
					Unit.logmysql.VIP_Add(Unit.log.setLog(vip.getId()));
					frame.dispose();
				}
			}
		});
		btnenter.setBounds(38, 163, 148, 23);
		panel.add(btnenter);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnenter)
		{
			if(textField.getText().equals("")||textField_1.getText().equals("")
					||textField_2.getText().equals("")||textField_3.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"请将信息填写完整！","消息提示", JOptionPane.INFORMATION_MESSAGE);					
			}
		 	else
			{
				VIP vip = new VIP(textField.getText(),textField_1.getText(),textField_2.getText(),0,textField_3.getText(),new Date());
				vipmysql.add(vip);
				Unit.putDebug(vip);
				JOptionPane.showMessageDialog(null,"注册会员成功！","消息提示", JOptionPane.INFORMATION_MESSAGE);					
				Unit.logmysql.VIP_Add(Unit.log.setLog(vip.getId()));
				frame.dispose();
			}
		}
	}
}
