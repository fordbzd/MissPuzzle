package puzzles_2;

import datastructure.LRUCache;
import interfaces.Puzzle;

public class LRUCacheTest implements Puzzle {

	@Override
	public void execute() {
//		LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//		cache.put(1, 1);
//		cache.put(2, 2);
//		cache.get(1);       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		cache.get(2);       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		cache.get(1);       // returns -1 (not found)
//		cache.get(3);       // returns 3
//		cache.get(4);       // returns 4
		
		LRUCache cache = new LRUCache( 10 );

		cache.put(7, 28);
		cache.put(7, 1);
		cache.put(8, 15);
		cache.get(6);
		cache.put(10, 27);
		cache.put(8, 10);
		cache.get(8);
		cache.put(6, 29);
		cache.put(1, 9);
		cache.get(6);
		cache.put(10, 7);
		cache.get(1);
		cache.get(2);
		cache.get(13);
		cache.put(8, 30);
		cache.put(1, 5);
		cache.get(1);
		cache.put(13, 2);
		cache.get(12);
	}

}
