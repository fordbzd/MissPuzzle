package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CanCross implements Puzzle {

	@Override
	public void execute() {
		System.out.println(canCross(new int[]{0,1,2,3,4,8,9,11}));

	}
	
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
     
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        
        for (int i = 1; i < stones.length; i++) {
        	map.put(stones[i], new HashSet<Integer>());
        }
        
        for (int i = 0; i < stones.length - 1; i++) {
        	Set<Integer> set = map.get(stones[i]);
        	
        	for (int step : set) {
        		if (stones[i] + step == stones[stones.length - 1]) {
        			return true;
        		}
        		
        		Set<Integer> next = map.get(stones[i] + step);
        		
        		if (next != null) {
        			next.add(step);
        			
        			if (step - 1 > 0) {
        				next.add(step - 1);
        			}

        			next.add(step + 1);
        		}
        	}
        }
        
        return false;
        
    }
}