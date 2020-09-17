package CS.DAO;

import java.util.List;

import CS.Object.BufferAppointment;



public interface BufferAppointmentDao {
	public int add(BufferAppointment bufferappointment);

	public int delete(BufferAppointment bufferappointment);

	public int update(BufferAppointment bufferappointment);

	public BufferAppointment getById(int id);

	public List<BufferAppointment> getByType(int type);

	public List<BufferAppointment> getAll();
}
