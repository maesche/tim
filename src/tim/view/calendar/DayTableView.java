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
import java.util.Vector;

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
	private static int hourInDay;
	int nbrPerson = 0;
	
	CalendarController controller;
	
	public DayTableView(){
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		
		this.controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		
		this.hourInDay = Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START;
		//this.hourInDay = controller.getHoursPerDay();
		
	
		
		nbrPerson = controller.getNbrPerson();
		

		this.table = controller.getFormatedTable();
		
		
		

		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(150);
		table.setRowHeight(100);

		
		table.getTableHeader().setReorderingAllowed(false); 
		table.setEnabled(false);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		add(scroll);

	}
	
	public static int test(){
		return table.getColumnModel().getColumn(1).getWidth() * hourInDay;
	}
	
	public void validate(){
		this.setSize(CalendarContainer.getCalendarDimension());
		
		
		
		Dimension d = new Dimension((int)CalendarContainer.getCalendarDimension().getWidth(), (int)CalendarContainer.getCalendarDimension().getHeight());
		table.setSize(d);
		table.setPreferredSize(d);
		table.setBounds(0,0, (int) CalendarContainer.getCalendarDimension().getWidth(), (int) CalendarContainer.getCalendarDimension().getHeight());
		
		
		table.setRowHeight((int) ((table.getSize().getHeight()-20)/nbrPerson));
		
		CalendarContainer.setCalendarHourWidth(test());
		CalendarContainer.setCalendarPersonColWidth(table.getColumnModel().getColumn(0).getWidth());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		validate();
	}
}
