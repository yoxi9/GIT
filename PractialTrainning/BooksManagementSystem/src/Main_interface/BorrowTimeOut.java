package Main_interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import CS.DAO.DBUtils;

public class BorrowTimeOut {

	public boolean BorrowTimeOut(String zhanghao) {
		boolean a = true;
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		connection = DBUtils.getConnection();
		String sql = null;
		String[] rowData = new String[8];//做了修改
		try {
			statement = connection.createStatement();
			sql = "select userid,returndate from borrow";
			rs = statement.executeQuery(sql);
			for (int i = 0; rs.next(); i++) {
				int userid = rs.getInt(1);
				String returndate = rs.getString(2);

				String userid1 = String.valueOf(userid);
				if (zhanghao.equals(userid1)) {
					rowData[i] = returndate;
					System.out.println("获取到第" + (i + 1) + "个日期：" + rowData[i]);
					/*
					 * 对每一个获取到的日期与实时的日期进行判断若大于实时的时间 即有未归还书籍 需要提示借阅者先归还书籍再借书
					 */
					Date date = new Date();
					DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
					String str1 = df1.format(date);
					System.out.println("1.此刻的时间为：" + str1);

					// 系统实时的年月日
					String year1 = str1.substring(0, 4);
					int year = Integer.parseInt(year1);
					String month1 = str1.substring(5, 7);
					int month = Integer.parseInt(month1);
					String day1 = str1.substring(8, 10);
					int day = Integer.parseInt(day1);
					// 获取的还书日期的年月日
					String year2 = rowData[i].substring(0, 4);
					int hqyear = Integer.parseInt(year2);
					String month2 = rowData[i].substring(5, 7);
					int hqmonth = Integer.parseInt(month2);
					String day2 = rowData[i].substring(8, 10);
					int hqday = Integer.parseInt(day2);

					if (hqyear < year) {
						a = false;
						break;
					} else if (hqyear == year && hqmonth < month) {
						a = false;
						break;
					} else if (hqyear == year && hqmonth == month && hqday < day) {
						a = false;
						break;
					} else {
						a = true;
					}
				} else {
					i--;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.closeResource(connection, statement, rs);
		}

		return a;

	}

}
