package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import javax.lang.model.element.Element;

import main.models.UnionFind;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int actual = lengthOfLIS(nums);
        System.out.println(actual);
    }

    public static int lengthOfLIS(int[] nums) {
        // 初始化没有牌堆
        int piles = 0;
        // 每个牌堆顶部为每个子序列的最大值，最多有 nums.length 个牌堆
        int[] pileTops = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = piles;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (pileTops[mid] < nums[i]) {
                    left = left + 1;
                } else if (pileTops[mid] > nums[i]) {
                    right = mid;
                } else {
                    right = mid;
                }
            }

            // left 已经找到最右边证明需要新建一个堆
            if (left == piles) {
                piles++;
            }
            pileTops[left] = nums[i];
        }

        return piles;
    }
}
