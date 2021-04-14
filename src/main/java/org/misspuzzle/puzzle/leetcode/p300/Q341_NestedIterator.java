package org.misspuzzle.puzzle.leetcode.p300;

import org.misspuzzle.datastructure.NestedInteger;
import org.misspuzzle.datastructure.NestedIterator;

import java.util.List;

public class Q341_NestedIterator {
    public NestedIterator nestedIterator;

    Q341_NestedIterator(List<NestedInteger> list) {
        nestedIterator = new NestedIterator(list);
    }
}
