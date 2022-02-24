package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class LengthOfLISTest {
    @Test
    public void testLengthOfLIS4() {
        int[] nums = new int[] { 10, 9, 2, 5, 3, 7, 101, 18 };
        int actual = Main.lengthOfLIS(nums);
        assertEquals(4, actual);
    }

    @Test
    public void testLengthOfLIS1() {
        int[] nums = new int[] { 7, 7, 7, 7, 7, 7, 7 };
        int actual = Main.lengthOfLIS(nums);
        assertEquals(1, actual);
    }
}
