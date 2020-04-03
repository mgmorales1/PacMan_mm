import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class PacMan {
	
	private double x, y, radius, oldx, oldy;
	private final double STEP = .01;
	
	public PacMan() {
		this.x = .5;
		this.y = .5;
		this.radius = .02;
	}
	
	public void update() {
		
		this.oldx = this.x;
		this.oldy = this.y;
		
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
			oldx= this.x;
			this.x += this.STEP;
	        
	    }
	    if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
	    	oldx= this.x;
	    	this.x -= this.STEP;
	        
	    }
	    if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
	    	oldy= this.y;
	    	this.y += this.STEP;
	        
	    }
	    if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
	    	oldy= this.y;
	    	this.y -= this.STEP;
	        
	    }
	}
	
	
	public void undo() {
		this.x = oldx;
		this.y = oldy;
	}
	
	public boolean checkWallCollision(Wall wall) {		
		Rectangle2D pacmanRect = (Rectangle2D) new Rectangle2D.Double(this.x - radius, this.y - radius, 2 * radius, 2 * radius);		
			if (pacmanRect.intersects(wall.leftX(), wall.upperY(), wall.getWidth(), wall.getHeight())){
				return true;
			}
			return false;
	}
	
	public boolean checkPelletCollision(Pellet pellet) {
		Rectangle2D pacmanRect = (Rectangle2D) new Rectangle2D.Double(this.x - radius, this.y - radius, 2 * radius, 2 * radius);
		if (pacmanRect.intersects(pellet.leftX(), pellet.upperY(), pellet.getWidth(), pellet.getHeight())){
		return true;
		}
		return false;

	}
	
	public boolean checkGhostCollision(Ghost ghost) {
		Rectangle2D pacmanRect = (Rectangle2D) new Rectangle2D.Double(this.x - radius, this.y - radius, 2 * radius, 2 * radius);
        if(pacmanRect.intersects(ghost.leftX(), ghost.upperY(), ghost.getWidth(), ghost.getHeight())) {
        	return true;
        }
        return false;
	}
	
	public double getX() {
		return this.x ;
	}
	public double getY() {
		return this.y ;
	}
	
	
	public void draw() {		
		StdDraw.picture(this.x, this.y, "pacman.png",this.radius *2, this.radius*2  );
	}

}
