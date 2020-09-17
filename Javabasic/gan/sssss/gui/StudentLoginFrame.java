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
    JLabel jName = new JLabel("���֣�");
    JLabel jPassword = new JLabel("���룺");

    JTextField jtfName = new JTextField("", 40);
    JTextField jtfPassword = new JPasswordField("", 40);

    JButton jButtonInsert = new JButton("ע��");
    JButton jButtonDelete = new JButton("ע��");
    JButton jButtonSearch = new JButton("��¼");

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
        System.out.println("ϵͳ����" + e.getActionCommand());
        if ("ע��".equals(e.getActionCommand())) {
            User user = new User();
            user.setName(jtfName.getText());
            user.setPassword(jtfPassword.getText());
            int code = dao.add(user);
            System.out.println("�ɹ�������Ϊ��" + user.getName() + "���û�ע����Ϣ��ӵ����ݿ���");
            System.out.println("----------------------------------------------");
        } else if ("ע��".equals(e.getActionCommand())) {
            String sql = "delete from users where name=?";
            int code = DBUtils.update(sql, "A");
            System.out.println("�Ѿ��ɹ�ע���û�A�Ļ�����Ϣ");
            System.out.println("---------------------------------------------");
        } else if ("��¼".equals(e.getActionCommand())) {
            List<User> userList = null;
            User user = new User();
            user.setName(jtfName.getText());
            user.setPassword(jtfPassword.getText());
            userList = dao.getUser(user);
            System.out.println("��½�ɹ�����ӭ����" + user.getName());
            System.out.println("---------------------------------------------");
            if (userList.size() != 0) {
                new StudentFrame("ѧ����Ϣ�޸�");
                this.setVisible(false);
            }

        }

    }

    public static void main(String[] args) {
        new StudentLoginFrame("ѧ������");
    }
}