import java.util.HashMap;
import java.util.LinkedHashSet;

/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start
class LFUCache {
    private int capacity;
    private int minFre;
    private HashMap<Integer, Integer> keyToVal;
    private HashMap<Integer, Integer> keyToFre;
    private HashMap<Integer, LinkedHashSet<Integer>> freToKey;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToVal = new HashMap<>();
        keyToFre = new HashMap<>();
        freToKey = new HashMap<>();
    }

    public int get(int key) {
        if (keyToVal.containsKey(key)) {
            increaseFre(key);
            return keyToVal.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keyToVal.containsKey(key)) {
            increaseFre(key);
            keyToVal.put(key, value);
            return;
        }

        if (capacity <= keyToVal.size()) {
            removeMinFreKey();
        }

        keyToVal.put(key, value);
        keyToFre.put(key, 1);
        freToKey.putIfAbsent(1, new LinkedHashSet<>());
        freToKey.get(1).add(key);
        this.minFre = 1;
    }

    private void removeMinFreKey() {
        LinkedHashSet<Integer> keys = freToKey.get(minFre);
        int key = keys.iterator().next();

        // remove k-v
        keyToVal.remove(key);

        // remove k-fre
        keyToFre.remove(key);

        // remove fre-k
        keys.remove(key);

        if (keys.isEmpty()) {
            freToKey.remove(minFre);
        }
    }

    private void increaseFre(int key) {
        int curFre = keyToFre.get(key);
        int newFre = curFre + 1;

        keyToFre.put(key, newFre);

        freToKey.putIfAbsent(newFre, new LinkedHashSet<>());
        freToKey.get(newFre).add(key);

        LinkedHashSet<Integer> keys = freToKey.get(curFre);
        keys.remove(key);

        if (keys.isEmpty()) {
            freToKey.remove(curFre);

            if (curFre == minFre) {
                this.minFre++;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
