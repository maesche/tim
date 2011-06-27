package tim.view.calendar.test;

import java.awt.FlowLayout;
import java.awt.Insets;
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
		btnPreview = new JButton("<");
		dayField = new JTextField(DateHelper.DateToString(DateHelper.getToday()));
		btnNext = new JButton(">");
		
		dayField.setMargin(new Insets(4,4,4,4));
		
		
		add(btnToday);
		add(btnPreview);
		add(dayField);
		add(btnNext);
		update();
	}

	public void update() {
		btnToday.setText(Config.RESSOURCE_BUNDLE.getString("applicationNavigationToday"));
		dayField.setEditable(false);
		repaint();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		update();
	}
}
