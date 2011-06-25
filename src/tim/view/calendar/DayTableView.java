package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
<<<<<<< HEAD
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.JButton;
=======
>>>>>>> refs/remotes/origin/mnoverraz
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import tim.application.GlobalRegistry;
import tim.controller.CalendarController;
<<<<<<< HEAD
import tim.model.Client;
import tim.model.Element;
import tim.model.Employee;
import tim.view.ChildView;
import tim.view.ParentView;
=======
>>>>>>> refs/remotes/origin/mnoverraz

public class DayTableView extends JPanel implements ChildView {
	
	public JTable table;
	int nbrPerson = 0;
	
	private Vector<Vector<Object>> data;
	private Vector<String> columnNames;
	private Vector<Integer> columnWidth;
	
	CalendarController controller;
	private ArrayList<Employee> employees;
	private int rowHeight;
	private Dimension dimension;
	
	public DayTableView(){
		setOpaque(false);
		setLayout(new BorderLayout());
		columnNames = new Vector<String>();
	}
	
	public void load(){
		table = new JTable(data, columnNames);
		/*int preferredSize = 0;
		if (columnWidth.size() == columnNames.size()) {
			for (int i = 0; i < columnWidth.size(); i++) {
				table.getColumnModel().getColumn(i).setMinWidth(columnWidth.get(i));
				//preferredSize += columnWidth.get(i);
			}
		}
		else {
			//preferredSize = 800;
		}*/

		System.out.println((int)(dimension.getHeight() - 20) / 3);
		table.setRowHeight((int)(dimension.getHeight() - 20) / 3);
		table.getTableHeader().setReorderingAllowed(false);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		//setPreferredSize(new Dimension(preferredSize, data.size() * rowHeight + 150));
		
		
		//this.hourInDay = controller.getHoursPerDay();
		

		

		//table = controller.getFormatedTable();
		
		
		

		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(150);


		

		table.setEnabled(false);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		add(scroll, BorderLayout.CENTER);
		add(new JButton("test"), BorderLayout.NORTH);
		table.setSize(dimension);
		table.setPreferredSize(dimension);
		table.setBounds(0,0, (int) dimension.getWidth(), (int) dimension.getHeight());
	}
	
<<<<<<< HEAD
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
	
	
=======
	@Override
>>>>>>> refs/remotes/origin/mnoverraz
	public void validate(){


		
		
		/*this.setSize(CalendarContainer.getCalendarDimension());
		
		
		
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
		
		*/
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		validate();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParentView(ParentView view) {
		// TODO Auto-generated method stub
		
	}
	
	public void setColumnWidth(Vector<Integer> columnWidth) {
		this.columnWidth = columnWidth;
	}
	
	public void setRowHeight(int rowHeight) {
		this.rowHeight = rowHeight;
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createData(Object value) {
		@SuppressWarnings("unchecked")
		ArrayList<Employee> employees = (ArrayList<Employee>) value;
		data = new Vector<Vector<Object>>();
		Vector<Object> rowData;

		for (Employee employee : employees) {
	
			rowData = new Vector<Object>();
			rowData.add(employee);
			for (int i=7; i < 19; i++) {
				rowData.add(null);
			}
			data.add(rowData);
		}
	}
	
	public void setColumnNames(Vector<String> columnNames) {
		this.columnNames = columnNames;
	}
	
	@Override
	public void setData(Object value) {
		createData(value);
	}
}
