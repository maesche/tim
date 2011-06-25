package tim.view.calendar;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tim.application.Config;
import tim.application.GlobalRegistry;
import tim.application.exception.ResourceNotFoundException;
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
		JTextField dayField = new JTextField("19.07.1986");
		JButton btnNext = new JButton(">");
		
		dayField.setMargin(new Insets(4,4,4,4));
		
		
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
