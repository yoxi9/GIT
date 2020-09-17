package Main_interface;

import javax.swing.JOptionPane;

import CS.DAO.BookDAO;
import CS.DAO.UserDAO;
import CS.DAOIMIO.BookDaoImio;
import CS.DAOIMIO.UserDaoImlo;
import CS.Object.Book;
import CS.Object.User;

public class Reader_LogOut {

	public Reader_LogOut(String zhanghao) {
		CancelAccountsBookNoReturn CABNR = new CancelAccountsBookNoReturn();
		boolean a = CABNR.CancelAccountsBookNoReturn(zhanghao);
		if (a) {
			JOptionPane.showMessageDialog(null, "您有书籍未归还，无法注销帐号！", "消息提示", JOptionPane.INFORMATION_MESSAGE);

		} else {
			User user = new User();
			user.setBorrowid(Integer.parseInt(zhanghao));
			UserDAO dao = new UserDaoImlo();
			dao.delete1(user);
			JOptionPane.showMessageDialog(null, "已成功注销帐号！", "消息提示", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
