package CS.Object;

public class Appointment {

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getForwardstart() {
		return forwardstart;
	}

	public void setForwardstart(String forwardstart) {
		this.forwardstart = forwardstart;
	}

	public String getForwardend() {
		return forwardend;
	}

	public void setForwardend(String forwardend) {
		this.forwardend = forwardend;
	}

	@Override
	public String toString() {
		return "Appointment [userid=" + userid + ", bookid=" + bookid + ", forwardstart=" + forwardstart
				+ ", forwardend=" + forwardend + "]";
	}

	private int userid;// 用户ID
	private int bookid;// 书籍ID
	private String forwardstart;// 预约启始时间
	private String forwardend;// 预约结束时间
}
