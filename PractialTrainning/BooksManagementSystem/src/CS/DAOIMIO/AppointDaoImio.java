package CS.DAOIMIO;

import java.util.List;

import CS.DAO.AppointmentDao;
import CS.DAO.BorrowDao;
import CS.DAO.DBUtils;
import CS.Object.Appointment;

public class AppointDaoImio implements AppointmentDao {

	@Override
	public int add(Appointment appointment) {
		// TODO Auto-generated method stub
		String sql = "insert into appointment(userid,bookid,forwardstart,forwardend)value(?,?,?,?)";
		DBUtils.update(sql, appointment.getUserid(), appointment.getBookid(), appointment.getForwardstart(),
				appointment.getForwardend());
		return 0;
	}

	@Override
	public int delete(Appointment appointment) {
		// TODO Auto-generated method stub
		String sql = "delete from appointment where userid=? AND bookid=?";
		DBUtils.update(sql, appointment.getUserid(), appointment.getBookid());
		return 0;
	}

	@Override
	public int update(Appointment appointment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Appointment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getByType(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
