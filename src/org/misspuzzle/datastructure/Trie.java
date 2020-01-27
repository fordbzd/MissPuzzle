package org.misspuzzle.datastructure;

public class Trie {

	private Trie[] letters = new Trie[26];

	private String word;

	/** Initialize your data structure here. */
	public Trie() {

	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Trie root = this;

		for (char c : word.toCharArray()) {
			int index = c - 'a';

			Trie trie = root.letters[index];
			if (trie == null) {
				root.letters[index] = trie = new Trie();
			}

			root = trie;
		}

		root.word = word;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Trie trie = this;

		for (char c : word.toCharArray()) {
			int index = c - 'a';

			trie = trie.letters[index];

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
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		Trie trie = this;

		for (char c : prefix.toCharArray()) {
			int index = c - 'a';

			trie = trie.letters[index];

			if (trie == null) {
				return false;
			}
		}

		return true;
	}

}
