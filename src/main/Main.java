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
        int[] nums = { 3, 2, 1, 0, 4 };
        boolean res = canJump(nums);
        System.out.println(res);
    }

    public static boolean canJump(int[] nums) {
        int fastest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            System.out.println(String.format("i=%s;fastest=%s;nums[%s]=%s", i, fastest, i, nums[i]));
            if (fastest <= i)
                return false;
        }
        return true;
    }
}
