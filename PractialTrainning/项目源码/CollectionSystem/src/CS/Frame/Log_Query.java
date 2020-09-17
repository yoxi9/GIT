package CS.Frame;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import CS.Kit.Unit;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Log_Query 
{
	private JFrame frame;
	private JComboBox comboBox;
	private DefaultTableModel DTM;
	private String tableTitle[]={"日志类型", "操作时间","操作用户","操作物品","操作数量","其他信息"};
	private JTable table;
	private JButton button;

	public Log_Query() 
	{
		initialize();
		frame.setVisible(true);
	}

	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 299);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "查询日志", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 539, 241);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 519, 182);
		panel.add(scrollPane);
		
		JLabel label = new JLabel("请选择日志类型：");
		label.setBounds(10, 216, 114, 15);
		panel.add(label);
		
		button = new JButton("查询");
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				refreshTable();
			}
		});
		button.setBounds(362, 212, 167, 23);
		panel.add(button);
		
		comboBox = new JComboBox();
		comboBox.addItem("所有日志");
		comboBox.addItem("注册日志");
		comboBox.addItem("登陆日志");
		comboBox.addItem("修改密码");
		
		comboBox.addItem("商品修改");
		comboBox.addItem("商品添加");
		comboBox.addItem("商品出售");
		
		comboBox.addItem("会员添加");
		comboBox.addItem("会员修改");
		comboBox.addItem("会员删除");
		comboBox.addItem("会员积分");
		
		comboBox.addItem("优惠券添加");
		comboBox.addItem("优惠券删除");
		comboBox.addItem("优惠券使用");
		comboBox.setBounds(109, 212, 243, 22);
		panel.add(comboBox);
		
		table = new JTable();
		DTM=new DefaultTableModel(new Object[][] {},tableTitle);
		table.setModel(DTM);
		refreshTable();
		scrollPane.setViewportView(table);
	}

	private void refreshTable()
	{
		List list = Unit.logmysql.getAll();
		Object tableText[][] = new Object[list.size()][];
		int count = 0;
		for(int i=0;i<list.size();i++)
		{
			HashMap hm = (HashMap) list.get(i);
			Object temp[]=new Object[6];
			for(Object key:hm.keySet())
			{
				if(key.equals("date"))
				{
					temp[0]=hm.get(key);
				}
				if(key.equals("type"))
				{
					temp[1]=hm.get(key);
				}
				if(key.equals("userid"))
				{
					temp[2]=hm.get(key);
				}
				if(key.equals("itemid"))
				{
					temp[3]=hm.get(key);
				}
				if(key.equals("count"))
				{
					temp[4]=hm.get(key);
				}
				if(key.equals("note"))
				{
					temp[5]=hm.get(key);
				}
			}
			if(temp[1].equals(comboBox.getSelectedItem()))
			{
				tableText[count]=temp;
				count++;
			}
			else if(comboBox.getSelectedItem().equals("所有日志"))
			{
				tableText[i]=temp;
			}
		}
		count = 0;
		DTM.setDataVector(tableText,tableTitle);	
	}
}
