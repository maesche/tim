package tim.view.appointmentdialog;

import tim.application.utils.FormValidator;

public class AppointmentDialogValidator extends FormValidator {
	public static boolean startEnd (int beginH, int beginM, int endH, int endM) {
		return endH > beginH || (endH == beginH && endM > endM);
	}
}
