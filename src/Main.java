import puzzlelist.*;
import interfaces.*;

public class Main {

	public static void main(String[] args) {
		
		PuzzleList puzzleList = new Puzzles_1();
//		PuzzleList puzzleList = new Amazon();
		

		for (String puzzle : puzzleList.getPuzzleList()) {
			System.out.println("Question - " + puzzle);

			try {
				Class<?> c = Class.forName(puzzleList.getPackageName() + puzzle);

				Puzzle p = (Puzzle) c.newInstance();
				p.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println();
		}
	}

}
