package Xingxin.Record;

import Xingxin.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 231
 * @date 2020-06-20 16:29
 */
public class BorrowDaoImpl implements BorrowDao{

    @Override
    public List<Borrow> getAll() {
        String sql = "select * from borrowingrecord order by (id-0)";
        List<Borrow> borrowList = new ArrayList<Borrow>();
        List<Map<String, Object>> maplist = DBUtils.query(sql);
        for (Map<String, Object> map : maplist) {
            Borrow borrow = new Borrow();
            borrow.setId((Integer) (map.get("id")));
            borrow.setUsername((String) (map.get("username")));
            borrow.setBooknumber((String) (map.get("booknumber")));
            borrow.setBookname((String) (map.get("bookname")));
            borrow.setLoandate((String) (map.get("loandate")));
            borrow.setDeadline((String) (map.get("deadline")));
            borrow.setDeadline((String) (map.get("returntime")));
            borrow.setDeadline((String) (map.get("whetheritisoverdue")));
            borrowList.add(borrow);
        }
        return borrowList;
    }

    @Override
    public int add(Borrow borrow) {
        int code=0;
        String sql="insert into borrowingrecord (username,booknumber,bookname,loandate,deadline) values(?,?,?,?,?)";
        code= DBUtils.update(sql,borrow.getUsername(),borrow.getBooknumber(),borrow.getBookname(),borrow.getLoandate(),borrow.getDeadline());
        return code;    }

    @Override
    public List<Borrow> getByUserName(String username) {
        String sql = "select * from borrowingrecord where username=?";
        List<Borrow> borrowList = new ArrayList<Borrow>();

        List<Map<String, Object>> maplist = DBUtils.query(sql, username);
        for (Map<String, Object> map : maplist) {
            Borrow borrow = new Borrow();
            borrow.setId((Integer) (map.get("id")));
            borrow.setUsername((String) (map.get("username")));
            borrow.setBooknumber((String) (map.get("booknumber")));
            borrow.setBookname((String) (map.get("bookname")));
            borrow.setLoandate((String) (map.get("loandate")));
            borrow.setDeadline((String) (map.get("deadline")));
            borrow.setDeadline((String) (map.get("returntime")));
            borrow.setDeadline((String) (map.get("whetheritisoverdue")));
            borrowList.add(borrow);
        }
        return borrowList;
    }

    @Override
    public List<Borrow> getByBookName(String bookname) {
        String sql = "select * from borrowingrecord where bookname=?";
        List<Borrow> borrowList = new ArrayList<Borrow>();

        List<Map<String, Object>> maplist = DBUtils.query(sql, bookname);
        for (Map<String, Object> map : maplist) {
            Borrow borrow = new Borrow();
            borrow.setId((Integer) (map.get("id")));
            borrow.setUsername((String) (map.get("username")));
            borrow.setBooknumber((String) (map.get("booknumber")));
            borrow.setBookname((String) (map.get("bookname")));
            borrow.setLoandate((String) (map.get("loandate")));
            borrow.setDeadline((String) (map.get("deadline")));
            borrow.setDeadline((String) (map.get("returntime")));
            borrow.setDeadline((String) (map.get("whetheritisoverdue")));
            borrowList.add(borrow);
        }
        return borrowList;
    }


}
