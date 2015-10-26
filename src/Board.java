import java.util.HashMap;


public class Board {
	private boolean[][] walls;
	private HashMap<Character,Point> targets;
	
	
	public Board(int x, int y){
		walls = new boolean[x][y];
		targets = new HashMap<Character,Point>();
	}
	
	public void setWall(Point p){
		walls[p.x][p.y] = true;	
	}
	
	public void addTarget(Character c, Point p){
		targets.put(c, p);
	}
	public Boolean isWall(Point p){
		return walls[p.x][p.y];
		
	}
	public Point getTarget(Character c){
		return targets.get(c);
	}
}
