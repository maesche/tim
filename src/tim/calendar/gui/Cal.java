package tim.calendar.gui;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;



public class Cal extends JFrame  {
	
	public static void main(String[] args){
		Cal testApp = new Cal();
		testApp.pack();
		testApp.setVisible(true);
		testApp.setSize(400, 200);
		
		//pour fermer l'application
		testApp.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				super.windowClosing(arg0);
				System.exit(0);
			}
			
		});	
	}
	
	
	public Cal(){
		int nbrPerson = 3;
		
		
		setLayout(new GridLayout(nbrPerson,1));
        add(new Cal1());
        add(new Cal1());
        add(new Cal1());
		
	}

}
