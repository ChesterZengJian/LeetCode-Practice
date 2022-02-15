package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.Main;

public class RemoveDuplicatesTest {
    @Test
    public void removeDuplicates2() {
        int[] nums = { 1, 1, 2 };
        int res = Main.removeDuplicates(nums);
        Assert.assertEquals(2, res);
    }

    @Test
    public void removeDuplicates5() {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int res = Main.removeDuplicates(nums);
        Assert.assertEquals(5, res);
    }
}
