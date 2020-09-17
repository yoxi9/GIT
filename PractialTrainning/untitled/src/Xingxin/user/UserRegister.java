package Xingxin.user;

import Xingxin.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 231
 * @date 2020-06-18 23:55
 */
public class UserRegister extends JFrame implements ActionListener {
    JLabel username = new JLabel("用户名:");
    JTextField usernameJf = new JTextField();
    JLabel password = new JLabel("密码:");
    JTextField passwordJf = new JTextField();
    JLabel name = new JLabel("姓名:");
    JTextField nameJf = new JTextField();
    JLabel sex = new JLabel("性别:");
    JTextField sexJf = new JTextField();
    JLabel age = new JLabel("年龄:");
    JTextField ageJf = new JTextField();
    JLabel telephoneNumber = new JLabel("联系方式:");
    JTextField telephoneNumberJf = new JTextField();

    JLabel questionjl = new JLabel("验证问题:");
    JLabel answerjl = new JLabel("验证答案:");

    JComboBox question = new JComboBox();
    JTextField answer = new JTextField();

    JButton RegisterButton = new JButton("确定");

    public UserRegister() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        username.setBounds(10,20,100,20);
        usernameJf.setBounds(120,20,120,20);
        password.setBounds(10,40,100,20);
        passwordJf.setBounds(120,40,120,20);
        name.setBounds(10,60,100,20);
        nameJf.setBounds(120,60,120,20);
        sex.setBounds(10,80,100,20);
        sexJf.setBounds(120,80,120,20);
        age.setBounds(10,100,100,20);
        ageJf.setBounds(120,100,120,20);
        telephoneNumber.setBounds(10,120,100,20);
        telephoneNumberJf.setBounds(120,120,120,20);
        RegisterButton.setBounds(100,200,60,30);

        question.addItem("你家乡的名字？");
        question.addItem("你父亲的姓名？");
        question.addItem("你母亲的姓名？");
        question.addItem("你第一次坐飞机去了哪？");
        question.addItem("你最喜欢的动漫角色是谁？");
        question.addItem("你最喜欢的明星？");
        question.addItem("你最好的朋友？");

        questionjl.setBounds(10,140,120,20);
        answerjl.setBounds(10,160,120,20);
        question.setBounds(100,140,120,20);
        answer.setBounds(100,160,120,20);


        add(username);add(usernameJf);
        add(password);add(passwordJf);
        add(name);add(nameJf);
        add(sex);add(sexJf);
        add(age);add(ageJf);
        add(telephoneNumber);add(telephoneNumberJf);
        add(name);add(nameJf);
        add(RegisterButton);
        add(questionjl);add(answerjl);
        add(question);add(answer);

        RegisterButton.addActionListener(this);

        setLocation(400, 300);
        this.setSize(1000, 1000);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserDao dao = new UserDaoImpl();
        if ("确定".equals(e.getActionCommand())){
            User user = new User();
            user.setUserName(usernameJf.getText());
            user.setPassword(passwordJf.getText());
            user.setName(nameJf.getText());
            user.setSex(sexJf.getText());
            user.setAge(ageJf.getText());
            user.setTelephoneNumber(telephoneNumberJf.getText());
            user.setQuestion((String) question.getSelectedItem());
            user.setAnswer(answer.getText());
            dao.addQuestion(user);
            dao.addUser(user);
            new Login();
        }
    }
}