package Main_interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

import CS.Object.User;

public class User_Login implements ActionListener {


	private JFrame frmXxx;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnr;
	private JButton btnenter;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;

	private JButton btnp;
	public String var;

	public static void main(String[] args) {
		new User_Login();
	}

	public User_Login() {
		initialize();
		frmXxx.setVisible(true);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		frmXxx = new JFrame();
		frmXxx.setBounds(100, 100, 388, 251);
		frmXxx.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmXxx.setLocationRelativeTo(null);
		frmXxx.getContentPane().setLayout(null);

		JPanel mainJPanel = new JPanel();
		mainJPanel.setBounds(10, 10, 352, 192);
		mainJPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "登录系统", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
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

		btnr = new JButton("注册账号");
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

		btnp = new JButton("修改密码");
		btnp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ChangePassword();
				System.out.println("修改密码了");
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

		radioButton = new JRadioButton("借阅者");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButton_1.setSelected(false);
			}
		});
		radioButton.setSelected(true);
		radioButton.setBounds(125, 105, 83, 23);
		mainJPanel.add(radioButton);

		String var = textField.getText();
		System.out.println(var);

		btnenter = new JButton("登陆系统");
		btnenter.registerKeyboardAction(this, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
		btnenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Detection_accounts fp = new Detection_accounts();

				fp.Detection_accounts(textField.getText(), textField_1.getText(), radioButton.isSelected(),
						radioButton_1.isSelected());// 检测登录账号密码是否正确
				// 进入系统

			}
		});
		btnenter.setBounds(114, 140, 123, 30);
		mainJPanel.add(btnenter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
