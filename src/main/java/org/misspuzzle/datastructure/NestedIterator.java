package org.misspuzzle.datastructure;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack;
    private Integer next;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();

        stack.push(nestedList.iterator());
        next = findNext();
    }

    @Override
    public Integer next() {
        Integer result = next;
        if (result != null) {
            next = findNext();
        }

        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    private Integer findNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iterator = stack.peek();

            if (iterator.hasNext()) {
                NestedInteger nestedInteger = iterator.next();

                if (nestedInteger.isInteger()) {
                    return nestedInteger.getInteger();
                } else {
                    stack.push(nestedInteger.getList().iterator());
                }
            } else {
                stack.pop();
            }
        }

        return null;
    }
}
