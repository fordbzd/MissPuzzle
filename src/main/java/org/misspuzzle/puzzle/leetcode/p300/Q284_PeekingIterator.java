package org.misspuzzle.puzzle.leetcode.p300;

import java.util.Iterator;

public class Q284_PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peekCache;

    public Q284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.peekCache = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekCache == null) {
            peekCache = iterator.next();
        }

        return peekCache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer next = peekCache == null ? iterator.next() : peekCache;

        peekCache = null;

        return next;
    }

    @Override
    public boolean hasNext() {
        return peekCache != null || iterator.hasNext();
    }
}
