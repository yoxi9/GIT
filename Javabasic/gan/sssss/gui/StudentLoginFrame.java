package gui;

import dao.DBUtils;
import dao.UserDao;
import Daoimpl.UserDaoImpl;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentLoginFrame extends JFrame implements ActionListener {
    JLabel jName = new JLabel("名字：");
    JLabel jPassword = new JLabel("密码：");

    JTextField jtfName = new JTextField("", 40);
    JTextField jtfPassword = new JPasswordField("", 40);

    JButton jButtonInsert = new JButton("注册");
    JButton jButtonDelete = new JButton("注销");
    JButton jButtonSearch = new JButton("登录");

    public StudentLoginFrame(String title) {
        super(title);
        Container container = this.getContentPane();
        container.setLayout(null);

        jName.setBounds(10, 20, 40, 30);
        jtfName.setBounds(60, 20, 100, 30);

        jPassword.setBounds(10, 60, 40, 30);
        jtfPassword.setBounds(60, 60, 100, 30);

        jButtonInsert.setBounds(10, 150, 80, 40);
        jButtonDelete.setBounds(100, 150, 80, 40);
        jButtonSearch.setBounds(190, 150, 80, 40);

        container.add(jName);
        container.add(jtfName);

        container.add(jPassword);
        container.add(jtfPassword);

        container.add(jButtonInsert);
        container.add(jButtonDelete);
        container.add(jButtonSearch);
        jButtonInsert.addActionListener(this);
        jButtonDelete.addActionListener(this);
        jButtonSearch.addActionListener(this);

        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        UserDao dao = new UserDaoImpl();
        System.out.println("系统正在" + e.getActionCommand());
        if ("注册".equals(e.getActionCommand())) {
            User user = new User();
            user.setName(jtfName.getText());
            user.setPassword(jtfPassword.getText());
            int code = dao.add(user);
            System.out.println("成功将姓名为：" + user.getName() + "的用户注册信息添加到数据库中");
            System.out.println("----------------------------------------------");
        } else if ("注销".equals(e.getActionCommand())) {
            String sql = "delete from users where name=?";
            int code = DBUtils.update(sql, "A");
            System.out.println("已经成功注销用户A的基本信息");
            System.out.println("---------------------------------------------");
        } else if ("登录".equals(e.getActionCommand())) {
            List<User> userList = null;
            User user = new User();
            user.setName(jtfName.getText());
            user.setPassword(jtfPassword.getText());
            userList = dao.getUser(user);
            System.out.println("登陆成功，欢迎您：" + user.getName());
            System.out.println("---------------------------------------------");
            if (userList.size() != 0) {
                new StudentFrame("学生信息修改");
                this.setVisible(false);
            }

        }

    }

    public static void main(String[] args) {
        new StudentLoginFrame("学生管理");
    }
}