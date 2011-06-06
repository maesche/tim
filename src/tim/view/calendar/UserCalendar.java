package tim.view.calendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

import tim.model.Element;


public class UserCalendar extends JPanel{
	private JButton btn1 = new JButton("1");
	private JButton btn2 = new JButton("2");
	private JButton btn3 = new JButton("3");
	private JButton btn4 = new JButton("4");
	
	private int calendarHeight;
	private int calendarWidth;
	
	
		
	public UserCalendar(Element employee){
		//Layout du calendrier
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		layout.setHgap(0);
		layout.setVgap(0);
		setLayout(layout);
		this.setOpaque(false);
		
		
		//Paramètrage des boutons
		//btn1.setSize(this.getWidth(), this.getHeight());
		

		//ajout des boutons
		btn1.setSize(100,this.getHeight());
		btn1.setText("<html>" + employee.toString() + "</html>");
	    btn2.setSize(200,this.getHeight());
	    btn2.setText("<html>" + employee.toString() + "</html>");
	    btn3.setSize(300,this.getHeight());
	    btn3.setText("<html>" + employee.toString() + "</html>");
        add(btn1);
        add(btn2);
        add(btn3);
        //add(btn4);
        
        
        
        
        
        
        /*btn1.setPreferredSize(new Dimension(100,50));
        
        btn2.setPreferredSize(new Dimension(250,50));
        btn2.setBorderPainted(false);
        btn2.setBackground(new Color(1f,1f,1f,0));
        btn2.setOpaque(false);
        
        btn2.setText("");
        */
        
        
        //btn3.setMargin(new Insets(0, 0, 0, 0));
		
	}

	public void paintComponent(Graphics g) {
	    // Appel de la méthode de la classe JPanel
	    super.paintComponent(g);
	    
	    
	    
	    
	    
	    btn1.setSize(100,this.getHeight());
	    btn1.setPreferredSize(new Dimension(100,200));
	    
	    btn2.setSize(200,this.getHeight());
	    btn2.setText("");
	    btn2.setPreferredSize(new Dimension(200,200));
	    btn2.setBorderPainted(false);
        btn2.setBackground(new Color(1f,1f,1f,0));
        btn2.setOpaque(false);
        
	    btn3.setSize(300,this.getHeight());
	    //btn3.setBackground(new Color(1, 1, 1, 0));
	    btn3.setPreferredSize(new Dimension(300,200));
	    
	    
	    
	    
	    //this.calendarWidth = this.getWidth();
	    //this.calendarHeight = this.getHeight();
	    //System.out.println(this.getWidth() + "x" + this.getHeight());
	    //System.out.println(this.getWidth() + "x" + this.getHeight());
	    
	    
	    /*this.btn3.setSize(100, this.calendarHeight);
	    this.btn1.setSize(100, this.calendarHeight);
	    System.out.println(btn3.getPreferredSize().getHeight());
	    System.out.println("----------------");*/
	}

	
}
