import java.awt.Graphics;
import java.util.*;

public class Razorback extends Sprite {
	
	//Random object for the random numbers.
	Random move = new Random();
	private int width;
	private int height;  
    //Top and bottom range.
	int max = 5;
	int min = (-5);
	//Random numbers for the razorbacks update.
	int xSlope = move.nextInt(max - (min) + 1) + min;
	int ySlope = move.nextInt(max - (min) + 1) + min;
    
    Razorback(int x, int y, String image, int width, int height){
		
		super(x, y, "razorback.png");
		// The width and height variables.
		this.width = width;
		this.height = height;	
		
	}
   
	//Gets and sets are now handled by the Sprite superclass.
	/*	
	    public int getX(){return super.x;}
	    public int getY(){return super.y;}
	    
	    public void setX(int xIn){super.x = xIn;}
	    public void setY(int yIn){super.y = yIn;}
	*/    
	
	
	public void update(Graphics g) {
	    
		//Coordinated for the Razorback.
	     x += xSlope;
	     y += ySlope;
		
	  //Fixes the Razorback that spawns and doesn't move.
	    if(x == 0)
	    {
	     xSlope = move.nextInt(max - (min) + 1) + min;
	     x += xSlope;
	    }
	    if(y == 0)
	    {
		   ySlope = move.nextInt(max - (min) + 1) + min;
		   y += ySlope;
	    }
	     
	    //IF statements that make the Razorback wrap to the other side of the window. 
	      if((x < 0))
	    	  x = width;
	      
	      if(x > width)
	    	  x = 0;
	      
	      if((y < 0))
	          y = height;
		
	      
	      if(y > height)
	    	  y = 0;
	        // Draw the Razorback
	        g.drawImage(image, x, y, 100, 100, null);
	    	
	    }
       
	    //Razorback has no specific destination so setDest is no longer needed.
	    /*
	    static public void setDest(int x, int y) {dest_x = x; dest_y = y;}
        */
}