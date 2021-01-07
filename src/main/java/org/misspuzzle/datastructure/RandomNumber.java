package org.misspuzzle.datastructure;

public class RandomNumber {

	private long seed = System.nanoTime();
	private static long multiplier = 46548121L;
	private static long addEnd = 48746341974223L;
	
	public int generate(int from, int to) {
		
		seed = (seed * multiplier + addEnd);
		int r = (int) seed;
		
		return (r > 0 ? r : r * -1) % (from - to) + from;
		
	}
}
