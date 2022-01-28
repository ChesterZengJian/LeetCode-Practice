import java.util.ArrayList;
import java.util.List;

import models.MonotonicQueue;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> tmpResult = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
                continue;
            }

            window.push(nums[i]);
            tmpResult.add(window.getMax());
            // System.out.println(String.format("current max: %d", window.getMax()));
            window.pop(nums[i - k + 1]);
        }

        int[] result = new int[tmpResult.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = tmpResult.get(i);
        }

        return result;
    }
}

// public class MonotonicQueue {
//     private LinkedList<Integer> queue = new LinkedList<>();

//     public void push(int num) {
//         while (!queue.isEmpty() && queue.peekLast() < num) {
//             queue.pollLast();
//         }

//         queue.addLast(num);
//     }

//     public int pop(int num) {
//         if (!queue.isEmpty() && queue.peekFirst() == num) {
//             return queue.pop();
//         }

//         return num;
//     }

//     public int getMax() {
//         return queue.peekFirst();
//     }

//     public void print() {
//         while (!queue.isEmpty()) {
//             System.out.println(queue.pop());
//         }
//     }
// }
// @lc code=end
