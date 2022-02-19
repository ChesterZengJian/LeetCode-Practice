package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class EquationsPossibleTest {

    @Test
    public void testEquationsPossibleFalse() {
        String[] equations = new String[] { "a==b", "b!=a" };
        boolean actual = Main.equationsPossible(equations);
        assertEquals(false, actual);
    }

    @Test
    public void testEquationsPossibleTrue() {
        String[] equations = new String[] { "b==a", "a==b" };
        boolean actual = Main.equationsPossible(equations);
        assertEquals(true, actual);
    }
}