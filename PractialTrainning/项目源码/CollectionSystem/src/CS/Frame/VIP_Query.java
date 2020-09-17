package CS.Frame;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CS.Mysql.VIPMysql;
import CS.Object.VIP;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VIP_Query {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel DTM;
	private String tableTitle[]={"会员ID", "会员账户","会员姓名","会员积分","联系方式","注册日期"};

	private VIPMysql vipmysql = new VIPMysql();
	/**
	 * Create the application.
	 */
	public VIP_Query() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u4F1A\u5458\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 476, 241);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 456, 182);
		panel.add(scrollPane);
		
		table = new JTable();
		DTM=new DefaultTableModel(null,tableTitle)
		{
			public boolean isCellEditable(int rowindex,int colindex)
			{
					return false;
			}
		};
		table.setModel(DTM);
		refreshTable();
		scrollPane.setViewportView(table);
		
		JLabel lblid = new JLabel("请输入会员ID：");
		lblid.setBounds(10, 216, 98, 15);
		panel.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(113, 214, 188, 18);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(textField.getText().equals(""))
				{
					refreshTable();
					JOptionPane.showMessageDialog(null,"查询成功！","消息提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					try
					{
						VIP temp=vipmysql.getById(textField.getText());
						Object tableText[][]={{temp.getId(),temp.getUser(),temp.getName(),temp.getCount(),temp.getTelephone(),temp.getDate()}};
						DTM.setDataVector(tableText,tableTitle);
						JOptionPane.showMessageDialog(null,"查询成功！","消息提示", JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"无此会员ID！","消息提示", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		button.setBounds(311, 212, 155, 23);
		panel.add(button);
	}
	
	private void refreshTable()
	{
		List list = vipmysql.getAll();
		Object tableText[][] = new Object[list.size()][];
		for(int i=0;i<list.size();i++)
		{
			HashMap hm = (HashMap) list.get(i);
			Object temp[]=new Object[6];
			for(Object key:hm.keySet())
			{
				if(key.equals("ID"))
				{
					temp[0]=hm.get(key);
				}
				if(key.equals("USER"))
				{
					temp[1]=hm.get(key);
				}
				if(key.equals("NAME"))
				{
					temp[2]=hm.get(key);
				}
				if(key.equals("COUNT"))
				{
					temp[3]=hm.get(key);
				}
				if(key.equals("TELEPHONE"))
				{
					temp[4]=hm.get(key);
				}
				if(key.equals("DATE"))
				{
					temp[5]=hm.get(key);
				}
			}
			tableText[i]=temp;
		}
		DTM.setDataVector(tableText,tableTitle);	
	}
}
