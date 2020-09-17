package swingdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exer02_FrameCaculator extends JFrame implements ActionListener {	
	JTextField result;		// 显示输入的数字和计算结果
	int calculate_type = 0; // 0，无运算；1、2、3、4分别代表加减乘除
	
	Exer02_FrameCaculator(){	
		JPanel jp;
		JButton jb;
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		// 创建文本条，不允许编辑，添加到窗口上方
		result = new JTextField();
		result.setEditable(false);
		jp.add(result,BorderLayout.NORTH);
		
		// 窗口中间添加数字按钮、清空、退格、小数点按钮
		// 因为 BorderLayout 将窗口分为上下左右中五个区域，每个区域只能添加一个组件
		// 所以先在中间区域添加 keyPanel，再往keyPanel上添加数字按钮，实现容器的嵌套
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(5,3));
		for(int i=1;i<=9;i++){
			jb = new JButton(""+i);
			jb.addActionListener(this);
			keyPanel.add(jb);
		}
		jb = new JButton("0");
		keyPanel.add(jb);
		jb.addActionListener(this);
		jb = new JButton("清空");
		keyPanel.add(jb);
		jb.addActionListener(this);
		jb = new JButton("退格");
		keyPanel.add(jb);
		jb.addActionListener(this);
		
		jb = new JButton(".");
		jb.addActionListener(this);	
		keyPanel.add(jb);
		
		jb = new JButton("=");
		jb.addActionListener(this);	
		keyPanel.add(jb);
		
		jp.add(keyPanel,BorderLayout.CENTER);
		
		JPanel operatorPanel = new JPanel();
		operatorPanel.setLayout(new GridLayout(4,1));
		jb = new JButton("+");
		jb.addActionListener(this);
		operatorPanel.add(jb);
		
		jb = new JButton("-");
		jb.addActionListener(this);
		operatorPanel.add(jb);
		
		jb = new JButton("*");
		jb.addActionListener(this);
		operatorPanel.add(jb);
		
		jb = new JButton("/");
		jb.addActionListener(this);
		operatorPanel.add(jb);
		jp.add(operatorPanel,BorderLayout.EAST);	
		
		//添加JPanel容器到窗体中
		setContentPane(jp);
		
		//设置窗体的标题、大小、可见性及关闭动作
		setTitle("计算器");
		setSize(340,260);
		setVisible(true);
		// 设置窗口关闭时，程序退出
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void actionPerformed(ActionEvent e) { 
		String cmd = e.getActionCommand();
		String c = result.getText();
		
		if(cmd.equals("清空")){
			result.setText("");
		}
		else if(cmd.equals("退格")){
			if(c.length() > 0){
				String slast = c.substring(c.length() - 1); 
				if(slast.equals("+") || slast.equals("-") || slast.equals("*") || slast.equals("/")){
					calculate_type = 0; // 如果删除了运算符，将计算类型恢复为未确定状态
				}		
				result.setText(c.substring(0,c.length() - 1));
			}
		}
		else if(cmd.compareTo("0") >= 0 && cmd.compareTo("9") <= 0){
			result.setText(c + cmd);
		}
		else if(cmd.equals(".")){
			result.setText(c + cmd);
		}
		else if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")){
			if(calculate_type == 0){ // 自上次计算完成后，第一次点击运算符
				result.setText(c + cmd);
				judgeCalculateType(cmd); // 判断计算类型
			}
			else{	// 自上次计算完成后，第二次点击运算符，触发计算
				calculate();
				result.setText(result.getText() + cmd);
				judgeCalculateType(cmd); // 判断计算类型
			}
		}
		else if(cmd.equals("=")){//点击  = 进行计算
			try{
				calculate();
			}
			catch(Exception exp){
			JOptionPane.showMessageDialog(this, "输入错误，请检查输出或重新启动程序");
			}
		}		
	}
	
	// 判断计算类型
	private void judgeCalculateType(String cmd){
		if(cmd.equals("+"))
			calculate_type = 1; // 记录运算类型
		else if(cmd.equals("-"))
			calculate_type = 2;
		else if(cmd.equals("*"))
			calculate_type = 3;
		else
			calculate_type = 4;
	}
	
	// 完成计算功能
	private void calculate(){
		double rt,op1,op2;
		String c = result.getText();
		int pos;
		char ops[] = new char[]{'+','-','*','/'};
		
		// 查找运算符位置
		pos = c.indexOf(ops[calculate_type - 1]);
		
		// 以运算符位置为分界点，分离出两个待计算的数
		op1 = Double.parseDouble(c.substring(0, pos));		
		op2 = Double.parseDouble(c.substring(pos + 1));		
		
		switch(calculate_type){
		case 1:
			rt = op1 + op2;
			break;
		case 2:
			rt = op1 - op2;
			break;
		case 3:
			rt = op1 * op2;
			break;
		case 4:
			rt = op1 / op2;
			break;
		default:
			rt = 0;
		}
		
		result.setText("" + rt); // 显示计算结果		
		calculate_type = 0;	// 准备记录下次计算的类型
	}
	
	public static void main(String[] args){		
		new Exer02_FrameCaculator();
	}
}