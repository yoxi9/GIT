
package swingdemo;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


	

	public class neww extends JFrame {

	    String[] choice1 = new String[]{"����","��ѧ","Ӣ��","����","��ѧ","����","��ʷ"};
	    String[] choice2 = new String[]{"null","Apple","ONEPLUS","MI","HUAWEI"};

	    JLabel jLabel1 = new JLabel("���᣺");
	    JRadioButton nativePlace1 = new JRadioButton("����ʡ��");
	    JRadioButton nativePlace2 = new JRadioButton("����ʡ��");
	    JLabel jLabel2 = new JLabel("��ѡ��γ�");
	    JList<String> course = new JList<>(choice1);
	    JLabel jLabel3 = new JLabel("��ѡ���ֻ�Ʒ��");
	    JComboBox<String> phoneBrand = new JComboBox<>(choice2);
	    JLabel jLabel4 = new JLabel("ѡ�����������");
	    JTextField jTextField = new JTextField(50);
	    JButton jButton = new JButton("�ύ");

	    public neww() throws HeadlessException {

	        setLayout(new FlowLayout());

	        ButtonGroup buttonGroup = new ButtonGroup();
	        buttonGroup.add(nativePlace1);
	        buttonGroup.add(nativePlace2);

	        course.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	        add(jLabel1);
	        add(nativePlace1);
	        add(nativePlace2);
	        add(jLabel2);add(course);
	        add(jLabel3);add(phoneBrand);
	        add(jButton);
	        add(jLabel4);add(jTextField);

	        jButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {

	                String naP;
	                if (nativePlace1.isSelected()){
	                    naP = nativePlace1.getText();
	                }else if (nativePlace2.isSelected()){
	                    naP = nativePlace2.getText();
	                }else {
	                    naP = "null";
	                }
	                jTextField.setText("���᣺"+naP+"  �γ̣�"+course.getSelectedValuesList()+"  �ֻ�Ʒ�ƣ�"+phoneBrand.getSelectedItem().toString());

	            }
	        });

	        setSize(550,300);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	    }
	    

	   
	
	public static void main(String[] args) {
	        new neww();
	    }

	}
