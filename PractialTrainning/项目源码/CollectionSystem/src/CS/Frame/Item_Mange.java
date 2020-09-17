package CS.Frame;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import CS.Kit.Unit;
import CS.Mysql.ItemMysql;
import CS.Object.Item;
import CS.Object.VIP;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Item_Mange implements TableModelListener {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel DTM;
	private String tableTitle[]={"商品ID", "商品名称","商品价格","库存数量","备注信息"};

	private ItemMysql itemmysql = new ItemMysql();

	public Item_Mange()
	{
		initialize();
		frame.setVisible(true);
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "库存管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 414, 241);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 394, 151);
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
		
		JButton btnNewButton = new JButton("删除选中商品");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int row = table.getSelectedRow();
				int column = 0;
				System.out.println(row+" "+column);
				String id = (String)table.getValueAt(row,column);
				
				try
				{
					itemmysql.delete(itemmysql.getById(id));
					JOptionPane.showMessageDialog(null,"成功删除指定数据","提示信息", JOptionPane.INFORMATION_MESSAGE);
					Unit.logmysql.Item_Delete(Unit.log.setLog(id,0,"敏感操作"));
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
					System.err.println("操作失败！");
				}
				refreshTable();
			}
		});
		btnNewButton.setBounds(10, 202, 394, 29);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("修改商品信息的时候，直接在表格中修改，自动保存！");
		label.setBounds(10, 181, 394, 15);
		panel.add(label);
	}
	
	private void refreshTable()
	{
		List list = itemmysql.getAll();
		Object tableText[][] = new Object[list.size()][];
		for(int i=0;i<list.size();i++)
		{
			HashMap hm = (HashMap) list.get(i);
			Object temp[]=new Object[5];
			for(Object key:hm.keySet())
			{
				if(key.equals("id"))
				{
					temp[0]=hm.get(key);
				}
				if(key.equals("name"))
				{
					temp[1]=hm.get(key);
				}
				if(key.equals("prices"))
				{
					temp[2]=hm.get(key);
				}
				if(key.equals("count"))
				{
					temp[3]=hm.get(key);
				}
				if(key.equals("note"))
				{
					temp[4]=hm.get(key);
				}
			}
			tableText[i]=temp;
		}
		DTM.setDataVector(tableText,tableTitle);	
	}

	@Override
	public void tableChanged(TableModelEvent e)
	{
		int row = e.getFirstRow();
		int column = e.getColumn(); 
		if(row!=-1)
		{
			String id = (String) table.getValueAt(row,0);
			String name = (String) table.getValueAt(row,1);
			double prices;
			int count;
			String note = (String) table.getValueAt(row,4);
			if(table.getValueAt(row,2) instanceof String)
			{
				prices = Float.valueOf((String) table.getValueAt(row,2));
			}
			else 
			{
				prices = (float)table.getValueAt(row,2);
			}
			
			if(table.getValueAt(row,3) instanceof String)
			{
				count = Integer.valueOf((String) table.getValueAt(row,3));
			}
			else 
			{
				count = (int)table.getValueAt(row,3);
			}
			
			Item item = new Item(id,name,prices,count,note);
			try
			{
				itemmysql.update(item);
				item=itemmysql.getById(item.getId());
				JOptionPane.showMessageDialog(null,"已成功修改内容："+(String) table.getValueAt(row,column),"信息提示", JOptionPane.INFORMATION_MESSAGE);
				Unit.logmysql.Item_Change(Unit.log.setLog(item.getId(),item.getCount(),"无"));
			}
			catch (Exception e1)
			{
				// TODO Auto-generated catch block
				System.err.println("修改错误");
				e1.printStackTrace();
			}
		}
	}
}
