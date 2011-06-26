package tim.test;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class TestPanel extends JPanel {

	public TestPanel() {
		this.setBackground(Color.red);
	}
	
	public void resize() {
		this.setSize(new Dimension(100, 100));
	}
}
