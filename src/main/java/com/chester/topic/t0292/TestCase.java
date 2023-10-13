package main.java.com.chester.topic.t0292;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testCanWinNim4() {
        Solution solution = new Solution();
        boolean actual = solution.canWinNim(4);
        assertEquals(false, actual);
    }

    @Test
    public void testCanWinNim1() {
        Solution solution = new Solution();
        boolean actual = solution.canWinNim(1);
        assertEquals(true, actual);
    }

    @Test
    public void testCanWinNim2() {
        Solution solution = new Solution();
        boolean actual = solution.canWinNim(2);
        assertEquals(true, actual);
    }
}
