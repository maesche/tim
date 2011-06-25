package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import tim.application.GlobalRegistry;
import tim.controller.CalendarController;

public class DayTableView extends JPanel {
	
	public /*static*/ JTable table;
	int nbrPerson = 0;
	
	CalendarController controller;
	
	public DayTableView(){
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		
		this.controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		
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
	
	@Override
	public void validate(){
		this.setSize(CalendarContainer.getCalendarDimension());
		
		
		
		Dimension d = new Dimension((int)CalendarContainer.getCalendarDimension().getWidth(), (int)CalendarContainer.getCalendarDimension().getHeight());
		table.setSize(d);
		table.setPreferredSize(d);
		table.setBounds(0,0, (int) CalendarContainer.getCalendarDimension().getWidth(), (int) CalendarContainer.getCalendarDimension().getHeight());
		
		
		table.setRowHeight((int) ((table.getSize().getHeight()-20)/nbrPerson));
		
		int calHourWidth = table.getColumnModel().getColumn(1).getWidth() * this.controller.getHoursPerDay();
		CalendarContainer.setCalendarHourWidth(calHourWidth);
		CalendarContainer.setCalendarPersonColWidth(table.getColumnModel().getColumn(0).getWidth());
		
		
		
		//this.controller.setUserCalendarSize(table.getColumnModel().getColumn(1).getWidth(), 20);
		//System.out.println(this.getWidth());
		//this.controller.setDayViewContainerSize((int)table.getPreferredSize().getWidth()-table.getColumnModel().getColumn(1).getWidth(), (int) controller.getCalendarSize().getHeight()-20);
		//this.controller.setDayViewContainerPlacement(table.getColumnModel().getColumn(1).getWidth(), 20);
		//this.controller.setDayViewContainerPlacement();
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		validate();
	}
}
