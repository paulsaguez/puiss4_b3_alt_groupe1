package game;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    @Test
    void play() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);

        when(p1.getId()).thenReturn(1);
        when(p2.getId()).thenReturn(2);

        Game g = new Game(p1, p2);

        boolean ok = g.play(3);
        assertTrue(ok);
        assertEquals(1, g.plateau[0][3]);

        assertFalse(g.play(-1));
        assertFalse(g.play(7));

        for (int i = 0; i < 5; i++) g.play(3);
        assertFalse(g.play(3));
    }

    @Test
    void switchActivePlayer() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);

        when(p1.getId()).thenReturn(1);
        when(p2.getId()).thenReturn(2);

        Game g = new Game(p1, p2);

        assertEquals(p1, g.activePlayer);

        g.switchActivePlayer();
        assertEquals(p2, g.activePlayer);

        g.switchActivePlayer();
        assertEquals(p1, g.activePlayer);
    }

    @Test
    void checkDraw() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);

        when(p1.getId()).thenReturn(1);
        when(p2.getId()).thenReturn(2);

        Game g = new Game(p1, p2);

        assertFalse(g.checkDraw());

        for (int c = 0; c < 7; c++) {
            g.lastOne[c] = 5;
        }

        assertTrue(g.checkDraw());
    }

    @Test
    void checkVictory() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);

        when(p1.getId()).thenReturn(1);
        when(p2.getId()).thenReturn(2);

        Game g = new Game(p1, p2);

        g.plateau[0][0] = 1;
        g.plateau[0][1] = 1;
        g.plateau[0][2] = 1;
        g.plateau[0][3] = 1;

        g.lastRow = 0;
        g.lastCol = 3;

        assertTrue(g.checkVictory());

        Game g2 = new Game(p1, p2);
        g2.plateau[0][0] = 1;
        g2.plateau[0][1] = 2;
        g2.lastRow = 0;
        g2.lastCol = 1;

        assertFalse(g2.checkVictory());
    }
}
