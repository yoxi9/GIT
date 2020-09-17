package CS.DAO;

import java.util.List;

import CS.Object.Appointment;

public interface AppointmentDao {
	public int add(Appointment appointment);

	public int delete(Appointment appointment);

	public int update(Appointment appointment);

	public Appointment getById(int id);

	public List<Appointment> getByType(int type);

	public List<Appointment> getAll();
}
