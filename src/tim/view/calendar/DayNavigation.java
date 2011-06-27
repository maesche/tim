package tim.view.calendar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.ResourceNotFoundException;
import tim.controller.CalendarController;
import tim.view.AbstractView;

public class DayNavigation extends JPanel implements AbstractView{
	
	private JButton btnToday;

	public DayNavigation(){
		try {
			GlobalRegistry.mvcLinker.addObserverToSystemResource("LanguageLinker", this);
		} catch (ResourceNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setOpaque(false);
		this.setLayout(new FlowLayout());
		
		btnToday = new JButton();
		JButton btnPreview = new JButton("<");
		final JTextField dayField = new JTextField("19.07.1986");
		dayField.setEnabled(false);
		JButton btnNext = new JButton(">");
		
		dayField.setMargin(new Insets(4,4,4,4));
		
		CalendarController controller = (CalendarController) GlobalRegistry.mvcLinker.getControllers().get("CalendarController");
		
		btnToday.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dayField.setText("Today");
			}
		});
		
		btnPreview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dayField.setText("Preview");
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dayField.setText("Next");
			}
		});
		
		
		add(btnToday);
		add(btnPreview);
		add(dayField);
		add(btnNext);
		update();
	}

	public void update() {
		btnToday.setText(Config.RESSOURCE_BUNDLE.getString("applicationNavigationToday"));
		repaint();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		update();
		
	}
}
