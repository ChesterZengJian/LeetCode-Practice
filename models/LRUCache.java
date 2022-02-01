package models;

import java.util.LinkedHashMap;

public class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // key exist, remove and put
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }

        // key not exist
        // capacity = cache.size()
        if (capacity == cache.size()) {
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }

        cache.put(key, value);
    }
}
