package main.java.com.chester.topic.t0042;

import org.junit.Assert;
import org.junit.Test;

public class TestCase {
    @Test
    public void testTrap6() {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Solution solution = new Solution();
        int res = solution.trap(height);
        Assert.assertEquals(6, res);
    }

    @Test
    public void testTrap9() {
        int[] height = { 4, 2, 0, 3, 2, 5 };
        Solution solution = new Solution();
        int res = solution.trap(height);
        Assert.assertEquals(9, res);
    }
}
