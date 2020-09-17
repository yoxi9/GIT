package Xingxin;

import Xingxin.administrator.*;
import Xingxin.book.Book;
import Xingxin.book.BookDao;
import Xingxin.book.BookDaoImpl;
import Xingxin.dialog.LogInInfo;
import Xingxin.dialog.RegisterQs;
import Xingxin.user.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;

public class Login extends JFrame implements ActionListener {

    public static String us;

    JLabel username = new JLabel("用户名：");
    JLabel password = new JLabel("密码：");

    JTextField usernameTf = new JTextField("", 40);
    JPasswordField passwordPf = new JPasswordField("", 40);

    JButton login = new JButton("登录");
    JButton register = new JButton("注册");
    JButton forgetpassword = new JButton("忘记密码？");


    JRadioButton superadministrator = new JRadioButton("超管");
    JRadioButton administrator = new JRadioButton("管理员");
    JRadioButton user = new JRadioButton("用户");

    public Login() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        username.setBounds(100, 80, 100, 30);
        password.setBounds(100, 130, 100, 30);
        usernameTf.setBounds(200, 80, 200, 30);
        passwordPf.setBounds(200, 130, 200, 30);
        login.setBounds(200, 250, 100, 40);
        register.setBounds(300, 250, 100, 40);
        forgetpassword.setBounds(100, 250, 100, 40);

        register.setMargin(new Insets(0, 0, 0, 0));
        register.setIconTextGap(0);
        register.setBorderPainted(false);
        register.setBorder(null);
        register.setFocusPainted(false);
        register.setContentAreaFilled(false);

        forgetpassword.setMargin(new Insets(0, 0, 0, 0));
        forgetpassword.setIconTextGap(0);
        forgetpassword.setBorderPainted(false);
        forgetpassword.setBorder(null);
        forgetpassword.setFocusPainted(false);
        forgetpassword.setContentAreaFilled(false);

        superadministrator.setBounds(10, 280, 100, 40);
        administrator.setBounds(110, 280, 100, 40);
        user.setBounds(210, 280, 100, 40);


        ButtonGroup group = new ButtonGroup();
        group.add(superadministrator);
        group.add(administrator);
        group.add(user);


        add(username);
        add(password);
        add(usernameTf);
        add(passwordPf);
        add(login);
        add(register);
        add(forgetpassword);
        add(superadministrator);
        add(administrator);
        add(user);

        login.addActionListener(this);
        register.addActionListener(this);
        forgetpassword.addActionListener(this);

        setLocation(500, 200);
        this.setSize(500, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
        }
        InitGlobalFont(new Font("柳公权柳体", Font.PLAIN, 18));
        new Login();
    }

    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AdministratorDao dao = new AdministratorDaoImpl();
        UserDao dao2 = new UserDaoImpl();
        if ("登录".equals(e.getActionCommand())) {
            if (administrator.isSelected()) {
                List<Administrator> administratorList = null;
                Administrator administrator1 = new Administrator();
                administrator1.setUserName(usernameTf.getText());
                administrator1.setPassword(passwordPf.getText());
                administrator1.setAuthority(administrator.getText());
                administratorList = dao.getAdministrator(administrator1);
                if (administratorList.size() != 0) {
                    BookDao dao3 = new BookDaoImpl();
                    List<Book> bookList = null;
                    bookList = dao3.getAll();
                    new AdministratorFrame(bookList);
                    dispose();
                }else{
                    new LogInInfo();
                }
            } else if (user.isSelected()) {
                List<User> userList = null;
                User user = new User();
                user.setUserName(usernameTf.getText());
                user.setPassword(passwordPf.getText());
                userList = dao2.getUser(user);
                if (userList.size() != 0) {
                    BookDao dao3 = new BookDaoImpl();
                    List<Book> bookList = null;
                    bookList = dao3.getAll();
                    new UserFrame(bookList);
                    us = usernameTf.getText();
                    dispose();
                }else{
                    new LogInInfo();
                }
            } else if (superadministrator.isSelected()) {
                List<Administrator> administratorList = null;
                Administrator administrator = new Administrator();
                administrator.setUserName(usernameTf.getText());
                administrator.setPassword(passwordPf.getText());
                administrator.setAuthority(superadministrator.getText());
                administratorList = dao.getAdministrator(administrator);
                if (administratorList.size() != 0) {
                    BookDao dao3 = new BookDaoImpl();
                    List<Book> bookList = null;
                    bookList = dao3.getAll();
                    new SuperAdministratorTableFrame(bookList);
                    dispose();
                }else{
                    new LogInInfo();
                }
            }
        } else if ("注册".equals(e.getActionCommand())) {
            if (administrator.isSelected()) {
                new AdministratorRegister();
            } else if (superadministrator.isSelected()) {
                new RegisterQs();
            } else if (user.isSelected()) {
                new UserRegister();
            }
        }else if ("忘记密码？".equals(e.getActionCommand())) {
            if (user.isSelected()) {
                new ForgetPassword();
            }
        }
    }
}
