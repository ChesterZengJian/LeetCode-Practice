package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class JumpTest {
    @Test
    public void testJump() {
        int[] nums = { 2, 3, 1, 1, 4 };
        int res = Main.jump(nums);
        assertEquals(2, res);
    }

    @Test
    public void testJump2() {
        int[] nums = { 2, 3, 0, 1, 4 };
        int res = Main.jump(nums);
        assertEquals(2, res);
    }
}
