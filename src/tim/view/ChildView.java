package tim.view;


public interface ChildView extends AbstractView {
	public void setParentView(ParentView view);
	public Object getData();
	public void setData(Object value);
}
