
/*I Tahreem Saleem do verify that the submitted code is my own effort and that I have not copied it from any peer or any internet source that has not been acknowledged. 
I also understand that if my submission fails the similarity detection, I would be awarded zero marks not only for this submission but the whole evaluation component
*/
//importing 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.geom.*;
class myPanel extends JPanel implements ActionListener,MouseListener{													//extending Jpanel implementing listeners
	int flag =0;																													
	int x = 200;																																			//setting starting x y coordinates	
	int y = 150;
	int hold =0;
	JButton yes =new JButton ("YES");																											//creating yes no buttons
	JButton no = new JButton ("NO");
	

	{																																							//setting buttons												
		yes.setBounds(350,150,75,20);																										//setting bounds, action listener and color of yes button			
		yes.addActionListener(this);
		yes.setBackground(Color.magenta);
		add(yes);					
		
		no.addMouseListener(this);																												//setting  action listener and color of no button	
		no.setBounds(x,y,75,20);
		no.setBackground(Color.pink);
		add(no);
				
	}//ending block
	
	
	
   public void paintComponent(Graphics g) {																									//adding paintComponent
   
   
		Graphics2D g2d = (Graphics2D)g;
		this.setBackground(Color.cyan);																										//setting background
		super.paintComponent(g);
		Font font = new Font("Serif", Font.PLAIN, 25);																						//setting font
		g2d.setFont(font);
		
		if (flag==0)																																	
			g2d.drawString("Do you like your JAVA Instructor?", 100, 120);																//creating string		
		else if (flag==1)
			g2d.drawString("I already knew that :)",100,120);																				//creating second string

		if (x>40 && x<450 && y>90 && y<120)																							//button not over the string
		{
				g2d.drawString("i am in the box",400,350);		
			x=1+(int)(Math.random()*560);
			y=1+(int) (Math.random()*320);	
			
		}	//if ends
			
		else if (x>300 && x>420 && y>160 && y>150)																				//button not over the yes button
			{g2d.drawString("i am in yes",400,350);
				x=1+(int)(Math.random()*560);
			y=1+(int) (Math.random()*320);	
			}	//if ends
			
	
		no.setBounds(x,y,75,20);																														//setting bounds for no button
		
		try
		{
			Thread.sleep(5);
		}//ending try
		catch(Exception e){ }
		repaint(100);	
		//else ends
		
		
		g2d.drawString(x+" "+y, 200, 200);
		//g2d.fillRect(340,150,50,20);		
		//g2d.fill (new Ellipse2D.Double( 420, 160, 10, 10 ));	
																																	//repaint
   }//ending paint	
   public void actionPerformed (ActionEvent ae)																							//action performed
   {
		flag=1;	
  }//ending action listener
	public void mouseClicked( MouseEvent e){}																								//overridding mouse listener events
	public void mousePressed( MouseEvent e){}
    public void mouseReleased( MouseEvent e){}
    public void mouseExited( MouseEvent e){}
	public void mouseEntered( MouseEvent e){																								//mouse entered event			
		
			x=1+(int)(Math.random()*560);
			y=1+(int) (Math.random()*320);	
	}//ending mouse entered
  
  
  }//ending panel
  public class Frame extends JFrame{																										// extending Jframe
	
	public static void main(String[] args) {																								//starting main
		Frame myframe = new Frame() ;
		myPanel mypanel = new myPanel();
		mypanel.setLayout(null);
		myframe.add(mypanel);
		myframe.setSize(650, 400);
		myframe.setVisible(true);
   }//ending main
}//ending frame