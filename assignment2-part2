package assignment2;

public class Player {
	
	public String name;
	public int lives;
	public int numHits;
	public int x;
	public int y;
	
	public Player(String name, int x, int y, int lives) {
		this.name = name; 
		this.x = x;
		this.y = y;
		this.lives = lives;
		numHits = 0;
	}
	
	public void shootAt(Player[][]gameboard, Position pos) {
		if(gameboard[pos.x][pos.y] != null) {
			System.out.println("Player " + name + " hit " + "Player " + gameboard[pos.x][pos.y].name);
			gameboard[pos.x][pos.y].lives--;
			if(gameboard[pos.x][pos.y].lives == 0)
				gameboard[pos.x][pos.y] = null;
			}
			else
				System.out.println("You missed!");
		}
	
	
	
	public void moveTo(Player[][]gameboard, Position pos) {
		Position p = new Position(x,y);
		if(gameboard[pos.x][pos.y] == null) {
			gameboard[pos.x][pos.y] = new Player(name, pos.x, pos.y, lives);
			gameboard[x][y] = null;
		}
		else {
			p = Position.getPosition("Space is occupied. Try again.");
			while(p.distance(pos) > 1)
				pos = Position.getPosition("Too far. Try again.");
			moveTo(gameboard,pos);
		}
	}

	
	public boolean isShot() {
		return numHits == lives;
	}
	
}
