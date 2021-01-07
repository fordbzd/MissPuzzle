package org.misspuzzle.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

	@Test
	public void testcase() {
		final LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(1, cache.get(1));

		cache.put(3, 3);    // evicts key 2
		assertEquals(-1, cache.get(2));

		cache.put(4, 4);    // evicts key 1
		assertEquals(-1, cache.get(1));
		assertEquals(3, cache.get(3));
		assertEquals(4,cache.get(4));
	}
}
