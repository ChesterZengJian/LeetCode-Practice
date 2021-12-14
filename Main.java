import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3 ,5};
        int[] nums2 = { 2, 4 };
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numsCount = nums1.length + nums2.length;
        int k = 0;
        if (numsCount % 2 == 0) {
            double mid = (getKthElement(nums1, nums2, numsCount / 2) + getKthElement(nums1, nums2, numsCount / 2 + 1))
                    / 2.0;
            return mid;
        } else {
            k = numsCount / 2;
            int KthElement = getKthElement(nums1, nums2, k + 1);
            return KthElement;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0;
        int index2 = 0;

        while (true) {
            if (nums1.length == index1) {
                return nums2[index2 + k];
            }

            if (nums2.length == index2) {
                return nums1[index1 + k];
            }

            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int mid = k / 2;
            int nums1Mid = Math.min(mid + index1, nums1.length) - 1;
            int nums2Mid = Math.min(mid + index2, nums2.length) - 1;

            if (nums1[nums1Mid] < nums2[nums2Mid]) {
                k = k - (index1 - nums1Mid + 1);
                index1 = nums1Mid + 1;
                continue;
            }

            k = k - (index2 - nums2Mid + 1);
            index2 = nums2Mid + 1;
        }
    }
}
