package tim.view.calendar.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import tim.application.GlobalRegistry;
import tim.application.Resizer;
import tim.model.Element;
import tim.model.Employee;
import tim.view.ChildView;
import tim.view.ParentView;

public class DayTableView extends JPanel implements ChildView {
	private JTable table;
	private Vector<Vector<Object>> data;
	private Vector<String> columnNames;
	private int rowHeight;
	private Vector<Integer> columnWidth;
	private Dimension dimension;
	
	public DayTableView () {
		GlobalRegistry.resizer.addObserver(this);
		data = new Vector<Vector<Object>>();
		setLayout(new BorderLayout());
	}
	
	public void load() {
		table = new JTable(data, columnNames);
		table.setRowHeight(rowHeight);
		
			for (int i = 0; i < columnWidth.size(); i++) {
				table.getColumnModel().getColumn(i).setMinWidth(columnWidth.get(i));
				table.getColumnModel().getColumn(i).setPreferredWidth(columnWidth.get(i));
				table.getColumnModel().getColumn(i).setMaxWidth(columnWidth.get(i));
			}
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void createData(Object value) {
		@SuppressWarnings("unchecked")
		ArrayList<Element> elements = (ArrayList<Element>) value;
		data = new Vector<Vector<Object>>();
		Vector<Object> rowData;

		for (Element element : elements) {
			Employee employee = (Employee) element;
			rowData = new Vector<Object>();
			rowData.add(employee);
			data.add(rowData);
		}
	}

	public void setColumnNames(Vector<String> columnNames) {
		this.columnNames = columnNames;
	}
	
	public void setRowHeight(int rowHeight) {
		this.rowHeight = rowHeight;
	}
	
	public void setColumnWidth(Vector<Integer> columnWidth) {
		this.columnWidth = columnWidth;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Resizer) {
			this.dimension = (Dimension) arg;
			System.out.println("      DayTableView");
			System.out.println("         Taille obtenue par le Resizer: " + dimension);
		    
			repaint();

		    
		    //int rowHeight = (int) (dimension.getHeight()-30) / data.size();
		    //table.setRowHeight(rowHeight);
		    
		    
		    //System.out.println(dimension.getHeight());
		    //int rowHeight = table.getHeight()/data.size();
		    //System.out.println(rowHeight);
		    
		    //this.rowHeight = rowHeight;
		    //table.setRowHeight(rowHeight);
		    //table.setSize((int) dimension.getWidth(),rowHeight);
		    //table.setPreferredSize(new Dimension((int) dimension.getWidth(),tableSize));
		    //table.setRowHeight(rowHeight);
		    
		    //System.out.println(table.getRowHeight());

		}

	}

	@Override
	public void setParentView(ParentView view) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setData(Object value) {
		createData(value);
	}
	
	public void validate() {
		dimension = getSize();
		setSize(dimension);
	    setPreferredSize(dimension);
	    
	    System.out.println("rowHeight1 " + (dimension.getHeight()-20) / data.size());
		//table.setRowHeight((int) (dimension.getHeight()-30) / data.size());
	    
	    
	    
	    
	    int rowHeight2 = (int) ((int) (dimension.getHeight()-30) / (float)data.size());
	    int rowHeight3 = (int) ((dimension.getHeight()-20) / data.size());
	    
	    System.out.println("rowHeight1 " + rowHeight2);
	    System.out.println("rowHeight2 " + rowHeight3);
	    table.setRowHeight(rowHeight3);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		validate();
	}
	
}
