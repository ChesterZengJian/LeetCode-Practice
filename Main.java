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
        List<List<Integer>> result = subsets(nums);

        for (List<Integer> list : result) {
            for (Integer list2 : list) {
                System.out.print(list2);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        backTrack(0, nums, track, result);

        return result;
    }

    private static void backTrack(int startIdx, int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        result.add(new ArrayList<>(track));

        for (int i = startIdx; i < nums.length; i++) {
            track.push(nums[i]);
            backTrack(i + 1, nums, track, result);
            track.pollFirst();
        }
    }
}
