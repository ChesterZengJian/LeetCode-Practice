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
        List<List<Integer>> result = permute(nums);

        for (List<Integer> list : result) {
            for (Integer list2 : list) {
                System.out.print(list2);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        if (nums.length <= 0)
            return result;

        backTrack(nums, track, result);
        return result;
    }

    private static void backTrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        if (nums.length == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (track.contains(nums[i]))
                continue;

            track.push(nums[i]);
            backTrack(nums, track, result);
            track.pollFirst();
        }
    }
}
