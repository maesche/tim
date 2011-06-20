package tim.view.dialog.appointment;

import java.awt.Color;

import javax.swing.JLabel;

import tim.application.utils.FormValidator;

public class AppointmentDialogValidator extends FormValidator {
	public static boolean startEnd (JLabel lblBegin, JLabel lblEnd, int beginH, int beginM, int endH, int endM) {
		boolean res = endH > beginH || (endH == beginH && endM > beginM);
				
		if (!res) {
			lblBegin.setForeground(Color.RED);
			lblEnd.setForeground(Color.RED);
		}
		else {
			lblBegin.setForeground(Color.BLACK);
			lblEnd.setForeground(Color.BLACK);
		}
		
		return res;
	}
}
