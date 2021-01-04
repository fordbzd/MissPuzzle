package org.misspuzzle.puzzle.archive.puzzles_2;

import org.misspuzzle.puzzle.Puzzle;

import org.misspuzzle.datastructure.Trie;

public class TrieTest implements Puzzle {

	@Override
	public void execute() {
		Trie trie = new Trie();
		
		trie.insert("abcde");
		trie.insert("abc");
		trie.insert("west");
		
		System.out.println(trie.search("abcd"));
		System.out.println(trie.search("west"));
		System.out.println(trie.startsWith("a"));
	}

}