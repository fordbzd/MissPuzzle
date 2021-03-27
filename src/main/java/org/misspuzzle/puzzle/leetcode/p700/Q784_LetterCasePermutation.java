package org.misspuzzle.puzzle.leetcode.p700;

import java.util.ArrayList;
import java.util.List;

public class Q784_LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();

        dfs(S.toLowerCase().toCharArray(), 0, new StringBuilder(), result);

        return result;
    }

    private void dfs(char[] chars, int index, StringBuilder sb, List<String> result) {
        if (index == chars.length) {
            result.add(sb.toString());
            return;
        }

        sb.append(chars[index]);

        dfs(chars, index + 1, sb, result);

        sb.deleteCharAt(index);

        if ('a' <= chars[index] && chars[index] <= 'z') {
            sb.append((char)(chars[index] - 32));

            dfs(chars, index + 1, sb, result);

            sb.deleteCharAt(index);
        }
    }
}
