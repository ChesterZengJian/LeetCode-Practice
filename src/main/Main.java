package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Main {

    private static int base = 1337;

    public static void main(String[] args) {
        int[] nums = { 3, 6, 7, 11 };
        int target = 8;
        int res = minEatingSpeed(nums, target);
        System.out.println(res);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatFinish(mid, piles, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canEatFinish(int k, int[] piles, int h) {
        long totalHour = 0;

        for (int i = 0; i < piles.length; i++) {
            totalHour += (piles[i] / k) + (piles[i] % k > 0 ? 1 : 0);
        }

        if (totalHour <= h) {
            return true;
        }

        return false;
    }

    private static int getMaxPile(int[] piles) {
        int res = 0;

        for (int i = 0; i < piles.length; i++) {
            res = Math.max(res, piles[i]);
        }

        return res;
    }
}
