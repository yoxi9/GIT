package Xingxin.administrator;

import Xingxin.Login;
import Xingxin.dialog.KeyWordInfo;

import javax.swing.*;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author 231
 * @date 2020-06-18 11:14
 */
public class AdministratorRegister extends JFrame implements ActionListener {
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
    JLabel homeAddress = new JLabel("家庭住址:");
    JTextField homeAddressJf = new JTextField();
    JLabel keyWord = new JLabel("密钥:");
    JTextField keyWordJt = new JTextField();


    JButton RegisterButton = new JButton("确定");

    public AdministratorRegister() throws HeadlessException {
        Container container = this.getContentPane();
        container.setLayout(null);

        username.setBounds(10, 20, 100, 20);
        usernameJf.setBounds(120, 20, 120, 20);
        password.setBounds(10, 40, 100, 20);
        passwordJf.setBounds(120, 40, 120, 20);
        name.setBounds(10, 60, 100, 20);
        nameJf.setBounds(120, 60, 120, 20);
        sex.setBounds(10, 80, 100, 20);
        sexJf.setBounds(120, 80, 120, 20);
        age.setBounds(10, 100, 100, 20);
        ageJf.setBounds(120, 100, 120, 20);
        telephoneNumber.setBounds(10, 120, 100, 20);
        telephoneNumberJf.setBounds(120, 120, 120, 20);
        homeAddress.setBounds(10, 140, 100, 20);
        homeAddressJf.setBounds(120, 140, 120, 20);
        keyWord.setBounds(10, 160, 100, 20);
        keyWordJt.setBounds(120, 160, 120, 20);


        RegisterButton.setBounds(100, 200, 60, 30);


        add(username);
        add(usernameJf);
        add(password);
        add(passwordJf);
        add(name);
        add(nameJf);
        add(sex);
        add(sexJf);
        add(age);
        add(ageJf);
        add(telephoneNumber);
        add(telephoneNumberJf);
        add(homeAddress);
        add(homeAddressJf);
        add(keyWord);
        add(keyWordJt);

        add(name);
        add(nameJf);
        add(RegisterButton);

        RegisterButton.addActionListener(this);

        setLocation(400, 300);
        this.setSize(1000, 1000);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AdministratorDao dao = new AdministratorDaoImpl();
        KeyDao dao1 = new KeyImpl();
        List<Key> keyList = null;
        Key key = new Key();
        key.setId(1);
        key.setKey(keyWordJt.getText());
        keyList = dao1.getKey(key);
        if (keyList.size() != 0) {
            if ("确定".equals(e.getActionCommand())) {
                Administrator administrator = new Administrator();
                administrator.setUserName(usernameJf.getText());
                administrator.setPassword(passwordJf.getText());
                administrator.setName(nameJf.getText());
                administrator.setSex(sexJf.getText());
                administrator.setAge(ageJf.getText());
                administrator.setTelephoneNumber(telephoneNumberJf.getText());
                administrator.setHomeAddress(homeAddressJf.getText());
                dao.addAdministrator(administrator);
                dispose();
                new Login();
            }
        }else{
            new KeyWordInfo();
        }
    }
}
