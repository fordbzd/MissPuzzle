package org.misspuzzle.puzzle.leetcode.p100;

import org.misspuzzle.datastructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q56_Merge {
	
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval i1, Interval i2) {
        		return i1.start - i2.start;
        	}
        });
        
        List<Interval> result = new ArrayList<Interval>();
        
        Interval current = null;
        for (Interval i : intervals) {
        	if (current == null) {
        		current = i;
        	}
        	
        	if (current.end >= i.start) {
        		current.end = Math.max(current.end, i.end);
        	} else {
        		result.add(current);
        		current = i;
        	}
        }
        
        if (current != null) {
        	result.add(current);
        }
    	
    	return result;
    	
    }
}
