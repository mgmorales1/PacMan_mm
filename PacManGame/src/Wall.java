
public class Wall {
	
	private double x, y, halfWidth, halfHeight;

	public Wall(double newX, double newY, double newWidth, double newHeight) {
		this.x = newX;
		this.y = newY;
		this.halfWidth = newWidth;
		this.halfHeight = newHeight;
	}
	
	public double leftX() {
		return (this.x - this.halfWidth);
	}
		
	
	public double upperY() {
		return (this.y - this.halfHeight);
	}
		
	
	public double getWidth() {
		return (this.halfWidth * 2);
	}
	
	public double getHeight() {
		return (this.halfHeight * 2);
	}
	public double getX() {
		return this.x ;
	}
	
	public double getY() {
		return this.y ;
	}
	
	public void draw() {
		StdDraw.setPenColor(255, 190, 170);
		StdDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
	}

}
