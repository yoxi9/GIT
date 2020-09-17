package CS.Object;

import java.sql.Date;

public class Book {
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getProvenance() {
		return provenance;
	}
	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}
	public Double getBookprice() {
		return bookprice;
	}
	public void setBookprice(Double bookprice) {
		this.bookprice = bookprice;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getEntertime() {
		return entertime;
	}
	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}
	
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", provenance=" + provenance + ", author=" + author
				+ ", booknumber=" + booknumber + ", bookprice=" + bookprice + ", booktype=" + booktype + ", entertime="
				+ entertime + "]";
	}
	public Book(int bookid, String bookname, String provenance, String author, int booknumber, Double bookprice,
			String booktype, String entertime) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.provenance = provenance;
		this.author = author;
		this.booknumber = booknumber;
		this.bookprice = bookprice;
		this.booktype = booktype;
		this.entertime = entertime;
	}
	public Book() {
		super();
		this.bookid=bookid;
		this.bookname=bookname;
		this.provenance=provenance;
		this.author=author;
		this.booknumber=booknumber;
		this.bookprice=bookprice;
		this.booktype=booktype;
		this.entertime=entertime;
	}
	private int bookid;//�鼮id	
	private String bookname;//����
	private String provenance;//����
	private String author;//����
	private int booknumber;//ͼ�����ʣ����
	private Double bookprice;//ͼ��۸�
	private String booktype;//ͼ������
    private String entertime;//���ʱ��
	

}
