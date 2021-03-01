package org.misspuzzle.datastructure;

import java.util.*;

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 *
 * Ref: https://leetcode.com/problems/maximum-frequency-stack/
 */
public class FreqStack {

    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    HashMap<Integer, Stack<Integer>> stackMap = new HashMap<>();

    int maxFrequency = 0;

    public void push(int x) {
        int frequency = frequencyMap.getOrDefault(x, 0) + 1;
        frequencyMap.put(x, frequency);

        maxFrequency = Math.max(maxFrequency, frequency);

        if (!stackMap.containsKey(frequency)) {
            stackMap.put(frequency, new Stack<>());
        }

        stackMap.get(frequency).add(x);
    }

    public int pop() {
        int x = stackMap.get(maxFrequency).pop();

        frequencyMap.put(x, maxFrequency - 1);

        if (stackMap.get(maxFrequency).size() == 0) {
            maxFrequency--;
        }

        return x;
    }
}
