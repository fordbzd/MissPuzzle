package puzzles_1;

import interfaces.Puzzle;

public class Gibberized implements Puzzle {

	@Override
	public void execute() {
		String s = "aoiUe";
		System.out.println(s);
		System.out.println(gibber(s));
	}
	
	public String gibber(String s) {
		char[] eligible = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'};
		
		String[] gibberized = {"A^", "a^", "E^", "e^", "I^", "i^", "O^", "o^", "U^", "u^"};
		
		int firstCount = 0, pos = -1;
		for (int i = 0; i < s.length() && firstCount < 3; i++) {
			char c = s.charAt(i);
			if (isEligible(c, eligible) != -1) {
				firstCount++;
				pos = i;
			}
		}
		
		int lastCount = 0;
		for (int i = s.length() - 1; i > pos && lastCount < 4; i--) {
			char c = s.charAt(i);
			int idx = isEligible(c, eligible);
			if (idx != -1) {
				lastCount++;
				s = s.substring(0, i) + gibberized[idx] + s.substring(i + 1);
			}
		}
		
		return s;
	}
	
	private int isEligible(char c, char[] eligible) {
		for(int i = 0; i < eligible.length; i++) {
			if (c == eligible[i])
				return i;
		}
		
		return -1;
	}

}
