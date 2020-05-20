package ru.ifmo.collections;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 * <p>
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 * <p>
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {

    // private final Map<???, ???> contents; TODO decide Map implementation and key/value types. "???" is used just as an example
    private final transient TreeMap<T, Object> map;
    private static final Object PRESENT = new Object();

    private SortedSet() {
        map = new TreeMap<T, Object>();
    }

    private SortedSet(Comparator<T> comparator) {
        map = new TreeMap<T, Object>(comparator);
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<T>();
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    public List<T> getSorted() {
        return new ArrayList<>(map.keySet());
    }

    public List<T> getReversed() {
        ArrayList<T> list = new ArrayList<>(map.keySet());
        Collections.reverse(list);
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(T t) {
        return map.put(t, PRESENT) != null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }
}
