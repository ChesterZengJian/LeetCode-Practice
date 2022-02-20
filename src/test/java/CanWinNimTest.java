package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Main;

public class CanWinNimTest {
    @Test
    public void testCanWinNim4() {
        boolean actual = Main.canWinNim(4);
        assertEquals(false, actual);
    }

    @Test
    public void testCanWinNim1() {
        boolean actual = Main.canWinNim(1);
        assertEquals(true, actual);
    }

    @Test
    public void testCanWinNim2() {
        boolean actual = Main.canWinNim(2);
        assertEquals(true, actual);
    }
}
