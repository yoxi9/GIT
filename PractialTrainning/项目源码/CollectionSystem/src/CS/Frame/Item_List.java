package CS.Frame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
public class Item_List 
{
	private JFrame frame;
	private String list;
	public Item_List(String list) 
	{
		this.list=list;
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 277, 406);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "购物小票", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 241, 347);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 22, 221, 315);
		textArea.setText(list);
		panel.add(textArea);
	}
}
