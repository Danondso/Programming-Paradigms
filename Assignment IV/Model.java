import java.awt.Graphics;
import java.awt.*;
import java.io.IOException;
import java.util.*;



class Model
{   
    //ArrayList of the Sprites.
    ArrayList<Sprite> test = new ArrayList<Sprite>();
   //Random object declared for random turtle position.   
    Random gen = new Random();
    //Counter variable to cycle through adding turtles and Razorbacks.
    int count = 0;
    //x and y variables for the constructor
    int x;
    int y;
    //string variable for the image
    String image;
    
    //Model no longer used.
    Model() throws IOException {   }

    public void update(Graphics g) {
     //For loop cycles through the ArrayList and updates the sprites.
        for(int i = 0; i < test.size(); i++)
        {
        	//test grabs the object and then updates it.
        	test.get(i).update(g);
        }
        
    }

    public void setDestination(int x, int y, int width, int height) {
        
       //Gets the pointer location 
    	PointerInfo razor = MouseInfo.getPointerInfo();
    	Point back  = razor.getLocation();
    	
    	//Gets the x and y coordinate of the pointer to allow the Razorback to spawn where the pointer is.
    	int xx = (int)back.getX();
    	int yy = (int)back.getY();
    	
       //Counter variable used to alternate between turtle and Razorback.
    	count++;
    	
    	//If statement chooses which sprite to add to the array list.
    	if((count % 2 == 1))
        //Adds a turtle on every odd click
        test.add(new Turtle(gen.nextInt(width), gen.nextInt(height), image));
    	else if ((count % 2 == 0))
    	//Adds a Razorback on every even click	
        test.add(new Razorback(xx, yy, image, width, height));
        
    	//For loop to set the destination for all the turtles.
    	for(int i = 0; i < test.size(); i++) 
        {
    		test.get(i);
			Turtle.setDest(x, y);
    
        }
    	
    }
        
}
