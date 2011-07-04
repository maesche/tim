package tim.application.utils;

import java.awt.Color;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This class is a helper for validating Form inputs
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class FormValidator {
	/**
	 * Returns true if the text in specified textField is correct
	 * If not, the foreground color of the label of the text field 
	 * will be set to red
	 * @param label
	 * @param text
	 */
	public static boolean textField(JLabel label, JTextField text) {
		boolean res = true;
		if (text == null || "".equals(text.getText())) {
			label.setForeground(Color.RED);
			res = false;
		}
		else {
			label.setForeground(Color.BLACK);
		}
		
		return res;
	}
	
	/**
	 * Returns true if the text in specified textField is a date
	 * If not, the foreground color of the label of the text field 
	 * will be set to red
	 * @param label
	 * @param text
	 */
	public static boolean dateField(JLabel label, JTextField text) {
		boolean res = true;

		if (text != null) {
			try {
				res = text.getText().equals(DateHelper.DateToString(DateHelper.StringToDate(text.getText())));
			}
			catch (ParseException ex) {
				res = false;
			}
			
		} else {
			res = false;
		}
		
		if (!res) {
			label.setForeground(Color.RED);
		}
		else {
			
			label.setForeground(Color.BLACK);
		}
		
		return res;
	}
}
