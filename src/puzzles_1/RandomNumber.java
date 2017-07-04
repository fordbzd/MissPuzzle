package puzzles_1;

import interfaces.Puzzle;

public class RandomNumber implements Puzzle{

	private long seed = System.nanoTime();
	private static long multiplier = 46548121L;
	private static long addEnd = 48746341974223L;
	
	@Override
	public void execute() {
		
		for (int i = 0; i < 200; ++i)
			System.out.println(generate(0, 100));
	}
	
	private int generate(int from, int to) {
		
		seed = (seed * multiplier + addEnd);
		int r = (int) seed;
		
		return (r > 0 ? r : r * -1) % (from - to) + from;
		
	}
}
