package gui;

import dao.DBUtils;
import dao.StudentDao;
import Daoimpl.StudentDaoImpl;
import entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentFrame extends JFrame implements ActionListener {
	
    JLabel jId = new JLabel("序号：");
    JLabel jGrade = new JLabel("班级：");
    JLabel jName = new JLabel("姓名：");
    JLabel jNum = new JLabel("学号:");

    JTextField jtfId = new JTextField("", 40);
    JTextField jtfGrade = new JTextField("", 40);
    JTextField jtfName = new JTextField("", 40);
    JTextField jtfNum = new JTextField("", 40);

    JButton jButtonInsert = new JButton("Add");
    JButton jButtonDelete = new JButton("Delete");
    JButton jButtonUpdate = new JButton("Change");
    JButton jButtonSearch = new JButton("Search");

    public StudentFrame(String title) {
        super(title);
        Container container = this.getContentPane();

        container.setLayout(null);
        jId.setBounds(10, 20, 40, 30);
        jtfId.setBounds(60, 20, 100, 30);

        jGrade.setBounds(10, 60, 40, 30);
        jtfGrade.setBounds(60, 60, 100, 30);

        jName.setBounds(10, 100, 40, 30);
        jtfName.setBounds(60, 100, 100, 30);

        jNum.setBounds(10, 140, 40, 30);
        jtfNum.setBounds(60, 140, 100, 30);

        jButtonInsert.setBounds(10, 230, 100, 30);
        jButtonDelete.setBounds(120, 230, 100, 30);
        jButtonUpdate.setBounds(10, 270, 100, 30);
        jButtonSearch.setBounds(120, 270, 100, 30);

        container.add(jId);
        container.add(jtfId);

        container.add(jGrade);
        container.add(jtfGrade);

        container.add(jName);
        container.add(jtfName);

        container.add(jNum);
        container.add(jtfNum);

        container.add(jButtonInsert);
        container.add(jButtonDelete);
        container.add(jButtonUpdate);
        container.add(jButtonSearch);
        jButtonInsert.addActionListener(this);
        jButtonDelete.addActionListener(this);
        jButtonUpdate.addActionListener(this);
        jButtonSearch.addActionListener(this);

        this.setSize(300, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StudentDao dao = new Daoimpl.StudentDaoImpl();
        System.out.println("系统正在" + e.getActionCommand());
        if ("Add".equals(e.getActionCommand())) {
            Student student = new Student();
            student.setId(Integer.parseInt(jtfId.getText()));
            student.setGrade(jtfGrade.getText());
            student.setName(jtfName.getText());
            student.setNumber(Integer.parseInt(jtfNum.getText()));

            int code = dao.add(student);
            System.out.println("成功将姓名为：" + student.getName() + "的学生信息添加到数据库中");
            System.out.println("----------------------------------------------");
        } else if ("Delete".equals(e.getActionCommand())) {
            Student student = new Student();
            student.setId(Integer.parseInt(jtfId.getText()));
            int code = dao.delete(student);
            System.out.println("成功将序号为" +student.getId()+"的学生信息从数据库中删除");
            System.out.println("----------------------------------------------");
        } else if ("Change".equals(e.getActionCommand())) {

            String sql = "update student set name='X' where id=2";
            Integer id = Integer.parseInt(jtfId.getText());

            int code = DBUtils.update(sql);
            System.out.println("成功将序号为2的学生姓名更改为：X");
            System.out.println("----------------------------------------------");
        } else if ("Search".equals(e.getActionCommand())) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet rs = null;

            try {
                connection = DBUtils.getConnection();

                statement = connection.prepareStatement("select id,grade,name,number from student where id=?");
                System.out.println("查询完毕");
                System.out.println("-------------------------------------");
                statement.setInt(1, Integer.parseInt(jtfId.getText()));
                rs = statement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println(id);
                    jtfGrade.setText(rs.getString(2));
                    jtfName.setText(rs.getString(3));
                    jtfNum.setText(rs.getString(4));
                }
            } catch (ClassNotFoundException | SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } finally {
                DBUtils.closeResource(connection, statement, rs);
            }
        }
    }

    public static void main(String[] args) {
        new StudentFrame("Student");
    }

}


