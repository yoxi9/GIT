package gui;

import entity.Student;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;
import java.util.Vector;

public class StudentTableFrame  extends JFrame {
    public StudentTableFrame(List<Student> list){
        Vector<Vector<Object>> vectordata=new Vector<>();
        for(Student student:list){
            Vector<Object> objs=new Vector<>();
            objs.add(new Integer(student.getId()));
            objs.add(student.getName());
            objs.add(student.getGrade());
            objs.add(new Integer(student.getNumber()));
            vectordata.add(objs);
        }
        String[] labels={"序号","班级","名字","学号"};

        Vector<String> columnNames=new Vector<>();
        for(String label:labels){
            columnNames.add(label);
        }

        JTable table=new JTable(vectordata,columnNames);

        JScrollPane scrollPane = new JScrollPane(table);

        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBorder(new TitledBorder(null,"总面板",TitledBorder.LEADING,
                TitledBorder.TOP,null,null));

        this.getContentPane().add(panel);

        panel.add(scrollPane);
        scrollPane.setBounds(15,15,300,200);
        scrollPane.setBorder(new TitledBorder(null,"分数面板",
                TitledBorder.LEADING,TitledBorder.TOP,null,null));
        this.setSize(420,300);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
