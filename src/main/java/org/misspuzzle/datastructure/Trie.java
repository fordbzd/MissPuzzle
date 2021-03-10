package org.misspuzzle.datastructure;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private Map<Character, Trie> letters = new HashMap<>();

	private String word;

	/**
	 * Initialize your data structure here.
	 */
	public Trie() {

	}

	public Map<Character, Trie> getLetters() {
		return letters;
	}

	public String getWord() {
		return word;
	}

	/**
	 * Inserts a word into the trie.
	 */
	public void insert(String word) {
		Trie root = this;

		for (char c : word.toCharArray()) {
			Trie trie = root.letters.get(c);

			if (trie == null) {
				trie = new Trie();
				root.letters.put(c, trie);
			}

			root = trie;
		}

		root.word = word;
	}

	/**
	 * Returns if the word is in the trie.
	 */
	public boolean search(String word) {
		Trie trie = this;

		for (char c : word.toCharArray()) {
			trie = trie.letters.get(c);

			if (trie == null) {
				return false;
			}
		}

		if (trie.word != null && trie.word.equalsIgnoreCase(word)) {
			return true;
		}

		return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie trie = this;

		for (char c : prefix.toCharArray()) {
			trie = trie.letters.get(c);

			if (trie == null) {
				return false;
			}
		}

		return true;
	}
}
