import java.awt.geom.Rectangle2D;

public class Pellet {
	
	private double x, y, radius;

	public Pellet(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		this.radius = .0080;
		
	}
	
	public boolean checkWallCollision(Wall wall) {
		
		Rectangle2D pelletRect = (Rectangle2D) new Rectangle2D.Double(this.x - radius, this.y - radius, 2 * radius, 2 * radius);		
			if (pelletRect.intersects(wall.leftX(), wall.upperY(), wall.getWidth(), wall.getHeight())){
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
		StdDraw.setPenColor(250, 250, 250);
		StdDraw.filledCircle(this.x, this.y, this.radius);
	}
}
