
public class Main {

	public static void main(String[] args) {
		ProblemState ps = Parser.parseFile(args[0]);
		Solver.Solve(ps);
	}

}
