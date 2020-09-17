package swingdemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;


public class Demo11_FontSetMenu extends JFrame implements ActionListener{
	
	JTextArea txtDemo=new JTextArea("�����������Ҫ��ʽͨ���˵�����",10,30);
	JMenuBar jmb=new JMenuBar();
	
	JMenu fontMenu=new JMenu("����");
	JMenu helpMenu=new JMenu("����");
	
	
	JMenu styleMenu=new JMenu("��ʽ");
	JMenu colorMenu=new JMenu("��ɫ");
	
	JMenuItem exitItem=new JMenuItem("�˳�");
	JMenuItem aboutItem=new JMenuItem("����");
	
	JCheckBoxMenuItem boldItem=new JCheckBoxMenuItem("����");
	JCheckBoxMenuItem italicItem=new JCheckBoxMenuItem("б��");
	
	JRadioButtonMenuItem redItem=new JRadioButtonMenuItem("��ɫ");
	JRadioButtonMenuItem greenItem=new JRadioButtonMenuItem("��ɫ");
	JRadioButtonMenuItem blueItem=new JRadioButtonMenuItem("��ɫ");
	
	public Demo11_FontSetMenu(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container=this.getContentPane();
        
        container.add(new Label(""), BorderLayout.NORTH);
        
        container.add(txtDemo, BorderLayout.CENTER);
        
        this.setJMenuBar(jmb);
        jmb.add(fontMenu);
        jmb.add(helpMenu);
        
        //�ӿ�ݼ�F��alt+F�Ϳ��Դ�����˵�
        fontMenu.setMnemonic(KeyEvent.VK_F);
        
        fontMenu.add(styleMenu);
        fontMenu.add(colorMenu);
        
        fontMenu.addSeparator();
        
        fontMenu.add(exitItem);
        fontMenu.add(aboutItem);
        
        styleMenu.add(boldItem);
        styleMenu.add(italicItem);
        
        //�ӿ�ݼ�I��alt+I�Ϳ��Թ�ѡ��ȥѡб�帴ѡ��
        italicItem.setMnemonic(KeyEvent.VK_I);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(redItem);
        bg.add(greenItem);
        bg.add(blueItem);
        
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);
        
        exitItem.addActionListener(this);
        redItem.addActionListener(this);
        greenItem.addActionListener(this);
        blueItem.addActionListener(this);
        boldItem.addActionListener(this);
        italicItem.addActionListener(this);

        this.pack();
        this.setLocation(200, 200);
        //һ��Ҫ���óɿɼ���
        this.setVisible(true);	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int bold=Font.PLAIN, italic=Font.PLAIN;
		String command=e.getActionCommand();
		if("�˳�".equals(command)){
			System.exit(WindowConstants.EXIT_ON_CLOSE);
		}else if("��ɫ".equals(command)){
			txtDemo.setForeground(Color.red);
		}else if("��ɫ".equals(command)){
			txtDemo.setForeground(Color.green);
		}else if("��ɫ".equals(command)){
			txtDemo.setForeground(Color.blue);
		}else if("����".equals(command)){
			bold=boldItem.isSelected()?Font.BOLD:Font.PLAIN;
		}else if("б��".equals(command)){
			italic=italicItem.isSelected()?Font.ITALIC:Font.PLAIN;
		}
		
		txtDemo.setFont(new Font("����",bold+italic,26));
		
	}

	public static void main(String[] args) {
		new Demo11_FontSetMenu("�˵���ϰ");
	}
}
