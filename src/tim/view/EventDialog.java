package tim.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class EventDialog extends JDialog implements ActionListener {
		  public EventDialog() {
		   
		    JPanel messagePane = new JPanel();
		    messagePane.add(new JLabel("sd"));
		    getContentPane().add(messagePane);
		    JPanel buttonPane = new JPanel();
		    JButton button = new JButton("OK"); 
		    buttonPane.add(button); 
		    button.addActionListener(this);
		    getContentPane().add(buttonPane, BorderLayout.SOUTH);
		    

		  }
		  public void actionPerformed(ActionEvent e) {
		    setVisible(false); 
		    dispose(); 
		  }

		
}
