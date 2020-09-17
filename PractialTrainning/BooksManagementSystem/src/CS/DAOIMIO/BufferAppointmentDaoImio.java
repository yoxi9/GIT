package CS.DAOIMIO;

import java.util.List;

import CS.DAO.BufferAppointmentDao;
import CS.DAO.DBUtils;
import CS.Object.BufferAppointment;

public class BufferAppointmentDaoImio implements BufferAppointmentDao{

	@Override
	public int add(BufferAppointment bufferappointment) {
		// TODO Auto-generated method stub
		String sql = "insert into bufferappointment(userid,bookid,forwardstart,forwardend)value(?,?,?,?)";
		DBUtils.update(sql, bufferappointment.getUserid(), bufferappointment.getBookid(), bufferappointment.getForwardstart(),
				bufferappointment.getForwardend());
		return 0;
	}

	@Override
	public int delete(BufferAppointment bufferappointment) {
		// TODO Auto-generated method stub
		String sql = "delete from bufferappointment where bookid=?";
		DBUtils.update(sql, bufferappointment.getBookid());
		return 0;
	}

	@Override
	public int update(BufferAppointment bufferappointment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BufferAppointment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BufferAppointment> getByType(int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BufferAppointment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
