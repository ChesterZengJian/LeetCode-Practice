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
        int num = 4;
        boolean actual = canWinNim(num);
        System.out.println(actual);
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
