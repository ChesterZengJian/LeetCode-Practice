package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[][] nums = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
        int actual = findMinArrowShots(nums);
        System.out.println(actual);
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] < b[1]) ? -1 : ((a[1] == b[1]) ? 0 : 1);
            }
        });

        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            }
        }

        return count;
    }
}
