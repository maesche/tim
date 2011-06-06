package tim.view.test;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Table extends JPanel {
	
	public Table(){
		this.setOpaque(false);
		
		this.setBounds(0,0,800,600);
		Object[][] donnees = {  
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
			   {"1","2","3","4","5","6","7","8","9"},
		} ;
		
		String[] titreColonnes = {"1","2","3","4","5","6","7","8","9"}; 
		JTable jTable1 = new JTable(5,5);
		jTable1.setAutoResizeMode(3);
		add(jTable1);
		jTable1.setDragEnabled(false);
		jTable1.setEnabled(false);
		jTable1.setBounds(0, 0, 800, 600);
	}
}
