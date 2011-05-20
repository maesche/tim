package tim.application.db;

import java.util.ArrayList;

public abstract class SQLQuery {
	private ArrayList<String> select;
	private ArrayList<String> where;
	private ArrayList<String> from;
	private ArrayList<String> orderby;
	
	public SQLQuery() {
		select = new ArrayList<String>();
		where = new ArrayList<String>();
		from = new ArrayList<String>();
		orderby = new ArrayList<String>();
	}
	
	public abstract void add();
	
	
	
	
}
