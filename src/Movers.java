import java.util.Hashtable;

public class Movers {
	private Point pusher;
	private Hashtable<Character,Point> blocks;
	
	
	public Movers(){		
		blocks = new Hashtable<Character,Point>();
	}

	public void setPusherPos(Point p){
		pusher = p;
	}
	
	public void addBlock(Character c, Point p){
		blocks.put(c, p);
	}
}
