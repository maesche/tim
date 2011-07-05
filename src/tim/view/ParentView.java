package tim.view;

/**
 * All views susceptible to interact with a controller needs
 * to implement this interface
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public interface ParentView extends AbstractView {
	/**
	 * Saves information to the controller
	 * @param action (add/edit/delete)
	 * @param value (handled value)
	 */
	public void save(String action, Object value);
}
