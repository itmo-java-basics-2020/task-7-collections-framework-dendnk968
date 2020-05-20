package ru.ifmo.collections;

import java.util.*;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private int k;
    private Queue<Integer> s;
    public KthLargest(int k, int[] numbers) {
        s = new PriorityQueue<>();
        this.k = k;
        for (int number : numbers) {
            add(number);
        }
    }

    public int add(int val) {
        s.offer(val);
        if (s.size() > k){
            s.poll();
        }
        if(s.size() == k && s.size() != 0) {
            return s.peek();
        }
        return -1;
    }
}