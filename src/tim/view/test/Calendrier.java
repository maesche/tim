package tim.view.test;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;


public class Calendrier extends JLayeredPane{
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	
	public Calendrier(){
		
		this.setBounds(0,0,800,600);
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(0);
		layout.setVgap(0);
		setLayout(layout);
		this.setOpaque(false);
		
		//btn1.setSize(100, 50);
		
        add(btn1);
        add(btn2);
        add(btn3);
        
        btn1.setPreferredSize(new Dimension(100,50));
        
        btn2.setPreferredSize(new Dimension(250,50));
        btn2.setBorderPainted(false);
        btn2.setBackground(new Color(1f,1f,1f,0));
        btn2.setOpaque(false);
        
        btn2.setText("");
        
        
        
        btn3.setPreferredSize(new Dimension(100,50));
		
	}
}
