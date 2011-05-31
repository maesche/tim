package tim.application.utils;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormValidator {
	public static boolean textField(JLabel label, JTextField text) {
		boolean res = true;
		if (text == null || "".equals(text)) {
			label.setForeground(Color.RED);
			res = false;
		}
		else {
			label.setForeground(Color.RED);
		}
		
		return res;
	}
}
