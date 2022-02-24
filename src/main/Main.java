package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import main.models.UnionFind;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int actual = lengthOfLIS(nums);
        System.out.println(actual);
    }

    public static int lengthOfLIS(int[] nums) {
        // dp[i] 为每个数的最长子序列
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // i 为了遍历每个数
        for (int i = 0; i < dp.length; i++) {
            // j 表示 dp[0...i] 的操作
            for (int j = 0; j < i; j++) {
                // 找到 nums[0...i] 中比 nums[i] 小的数
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        // 找出 dp 中最大的值
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
