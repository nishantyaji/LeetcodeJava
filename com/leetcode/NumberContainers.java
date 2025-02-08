package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// Problem 2349
class NumberContainers {

    private Map<Integer, TreeSet<Integer>> numberToIndices;
    private Map<Integer, Integer> indexToNumber;

    public NumberContainers() {
        numberToIndices = new HashMap<>();
        indexToNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int prev = indexToNumber.get(index);
            numberToIndices.get(prev).remove(index);
        }
        indexToNumber.put(index, number);
        numberToIndices.computeIfAbsent(number, k -> new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        TreeSet<Integer> temp = numberToIndices.get(number);
        return temp != null && !temp.isEmpty() ? temp.first() : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */