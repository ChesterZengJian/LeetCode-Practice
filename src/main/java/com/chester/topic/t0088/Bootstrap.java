package main.java.com.chester.topic.t0088;

import main.java.com.chester.common.FormatPrint;

class Bootstrap {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;

        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);

        FormatPrint.print(nums1);
    }
}
