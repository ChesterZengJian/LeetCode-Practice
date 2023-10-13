import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);

        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < isPrimes.length; i++) {
            if (isPrimes[i])
                result++;
        }

        return result;
    }

    /**
     * over limit time
     * 
     * @param num
     * @return
     */
    public boolean isPrimes(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
