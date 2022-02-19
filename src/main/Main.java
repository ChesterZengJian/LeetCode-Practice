package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        int res = jump(nums);
        System.out.println(res);
    }

    public static int jump(int[] nums) {
        int fastest = 0, end = 0, jumps = 0;

        for (int i = 0; i < nums.length-1; i++) {
            fastest = Math.max(fastest, nums[i]+i);
            if (i == end) {
                jumps++;
                end = fastest;
            }
        }

        return jumps;
    }

    // public static int jump(int[] nums) {
    //     int[] memo = new int[nums.length];
    //     Arrays.fill(memo, nums.length);
    //     int res = dp(nums, 0, memo);
    //     return res;
    // }

    // public static int dp(int[] nums, int p, int[] memo) {
    //     int len = nums.length;

    //     // 刚好 p 为最后一步
    //     if (p >= len - 1) {
    //         return 0;
    //     }

    //     // memo 不为初始值证明已计算过了
    //     if (memo[p] != len) {
    //         return memo[p];
    //     }

    //     int steps = nums[p];

    //     for (int i = 1; i <= steps; i++) {
    //         int subProblem = dp(nums, p + i, memo);
    //         // 子方案数+当前方案，即 sub + 1
    //         memo[p] = Math.min(subProblem + 1, memo[p]);
    //     }

    //     return memo[p];
    // }
}
