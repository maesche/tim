package tim.view.test;


import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;



 
public class Application extends JFrame{
 
	private Layer layer;
	public Dimension appSize;
 
	@SuppressWarnings("deprecation")
	public Application () {
 
		super();
 
        layer = new Layer(this.getLayeredPane());
        this.setContentPane(layer);
        
        
 
		this.pack();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.show();
		
		Graphics g = getGraphics();
		paintComponent(g);
	}
 
	public static void main (String args[]) {
 
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			//ErrorHandler.getException(ex, this.getClass().getName(), "Application()");
		}
		new Application();
 
	}
	
	protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        //super.paintComponent(g);
        
		Dimension d = this.getSize();
		System.out.println(d.width + "x" + d.height);
	}

 
}