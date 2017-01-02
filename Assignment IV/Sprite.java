import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public abstract class Sprite
{
    //Protected variables for the subclasses to access.
	 protected int x;
	 protected int y;
	 protected Image image;
	
	
     Sprite(int x, int y, String filename)
     {   	 
    	 //Allows the turtle and razorback to get back an x and y value.
    	 this.x = x;
    	 this.y = y;
    	 //Loads the image
    	 try
         {
              image = ImageIO.read(new File(filename));
              
         } 
         catch (IOException ioe) 
         {
             System.out.println("Unable to load image file.");
         }   
    	 
     }

	public Image getImage(){
		//Returns the image.
		return image;
	}


     public void update(Graphics g){   }




}

