package org.misspuzzle.puzzle.amazon;

import java.util.Stack;

public class BaseballScore {
	
	public int baseBallScore(String[] input) {
		int sum = 0;
		int score = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (String s : input) {
			if (s.equalsIgnoreCase("x") && stack.size() > 0) {
				score = stack.peek() * 2;
				
				stack.push(score);
				
				sum += score;
			} else if (s.equalsIgnoreCase("z") && stack.size() > 0) {
				score = stack.pop();
				
				sum -= score;
			} else if (s.equalsIgnoreCase("+") && stack.size() > 0) {
				boolean isEnough = stack.size() > 1;
				
				int s1 = isEnough ? stack.pop() : 0;
				int s2 = stack.peek() + s1;
				
				if (isEnough) {
					stack.push(s1);
				}

				stack.push(s2);
				
				sum += s2;
			} else {
				try {
					score = Integer.parseInt(s);
				} catch (Exception e) {
					score = 0;
				}
				
				stack.push(score);
				
				sum += score;
			}
		}
		
		return sum;
	}

}
