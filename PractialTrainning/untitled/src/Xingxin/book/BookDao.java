package Xingxin.book;

import java.util.List;

/**
 * @author 231
 * @date 2020-06-19 9:18
 */
public interface BookDao {

    List<Book> getAll();
    List<Book> getSearch();

    List<Book> getByBookNumber(String booknumber);
    List<Book> getByBookName(String title);
    List<Book> getByAuthor(String author);
    List<Book> getByClassification(String classification);
    List<Book> getByKey(String key);

    int add(Book book);

    int update(Book book);

    int delete(Book book);

    int updateAmount(Book book);


}
