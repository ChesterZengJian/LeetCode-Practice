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

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int res = trap(height);
        System.out.println(res);
    }

    public static int trap(int[] height) {
        if (height.length == 0)
            return 0;

        int res = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int left = 0, right = height.length - 1;

        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
                continue;
            }
            res += rightMax - height[right];
            right--;
        }

        return res;
    }
}
