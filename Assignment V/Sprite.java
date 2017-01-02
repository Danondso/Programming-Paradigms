import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.util.Random;

abstract class Sprite
{
    private int x;
    private int y;
    private int size;
    private int w;
    private int h;
    private int xSlope;
    private int ySlope;
    private Image image;
    private static Random rand;
    //I counted with the counter at 0 and it was always 21 or 22,
    //changed to 2 and it always removes at 20.
    int counter = 2;
    //String for my get and set functions to change the gravestone
    private String ImagePath;
    //True or false for the hit
    private boolean smack;
    public Sprite(int xIn, int yIn, int width, int height, String imagePath, int imageSize) {
        if (rand == null) {
            rand = new Random();
        }
        size = imageSize;
        setImage(imagePath);
        x = xIn;
        y = yIn;
        w = width;
        h = height;
        xSlope = rand.nextInt(11) - 5;
        ySlope = rand.nextInt(11) - 5;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSize() { return size; }
    public void setSize(int s) { size = s; }
    public void setX(int xIn) { x = xIn; }
    public void setY(int yIn) { y = yIn; }
    
    public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
            setImagePath(imagePath);
        } 
        catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
    }
    public Image getImage() { return image; }
    //I wrote some functions to get the set the string for the imagepath for the should remove
    //I know there's another way but this works just fine.
    public void setImagePath(String path){ImagePath = path; }
    public String getImagePath(){return ImagePath;}
   
    public boolean overlaps(Sprite s) {
        
    	//Checks for the overlap
    	if(((x <= s.x) && (s.x <= x + size)) || ((x <= s.x + s.size) && (s.x + s.size <= x + size)))
    		if(((y <= s.y) && (s.y <= y + size)) || ((y <= s.y + s.size) && (s.y + s.size <= y + size)))
    		{
    		//	System.out.println("I overlapped!");
    			return true;	    
    		}
    	return false;
    }
    
    public void update(Graphics g) {
       
    	g.drawImage(getImage(), x, y, getSize(), getSize(), null);   
    	//Increments the counter for the should remove based on whether it was hit or not
    	  if(smack)
           counter ++;
        	
        
    }
    
    //Should remove method to check if the sprite should disappear
    public boolean shouldRemove()
    {
		//System.out.println(counter);
    	if(counter > 20)
    	{
    	    //System.out.println("I'm 20!");
    		return true; 	
    	}	    
    	    return false;
    }
    
   public void hit()
    {	
    	//sets the image to the gravestone and stops them from moving.
    	setImage("gravestone.jpg");
        xSlope = 0;
        ySlope = 0;
        //sets the hit to true
        smack = true;
    }


    
    
    public void move() {
        // Move the Sprite 
    	int x = getX() + xSlope;
        int y = getY() + ySlope;
        if (x < 0) x = w;
        if (x > w) x = 0;
        if (y < 0) y = h;
        if (y > h) y = 0;
        setX(x);
        setY(y);
    }  
    
}