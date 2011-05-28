package tim.calendar.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Cal1 extends JPanel{
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	
	public Cal1(){
		
		
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(0);
		layout.setVgap(0);
		setLayout(layout);
		
		//btn1.setSize(100, 50);
		
        add(btn1);
        add(btn2);
        add(btn3);
        
        btn1.setPreferredSize(new Dimension(100,50));
        
        btn2.setPreferredSize(new Dimension(250,50));
        btn2.setBorderPainted(false);
        btn2.setBackground(new Color(1f,1f,1f,0f));
        
        btn2.setText("h");
        
        btn3.setPreferredSize(new Dimension(100,50));
		
	}
}
