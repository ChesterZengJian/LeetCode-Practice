package main.java.com.chester.topic.t0001;

import main.java.com.chester.common.FormatPrint;

class Bootstrap {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);

        FormatPrint.print(result);
    }
}
