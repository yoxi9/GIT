package CS.Frame;

import java.awt.EventQueue;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import CS.Kit.Unit;
import CS.Mysql.VIPMysql;
import CS.Object.VIP;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VIP_Mange implements TableModelListener {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel DTM;
	private String tableTitle[]={"会员ID", "会员账户","会员姓名","会员积分","联系方式","注册日期"};

	private VIPMysql vipmysql = new VIPMysql();
	/**
	 * Create the application.
	 */
	public VIP_Mange() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "管理会员", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 466, 241);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 446, 142);
		panel.add(scrollPane);
		
		
		table = new JTable();
		DTM=new DefaultTableModel(null,tableTitle)
		{
			public boolean isCellEditable(int rowindex,int colindex)
			{
				if(colindex==0||colindex==1||colindex==5)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
		};
		
		DTM.addTableModelListener(this);
		table.setModel(DTM);
		refreshTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("删除会员信息");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int row = table.getSelectedRow();
				int column = 0;
				System.out.println(row+" "+column);
				String id = (String)table.getValueAt(row,column);
				
				try
				{
					vipmysql.delete(vipmysql.getById(id));
					JOptionPane.showMessageDialog(null,"成功删除指定数据","提示信息", JOptionPane.INFORMATION_MESSAGE);
					Unit.logmysql.VIP_Delete(Unit.log.setLog(id));
				}
				catch (Exception e)
				{
					//e.printStackTrace();
					System.err.println("操作失败！");
				}
				refreshTable();
			}
		});
		btnNewButton.setBounds(10, 199, 446, 32);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("修改会员信息的时候，直接在表格中修改，自动保存！");
		label.setBounds(10, 174, 394, 15);
		panel.add(label);
	}

	@Override
	public void tableChanged(TableModelEvent e)
	{
		int row = e.getFirstRow();
		int column = e.getColumn(); 
		if(row!=-1)
		{
			String id = (String) table.getValueAt(row,0);
			String user = (String) table.getValueAt(row,1);
			String name = (String) table.getValueAt(row,2);
			int count;
			String telephone = (String) table.getValueAt(row,4);
			if(table.getValueAt(row,3) instanceof String)
			{
				count = Integer.valueOf((String) table.getValueAt(row,3));
			}
			else 
			{
				count = (int)table.getValueAt(row,3);
			}
			
			VIP vip = new VIP(id,user,name,count,telephone,null);
			try
			{
				vipmysql.update(vip);
				JOptionPane.showMessageDialog(null,"已成功修改内容："+(String) table.getValueAt(row,column),"信息提示", JOptionPane.INFORMATION_MESSAGE);
				Unit.logmysql.VIP_Change(Unit.log.setLog((String) table.getValueAt(row,column),0,vip.getId()));
			}
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				System.err.println("修改错误");
				e1.printStackTrace();
			}
		}
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
