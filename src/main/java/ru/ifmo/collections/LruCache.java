package ru.ifmo.collections;

import java.util.HashMap;
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
public class LruCache<K, V> {
    private final Node end = new Node();
    private Node root = end;
    private Map<K, Node> cache = new HashMap<K, Node>();
    private int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) return null;
        moveInStart(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveInStart(node);
            return;
        }
        removeOldestIfNeed();
        Node node = addLinkedList(key, value);
        cache.put(key, node);
    }

    private Node addLinkedList(K key, V value) {
        Node node = new Node(key, value);
        node.next = root;
        node.last = root.last;
        root.last = node.next;
        root = node;
        return node;
    }

    public int elements() {
        return cache.size(); // TODO implement
    }

    private void moveInStart(Node node) {
        if (node == root) return;
        node.last.next = node.next;
        node.next.last = node.last;
        node.last = end;
        node.next = root;
        root.last = node;
        root = node;
    }

    private void removeOldestIfNeed() {
        if (elements() == capacity) {
            Node node = end.last;
            node.last = node.next;
            node.next = node.last;
            if (node.key != null) cache.remove(node.key);
        }
    }

    private class Node {

        private K key;
        private V value;

        private Node last;
        private Node next;

        public Node() {
            last = this;
            next = this;
        }

        private Node(K key, V value) {
            this();
            this.key = key;
            this.value = value;
        }
    }
}