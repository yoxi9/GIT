package Xingxin;

import Xingxin.dialog.ExchangePassword;
import Xingxin.dialog.QuestionInfo;
import Xingxin.user.User;
import Xingxin.user.UserDao;
import Xingxin.user.UserDaoImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author 231
 * @date 2020-06-19 8:27
 */
public class ForgetPassword extends JFrame implements ActionListener {
    JLabel username = new JLabel("用户名：");
    JTextField usernameTf = new JTextField();
    JLabel password1 = new JLabel("新密码：");
    JTextField passwordTf1 = new JTextField();
    JLabel password2 = new JLabel("请再次输入：");
    JTextField passwordTf2 = new JTextField();
    JLabel choose = new JLabel("请选择密保问题");
    JComboBox question = new JComboBox();
    JLabel answer = new JLabel("答案：");
    JTextField answerTf = new JTextField();
    JButton submit = new JButton("确定");

    public ForgetPassword() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        username.setBounds(10,10,60,40);
        password1.setBounds(10,50,60,40);
        password2.setBounds(10,100,60,40);
        choose.setBounds(10,150,60,40);
        answer.setBounds(10,200,60,40);
        usernameTf.setBounds(90,10,160,40);
        passwordTf1.setBounds(90,50,160,40);
        passwordTf2.setBounds(90,100,160,40);
        question.setBounds(90,150,160,40);
        answerTf.setBounds(90,200,160,40);
        submit.setBounds(70,280,100,40);

        question.addItem("你家乡的名字？");
        question.addItem("你父亲的姓名？");
        question.addItem("你母亲的姓名？");
        question.addItem("你第一次坐飞机去了哪？");
        question.addItem("你最喜欢的动漫角色是谁？");
        question.addItem("你最喜欢的明星？");
        question.addItem("你最好的朋友？");

        add(username);add(usernameTf);add(password1);add(password2);
        add(passwordTf1);add(passwordTf2);add(question);add(choose);
        add(answer);add(answerTf);add(submit);

        submit.addActionListener(this);

        setLocation(500, 300);
        this.setSize(600, 600);
        this.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        UserDao dao = new UserDaoImpl();
        if ("确定".equals(e.getActionCommand())) {
            List<User> userList = null;
            User user = new User();
            user.setUserName(usernameTf.getText());
            user.setAnswer(answerTf.getText());
            userList = dao.getAnswer(user);
            if (userList.size() != 0) {
                String pw1 = passwordTf1.getText();
                String pw2 = passwordTf2.getText();
                if (pw1.equals(pw2)){
                    User user1 = new User();
                    user1.setUserName(usernameTf.getText());
                    user1.setPassword(passwordTf1.getText());
                    dao.update(user1);
                }else {
                    new ExchangePassword();
                }
            }else {
                new QuestionInfo();
            }
        }
    }
}
