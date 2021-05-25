package org.misspuzzle.puzzle.leetcode.p800;

import java.util.ArrayList;
import java.util.List;

public class Q816_AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 2; i < s.length() - 1; i++) {
            String left = s.substring(1, i);
            String right = s.substring(i, s.length() - 1);

            List<String> leftList = getNum(left);
            List<String> rightList = getNum(right);

            for (String leftNum : leftList) {
                for (String rightNum : rightList) {
                    result.add("(" + leftNum + ", " + rightNum + ")");
                }
            }

        }

        return result;
    }

    private List<String> getNum(String s) {
        List<String> nums = new ArrayList<>();

        if (s.length() > 1 && s.charAt(0) == '0') {
            if (s.charAt(s.length() - 1) != '0') {
                nums.add("0." + s.substring(1));
            }
            return nums;
        }

        nums.add(s);

        if (s.length() == 1 || s.charAt(s.length() - 1) == '0') {
            return nums;
        }

        for (int i = 1; i < s.length(); ++i) {
            nums.add(s.substring(0, i) + '.' + s.substring(i));
        }

        return nums;
    }
}
