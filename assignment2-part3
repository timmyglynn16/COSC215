package assignment2;
import java.util.Scanner;

public  class Position {
	public int x,y;
	private static Scanner sc = new Scanner(System.in);

	public Position(int x, int y) { 
		this.x = x; this.y = y; 
	}

	public static Position getPosition(String msg) {
		int x, y;
		while(true) {
		    System.out.print(msg + " > ");
		    x = sc.nextInt();
		    y = sc.nextInt();
		    if (x < 1 || x > 5 || y < 1 || y > 5)
			System.out.println("Illegal position. Try again.");
		    else
			break;
		}
		return new Position(x-1,y-1);
	    }

	    public int distance(Position pos) {
	    	return Math.abs(x-pos.x) + Math.abs(y-pos.y);
	    }
	    
}
