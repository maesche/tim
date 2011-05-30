package tim.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import tim.application.ErrorHandler;

public class Application extends JFrame implements Observer{
	
	JButton btnDialog;
	JDialog eventDialog;
	
	public static void main (String args[]) {
		
	}
	
	public Application() {
		
		
		
		/*btnDialog = new JButton("Dialogue");
		Container container = getContentPane();

		btnDialog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventDialog = new EventDialog();
				eventDialog.setSize(200, 200);
				eventDialog.setLocationRelativeTo(Application.this);
				eventDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				eventDialog.setModal(true);
				eventDialog.setResizable(false);

				eventDialog.pack();
				eventDialog.setVisible(true);
			}
			
		});
		
		container.add(btnDialog);*/
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
