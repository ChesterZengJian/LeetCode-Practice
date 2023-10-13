package main.java.com.chester.topic.t0026;

import org.junit.Assert;
import org.junit.Test;

public class TestCase {
    @Test
    public void removeDuplicates2() {
        int[] nums = { 1, 1, 2 };
        Solution solution = new Solution();
        int res = solution.removeDuplicates(nums);
        Assert.assertEquals(2, res);
    }

    @Test
    public void removeDuplicates5() {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        Solution solution = new Solution();
        int res = solution.removeDuplicates(nums);
        Assert.assertEquals(5, res);
    }
}
