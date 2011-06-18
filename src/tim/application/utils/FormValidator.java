package tim.application.utils;

import java.awt.Color;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class FormValidator {
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
