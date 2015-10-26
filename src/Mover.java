import java.util.HashMap;

public class Mover {
	private Point pusher;
	private HashMap<Character,Point> blocks;
	public enum direction{up,down,left,right};
	
	public Mover(){		
		blocks = new HashMap<Character,Point>();
	}

	public void setPusherPos(Point p){
		pusher = p;
	}
	
	public void addBlock(Character c, Point p){
		blocks.put(c, p);
	}
	
	public Mover doMove(direction d){
		
		Mover m = new Mover();
		m.pusher = new Point(this.pusher);
		m.blocks.putAll(this.blocks);
		
		switch (d){
		case up:
			m.pusher = new Point(m.pusher.x, m.pusher.y -1);
			for(Character c : m.blocks.keySet()){
				if(m.blocks.get(c).equals(m.pusher)){
					m.blocks.put(c, new Point(m.pusher.x, m.pusher.y -1));
				}
			}
			break;
		case down:
			m.pusher = new Point(m.pusher.x, m.pusher.y +1);
			for(Character c : m.blocks.keySet()){
				if(m.blocks.get(c).equals(m.pusher)){
					m.blocks.put(c, new Point(m.pusher.x, m.pusher.y +1));
				}
			}
			break;
		case left:
			m.pusher = new Point(m.pusher.x -1, m.pusher.y);
			for(Character c : m.blocks.keySet()){
				if(m.blocks.get(c).equals(m.pusher)){
					m.blocks.put(c, new Point(m.pusher.x -1, m.pusher.y ));
				}
			}
			break;
		case right:
			m.pusher = new Point(m.pusher.x +1, m.pusher.y);
			for(Character c : m.blocks.keySet()){
				if(m.blocks.get(c).equals(m.pusher)){
					m.blocks.put(c, new Point(m.pusher.x +1, m.pusher.y));
				}
			}
			break;
		}
		
		return m;
	}
	public boolean isLegal(Board b){
		if(b.isWall(pusher)){
			return false;
		}
		for(Point p : blocks.values()){
			if(b.isWall(p)){
				return false;
			}
		}
		
		return true;
	}

	public boolean isFinished(Board b) {
		for(Character c : this.blocks.keySet()){
			if(!this.blocks.get(c).equals(b.getTarget(Character.toLowerCase(c)))){
				return false;
			}
		}
		return true;
	}
}
