package Xingxin.Record;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;
import java.util.Vector;

/**
 * @author 231
 * @date 2020-06-22 8:46
 */
public class RecordFrame extends JFrame {

    JTable table = null;
    String[] labels4={"id","用户姓名","图书编号","书名","借出时间","期限时间","归还时间","是否逾期"};
    JScrollPane scrollPane1 = null;
    JPanel panel4 = new JPanel();

    JButton returnBook = new JButton("归还");

    public RecordFrame(){
    BorrowDao dao3 = new BorrowDaoImpl();
    List<Borrow> borrowList1=null;
    borrowList1=dao3.getAll();
    Vector<Vector<Object>> vectordata=new Vector<>();
                    for(Borrow borrow:borrowList1){
        Vector<Object> objs=new Vector<>();
        objs.add(borrow.getId());
        objs.add(borrow.getUsername());
        objs.add(borrow.getBooknumber());
        objs.add(borrow.getBookname());
        objs.add(borrow.getLoandate());
        objs.add(borrow.getDeadline());
        objs.add(borrow.getReturntime());
        objs.add(borrow.isWhetheritisoverdue());
        vectordata.add(objs);
    }
    Vector<String> columnNames=new Vector<>();
                    for(String label: labels4){
        columnNames.add(label);
    }
    table=new JTable(vectordata, columnNames);
    scrollPane1 = new JScrollPane(table);
                    panel4.add(scrollPane1);
                    scrollPane1.setBounds(10, 10, 600, 400);
                    scrollPane1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setLayout(null);
        this.add(scrollPane1);
        setLocation(500, 200);
        this.setSize(1000, 600);
        this.setVisible(true);
}
}


