package main.java.com.chester.topic.t0045;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testJump() {
        int[] nums = { 2, 3, 1, 1, 4 };
        Solution solution = new Solution();
        int res = solution.jump(nums);
        assertEquals(2, res);
    }

    @Test
    public void testJump2() {
        int[] nums = { 2, 3, 0, 1, 4 };
        Solution solution = new Solution();
        int res = solution.jump(nums);
        assertEquals(2, res);
    }
}
