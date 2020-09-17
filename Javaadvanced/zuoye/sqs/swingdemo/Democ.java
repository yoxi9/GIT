package swingdemo;

import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import swingdome.Demo10;

public class Democ extends JFrame{
	private ButtonGroup bg = new ButtonGroup();
	JTextArea jta;

	public Democ() throws HeadlessException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Democ(String title) throws HeadlessException {
		super(title);
		// TODO Auto-generated constructor stub
		
		GraphicsEnvironment G = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Box boxv1=Box.createVerticalBox();
		
		JLabel jLabel1 = new JLabel("���᣺");
		JRadioButton jrb1 = new JRadioButton("����ʡ��");
		jrb1.setActionCommand("����ʡ��");
		JRadioButton jrb2 = new JRadioButton("����ʡ��");
		jrb2.setActionCommand("����ʡ��");
		
		boxv1.add(jLabel1);
		boxv1.add(jrb1);
		boxv1.add(jrb2);
		boxv1.add(Box.createVerticalStrut(200));
		bg.add(jrb1);
        bg.add(jrb2);
        jrb1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jta.setText(jta.getText() + "\n���Ƿ�ѡ���˽���ʡ�ڣ�" + jrb1.isSelected() +
                        "��ѡ����ǣ�" + bg.getSelection().getActionCommand());
            }
        });
		
		
		
		Box boxv2=Box.createVerticalBox();
		boxv2.add(new JLabel("��ѡ��ѡ�޵Ŀγ�"));
		String[] C1 = new String[]{"����                    ",
				"��ѧ                    ",
				"Ӣ��                    ",
				"����                    ",
				"��ѧ                    ",
				"����                    ",
				"��ʷ                    "};
		JList jl=new JList(C1);
		jl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int[] indices = jl.getSelectedIndices();
                List<String> list = jl.getSelectedValuesList();
                for (int i = 0; i < list.size(); i++) {
                    jta.setText(jta.getText() + "\n��ѡ���˵�" + indices[i] + "�ſΣ�Ϊ��" + list.get(i));
                }
            }
        });
        
        boxv2.add(jl);
		
		
		
		Box boxv3=Box.createVerticalBox();
		String[] choice2 = new String[]{"null","Apple","ONEPLUS","MI","HUAWEI"};
		JLabel jl1 = new JLabel("��ѡ���ֻ�Ʒ��");
	    JComboBox<String> phoneBrand = new JComboBox<>(choice2);
	    jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ); 
	    
	    boxv3.add(jl1);
	    boxv3.add(phoneBrand);
		
		
		
		Box boxh1=Box.createHorizontalBox();
	    boxh1.add(boxv1);
	    boxh1.add(boxv2);
	    boxh1.add(boxv3);
	    
	    
	    
        this.setContentPane(boxh1);
        this.pack();
        this.setLocation(200, 200);
        this.setVisible(true);
	    
		
        
		
	
	}
	public static void main(String[] args) {
		new Democ("sss");
	}
}
