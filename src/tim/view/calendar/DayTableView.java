package tim.view.calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import tim.application.Config;

public class DayTableView extends JPanel {
	
	JTable jTable1;
	
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
			h = Integer.toString(i + Config.CALENDAR_DAY_START);
			titreColonnes[i] = h + ":00";
		}
				
		/*for(int pers = 0; pers<nbrPerson; pers++){
			
			donnees[pers][j]  =
		}*/
		
		
		JTable t = new JTable(
				      donnees, titreColonnes);
				
				t.setAutoResizeMode(3);
				t.setBounds(100,100, (int) CalendarContainer.getJLayerPaneDimension().getWidth(), (int) CalendarContainer.getJLayerPaneDimension().getHeight());
		add(new JScrollPane(t));
		
	
		
		
		/*this. jTable1 = new JTable(3,hourInDay);
		jTable1.setAutoResizeMode(3);
		jTable1.setBounds(0,0, (int) CalendarContainer.getJLayerPaneDimension().getWidth(), (int) CalendarContainer.getJLayerPaneDimension().getHeight());
		add(jTable1);
		jTable1.setDragEnabled(false);
		jTable1.setEnabled(false);*/
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//this.jTable1.setPreferredSize(CalendarContainer.getJLayerPaneDimension());
		//this.jTable1.setBounds(0, 0, this.getWidth(), this.getHeight());
	}
}
