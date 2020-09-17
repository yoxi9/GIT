package Main_interface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import CS.DAO.VipDao;
import CS.DAOIMIO.VipDaoImio;
import CS.Object.Book;
import CS.Object.BorrowVip;

public class VIP_Date {
	public VIP_Date(String zhanghao) {
		Date date = new Date();
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String str1 = df1.format(date);
		System.out.println(str1);
		// 自动在获取的时间上增加一个月为还书日期

		String year1 = str1.substring(0, 4);
		int year = Integer.parseInt(year1);
		System.out.println(year);

		String month1 = str1.substring(5, 7);
		int month = Integer.parseInt(month1);
		System.out.println(month);

		String day1 = str1.substring(8, 10);
		int day = Integer.parseInt(day1);
		System.out.println(day);
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
		System.out.println(year + "-" + month + "-" + day);

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
		System.out.println(str2);
		BorrowVip borrowVip=new BorrowVip();
		borrowVip.setUserid(Integer.parseInt(zhanghao));
		borrowVip.setStarttime(str1);
		borrowVip.setOvertime(str2);
		VipDao dao =new VipDaoImio();
		dao.add(borrowVip);
	}
}
