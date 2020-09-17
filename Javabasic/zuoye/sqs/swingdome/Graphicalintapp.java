package swingdome;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class Graphicalintapp extends JFrame implements ActionListener {

    JComboBox<Phone> phones = null;
    private ButtonGroup bg = new ButtonGroup();

    JList listLesson;
    JTextArea jtaDemo;
    JButton btnExit;

    public Graphicalintapp() throws HeadlessException {
    }

    public Graphicalintapp(String title) throws HeadlessException {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();

        Box boxV1 = Box.createVerticalBox();
        boxV1.add(new JLabel("请选择籍贯"));
        JRadioButton jrbChina = new JRadioButton("中国");
        jrbChina.setActionCommand("中国");
        JRadioButton jrbEngland = new JRadioButton("英国");
        jrbEngland.setActionCommand("英国");

        boxV1.add(jrbChina);
        boxV1.add(jrbEngland);
        boxV1.add(Box.createVerticalStrut(200));
        bg.add(jrbChina);
        bg.add(jrbEngland);
        jrbChina.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                jtaDemo.setText(jtaDemo.getText() + "\n您是否选择了中国？" + jrbChina.isSelected() +
                        "您选择的国家是：" + bg.getSelection().getActionCommand());
            }
        });


        Box boxV2 = Box.createVerticalBox();
        boxV2.add(new JLabel("请选择选修的课程"));
        String[] strLesson = new String[]{"高数                              ", "java                                  ",
                "历史                                 ",
                "网页设计                            ", "物理                                  ",
                " 英语                                 ", "物联网开发                                  ",
                "体育                                  ", "数据库                                  "};
        // JList<String> jl = new JList<>(strLesson);
        listLesson = new JList(strLesson);
        
        listLesson.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int[] indices = listLesson.getSelectedIndices();
                List<String> list = listLesson.getSelectedValuesList();
                for (int i = 0; i < list.size(); i++) {
                    jtaDemo.setText(jtaDemo.getText() + "\n您选择了第" + indices[i] + "门课，为：" + list.get(i));
                }
            }
        });
        boxV2.add(new JScrollPane(listLesson));


        Box boxV3 = Box.createVerticalBox();
        Phone[] phs=new Phone[] {new Phone("小米","3999"),
        		new Phone("华为","4999"),
        		new Phone("三星","5999"),
        		new Phone("苹果","6999")};
        phones = new JComboBox<Phone>(phs);
        boxV3.add(phones);
        phones.setBorder(BorderFactory.createTitledBorder("请选择手机品牌："));
        boxV3.add(Box.createVerticalStrut(200));
        boxV3.add(Box.createVerticalGlue());
        phones.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                jtaDemo.setText(jtaDemo.getText() + "\n您选择了第" + phones.getSelectedIndex() +
                        "个手机，为" + phones.getSelectedItem());
            }
        });


        Box boxH1 = Box.createHorizontalBox();
        boxH1.add(boxV1);
        boxH1.add(Box.createHorizontalStrut(15));
        boxH1.add(boxV2);
        boxH1.add(Box.createHorizontalStrut(15));
        boxH1.add(boxV3);
        boxH1.add(Box.createHorizontalStrut(15));


        Box boxH2 = Box.createHorizontalBox();
        jtaDemo = new JTextArea("请选择国籍、选修课程、手机品牌", 5, 20);
        boxH2.add(jtaDemo);

        Box boxV4 = Box.createVerticalBox();
        btnExit = new JButton("退出");
        boxV4.add(btnExit);

        boxH2.add(boxV4);

        btnExit.addActionListener(this);

        Box baseBox = Box.createVerticalBox();
        baseBox.add(boxH1);
        baseBox.add(boxH2);
        this.setContentPane(baseBox);

        setTitle("基本信息选择");
        setBounds(100, 100, 550, 550);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            dispose();
        }
    }

    public static void main(String[] args) {
        Graphicalintapp vt = new Graphicalintapp("");
    }

}
