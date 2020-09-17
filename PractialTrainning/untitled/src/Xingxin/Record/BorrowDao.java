package Xingxin.Record;

import java.util.List;

/**
 * @author 231
 * @date 2020-06-20 16:29
 */
public interface BorrowDao {
    List<Borrow> getAll();

    int add(Borrow borrow);

    List<Borrow> getByUserName(String username);
    List<Borrow> getByBookName(String bookname);


}
