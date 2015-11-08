import java.util.HashSet;
import java.util.LinkedList;


public class Solver {
	static void Solve(ProblemState ps){
		HashSet<Mover> moveSet = new HashSet<Mover>();
		LinkedList<Mover.direction> moveList = new LinkedList<Mover.direction>();
		
		moveSet.add(ps.mover);
		
		while(ps.mover.isLegal(ps.board)&&!ps.mover.isFinished(ps.board)){
			ps.mover = ps.mover.doMove(Mover.direction.down);
			moveSet.add(ps.mover);
		}
		if(ps.mover.isFinished(ps.board)){
			System.out.println("Complete!");
		}
		else{
			System.out.println("Crashed!");
		}
	}
}
