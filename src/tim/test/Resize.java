package tim.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Resize extends JFrame {
	
	private TestPanel testPanel;

	public Resize() {
		testPanel = new TestPanel();

		JButton resize = new JButton("Resize");
		
		resize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				resize();
			}
		});
		
		add(resize, BorderLayout.NORTH);
		add(testPanel, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(600, 600));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	
	public void resize() {
		testPanel.resize();
	}
	
	
	public static void main(String[] args) {
		new Resize();

	}

}
