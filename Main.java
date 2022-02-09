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

    private static int base = 1337;

    public static void main(String[] args) {
        System.out.println(superPow(2, new int[] { 1, 0 }));
    }

    public static int superPow(int a, int[] b) {
        List<Integer> indexs = new ArrayList<>(b.length);

        for (int i = 0; i < b.length; i++) {
            indexs.add(b[i]);
        }

        return superPow(a, indexs);
    }

    public static int superPow(int a, List<Integer> indexs) {
        if (indexs.isEmpty())
            return 1;
        int last = indexs.remove(indexs.size() - 1);
        int part1 = myPow(a, last);
        int part2 = myPow(superPow(a, indexs), 10);

        return (part1 * part2) % base;
    }

    public static int myPow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        // a 作为乘数，也需要取模

        a %= base;
        if (b % 2 == 1) {
            return (myPow(a, b - 1) * a) % base;
        }

        int res = myPow(a, b / 2);
        return (res * res) % base;
    }
}
