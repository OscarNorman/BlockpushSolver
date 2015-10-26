
public class Main {

	public static void main(String[] args) {
		ProblemState ps = Parser.parseFile(args[0]);
		while(ps.mover.isLegal(ps.board)&&!ps.mover.isFinished(ps.board)){
			ps.mover = ps.mover.doMove(Mover.direction.down);
		}
		if(ps.mover.isFinished(ps.board)){
			System.out.println("Complete!");
		}
		else{
			System.out.println("Crashed!");
		}
	}

}
