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
        String[] equations = new String[] { "a==b", "b!=a" };
        boolean actual = equationsPossible(equations);
        System.out.println(actual);
    }

    public static boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!' && unionFind.connect(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }
}
