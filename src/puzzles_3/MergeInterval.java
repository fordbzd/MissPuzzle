package puzzles_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import datastructure.Interval;
import interfaces.Puzzle;

public class MergeInterval implements Puzzle {

	@Override
	public void execute() {
		List<Interval> list = new ArrayList<Interval>();
		
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(15, 30));
		
		System.out.println(merge(list));

	}
	
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
