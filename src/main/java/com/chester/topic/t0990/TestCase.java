package main.java.com.chester.topic.t0990;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCase {
    @Test
    public void testEquationsPossibleFalse() {
        String[] equations = new String[] { "a==b", "b!=a" };
        Solution solution = new Solution();
        boolean actual = solution.equationsPossible(equations);
        assertEquals(false, actual);
    }

    @Test
    public void testEquationsPossibleTrue() {
        String[] equations = new String[] { "b==a", "a==b" };
        Solution solution = new Solution();
        boolean actual = solution.equationsPossible(equations);
        assertEquals(true, actual);
    }
}
