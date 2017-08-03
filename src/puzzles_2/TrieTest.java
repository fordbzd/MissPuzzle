package puzzles_2;

import datastructure.Trie;
import interfaces.Puzzle;

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
