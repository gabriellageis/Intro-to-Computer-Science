package gotcha;

import java.util.ArrayList;

import processing.core.PApplet;

// import processing.core.PImage; // For background image

public class GoGetEm extends PApplet {
	
    // Keep track of current score
    int score = 0;
    
    // timer
    int timer;
    int gameDuration = 20000;

    // Canvas size
    final int canvasWidth  = 500;
    final int canvasHeight = 500;

    // Declare disks
    ArrayList<Disk> disks = new ArrayList<Disk>();

    public static void main(String[] args){
        PApplet.main("gotcha.GoGetEm");
    }
    
    public void settings() {
        size(canvasWidth, canvasHeight);
        smooth();
    }

    // setup() runs one time at the beginning of your program
    public void setup() {
    	timer = gameDuration;
        // Create a disk
    	//d1 = new Disk(231, 166, 255);
    	int pointValue = 10; 
    	int positionX = 100;
    	int positionY = 50;
    	int xSpeed = 1;
    	
    	for (int i = 0; i < 5; i++) {
    		pointValue += 20;
    		positionX += 100;
    		positionY += 100;
    		xSpeed += 2;
    		disks.add(new Disk(random(0, 255), random(0, 255), random(0, 255), pointValue, positionX, positionY, xSpeed));
    	}
    }

    // draw() is called repeatedly in an infinite loop.
    // By default, it is called about 60 times per second.
    public void draw() {
    	System.out.println(millis());
    	if (millis() >= timer) {
    		eraseBackground();
    		textSize(20);
            fill(156, 186, 255);
            textAlign(CENTER);
    		text("Thank you for playing, press any key to exit.", 250, 150);
    		text("Score: " + this.score, 250, 250);
    		if (this.mousePressed || this.keyPressed) {
    			System.exit(0);
    		}
    	} else {
    		// Erase the background, if you don't, the previous shape(s) will 
            // still be displayed
            eraseBackground();
            
            for (int i = 0; i < 5; i++) {
            	// Move the shape, i.e. calculate the next x and y position
                // where the shape will be drawn.
                disks.get(i).calcCoords();

                // Draw the shape
                disks.get(i).drawShape();

                // Display point value on the shape
                disks.get(i).displayPointValue();
            }
            

            // Display player's score 
            // text(String, x-coordinate, y-coordinate)
            textSize(20);
            fill(156, 186, 255);
            textAlign(CENTER);
            text("Score: " + this.score, 250, 50);
    	}
        
        
    }

    public void eraseBackground() {      
        // White background:
        background(255, 253, 156);
        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           | Use the following lines to display an image in the background. |
           | You will need to bring a .png file into your package. The path |
           | given below should be replaced by your path and png file name. |
           |                                                                |
           |   PImage bg = loadImage("hw_pkg/moon_walk.png");               |
           |   background(bg);                                              |
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

    // mousePressed() is a PApplet method that you will override.
    // This method is called from PApplet one time when the mouse is pressed.
    public void mousePressed() {
        // Draw a circle wherever the mouse is
        int mouseWidth  = 20;
        int mouseHeight = 20;
        fill(0, 255, 0);
        ellipse(mouseX, mouseY, mouseWidth, mouseHeight);

        for (int i = 0; i < disks.size(); i++) {
        	// Check whether the click occurred within range of the shape
            if ((this.mouseX >= (disks.get(i).x - disks.get(i).targetRange)) && (this.mouseX <= (disks.get(i).x + disks.get(i).targetRange)) && 
                 (this.mouseY >= (disks.get(i).y - disks.get(i).targetRange)) && (this.mouseY <= (disks.get(i).y + disks.get(i).targetRange))) {
                
                // Update score:
                score = score + disks.get(i).pointValue;
                System.out.println("DBG:  HIT!");
            }
        }
        
    }

    // Create a Disk class that you will use to create one or more disks with each
    // disk having a color, speed, position, etc.
    class Disk {
        // Size of disk
        final int shapeWidth  = 50;			
        final int shapeHeight = 35;			

        // Point value of disk
        int pointValue;

        // Position of disk - keep track of x and y position of disk
        float x;			
        float y;			

        // Horizontal speed of disk
        float xSpeed; 		

        // It's hard to click a precise pixel on a disk, to make it easier we can
        // allow the user to click somewhere on the disk.
        // You might want to make the scoring space be a rectangle fitted tightly
        // to the disk - it's easier than calculating a rounded boundary.
        int targetRange = Math.round(min(shapeHeight, shapeWidth));		

        float red;
        float green;
        float blue;

        // The constructor could be extended to accept other disk characteristics
        Disk(float red, float green, float blue, int pointValue, float x, float y, float xSpeed) {
            this.red   = red;
            this.green = green;
            this.blue  = blue;
            this.pointValue = pointValue;
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
        }

        Disk() {
            this(0, 0, 255, 10, 100, 100, 1);
        }

        public void calcCoords() {      
            // Compute the x position where the shape will be drawn
            this.x += this.xSpeed;			 

            // If the x position is off right side of the canvas, reverse direction of 
            // movement:
            if (this.x > canvasWidth) {
                // Log a debug message:
                System.out.println("DBG:  <---  Change direction, go left because x = " + this.x);

                // Recalculate:
                this.xSpeed = -1 * this.xSpeed;			//switch directions
            }

            // If the x position is off left side of the canvas, reverse direction of 
            // movement:
            if (this.x < 0) {
                // Log a debug message:
                System.out.println("DBG:      ---> Change direction, go right because x = " + this.x + "\n");
               
                // Recalculate:
                this.xSpeed = -1 * this.xSpeed;
            } 
        }

        public void drawShape() {
            // Select color, then draw the shape at computed x, y location
            fill(red, green, blue);
            ellipse(x, y, shapeWidth, shapeHeight);
        }

        public void displayPointValue() {
            // Draw the text at computed x, y location
            //TODO this.pointValue = ...
            textSize(20);
            fill(0, 0, 0);
            text(this.pointValue, x, y+5);
        }
    }

}
