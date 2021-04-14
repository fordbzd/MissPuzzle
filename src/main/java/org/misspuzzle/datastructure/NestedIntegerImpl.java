package org.misspuzzle.datastructure;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

    private final Integer integer;
    private final List<NestedInteger> list;

    public NestedIntegerImpl(Integer integer) {
        this.integer = integer;
        this.list = new ArrayList<>();
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.list = list;
        this.integer = null;
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
