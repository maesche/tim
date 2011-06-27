package tim.view.calendar.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Vector;

import tim.model.Appointment;
import tim.model.AppointmentModel;
import tim.model.Element;
import tim.model.Employee;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.Resizer;
import tim.application.exception.PersistanceException;
import tim.application.exception.ResourceNotFoundException;
import tim.application.utils.DateHelper;
import tim.view.ParentView;

public class CalendarContainer extends JPanel implements ParentView {
	private Dimension dimension;
	private JLayeredPane layeredPane;
	private CalendarController controller;
	private DayViewContainer dayViewContainer;
	private DayTableView dayTableView;
	private ArrayList<Element> elements;
	
	public CalendarContainer() {
		this.setBounds(0, 0, 500, 500);
		
		controller = new CalendarController();
		dimension = new Dimension(Config.APPLICATION_DEFAULT_FRAME_WIDTH, Config.APPLICATION_DEFAULT_FRAME_HEIGHT-88);
		
		GlobalRegistry.resizer.addObserver(this);
		

		loadData(DateHelper.getToday(), DateHelper.getToday());
		initDayTableView(elements);
		initDayViewContainer(elements);
		
		setLayout(new BorderLayout());
		
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(dimension);

		setPreferredSize(dimension);
		
		layeredPane.add(dayTableView, new Integer(5));
		layeredPane.add(dayViewContainer, new Integer(20));
	
		add(layeredPane, BorderLayout.NORTH);
	}
	
	
	public void loadData(Date begin, Date end) {
		begin = null;
		try {
			begin = DateHelper.StringToDate("2011-05-14");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = null;
		try {
			end = DateHelper.StringToDate("2011-06-15");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			elements = controller.getCalendars(begin, end);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initDayTableView(ArrayList<Element> elements) {
		dayTableView = new DayTableView();
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add(Config.RESSOURCE_BUNDLE.getString("calendarCollaborator"));
		String hour;
		for(int i=1; i<Config.CALENDAR_DAY_END-Config.CALENDAR_DAY_START+1; i++){
			hour = Integer.toString(i-1 + Config.CALENDAR_DAY_START);
			columnNames.add(hour + ":00");
		}
		
		Vector<Integer> columnWidth = new Vector<Integer>();
		columnWidth.add(200);
		
		dayTableView.setColumnWidth(columnWidth);
		dayTableView.setColumnNames(columnNames);

		dayTableView.setRowHeight((int) (dimension.getHeight()-20) / elements.size());
		dayTableView.setData(elements);
		dayTableView.load();
		dayTableView.setSize(dimension);
	}
	
	public ArrayList<EventButton> getButtonsForCalendar(ArrayList<Appointment> appointments) {
		ArrayList<EventButton> eventButtons = new ArrayList<EventButton>();
		try {
			eventButtons = new CalendarController().getButtonsCalendar(appointments);
		} catch (PersistanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventButtons;
	}
	
	private void initDayViewContainer(ArrayList<Element> elements) {
		dayViewContainer = new DayViewContainer();
		dayViewContainer.setData(elements);
		dayViewContainer.setParentView(this);
		dayViewContainer.load();
		dayViewContainer.setSize(new Dimension(((int) dimension.getWidth()), (int) dimension.getHeight()-20));
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Resizer) {
			this.dimension = (Dimension) arg;
			System.out.println("CalendarContainer");
			System.out.println("   Taille obtenue par le Resizer: " + dimension);
			repaint();
		}
	}

	@Override
	public void save(String action, Object value) {
		// TODO Auto-generated method stub

	}
	
	public Employee getData(Employee employee, Date date) {
		loadData(date, date);
		Employee employRet = null;

		for (Element element : elements) {
			if (element.getId() == employee.getId()) {
				employRet = (Employee) element;
			}
		}
		return employRet;
		
	}
	
	public void goTo(Date date) {
		dayViewContainer.goTo(date);
	}
	
	public void validate(){
	    setSize(dimension);
	    setPreferredSize(dimension);
	    layeredPane.setPreferredSize(dimension);
	}
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    validate();
	}

}
