package ru.ifmo.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 * <p>
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 * <p>
 * This class should not have any other public methods.
 * <p>
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> extends LinkedHashMap {
    private int capacity;

    public LruCache(int capacity) {
        super(capacity, 1f, true);
        this.capacity = capacity;
    }

    public int elements() {
        return this.size();
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return elements() > capacity;
    }
}