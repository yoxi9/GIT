package Main_interface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import CS.DAO.AppointmentDao;
import CS.DAO.BorrowDao;
import CS.DAOIMIO.AppointDaoImio;
import CS.DAOIMIO.BorrowDaoImio;
import CS.Object.Appointment;
import CS.Object.Book;
import CS.Object.Borrow;

public class Appointment_DelTable {

	public Appointment_DelTable(String userid, int hqbookid) {

		/* 删除预约表中的此书 */
		Appointment appointment = new Appointment();
		appointment.setUserid(Integer.parseInt(userid));
		appointment.setBookid(hqbookid);
		AppointmentDao dao = new AppointDaoImio();
		dao.delete(appointment);
		/* 将预约的表中的此书信息载入到借阅表中 */

		Date date = new Date();
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String str1 = df1.format(date);

		String year1 = str1.substring(0, 4);
		int year = Integer.parseInt(year1);
		String month1 = str1.substring(5, 7);
		int month = Integer.parseInt(month1);
		String day1 = str1.substring(8, 10);
		int day = Integer.parseInt(day1);

		if (month == 1 && day > 28) {
			month += 2;
			day = 1;
		} else if (month != 11 && month % 2 == 1 && day == 31 && month <= 7) {
			month += 2;
			day = 1;
		} else if (month >= 8 && month % 2 == 0 && month != 12 && day == 31) {
			month += 2;
			day = 1;
		} else if (month == 12) {
			year += 1;
			month = 1;
		} else {
			month += 1;
		}
		String Year = String.valueOf(year);
		System.out.println(Year.getClass());
		String Month = String.valueOf(month);
		String Day = String.valueOf(day);
		System.out.println(Year + Month + Day);
		String str2 = null;
		if (month < 10 && day < 10) {
			str2 = Year.concat("-0" + Month).concat("-0" + Day);
		} else if (month >= 10 && day >= 10) {
			str2 = Year.concat("-" + Month).concat("-" + Day);
		} else if (month < 10 && day >= 10) {
			str2 = Year.concat("-0" + Month).concat("-" + Day);
		} else {
			str2 = Year.concat("-" + Month).concat("-0" + Day);

		}

		System.out.println("这里获取到的图书id为：" + hqbookid);
		Borrow borrow = new Borrow();
		borrow.setUserid(Integer.parseInt(userid));
		borrow.setBookid(hqbookid);
		borrow.setBorrowdate(str1);
		borrow.setReturndate(str2);

		BorrowDao dao1 = new BorrowDaoImio();
		dao1.add(borrow);
	}
}
