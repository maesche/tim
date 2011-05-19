package tim.calendar.model;

import java.util.Date;

public class TimeTable {
	private Date begin;
	private Date end;
	
	public TimeTable (Date begin, Date end) {

		this.begin = begin;
		this.end = end;
	}

	public Date getBegin() {
		return begin;
	}

	public Date getEnd() {
		return end;
	}
	
	
	
}
