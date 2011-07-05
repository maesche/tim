package tim.view;

/**
 * This class holds presentation container visible to the user
 * 
 * 
 * @author BELLATALLA Alain, MEIER Stefan, NOVERRAZ Mathieu
 * @version 2011.0704
 */
public interface ChildView extends AbstractView {
	/**
	 * Sets the ParentView as some operation may need
	 * to ask information
	 * @param view
	 */
	public void setParentView(ParentView view);
	
	/**
	 * Returns all data as an Object
	 * @return
	 */
	public Object getData();
	
	/**
	 * Sets all date for view components visible to the user
	 * @param value
	 */
	public void setData(Object value);
	
	public void load();
}
