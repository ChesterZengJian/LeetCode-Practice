import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {
    private int base = 1337;

    public int superPow(int a, int[] b) {
        List<Integer> indexs = new ArrayList<>(b.length);

        for (int i = 0; i < b.length; i++) {
            indexs.add(b[i]);
        }

        return superPow(a, indexs);
    }

    public int superPow(int a, List<Integer> indexs) {
        if (indexs.isEmpty())
            return 1;
        int last = indexs.remove(indexs.size() - 1);
        int part1 = myPow(a, last);
        int part2 = myPow(superPow(a, indexs), 10);

        return (part1 * part2) % base;
    }

    public int myPow(int a, int b) {
        if (b == 0) {
            return 1;
        }

        a %= base;
        if (b % 2 == 1) {
            return (myPow(a, b - 1) * a) % base;
        }

        int res = myPow(a, b / 2);
        return (res * res) % base;
    }
}
// @lc code=end
