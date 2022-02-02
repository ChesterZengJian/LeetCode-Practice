import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import models.LRUCache;

public class Main {

    public static void main(String[] args) {
        // LFUCache cache = new LFUCache(2);

        // cache.put(1, 1);
        // cache.put(2, 2);
        // System.out.println(cache.get(1));

        // cache.put(3, 3);
        // System.out.println(cache.get(2));
        // System.out.println(cache.get(3));

        // cache.put(4, 4);
        // System.out.println(cache.get(1));
        // System.out.println(cache.get(3));
        // System.out.println(cache.get(4));

        LFUCache cache = new LFUCache(0);
        cache.put(0, 0);
        System.out.println(cache.get(0));
    }
}
