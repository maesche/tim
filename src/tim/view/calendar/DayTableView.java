package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.JTableHeader;

import tim.application.Config;

public class DayTableView extends JPanel {
	
	static JTable table;
	public JScrollPane scroll;
	
	public DayTableView(){
		this.setOpaque(false);
		
		this.setBounds(0,0, (int) CalendarContainer.getJLayerPaneDimension().getWidth(), (int) CalendarContainer.getJLayerPaneDimension().getHeight());
		this.setLayout(new BorderLayout());
		
		int hourInDay = Config.CALENDAR_DAY_END - Config.CALENDAR_DAY_START;
		int nbrPerson = 3;
		String h;
		
		Object[][] donnees = new Object[nbrPerson][hourInDay+1];
		String[] titreColonnes = new String[hourInDay+1];
		
		titreColonnes[0] = "Collaborateur";
		for(int i=1; i<hourInDay+1; i++){
			h = Integer.toString(i-1 + Config.CALENDAR_DAY_START);
			titreColonnes[i] = h + ":00";
		}
				
		for(int pers = 0; pers<nbrPerson; pers++){
			
			donnees[pers][0]  = "Mathieu Noverraz-Belattalla";
		}
		
		
		this.table = new JTable(donnees, titreColonnes);
		
		
		table.getColumnModel().getColumn(0).setWidth(200);
		table.getColumnModel().getColumn(0).setMinWidth(200);
		
		table.setRowHeight(100);
		
		System.out.println(table.getColumnModel().getColumn(0).getWidth());
		
		table.setAutoResizeMode(0);
		table.setEnabled(false);
		table.setDragEnabled(false);
		table.setFocusable(false);
		this.scroll = new JScrollPane(table);
		scroll.setAutoscrolls(true);
		scroll.setEnabled(false);
		//table.setBounds(100,100, (int) CalendarContainer.getJLayerPaneDimension().getWidth(), (int) CalendarContainer.getJLayerPaneDimension().getHeight());
		add(scroll);
		
	
		
		
		/*this. jTable1 = new JTable(3,hourInDay);
		jTable1.setAutoResizeMode(3);
		jTable1.setBounds(0,0, (int) CalendarContainer.getJLayerPaneDimension().getWidth(), (int) CalendarContainer.getJLayerPaneDimension().getHeight());
		add(jTable1);
		jTable1.setDragEnabled(false);
		jTable1.setEnabled(false);*/
		
	}
	
	public static int getPersonColumnWidth(){
		return table.getColumnModel().getColumn(0).getWidth();
	}
	
	public void validate(){
		this.setSize(CalendarContainer.getJLayerPaneDimension());
		
		scroll.setPreferredSize(CalendarContainer.getJLayerPaneDimension());
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		Dimension d = new Dimension((int)CalendarContainer.getJLayerPaneDimension().getWidth()-2, (int)CalendarContainer.getJLayerPaneDimension().getHeight());
		table.setSize((int)CalendarContainer.getJLayerPaneDimension().getWidth(), (int)CalendarContainer.getJLayerPaneDimension().getHeight());
		table.setPreferredSize(d);
		table.setBounds(0,0, (int) CalendarContainer.getJLayerPaneDimension().getWidth(), (int) CalendarContainer.getJLayerPaneDimension().getHeight());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//this.jTable1.setPreferredSize(CalendarContainer.getJLayerPaneDimension());
		//this.jTable1.setBounds(0, 0, this.getWidth(), this.getHeight());
	}
}
