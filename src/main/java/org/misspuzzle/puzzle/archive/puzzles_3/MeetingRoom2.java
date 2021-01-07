package org.misspuzzle.puzzle.archive.puzzles_3;

import org.misspuzzle.datastructure.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
	
	public int minMeetingRooms(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		PriorityQueue<Interval> minHeap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end;
			}
		});
		
		minHeap.offer(intervals[0]);
		
		for (int i = 1; i < intervals.length; i++) {
			Interval interval = minHeap.poll();
			
			if (interval.end <= intervals[i].start) {
				interval.end = intervals[i].end;
			} else {
				minHeap.offer(intervals[i]);
			}
			
			minHeap.offer(interval);
		}
		
		return minHeap.size();
	}

}
