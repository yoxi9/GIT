package CS.Object;

public class BufferAppointment {
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
	private int userid;// �û�ID
	private int bookid;// �鼮ID
	private String forwardstart;// ԤԼ��ʼʱ��
	private String forwardend;// ԤԼ����ʱ��
}
