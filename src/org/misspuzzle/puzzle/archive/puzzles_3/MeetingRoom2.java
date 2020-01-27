package org.misspuzzle.puzzle.archive.puzzles_3;

import org.misspuzzle.puzzle.Puzzle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.misspuzzle.datastructure.Interval;

public class MeetingRoom2 implements Puzzle {

	@Override
	public void execute() {
		Interval[] intervals = {
				new Interval(0, 30),
				new Interval(5, 10),
				new Interval(15, 20)
		};
		
		System.out.println(minMeetingRooms(intervals));

	}
	
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
