package swingdemo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exer02_FrameCaculator extends JFrame implements ActionListener {	
	JTextField result;		// ��ʾ��������ֺͼ�����
	int calculate_type = 0; // 0�������㣻1��2��3��4�ֱ����Ӽ��˳�
	
	Exer02_FrameCaculator(){	
		JPanel jp;
		JButton jb;
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		
		// �����ı�����������༭����ӵ������Ϸ�
		result = new JTextField();
		result.setEditable(false);
		jp.add(result,BorderLayout.NORTH);
		
		// �����м�������ְ�ť����ա��˸�С���㰴ť
		// ��Ϊ BorderLayout �����ڷ�Ϊ�����������������ÿ������ֻ�����һ�����
		// ���������м�������� keyPanel������keyPanel��������ְ�ť��ʵ��������Ƕ��
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
		jb = new JButton("���");
		keyPanel.add(jb);
		jb.addActionListener(this);
		jb = new JButton("�˸�");
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
		
		//���JPanel������������
		setContentPane(jp);
		
		//���ô���ı��⡢��С���ɼ��Լ��رն���
		setTitle("������");
		setSize(340,260);
		setVisible(true);
		// ���ô��ڹر�ʱ�������˳�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void actionPerformed(ActionEvent e) { 
		String cmd = e.getActionCommand();
		String c = result.getText();
		
		if(cmd.equals("���")){
			result.setText("");
		}
		else if(cmd.equals("�˸�")){
			if(c.length() > 0){
				String slast = c.substring(c.length() - 1); 
				if(slast.equals("+") || slast.equals("-") || slast.equals("*") || slast.equals("/")){
					calculate_type = 0; // ���ɾ��������������������ͻָ�Ϊδȷ��״̬
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
			if(calculate_type == 0){ // ���ϴμ�����ɺ󣬵�һ�ε�������
				result.setText(c + cmd);
				judgeCalculateType(cmd); // �жϼ�������
			}
			else{	// ���ϴμ�����ɺ󣬵ڶ��ε�����������������
				calculate();
				result.setText(result.getText() + cmd);
				judgeCalculateType(cmd); // �жϼ�������
			}
		}
		else if(cmd.equals("=")){//���  = ���м���
			try{
				calculate();
			}
			catch(Exception exp){
			JOptionPane.showMessageDialog(this, "����������������������������");
			}
		}		
	}
	
	// �жϼ�������
	private void judgeCalculateType(String cmd){
		if(cmd.equals("+"))
			calculate_type = 1; // ��¼��������
		else if(cmd.equals("-"))
			calculate_type = 2;
		else if(cmd.equals("*"))
			calculate_type = 3;
		else
			calculate_type = 4;
	}
	
	// ��ɼ��㹦��
	private void calculate(){
		double rt,op1,op2;
		String c = result.getText();
		int pos;
		char ops[] = new char[]{'+','-','*','/'};
		
		// ���������λ��
		pos = c.indexOf(ops[calculate_type - 1]);
		
		// �������λ��Ϊ�ֽ�㣬������������������
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
		
		result.setText("" + rt); // ��ʾ������		
		calculate_type = 0;	// ׼����¼�´μ��������
	}
	
	public static void main(String[] args){		
		new Exer02_FrameCaculator();
	}
}