

// The main method for the Pac-Man project
// CMS 170, Spring 2019

public class Game {
	static final int NUM_ROWS = 18;
	static final int NUM_COLS = 18;
		
	public static void main(String[] args) {
		
		// Initialize objects
		PacMan pacman = new PacMan();
		Ghost blinky = new Ghost(.65, .66, .02);
		Ghost inky = new Ghost(.10, .66, .02);
		Ghost pinky = new Ghost();
		Ghost clyde = new Ghost();
		int  userScore = 0;
		
		Wall[] walls = new Wall[18];
		walls[0] = new Wall(.0, .5, .02, .5); 
		walls[1] = new Wall(.5, .0, .5, .02); 
		walls[2] = new Wall(1, .5, .02, .5); 
		walls[3] = new Wall(.5, 1, .5, .02);
		walls[4] = new Wall(.26, .20, .16, .1); 
		walls[5] = new Wall(.74, .20, .16, .1); 
		walls[6] = new Wall(.5, .20, .02, .1); 
		walls[7] = new Wall(.5, .80, .02, .1); 
		walls[8] = new Wall(.26, .80, .16, .1); 
		walls[9] = new Wall(.74, .80, .16, .1); 
		walls[10] = new Wall(.25, .50, .1, .1); 
		walls[11] = new Wall(.75, .50, .1, .09); 
		walls[12] = new Wall(.5, .58, .02, .02); 
		walls[13] = new Wall(.5, .42, .02, .02); 
		walls[14] = new Wall(.25, .5, .03, .045);
		walls[15] = new Wall(.75, .5, .03, .045);
		walls[16] = new Wall(.25, .42, .03, .01);
		walls[17] = new Wall(.75, .42, .03, .01);

		
		
		Pellet[][] pellets = new Pellet[NUM_ROWS][NUM_COLS];
		int numPellets = NUM_ROWS * NUM_COLS;
		double x = .075;
		double y = .068;
		for (int row = 0; row<pellets.length; row++) {						
			for (int col = 0; col<pellets[row].length; col++) {	
				pellets[row][col] = new Pellet (x, y);
				x += 0.05;									
			}
			    y += 0.05;
			    x = .075;			
		}
		
		for (int row = 0; row<pellets.length; row++) {						
			for (int col = 0; col<pellets[row].length; col++) {
				if(pellets[row][col].checkWallCollision(walls[row]) || pellets[row][col].checkWallCollision(walls[col]) ||
					pellets[row][col].checkWallCollision(walls[row+1 - row]) || pellets[row][col].checkWallCollision(walls[col+1 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+2 - row]) || pellets[row][col].checkWallCollision(walls[col+2 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+3 - row]) || pellets[row][col].checkWallCollision(walls[col+3 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+4 - row]) || pellets[row][col].checkWallCollision(walls[col+4 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+5 - row]) || pellets[row][col].checkWallCollision(walls[col+5 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+6 - row]) || pellets[row][col].checkWallCollision(walls[col+6 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+7 - row]) || pellets[row][col].checkWallCollision(walls[col+7 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+8 - row]) || pellets[row][col].checkWallCollision(walls[col+8 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+9 - row]) || pellets[row][col].checkWallCollision(walls[col+9 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+10 - row]) || pellets[row][col].checkWallCollision(walls[col+10 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+11 - row]) || pellets[row][col].checkWallCollision(walls[col+11 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+12 - row]) || pellets[row][col].checkWallCollision(walls[col+12 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+12 - row]) || pellets[row][col].checkWallCollision(walls[col+13 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+14 - row]) || pellets[row][col].checkWallCollision(walls[col+14 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+15 - row]) || pellets[row][col].checkWallCollision(walls[col+15 - col]) ||
					pellets[row][col].checkWallCollision(walls[row+16 - row]) || pellets[row][col].checkWallCollision(walls[col+16 - col]) ||
				    pellets[row][col].checkWallCollision(walls[row+17 - row]) || pellets[row][col].checkWallCollision(walls[col+17 - col]) ){
					pellets[row][col] = null;
					numPellets--;
				}
				
			}
		}
	
		boolean playing = true;
		while (playing ) {
			
			//*** Check for collisions ***//
			
			for (int i=0; i<walls.length; i++) {
				if (blinky.checkWallCollision(walls[i])) {
					blinky.undo();
				}
				
			}
			for (int i=0; i<walls.length; i++) {
				if (inky.checkWallCollision(walls[i])) {
					inky.undo();
				}
				
			}
			for (int i=0; i<walls.length; i++) {
				if (pinky.checkWallCollision(walls[i])) {
					pinky.undo();
				}
				
			}
			for (int i=0; i<walls.length; i++) {
				if (clyde.checkWallCollision(walls[i])) {
					clyde.undo();
				}
				
			}
			
			if (numPellets == 0) {
				
				
		        playing = false;
			}
			
			if (pacman.checkGhostCollision(blinky)) {
				playing = false;
			}
			if (pacman.checkGhostCollision(inky)) {
				playing = false;
			}
			if (pacman.checkGhostCollision(pinky)) {
				playing = false;
			}
			if (pacman.checkGhostCollision(clyde)) {
				playing = false;
			}
			
			for (int i=0; i<walls.length; i++) {
				if (pacman.checkWallCollision(walls[i])) {
					pacman.undo();
				}
				
			}
			
		
			
			for (int row = 0; row< pellets.length; row++) {
				for (int col = 0; col < pellets[row].length; col++) {
					boolean testResult;
					if (pellets[row][col] != null) {
					testResult = pacman.checkPelletCollision(pellets[row][col]);
						if(testResult == true) {
							pellets[row][col]= null;
							numPellets--;
							userScore ++;
						}
					}
				}
			}
			
			
			//*** Update positions ***//
			pacman.update();
			
			blinky.updateIB();
			inky.updateIB();
			pinky.updateP();
			clyde.updateC();
			
			//*** Animate all elements ***//
			
			StdDraw.clear();
			
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledRectangle(.5, .5, .5, .5);
			
			pacman.draw();
			blinky.draw();
			inky.draw();
			pinky.draw();
			clyde.draw();
			
			for (Pellet r[] : pellets) {
				for (Pellet c : r) {					
					if (c != null) {
						c.draw();
					}	
				}				
			}
			
			for (Wall w : walls) {
				w.draw();
			}
			
			StdDraw.setPenColor(0, 0, 0);
		    
			StdDraw.text(.25, .80, "Score: " + userScore);
			
			if (userScore == 160) {
				StdDraw.setPenColor(0, 0, 0);
		        StdDraw.text(0.25, 0.5, "YOU WON!", 45.0);
			}
			if (pacman.checkGhostCollision(blinky) || pacman.checkGhostCollision(inky)
			    || pacman.checkGhostCollision(pinky) || pacman.checkGhostCollision(clyde)) {
				StdDraw.setPenColor(0, 0, 0);
		        StdDraw.text(0.25, 0.20, "GAME OVER :(", 45.0);
			}
			
			StdDraw.show(40);
		}
		
	}

}
