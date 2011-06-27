package tim.view.calendar.test;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.ResourceNotFoundException;
import tim.application.utils.DateHelper;
import tim.view.AbstractView;

public class DayNavigation extends JPanel implements AbstractView{
	
	private JButton btnToday;
	private JButton btnPreview;
	private JTextField dayField;
	private JButton btnNext;
	private Date currentDate;
	private CalendarContainer calendarContainer;

	public DayNavigation(CalendarContainer calendarContainer){
		this.calendarContainer = calendarContainer;
		try {
			GlobalRegistry.mvcLinker.addObserverToSystemResource("LanguageLinker", this);
		} catch (ResourceNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setOpaque(false);
		this.setLayout(new FlowLayout());
		
		currentDate = DateHelper.getToday();
		
		btnToday = new JButton();
		
		
		btnPreview = new JButton("<");
		dayField = new JTextField();
		btnNext = new JButton(">");
		
		btnToday.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				today();
			}
		});
		
		btnPreview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				previous();
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				next();
			}
		});
		
		dayField.setMargin(new Insets(4,4,4,4));
		
		
		add(btnToday);
		add(btnPreview);
		add(dayField);
		add(btnNext);
		update();
	}
	
	private void today() {
		currentDate = DateHelper.getToday();
		calendarContainer.goTo(currentDate);
		update();
	}
	
	private void next() {
		currentDate = DateHelper.getNextDay(currentDate);
		calendarContainer.goTo(currentDate);
		update();
	}
	
	private void previous() {
		currentDate = DateHelper.getPreviousDay(currentDate);
		calendarContainer.goTo(currentDate);
		update();
	}
	
	public void update() {
		btnToday.setText(Config.RESSOURCE_BUNDLE.getString("applicationNavigationToday"));
		dayField.setText((DateHelper.DateToString(currentDate)));
		dayField.setEditable(false);
		repaint();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		update();
	}
}
