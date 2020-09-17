package Xingxin.user;

import Xingxin.Login;
import Xingxin.Record.Borrow;
import Xingxin.Record.BorrowDao;
import Xingxin.Record.BorrowDaoImpl;
import Xingxin.Record.RecordFrame;
import Xingxin.book.Book;
import Xingxin.book.BookDao;
import Xingxin.book.BookDaoImpl;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import static Xingxin.Login.us;

public class UserFrame extends JFrame implements ActionListener{
    JButton libraryManagement = new JButton("借书");
    JButton libraryManagement1 = new JButton("还书");

    JButton searchBook = new JButton("查询书籍");
    JButton exchangeAccount = new JButton("切换账号");

    JMenuBar menuBar = new JMenuBar();
    JMenu m1 = new JMenu("图书");
    JMenu m2 = new JMenu("记录");
    JMenu m3 = new JMenu("设置");

    JMenuItem insertRow = new JMenuItem("添加行");
    JMenuItem save = new JMenuItem("保存");
    JMenuItem Delete = new JMenuItem("删除行");
    JMenuItem exchange = new JMenuItem("修改并保存");
    JTable table = null;
    JTable table1 = null;
    JTable table2 = null;
    JTable table3 = null;


    String[] labels1 ={"图书编号","书名","作者","出版社","图书类别","出版时间","总数量","剩余数量"};
    String[] labels2={"图书编号","书名","作者","出版社","图书类别","出版时间","总数量","剩余数量"};
    String[] labels3={"用户名","密码","姓名","性别","年龄","权限","联系方式","家庭住址"};
    String[] labels4={"id","用户姓名","图书编号","书名","借出时间","归还时间","操作员"};

    JLabel searchByBookNumberJl = new JLabel("输入编号");
    JTextField searchByBookNumberJt = new JTextField("",40);
    JButton searchByBookNumberJb = new JButton("查询");

    JLabel searchByBookNameJl = new JLabel("输入书名");
    JTextField searchByBookNameJt = new JTextField("",40);
    JButton searchByBookNameJb = new JButton("查询");

    JLabel searchByAuthorJl = new JLabel("输入作者");
    JTextField searchByAuthorJt = new JTextField("",40);
    JButton searchByAuthorJb = new JButton("查询");

    JLabel searchByClassJl = new JLabel("输入类别");
    JTextField searchByClassJt = new JTextField("",40);
    JButton searchByClassJb = new JButton("查询");

    JLabel searchJl = new JLabel("输入关键字");
    JTextField searchJt = new JTextField("",40);
    JButton searchJb = new JButton("查询");

    JButton searchByTitle = new JButton("按书名查询");
    JButton searchByAuthor = new JButton("按作者查询");
    JButton searchByClassification = new JButton("按分类查询");
    JButton search = new JButton("关键词精准查询");

    JButton searchByBookNumber1 = new JButton("按编号查询");
    JButton searchByAuthor1 = new JButton("按作者查询");
    JButton searchByClassification1 = new JButton("按分类查询");
    JButton search1 = new JButton("关键词精准查询");

    JButton searchByBookNumber2 = new JButton("按编号查询");
    JButton searchByTitle2 = new JButton("按书名查询");
    JButton searchByClassification2 = new JButton("按分类查询");
    JButton search2 = new JButton("关键词精准查询");

    JButton searchByBookNumber3 = new JButton("按编号查询");
    JButton searchByTitle3 = new JButton("按书名查询");
    JButton searchByAuthor3 = new JButton("按作者查询");
    JButton search3 = new JButton("关键词精准查询");

    JButton searchByBookNumber4 = new JButton("按编号查询");
    JButton searchByTitle4 = new JButton("按书名查询");
    JButton searchByAuthor4 = new JButton("按作者查询");
    JButton searchByClassification4 = new JButton("按分类查询");

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();


    JPanel bookNumberPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel authorPanel = new JPanel();
    JPanel classificationPanel = new JPanel();
    JPanel accuratePanel = new JPanel();
    JScrollPane scrollPane = null;
    JScrollPane scrollPane1 = null;
    JScrollPane scrollPane2 = null;
    JScrollPane scrollPane3 = null;
    JScrollPane scrollPane4 = null;
    JScrollPane scrollPane5 = null;
    JScrollPane scrollPane6 = null;
    JScrollPane scrollPane7 = null;

    JTabbedPane tabbedPane = new JTabbedPane();
    private DefaultTableModel tableModel = null ;
    private DefaultTableModel tableModel1 = null ;
    private DefaultTableModel tableModel2 = null ;



