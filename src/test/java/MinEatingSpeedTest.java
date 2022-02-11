package test.java;

import org.junit.Assert;
import org.junit.Test;

import main.Main;

public class MinEatingSpeedTest {
    @Test
    public void testMinEatingSpeedByH8() {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        int res = Main.minEatingSpeed(piles, h);
        System.out.println(res);
        Assert.assertEquals(4, res);
    }

    @Test
    public void testMinEatingSpeedByH5() {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 5;
        int res = Main.minEatingSpeed(piles, h);
        System.out.println(res);
        Assert.assertEquals(30, res);
    }

    @Test
    public void testMinEatingSpeedByH6() {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 6;
        int res = Main.minEatingSpeed(piles, h);
        System.out.println(res);
        Assert.assertEquals(23, res);
    }

    @Test
    public void testMinEatingSpeedByH823855818() {
        int[] piles = { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077,
                337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728,
                941802184 };
        int h = 823855818;
        int res = Main.minEatingSpeed(piles, h);
        System.out.println(res);
        Assert.assertEquals(14, res);
    }
}
