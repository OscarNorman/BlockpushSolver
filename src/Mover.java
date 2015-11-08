import java.util.HashMap;

public class Mover {
	private int hashCode;
	private Point pusher;
	private HashMap<Character,Point> blocks;
	public enum direction{up,down,left,right};
	
	public Mover(){		
		blocks = new HashMap<Character,Point>();
	}

	public void setPusherPos(Point p){
		pusher = p;
		calculateHashCode();
	}
	
	public void addBlock(Character c, Point p){
		blocks.put(c, p);
		calculateHashCode();
	}
	@Override
	public boolean equals(Object obj){
		Mover m = (Mover)obj;
		if(!this.pusher.equals(m.pusher)){
			return false;
		}
		for(Character c : m.blocks.keySet()){
			if(!this.blocks.get(c).equals(m.blocks.get(c))){
				return false;
			}
		}
		return true;
	}
	@Override
	public int hashCode() {

		return hashCode;
    }
	private void calculateHashCode(){
		hashCode = 0;
		hashCode += pusher.hashCode();
		for(Character c : blocks.keySet()){
			hashCode*=4;
			hashCode += blocks.get(c).hashCode();
		}
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
		calculateHashCode();
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
