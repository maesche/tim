package tim.view.dialog.appointment;

import java.awt.Color;

import javax.swing.JLabel;

import tim.application.utils.FormValidator;

/**
 * Specific validator for Appointments
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public class AppointmentDialogValidator extends FormValidator {
	
	/**
	 * Returns true if end time is greather than start
	 * 
	 * @param lblBegin
	 * @param lblEnd
	 * @param beginH
	 * @param beginM
	 * @param endH
	 * @param endM
	 */
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
