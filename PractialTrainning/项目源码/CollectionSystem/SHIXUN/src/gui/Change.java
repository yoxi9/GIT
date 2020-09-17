package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Change implements ActionListener {
    private JFrame jf;
    private JLabel jlcod;
    private JTextField jtfold;
    private JLabel jlnew;
    private JTextField jtfnew;
    private JLabel jlcon;
    private JTextField jtfcon;
    private JButton jbcon;
    private JButton jbre;

    public Change(){
        initialize();
        jf.setVisible(true);
    }

    private void initialize(){
        jf= new JFrame();
        jf.setBounds(100, 100, 215, 330);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.getContentPane().setLayout(null);
        jf.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "修改密码", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 10, 179, 271);
        jf.getContentPane().add(panel);
        panel.setLayout(null);



    }





    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
