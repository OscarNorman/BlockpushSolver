
public class Point implements Cloneable{
	public int x = 0;
	public int y = 0;
	
	public Point(int x , int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	public boolean equals(Point p){
		return this.x == p.x && this.y == p.y;
	}
	public String toString(){
		return "Point("+x+","+y+")"; 
	}
}
