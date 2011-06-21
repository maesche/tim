package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.JTableHeader;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.XMLResourceBundleControl;
import tim.application.exception.PersistanceException;
import tim.application.utils.DateHelper;
import tim.controller.CalendarController;
import tim.model.Employee;

public class DayTableView extends JPanel {
	
	private static JTable table;
	public JScrollPane scroll;
	private static int hourInDay;
	
	public DayTableView(){
		this.setOpaque(false);
		
		this.setLayout(new BorderLayout());
		
		CalendarController controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		
		this.hourInDay = Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START;
		//this.hourInDay = controller.;
		
		
		
		
		/*Date begin = null, end = null;
		try {
			begin = DateHelper.StringToDate("2011-01-01", Config.DATE_FORMAT_SHORT);
			end = DateHelper.StringToDate("2011-06-10", Config.DATE_FORMAT_SHORT);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		
		ArrayList<Employee> test = null;
		try {
			test = controller.getCalendars(begin, end);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	
		
		
		int nbrPerson = controller.getNbrPerson();
		
		
		//int nbrPerson = 3;
		String h;
		
		Object[][] donnees = new Object[nbrPerson][hourInDay+1];
		String[] titreColonnes = new String[hourInDay+1];
		
		titreColonnes[0] = "Collaborateur";
		for(int i=1; i<hourInDay+1; i++){
			h = Integer.toString(i-1 + Config.CALENDAR_DAY_START);
			titreColonnes[i] = h + ":00";
		}
		
		int i = 0;
		for(Employee e : controller.getEmployees()){
			donnees[i][0]  = e.getFirstName() + " " + e.getLastName();
			i++;
		}
		
		
		this.table = new JTable(donnees, titreColonnes);
		
		
		table.getColumnModel().getColumn(0).setWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		
		table.setRowHeight(100);
		
		System.out.println(table.getColumnModel().getColumn(0).getWidth());
		
		table.getTableHeader().setReorderingAllowed(false); 
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setEnabled(false);
		table.setDragEnabled(false);
		table.setFocusable(false);
		
		this.scroll = new JScrollPane(table);
		add(scroll);

		
	}
	
	public static int test(){
		return table.getColumnModel().getColumn(1).getWidth() * hourInDay;
	}
	
	public void validate(){
		this.setSize(CalendarContainer.getCalendarDimension());
		
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		Dimension d = new Dimension((int)CalendarContainer.getCalendarDimension().getWidth(), (int)CalendarContainer.getCalendarDimension().getHeight());
		table.setSize(d);
		table.setPreferredSize(d);
		table.setBounds(0,0, (int) CalendarContainer.getCalendarDimension().getWidth(), (int) CalendarContainer.getCalendarDimension().getHeight());
		
		
		table.setRowHeight((int) ((table.getSize().getHeight()-20)/3));
		
		CalendarContainer.setCalendarHourWidth(test());
		CalendarContainer.setCalendarPersonColWidth(table.getColumnModel().getColumn(0).getWidth());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		validate();
	}
}
