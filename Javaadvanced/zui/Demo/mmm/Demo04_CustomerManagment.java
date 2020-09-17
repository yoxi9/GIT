package mmm;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class CustomerFrame extends JFrame implements ActionListener{
	
	JLabel jId=new JLabel("ID：");
	JLabel jName=new JLabel("姓名：");
	JLabel jAge=new JLabel("年龄：");
	JLabel jSalary=new JLabel("工资：");
	
	JTextField jtfId=new JTextField(" ",20);
	JTextField jtfName=new JTextField(" ",20);
	JTextField jtfAge=new JTextField(" ",20);
	JTextField jtfSalary=new JTextField(" ",20);
	
	JButton jButtonInsert=new JButton("Insert");
	JButton jButtonDelete=new JButton("Update");
	JButton jButtonSearch=new JButton("Delete");
	
	public CustomerFrame(String title){
		super(title);
		
        Container container=this.getContentPane();
		
		container.setLayout(null);
		
		jId.setBounds(10, 20, 40, 30);
		jtfId.setBounds(60, 20, 100, 30);
		
		jName.setBounds(10, 60, 40, 30);
		jtfName.setBounds(60, 60, 100, 30);
		
		jAge.setBounds(10, 100, 40, 30);
		jtfAge.setBounds(60, 100, 100, 30);
		
		jSalary.setBounds(10, 140, 40, 30);
		jtfSalary.setBounds(60, 140, 100, 30);
		
		jButtonInsert.setBounds(10, 160, 80, 30);
		jButtonDelete.setBounds(100, 160, 80, 30);
		jButtonSearch.setBounds(190, 160, 80, 30);
		
		container.add(jId);
		container.add(jtfId);
		
		container.add(jName);
		container.add(jtfName);
		
		container.add(jAge);
		container.add(jtfAge);
		
		container.add(jSalary);
		container.add(jtfSalary);
		
		container.add(jButtonInsert);
		container.add(jButtonDelete);
		container.add(jButtonSearch);
		
		jButtonInsert.addActionListener(this);
		jButtonDelete.addActionListener(this);
		jButtonSearch.addActionListener(this);
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection connection=null;
		System.out.println(e.getActionCommand());
		if("Insert".equals(e.getActionCommand())){
			
			String sql="insert into customers (id,name,age,salary) values(?,?,?,?)";
			Integer id=Integer.parseInt(jtfId.getText());
			String name=jtfName.getText();
			String age=jtfAge.getText();
			Integer salary=Integer.parseInt(jtfSalary.getText());
			
			
			int code=DBUtils.update(sql, id,name,age,salary);
			System.out.println(code);
			
			
		}else if("Update".equals(e.getActionCommand())){
			
			String sql="update customers set salary='？*1.1' where id=1";
			Integer id=Integer.parseInt(jtfId.getText());

			int code=DBUtils.update(sql);
			System.out.println(code);	
			
			
		}else if ("Delete".equals(e.getActionCommand())) {
			
		    try {
		        Statement statement1 = connection.createStatement();
		        String sql1 = "delete from employees where id=1";
		        statement1.executeUpdate(sql1);
		    } catch (SQLException e2) {
		        e2.printStackTrace();
		    }
		}
	}
	
}

public class Demo04_CustomerManagment {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerFrame("客户管理");
	}

}
