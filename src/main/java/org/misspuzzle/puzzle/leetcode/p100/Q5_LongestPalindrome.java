package org.misspuzzle.puzzle.leetcode.p100;

public class Q5_LongestPalindrome {

	public String longestPalindrome(String s) {

		String lp = "";

		for (int i = s.length() / 2; i < s.length(); i++) {
			
			if ((s.length() - i) * 2 < lp.length() ) {
				break;
			}

			int j = 0;

			while (i - j - 1 >= 0 && i + j + 1 < s.length()) {
				if (s.charAt(i - j - 1) != s.charAt(i + j + 1)) {
					break;
				}

				j++;
			}

			if (j > 0 && (j * 2 + 1 > lp.length())) {
				lp = s.substring(i - j, i + j + 1);
			}

			j = 0;

			while (i - j - 1 >= 0 && i + j < s.length()) {
				if (s.charAt(i - j - 1) != s.charAt(i + j)) {
					break;
				}

				j++;
			}

			if (j > 0 && (j * 2) > lp.length()) {
				lp = s.substring(i - j, i + j);
			}
		}

		for (int i = s.length() / 2 - 1; i >= 0; i--) {
			
			if ((i * 2 + 1) < lp.length() ) {
				break;
			}

			int j = 0;

			while (i - j - 1 >= 0 && i + j + 1 < s.length()) {
				if (s.charAt(i - j - 1) != s.charAt(i + j + 1)) {
					break;
				}

				j++;
			}

			if (j > 0 && (j * 2 + 1 > lp.length())) {
				lp = s.substring(i - j, i + j + 1);
			}

			j = 0;

			while (i - j - 1 >= 0 && i + j < s.length()) {
				if (s.charAt(i - j - 1) != s.charAt(i + j)) {
					break;
				}

				j++;
			}

			if (j > 0 && (j * 2) > lp.length()) {
				lp = s.substring(i - j, i + j);
			}
		}

		return lp.length() > 0 ? lp : (s.length() > 0 ? s.substring(0, 1) : "");

	}

}