    JButton borrow = new JButton("添加行");
    JButton add1 = new JButton("添加图书");
    JButton delete1 = new JButton("下架图书");
    JButton update1 = new JButton("修改图书信息");

    JButton addRow3 = new JButton("添加行");
    JButton add3 = new JButton("添加管理员");
    JButton delete3 = new JButton("辞退管理员");
    JButton update3 = new JButton("修改管理员信息");

    public UserFrame(List<Book> list) {

        Vector<Vector<Object>> vectordata=new Vector<>();
        for(Book book:list){
            Vector<Object> objs=new Vector<>();
            objs.add(book.getBookNumber());
            objs.add(book.getTitle());
            objs.add(book.getAuthor());
            objs.add(book.getPublishingHouse());
            objs.add(book.getClassification());
            objs.add(book.getPublicationDate());
            objs.add(book.getTotal());
            objs.add(book.getRemainingAmount());
            vectordata.add(objs);
        }
        Vector<String> columnNames=new Vector<>();
        for(String label: labels1){
            columnNames.add(label);
        }

        table=new JTable(vectordata, columnNames);

        scrollPane = new JScrollPane(table);

        libraryManagement1.setBounds(0,60,200,30);
        libraryManagement.setBounds(0,20,200,30);
        searchBook.setBounds(0,100,200,30);
        exchangeAccount.setBounds(0,140,200,30);
        panel2.add(libraryManagement);
        panel2.add(libraryManagement1);
        panel2.add(searchBook);
        panel2.add(exchangeAccount);

        libraryManagement1.addActionListener(this);
        libraryManagement.addActionListener(this);
        searchBook.addActionListener(this);
        exchangeAccount.addActionListener(this);

        panel2.setLayout(null);
        bookNumberPanel.setLayout(null);
        titlePanel.setLayout(null);
        authorPanel.setLayout(null);
        classificationPanel.setLayout(null);
        accuratePanel.setLayout(null);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(7).setPreferredWidth(100);

        searchByBookNumberJb.addActionListener(new ActionListener() {
            BookDao dao = new BookDaoImpl();
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Book> bookList=null;
                bookList=dao.getByBookNumber(searchByBookNumberJt.getText());
                Vector<Vector<Object>> vectordata=new Vector<>();
                for(Book book:bookList){
                    Vector<Object> objs=new Vector<>();
                    objs.add(book.getBookNumber());
                    objs.add(book.getTitle());
                    objs.add(book.getAuthor());
                    objs.add(book.getPublishingHouse());
                    objs.add(book.getClassification());
                    objs.add(book.getPublicationDate());
                    objs.add(book.getTotal());
                    objs.add(book.getRemainingAmount());
                    vectordata.add(objs);
                }
                Vector<String> columnNames=new Vector<>();
                for(String label: labels1){
                    columnNames.add(label);
                }
                table=new JTable(vectordata, columnNames);
                scrollPane1 = new JScrollPane(table);
                panel1.add(scrollPane1);
                scrollPane1.setBounds(280, 220, 1000, 500);
                scrollPane1.setBorder(new TitledBorder(null, "",
                        TitledBorder.LEADING, TitledBorder.TOP, null, null));
                scrollPane.setVisible(false);
            }
        });

        searchByBookNumberJl.setBounds(20,20,100,30);
        searchByBookNumberJt.setBounds(20,60,200,30);
        searchByBookNumberJb.setBounds(40,100,150,30);

        searchByTitle.setBounds(550,20,200,30);
        searchByAuthor.setBounds(550,60,200,30);
        searchByClassification.setBounds(550,100,200,30);
        search.setBounds(550,140,200,30);

        bookNumberPanel.add(searchByBookNumberJl);
        bookNumberPanel.add(searchByBookNumberJt);
        bookNumberPanel.add(searchByBookNumberJb);
        bookNumberPanel.add(searchByTitle);
        bookNumberPanel.add(searchByAuthor);
        bookNumberPanel.add(searchByClassification);
        bookNumberPanel.add(search);

        searchByTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookNumberPanel.setVisible(false);
                titlePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane1!=null){
                    scrollPane1.setVisible(false);
                }
            }
        });

        searchByAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookNumberPanel.setVisible(false);
                authorPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane1!=null){
                    scrollPane1.setVisible(false);
                }
            }
        });

        searchByClassification.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookNumberPanel.setVisible(false);
                classificationPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane1!=null){
                    scrollPane1.setVisible(false);
                }
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookNumberPanel.setVisible(false);
                accuratePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane1!=null){
                    scrollPane1.setVisible(false);
                }
            }
        });
        /**
         *
         */

        searchByBookNameJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDao dao = new BookDaoImpl();
                List<Book> bookList=null;
                bookList=dao.getByBookName(searchByBookNameJt.getText());
                Vector<Vector<Object>> vectordata=new Vector<>();
                for(Book book:bookList){
                    Vector<Object> objs=new Vector<>();
                    objs.add(book.getBookNumber());
                    objs.add(book.getTitle());
                    objs.add(book.getAuthor());
                    objs.add(book.getPublishingHouse());
                    objs.add(book.getClassification());
                    objs.add(book.getPublicationDate());
                    objs.add(book.getTotal());
                    objs.add(book.getRemainingAmount());
                    vectordata.add(objs);
                }
                Vector<String> columnNames=new Vector<>();
                for(String label: labels1){
                    columnNames.add(label);
                }
                table=new JTable(vectordata, columnNames);
                scrollPane2 = new JScrollPane(table);
                panel1.add(scrollPane2);
                scrollPane2.setBounds(280, 220, 1000, 500);
                scrollPane2.setBorder(new TitledBorder(null, "",
                        TitledBorder.LEADING, TitledBorder.TOP, null, null));
                scrollPane.setVisible(false);
            }
        });

        searchByBookNameJl.setBounds(20,20,100,30);
        searchByBookNameJt.setBounds(20,60,200,30);
        searchByBookNameJb.setBounds(40,100,150,30);

        searchByBookNumber1.setBounds(550,20,200,30);
        searchByAuthor1.setBounds(550,60,200,30);
        searchByClassification1.setBounds(550,100,200,30);
        search1.setBounds(550,140,200,30);

        titlePanel.add(searchByBookNameJl);
        titlePanel.add(searchByBookNameJt);
        titlePanel.add(searchByBookNameJb);
        titlePanel.add(searchByBookNumber1);
        titlePanel.add(searchByAuthor1);
        titlePanel.add(searchByClassification1);
        titlePanel.add(search1);

        searchByBookNumber1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titlePanel.setVisible(false);
                bookNumberPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane2!=null){
                    scrollPane2.setVisible(false);
                }
            }
        });

        searchByAuthor1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titlePanel.setVisible(false);
                authorPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane2!=null){
                    scrollPane2.setVisible(false);
                }
            }
        });

        searchByClassification1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titlePanel.setVisible(false);
                classificationPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane2!=null){
                    scrollPane2.setVisible(false);
                }
            }
        });

        search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titlePanel.setVisible(false);
                accuratePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane2!=null){
                    scrollPane2.setVisible(false);
                }
            }
        });

        /**
         *
         */

        searchByAuthorJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDao dao = new BookDaoImpl();
                List<Book> bookList=null;
                bookList=dao.getByAuthor(searchByAuthorJt.getText());
                Vector<Vector<Object>> vectordata=new Vector<>();
                for(Book book:bookList){
                    Vector<Object> objs=new Vector<>();
                    objs.add(book.getBookNumber());
                    objs.add(book.getTitle());
                    objs.add(book.getAuthor());
                    objs.add(book.getPublishingHouse());
                    objs.add(book.getClassification());
                    objs.add(book.getPublicationDate());
                    objs.add(book.getTotal());
                    objs.add(book.getRemainingAmount());
                    vectordata.add(objs);
                }
                Vector<String> columnNames=new Vector<>();
                for(String label: labels1){
                    columnNames.add(label);
                }
                table=new JTable(vectordata, columnNames);
                scrollPane3 = new JScrollPane(table);
                panel1.add(scrollPane3);
                scrollPane3.setBounds(280, 220, 1000, 500);
                scrollPane3.setBorder(new TitledBorder(null, "",
                        TitledBorder.LEADING, TitledBorder.TOP, null, null));
                scrollPane.setVisible(false);

            }
        });

        searchByAuthorJl.setBounds(20,20,100,30);
        searchByAuthorJt.setBounds(20,60,200,30);
        searchByAuthorJb.setBounds(40,100,150,30);

        searchByBookNumber2.setBounds(550,20,200,30);
        searchByTitle2.setBounds(550,60,200,30);
        searchByClassification2.setBounds(550,100,200,30);
        search2.setBounds(550,140,200,30);

        authorPanel.add(searchByAuthorJl);
        authorPanel.add(searchByAuthorJt);
        authorPanel.add(searchByAuthorJb);
        authorPanel.add(searchByBookNumber2);
        authorPanel.add(searchByTitle2);
        authorPanel.add(searchByClassification2);
        authorPanel.add(search2);

        searchByBookNumber2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorPanel.setVisible(false);
                bookNumberPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane3!=null){
                    scrollPane3.setVisible(false);
                }
            }
        });

        searchByTitle2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorPanel.setVisible(false);
                titlePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane3!=null){
                    scrollPane3.setVisible(false);
                }
            }
        });

        searchByClassification2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorPanel.setVisible(false);
                classificationPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane3!=null){
                    scrollPane3.setVisible(false);
                }
            }
        });

        search2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorPanel.setVisible(false);
                accuratePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane3!=null){
                    scrollPane3.setVisible(false);
                }
            }
        });

        /**
         *
         */

        searchByClassJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDao dao = new BookDaoImpl();
                List<Book> bookList=null;
                bookList=dao.getByClassification(searchByClassJt.getText());
                Vector<Vector<Object>> vectordata=new Vector<>();
                for(Book book:bookList){
                    Vector<Object> objs=new Vector<>();
                    objs.add(book.getBookNumber());
                    objs.add(book.getTitle());
                    objs.add(book.getAuthor());
                    objs.add(book.getPublishingHouse());
                    objs.add(book.getClassification());
                    objs.add(book.getPublicationDate());
                    objs.add(book.getTotal());
                    objs.add(book.getRemainingAmount());
                    vectordata.add(objs);
                }
                Vector<String> columnNames=new Vector<>();
                for(String label: labels1){
                    columnNames.add(label);
                }
                table=new JTable(vectordata, columnNames);
                scrollPane4 = new JScrollPane(table);
                panel1.add(scrollPane4);
                scrollPane4.setBounds(280, 220, 1000, 500);
                scrollPane4.setBorder(new TitledBorder(null, "",
                        TitledBorder.LEADING, TitledBorder.TOP, null, null));
                scrollPane.setVisible(false);

            }
        });

        searchByClassJl.setBounds(20,20,100,30);
        searchByClassJt.setBounds(20,60,200,30);
        searchByClassJb.setBounds(40,100,150,30);

        searchByBookNumber3.setBounds(550,20,200,30);
        searchByTitle3.setBounds(550,60,200,30);
        searchByAuthor3.setBounds(550,100,200,30);
        search3.setBounds(550,140,200,30);

        classificationPanel.add(searchByClassJl);
        classificationPanel.add(searchByClassJt);
        classificationPanel.add(searchByClassJb);
        classificationPanel.add(searchByBookNumber3);
        classificationPanel.add(searchByTitle3);
        classificationPanel.add(searchByAuthor3);
        classificationPanel.add(search3);

        searchByBookNumber3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classificationPanel.setVisible(false);
                bookNumberPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane4!=null){
                    scrollPane4.setVisible(false);
                }
            }
        });

        searchByTitle3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classificationPanel.setVisible(false);
                titlePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane4!=null){
                    scrollPane4.setVisible(false);
                }
            }
        });

        searchByAuthor3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classificationPanel.setVisible(false);
                authorPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane4!=null){
                    scrollPane4.setVisible(false);
                }
            }
        });

        search3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classificationPanel.setVisible(false);
                accuratePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane4!=null){
                    scrollPane4.setVisible(false);
                }
            }
        });

        /**
         *
         */

        searchJb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDao dao = new BookDaoImpl();
                List<Book> bookList=null;
                bookList=dao.getByKey(searchJt.getText());
                Vector<Vector<Object>> vectordata=new Vector<>();
                for(Book book:bookList){
                    Vector<Object> objs=new Vector<>();
                    objs.add(book.getBookNumber());
                    objs.add(book.getTitle());
                    objs.add(book.getAuthor());
                    objs.add(book.getPublishingHouse());
                    objs.add(book.getClassification());
                    objs.add(book.getPublicationDate());
                    objs.add(book.getTotal());
                    objs.add(book.getRemainingAmount());
                    vectordata.add(objs);
                }
                Vector<String> columnNames=new Vector<>();
                for(String label: labels1){
                    columnNames.add(label);
                }
                table=new JTable(vectordata, columnNames);
                scrollPane5 = new JScrollPane(table);
                panel1.add(scrollPane5);
                scrollPane5.setBounds(280, 220, 1000, 500);
                scrollPane5.setBorder(new TitledBorder(null, "",
                        TitledBorder.LEADING, TitledBorder.TOP, null, null));
                scrollPane.setVisible(false);
            }
        });

        searchJl.setBounds(20,20,100,30);
        searchJt.setBounds(20,60,200,30);
        searchJb.setBounds(40,100,150,30);

        searchByBookNumber4.setBounds(550,20,200,30);
        searchByTitle4.setBounds(550,60,200,30);
        searchByAuthor4.setBounds(550,100,200,30);
        searchByClassification4.setBounds(550,140,200,30);

        accuratePanel.add(searchJl);
        accuratePanel.add(searchJt);
        accuratePanel.add(searchJb);
        accuratePanel.add(searchByBookNumber4);
        accuratePanel.add(searchByTitle4);
        accuratePanel.add(searchByAuthor4);
        accuratePanel.add(searchByClassification4);

        searchByBookNumber4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accuratePanel.setVisible(false);
                bookNumberPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane5!=null){
                    scrollPane5.setVisible(false);
                }
            }
        });

        searchByTitle4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accuratePanel.setVisible(false);
                titlePanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane5!=null){
                    scrollPane5.setVisible(false);
                }
            }
        });

        searchByAuthor4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accuratePanel.setVisible(false);
                authorPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane5!=null){
                    scrollPane5.setVisible(false);
                }
            }
        });

        searchByClassification4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accuratePanel.setVisible(false);
                classificationPanel.setVisible(true);
                scrollPane.setVisible(true);
                if (scrollPane5!=null){
                    scrollPane5.setVisible(false);
                }
            }
        });

        /**
         *
         */

        panel1.setLayout(null);
        panel1.setBorder(new TitledBorder(null, "总面板", TitledBorder.LEADING,
                TitledBorder.TOP, null, null));

        this.getContentPane().add(panel1);

        panel2.setBounds(0,0,280,720);

        bookNumberPanel.setBounds(280,0,1000,220);
        titlePanel.setBounds(280,0,1000,220);
        authorPanel.setBounds(280,0,1000,220);
        classificationPanel.setBounds(280,0,1000,220);
        accuratePanel.setBounds(280,0,1000,220);

        panel2.setBorder(new TitledBorder(null, "信息面板",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));

        bookNumberPanel.setBorder(new TitledBorder(null, "编号查询",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        titlePanel.setBorder(new TitledBorder(null, "书名查询",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        authorPanel.setBorder(new TitledBorder(null, "作者查询",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        classificationPanel.setBorder(new TitledBorder(null, "类别查询",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        accuratePanel.setBorder(new TitledBorder(null, "关键字查询",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));

        panel3.setBounds(280,0,1000,720);
        panel3.setBorder(new TitledBorder(null, "图书",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel4.setBounds(280,0,1000,720);
        panel4.setBorder(new TitledBorder(null, "借阅",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));

        panel3.setLayout(null);
        panel4.setLayout(null);

        tabbedPane.add("借书", panel3);
        tabbedPane.add("还书", panel4);
        tabbedPane.setBounds(280,0,1000,720);

        panel1.add(panel2);
        panel1.add(bookNumberPanel);
        panel1.add(titlePanel);
        panel1.add(authorPanel);
        panel1.add(classificationPanel);
        panel1.add(accuratePanel);

        bookNumberPanel.setVisible(true);
        titlePanel.setVisible(false);
        authorPanel.setVisible(false);
        classificationPanel.setVisible(false);
        accuratePanel.setVisible(false);

        panel1.add(scrollPane);
        scrollPane.setBounds(280, 220, 1000, 500);
        scrollPane.setBorder(new TitledBorder(null, "",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        this.setSize(1280, 720);

        menuBar.add(m1);
        menuBar.add(m2);
        menuBar.add(m3);
        m1.add(insertRow);
        m1.add(save);
        m3.add(Delete);
        m2.add(exchange);
        this.setJMenuBar(menuBar);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BorrowDao dao = new BorrowDaoImpl();
        BookDao dao1 = new BookDaoImpl();
        if ("借书".equals(e.getActionCommand())) {
            Book book = new Book();
            Borrow borrow = new Borrow();
            tableModel = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            borrow.setUsername(us);
            borrow.setBooknumber((String) tableModel.getValueAt(row, 0));
            borrow.setBookname((String) tableModel.getValueAt(row, 1));
            SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");
            String datetime = tempDate.format(new Date());
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 7);
            Date today = calendar.getTime();
            String result = tempDate.format(today);
            borrow.setLoandate(datetime);
            borrow.setDeadline(result);

            Integer remainAmount =Integer.parseInt(tableModel.getValueAt(row,7).toString());

            book.setBookNumber((String) tableModel.getValueAt(row,0));
            book.setRemainingAmount(String.valueOf(remainAmount-1));

            dao.add(borrow);
            dao1.updateAmount(book);
        }else if ("切换账号".equals(e.getActionCommand())) {
            new Login();
            dispose();
        }else if ("还书".equals(e.getActionCommand())) {
            new RecordFrame();
        }
    }
}