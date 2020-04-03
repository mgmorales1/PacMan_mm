//import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Ghost {
	
	private double x, y, radius, oldx, oldy;
	private final double STEP = .02;
	private final double STEP_S = .01;
	
	
	public Ghost() {
		this.x = .26;
		this.y = .66;
		this.radius = .02;
	}
	
	public Ghost(double newX, double newY, double newRadius) {
		this.x = newX;
		this.y = newY;
		this.radius = newRadius;
	}
	
	
	public void undo() {
		this.x = oldx;
		this.y = oldy;
	}
	
	
	public boolean checkWallCollision(Wall wall) {		
		Rectangle2D ghostRect = (Rectangle2D) new Rectangle2D.Double(this.x - radius, this.y - radius, 2 * radius, 2 * radius);		
			if (ghostRect.intersects(wall.leftX(), wall.upperY(), wall.getWidth(), wall.getHeight())){
				return true;
			}
			    return false;
	}
	
	
	public void updateIB() {
		if (this.y > .65 && this.y <= .66 && this.x < .70 && this.x >= 0.06) {
			this.x -= this.STEP; 
		}
		if (this.y > .64 && this.y <= .96 && this.x >= 0.06 && this.x < 0.08) {
			this.y += this.STEP; 
		}
		if (this.y <= 0.96 && this.y > 0.94 && this.x >= 0.06 && this.x < 0.95) {
			this.x += this.STEP;  
		}
		if (this.y > 0.05 && this.y <= 0.96 && this.x > 0.92 && this.x <= 0.94) {
			this.y -= this.STEP; 
		}
		if (this.y > .04 && this.y <= .06 && this.x < .94 && this.x >= 0.06) {
			this.x -= this.STEP;  
		}
		if (this.y > .05 && this.y <= .62 && this.x >= 0.06 && this.x < 0.08) {
			this.y += this.STEP; 
		}
		if (this.y <= 0.65 && this.y > 0.62 && this.x >= 0.05 && this.x < 0.45) {
			this.x += this.STEP;  
		}
		if (this.y > 0.5 && this.y <= 0.65 && this.x > 0.42 && this.x <= 0.45) {
			this.y -= this.STEP; 
		}
		if (this.y > 0.49 && this.y <= 0.52 && this.x >0.42 && this.x <= 0.58) {
			this.x += this.STEP;  
		}
		if (this.y > .49 && this.y <= .62 && this.x > 0.57 && this.x <= 0.60) {
			this.y += this.STEP; 
		}
		if (this.y > .60 && this.y <= .65 && this.x > .55 && this.x <= 0.92) {
		   this.x += this.STEP; 		   
		}
	}
	
	
    public void updateP () {
		
		if (this.x > 0 && this.x < 1 && this.y > .05 && this.y < 0.70) {			
			this.x += this.STEP_S;	
			if(this.x >= 0.94) { 
			   this.x -= this.STEP_S;
			   this.y -= this.STEP_S;
		     }
		}
			if (this.x <= 0.06) { 
				this.y += this.STEP_S; 
				this.x += this.STEP_S ;				
			}
		else if (this.x > 0 && this.x < 1 && this.y > .05 && this.y <= 0.36) {
			     this.x -= this.STEP_S;
			 if (this.y >= 0.35) { 				   
				 this.x -= this.STEP_S; 			   
			  }
		}				     
}


    public void updateC() {
	
    	if (this.x > 0 && this.x < 1 && this.y > .05 && this.y < 0.70) {			
		    this.x += this.STEP_S;	
		if (this.x >= 0.94) { 
		    this.x -= this.STEP_S;
		    this.y -= this.STEP_S;
	     }
    	}
		if (this.x <= 0.06) { 
			this.y += this.STEP_S; 
			this.x += this.STEP_S;			
		}
		else if (this.x > 0 && this.x < 1 && this.y > .5 && this.y <= 0.65) {
		         this.x -= this.STEP_S;
		     if (this.y >= 0.64) { 					   
		         this.x -= this.STEP_S; 			   
		 }
	    }
} 

	
	public double leftX() {
		return (this.x - radius);
	}
	
	
	public double upperY() {
		return (this.y - radius);
	}
	
	
	public double getWidth() {
		return (this.radius * 2);
	}
	
	
	public double getHeight() {
		return (this.radius * 2);
	}
	
	
	public void draw() {		
		StdDraw.picture(this.x, this.y, "ghost.png",this.radius *2, this.radius*2  );
	}

}
