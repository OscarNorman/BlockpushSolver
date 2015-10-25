import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Parser {
	
	
	public static ProblemState parseFile(String filename){
		//Open file
		List<String> fc;
		try {
			 fc = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		//Find dimensions of board
		int xSize = fc.get(0).length();
		int ySize = fc.size();
		
		//Create board + mover objects
		Board b = new Board(xSize, ySize);
		Movers m = new Movers();
		
		//Parse File
		for(int y = 0; y<ySize;y++){
			String row = fc.get(y);
			for(int x = 0;x<xSize;x++){
				Character c = row.charAt(x);
				if(c == '#'){
					b.setWall(new Point(x,y));
				}
				else if(c == '@'){
					m.setPusherPos(new Point(x,y));
				}
				else if(Character.isUpperCase(c)){
					m.addBlock(c, new Point(x,y));
				}
				else if(Character.isLowerCase(c)){
					b.addTarget(c, new Point(x,y));
				}
			
			}
		}
	
		ProblemState ps = new ProblemState();
		ps.board = b;
		ps.movers = m;
		return ps;
	}
}
