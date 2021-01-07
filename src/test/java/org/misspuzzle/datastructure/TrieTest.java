package org.misspuzzle.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {

	@Test
	public void testcase() {
		final Trie trie = new Trie();

		trie.insert("abcde");
		trie.insert("abc");
		trie.insert("west");

		assertFalse(trie.search("abcd"));
		assertTrue(trie.search("west"));
		assertTrue(trie.startsWith("a"));
	}
}
