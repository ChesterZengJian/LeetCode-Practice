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
        UnionFind unionFind = new UnionFind(10);
        unionFind.union(0, 1);
        unionFind.union(2, 1);
        System.out.println(unionFind.connect(0, 2));
        System.out.println(unionFind.connect(0, 4));
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
