package ru.ifmo.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private TreeSet<Integer> uniq = new TreeSet<>();
    private Set<Integer> multyInt = new HashSet<>();

    public FirstUnique(int[] numbers) {
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        if (uniq.size() != 0) {
            return uniq.first();
        }
        return -1;
    }

    public void add(int value) {
        if (uniq.contains(value)) {
            uniq.remove(value);
            multyInt.add(value);
        } else if (!multyInt.contains(value)) {
            uniq.add(value);
        }
    }
}
