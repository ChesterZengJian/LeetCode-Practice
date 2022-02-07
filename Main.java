import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import models.LRUCache;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> result = combine(4, 2);

        for (List<Integer> list : result) {
            for (Integer list2 : list) {
                System.out.print(list2);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        if (k <= 0 || n <= 0)
            return result;

        backTrack(1, n, k, track, result);
        return result;
    }

    private static void backTrack(int startIdx, int n, int k, LinkedList<Integer> track,
            List<List<Integer>> result) {
        if (k == track.size()) {
            result.add(new ArrayList<>(track));
        }

        for (int i = startIdx; i <= n; i++) {
            track.push(i);
            backTrack(i + 1, n, k, track, result);
            track.pollFirst();
        }
    }
}
