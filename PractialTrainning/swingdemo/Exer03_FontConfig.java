package swingdemo;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Exer03_FontConfig  extends JFrame implements ItemListener, ActionListener{
	
	JRadioButton jrbRed = new JRadioButton("��ɫ",true);
	JRadioButton jrbGreen = new JRadioButton("��ɫ");
	JRadioButton jrbBlue = new JRadioButton("��ɫ");		
	private ButtonGroup bg = new ButtonGroup();
	
	JCheckBox jcb1 = new JCheckBox("�Ӵ�");
	JCheckBox jcb2 = new JCheckBox("��б");	
	
	JComboBox listFont;
	JList listSize;
	JTextArea taDemo;
	JButton btnExit,btnEdit;
	
	public Exer03_FontConfig(){
		
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = g.getAvailableFontFamilyNames();
		
		Box boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("��ѡ������"));
		listFont = new JComboBox(fontName);
		boxV1.add(new JScrollPane(listFont));
		boxV1.add(Box.createVerticalStrut(155));
				
		Box boxV2 = Box.createVerticalBox();
		boxV2.add(new JLabel("��ѡ���ֺ�"));
		String strSize[] = new String[30];
		for(int i=0;i<30;i++){
			strSize[i] = ""+(i+16);
		}
		listSize = new JList(strSize);
		boxV2.add(new JScrollPane(listSize));
		
		Box boxV3 = Box.createVerticalBox();
		boxV3.add(new JLabel("��ѡ������"));		
		boxV3.add(jcb1);
		boxV3.add(jcb2);
		boxV3.add(Box.createVerticalGlue());
		
		Box boxV4 = Box.createVerticalBox();		
		boxV4.add(new JLabel("��ѡ����ɫ"));
		boxV4.add(jrbRed);
		boxV4.add(jrbGreen);
		boxV4.add(jrbBlue);
		boxV4.add(Box.createVerticalGlue());
		
		bg.add(jrbRed);
		bg.add(jrbGreen);
		bg.add(jrbBlue);
		
		Box boxH1 = Box.createHorizontalBox();
	
		boxH1.add(boxV1);
		boxH1.add(Box.createHorizontalStrut(15));
		boxH1.add(boxV2);
		boxH1.add(Box.createHorizontalStrut(15));
		boxH1.add(boxV3);
		boxH1.add(Box.createHorizontalStrut(15));
		boxH1.add(boxV4);
		
		Box boxH2 = Box.createHorizontalBox();
		taDemo = new JTextArea("�����������õĲ�������",5,20);
		boxH2.add(taDemo);
		
		Box boxV5 = Box.createVerticalBox();
		
		btnExit = new JButton("�˳�");
		btnEdit = new JButton("�༭");
		boxV5.add(btnExit);
		boxV5.add(btnEdit);	
		boxH2.add(boxV5);
		
		btnExit.addActionListener(this);
		btnEdit.addActionListener(this);
		
		Box baseBox = Box.createVerticalBox();
		baseBox.add(boxH1);
		baseBox.add(boxH2);
	
        this.setContentPane(baseBox);
		
		setTitle("����������");
		setBounds(150,150,550,380);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void itemStateChanged(ItemEvent e){		
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == btnExit) {
			dispose();
		}
		else if (e.getSource() == btnEdit){
			int style = Font.PLAIN;
			if(jcb1.isSelected()) 
				style |= Font.BOLD;
			if(jcb2.isSelected()) 
				style |= Font.ITALIC;
			
			//���ݵ�ѡ��ť��ѡ��ֱ�������ı���������������ɫ
			if(jrbRed.isSelected())
				taDemo.setForeground(Color.RED);
			if(jrbGreen.isSelected())
				taDemo.setForeground(Color.GREEN);
			if(jrbBlue.isSelected())
				taDemo.setForeground(Color.BLUE);
	
			String strFont = (String)listFont.getSelectedItem();
			//���������ѡ�񣬵õ���������Ķ��������Ȼ��������
			Font ft = new Font(strFont,style,listSize.getSelectedIndex()+16);
			//���ı���������������
			taDemo.setFont(ft);
		}
		//��������������¼�������̣����縴ѡ��ֱ�Ӹ�����ϸ��ʾ��
	}
	
	public static void main(String[] args){
		Exer03_FontConfig vt = new Exer03_FontConfig();
	}
}