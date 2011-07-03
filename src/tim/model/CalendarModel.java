package tim.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import tim.application.Config;
import tim.application.Db;
import tim.application.GlobalRegistry;
import tim.application.exception.ExceptionFormatter;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;

public class CalendarModel extends AbstractModel {

	public ArrayList<Element> get(Employee employee, Date fSince, Date fUntil, int fId) {
		EmployeeModel employeeModel = (EmployeeModel) GlobalRegistry.mvcLinker.getModels().get("EmployeeModel");
		AppointmentModel appointmentModel = (AppointmentModel) GlobalRegistry.mvcLinker.getModels().get("AppointmentModel");
		
		Connection conn;
		Statement stmt = null;
		ResultSet rs;
		
		ArrayList<String> filter = new ArrayList<String>();
		
		ArrayList<Element> appointments = new ArrayList<Element>();

		String sql = "SELECT" +
					 "	C.calendar_id, " +
					 "	Col.r, " +
					 "  Col.g, " +
					 "  Ccol.b " +
					 "FROM calendars C " +
                     "LEFT JOIN Colors Col " +
                     "  ON Col.color_id = C.color_id ";
		
		if (fId > 0) {
			sql += "WHERE C.calendar_id=" + fId;
		}
		
		sql +=  " ORDER BY begin";

		try {
			conn = Db.open();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ClientModel clientModel = (ClientModel) GlobalRegistry.mvcLinker.getModels().get("ClientModel");
			
			while (rs.next()) {
				
				long id = rs.getLong("A_id");
				
				Date begin = rs.getTimestamp("begin");
				Date end = rs.getTimestamp("end");
				String description = rs.getString("description");
	
				Person client = (Client) clientModel.get(rs.getInt("C_id")).get(0);

				Appointment appointment = new Appointment(id, begin, end, description, /*employee,*/ client);
				
				appointments.add(appointment);
			}
			stmt.close();
		} catch (Exception ex) {
			throw new PersistanceException(ExceptionFormatter.format(ex, this.getClass().getName(), "getElements"));
		}
		finally {
			Db.close();
		}
		return appointments;
		

	}
	
	@Override
	public ArrayList<Element> get() throws PersistanceException {
		return get(null, null, null);
	}

	@Override
	public void add(Element element) throws ClassCastException,
			PersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Element element) throws ClassCastException,
			PersistanceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Element element) throws ClassCastException,
			PersistanceException {
		// TODO Auto-generated method stub

	}

}
