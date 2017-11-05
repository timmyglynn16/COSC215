package assignment2;

public class GameBoard {
	
	private int numLost;
	Player[][] gameboard;
	private Player[] player = new Player[4];
	
	public GameBoard() {
		gameboard = new Player[5][5];
		numLost = 0;
		
		player[0] = new Player("1", 0, 0, 5);
		player[1] = new Player("2", 4, 0, 5);
		player[2] = new Player("3", 0, 4, 5);
		player[3] = new Player("4", 4, 4, 5); 
		
		gameboard[0][0] = player[0];
		gameboard[4][0] = player[1];
		gameboard[0][4] = player[2];
		gameboard[4][4] = player[3];
	}
		
		public String toString() {
			
			String axis = "   1 2 3 4 5\n";
			for(int x=0; x<5; x++) {
				axis += String.format("%2d ",x+1);
				for(int y=0; y<5; y++)
					// print game board symbols
					if(gameboard[x][y] == null) {
						axis += ". ";
					}
					else {
						axis += gameboard[x][y].name + " ";
					}
					axis += "\n";
			}
			return axis;
		}
		
		public boolean gameOver() {
			return numLost == 3;
		}
		

		
		public void turns() {
			Position pos;
			Position newPos;
			
			while(!gameOver()) {
				if(player[0].lives > 0) {
					System.out.println(toString());
					pos = new Position(player[0].x, player[0].y);
					newPos = Position.getPosition("Player 1 - Enter coordinates to move to:");
					while(pos.distance(newPos) > 1)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[0].moveTo(gameboard, newPos);
					player[0] = gameboard[newPos.x][newPos.y];
					pos = newPos;
					
					newPos = Position.getPosition("Player 1 - Enter coordinates to shoot at:");
					while(pos.distance(newPos) > 2)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[0].shootAt(gameboard, newPos);
				}
				
				if(player[1].lives > 0) {
					System.out.println(toString());
					pos = new Position(player[1].x, player[1].y);
					newPos = Position.getPosition("Player 2 - Enter coordinates to move to:");
					while(pos.distance(newPos) > 1)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[1].moveTo(gameboard, newPos);
					player[1] = gameboard[newPos.x][newPos.y];
					pos = newPos;
					
					newPos = Position.getPosition("Player 2 - Enter coordinates to shoot at:");
					while(pos.distance(newPos) > 2)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[1].shootAt(gameboard, newPos);
				}
				
				if(player[2].lives > 0) {
					System.out.println(toString());
					pos = new Position(player[2].x, player[2].y);
					newPos = Position.getPosition("Player 3 - Enter coordinates to move to:");
					while(pos.distance(newPos) > 1)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[2].moveTo(gameboard, newPos);
					player[2] = gameboard[newPos.x][newPos.y];
					pos = newPos;
					
					newPos = Position.getPosition("Player 3 - Enter coordinates to shoot at:");
					while(pos.distance(newPos) > 2)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[2].shootAt(gameboard, newPos);
				}
				
				if(player[3].lives > 0) {
					System.out.println(toString());
					pos = new Position(player[3].x, player[3].y);
					newPos = Position.getPosition("Player 4 - Enter coordinates to move to:");
					while(pos.distance(newPos) > 1)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[3].moveTo(gameboard, newPos);
					player[3] = gameboard[newPos.x][newPos.y];
					pos = newPos;
					
					newPos = Position.getPosition("Player 4 - Enter coordinates to shoot at:");
					while(pos.distance(newPos) > 2)
						newPos = Position.getPosition("Invalid input, try again");
					
					player[3].shootAt(gameboard, newPos);
				}
			}			
		}
	}
