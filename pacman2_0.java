

/*I Tahreem Saleem do verify that the submitted code is my own effort and that I have not copied it from any peer or any internet source that has not been acknowledged. 
I also understand that if my submission fails the similarity detection, I would be awarded zero marks not only for this submission but the whole evaluation component
*/


// importing 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;


class panel extends JPanel implements KeyListener,ActionListener{				//extending Jpanel and implementing Listeners
  
	Timer t= new Timer(5,this);																		//setting timer

	int xpointsR[]= { 45, 30,20,10,0};																//initializing angle start for all mouth movement
	int xpointsL[] = { 225,210,200,190,0};														
	int xpointsU[] = { 130,120,106,98,0};															
	int xpointsD[] = { 315,300,290,280,0};														
	int ypoints []= { 270, 300,320,340,360};														
	int i=0; 																									// iniializing for iteration in arrays
	int x = 10 ;																								//initializing starting x y coordinate
	int y=10;																									
	int dx=0;																									//initializing the increment in coordinates
	int dy=0;
	int flag= 0;
	
     public panel()																							//construstor 
	 {
	 t.start();
	 addKeyListener(this);
	 setFocusable(true);
  
    }//constructor ends
 public void paintComponent(Graphics g) {														//starting paint component
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g);
		this.setBackground(Color.black);															//setting backgound color
		g2d.setColor(Color.blue);																		//setting color for obstacle
		g2d.fillRect(285,100,20,185);																	//making obstacle
		
		g2d.setColor(Color.yellow);
		Arc2D.Float pacman = new Arc2D.Float(Arc2D.PIE);										//making packman
		pacman.setFrame(x, y, 67, 46);																			
	
		switch (flag){																								//setting face movement with different sides
			case 0:																						
				pacman.setAngleStart(45);
				pacman.setAngleExtent(270);
				break;
			case 1:
				pacman.setAngleStart(xpointsR[i]);																//when moving Right
				break;
			case 2:
				pacman.setAngleStart(xpointsL[i]);		
				break;																											//when moving left
			case 3:
				pacman.setAngleStart(xpointsU[i]);																	//when moving Up
				break;
			case 4:
				pacman.setAngleStart(xpointsD[i]);																	//when moving down
				break;	
				}//switch ends
		
		if (flag!=0)																									
			pacman.setAngleExtent(ypoints[i]);
											
		i++;																												//iterating arrays
		if (i==5)
			i=0;
		g2d.draw(pacman);
		g2d.fill(pacman);
		
		
		if (x>=570)																								//setting the boundaries
			{flag=2; dx=-5;dy=0;}
		if (y>=320)
			{flag=3;dx=0;dy=-5;}
		if (x<=0)
			{flag =1; dx=5;dy=0;}
		if (y<=0)
			{flag =4;dx=0;dy=5;}
		
		if(x>=220 && x<=305 && y==55)																// reflection from obstacle
			{flag =3;dx=0;dy=-5;}
		if(x>=220 && x<=305 && y==285)
			{flag =4;dx=0;dy=5;}
		if(y>=55 && y<=275 && x==220)
			{flag =2;dx=-5;dy=0;}
		if(y>=55 && y<=275 && x==305)
			{flag =1;dx=5;dy=0;}
		
	
		try
		{
			Thread.sleep(100);
		}
		catch(Exception e){ }
		repaint(10);
   
		}//paint ends
		
		public void actionPerformed(ActionEvent ae){ 												//Action Performed event
		
		repaint (10);
		x=x+dx;
		y=y+dy;
		}//action performed ends
		
		
		public void keyReleased(KeyEvent e){																//key Released event
		      switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
								flag =2;
								dx=-5; 
								dy=0;
								break;
                case KeyEvent.VK_RIGHT:
								flag=1;
								dx=5; 
								dy=0;
								break;
                case KeyEvent.VK_UP:
								flag=3;
								dy=-5;
								dx=0;    
								break;
                case KeyEvent.VK_DOWN:
								flag=4;
								dy=5;
								dx=0;
								break;
            }//switch ends
		}//key released ends
		
		public void keyTyped(KeyEvent e){}																			//key typed event
        public void keyPressed(KeyEvent e){																				//key pressed event
			switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                          dx=-5; 
						  dy=0;
						  flag=2;
						break;
                case KeyEvent.VK_RIGHT:
						dx=5; 
						dy=0;
						flag=1;
						break;
                case KeyEvent.VK_UP:
						dy=-5;
						dx=0;    
						flag=3;
						break;
                case KeyEvent.VK_DOWN:
						dy=5;	
						dx=0;
						flag=4;
						break;
            }//switch ends
			}//keypressed ends
		
		}//panel ends
public class pacman2_0 extends JFrame{															//extending JFrame
	
	public static void main(String[] args) {																		//starting main
		
		pacman2_0 myframe = new pacman2_0() ;														//making object of frame
		panel mypanel = new panel();																			//making object of panel
		mypanel.setLayout(null);																					//setting layout	
		myframe.add(mypanel);																						//adding panel in frame
		myframe.setSize(650, 400);																				//setting size		
		myframe.setVisible(true);																					//making frame visible		
   }//main ends
}//frame ends
		