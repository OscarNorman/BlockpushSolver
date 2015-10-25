import java.util.Hashtable;

public class Board {
	private boolean[][] walls;
	private Hashtable<Character,Point> targets;
	
	
	public Board(int x, int y){
		walls = new boolean[x][y];
		targets = new Hashtable<Character,Point>();
	}
	
	public void setWall(Point p){
		walls[p.x][p.y] = true;	
	}
	
	public void addTarget(Character c, Point p){
		targets.put(c, p);
	}
}
