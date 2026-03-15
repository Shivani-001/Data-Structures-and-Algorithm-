package org.example.LinkedList;

import java.util.*;

//public class LRUCache {

    // ===== LRU CACHE IMPLEMENTATION =====
    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int cap;

        LRUCache(int cap) {
            super(cap, 0.75f, true); // access-order = true
            this.cap = cap;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > cap;
        }


    // ===== MAIN METHOD =====
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println("Get 1: " + cache.get(1)); // returns 10

        cache.put(3, 30); // evicts key 2

        System.out.println("Get 2: " + cache.get(2)); // returns -1

        cache.put(4, 40); // evicts key 1

        System.out.println("Get 1: " + cache.get(1)); // returns -1
        System.out.println("Get 3: " + cache.get(3)); // returns 30
        System.out.println("Get 4: " + cache.get(4)); // returns 40
    }
}