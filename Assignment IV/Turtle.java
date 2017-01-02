import java.awt.Graphics;

class Turtle extends Sprite
{
   
    static private int dest_x;
    static private int dest_y;
    //private Image image;
   // Random gen = new Random();
    
    Turtle(int x, int y, String image){super(x, y, "turtle.png");}
    
   /*
    public int getX(){return super.x;}
    public int getY(){return super.y;}     
    public void setX(int xIn){super.x = xIn;}
    public void setY(int yIn){super.y = yIn;}
   */ 
   
    public void update(Graphics g) {
        // Move the turtle 	
    	if (x < dest_x) {
            x += 1;
        } else if (x > dest_x) {
            x -= 1;
        }
        
        if (y < dest_y) {
            y += 1;
        } else if (y > dest_y) {
           y -= 1;
        }
       
        // Draw the turtle
        g.drawImage(image, x, y, 100, 100, null);
        
    }

   static public void setDest(int x, int y) {
        dest_x = x;
        dest_y = y;
    }  
    
}