package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class CanJumpTest {
    @Test
    public void testCanJump() {
        int[] nums = { 2, 3, 1, 1, 4 };
        boolean res = Main.canJump(nums);
        assertEquals(true, res);
    }

    @Test
    public void testCanJumpFalse() {
        int[] nums = { 3, 2, 1, 0, 4 };
        boolean res = Main.canJump(nums);
        assertEquals(false, res);
    }
}
