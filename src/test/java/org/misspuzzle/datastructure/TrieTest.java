package org.misspuzzle.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
