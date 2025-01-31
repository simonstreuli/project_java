package src.test.java.game;

import org.junit.jupiter.api.Test;
import src.main.java.game.Cell;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testCellInitialization() {
        Cell cell = new Cell('A', 1);
        assertEquals('A', cell.getRow());
        assertEquals(1, cell.getColumn());
        assertFalse(cell.isOccupied());
        assertFalse(cell.isHit());
        assertFalse(cell.isMiss());
    }

    @Test
    public void testSetOccupied() {
        Cell cell = new Cell('A', 1);
        cell.setOccupied(true);
        assertTrue(cell.isOccupied());
    }

    @Test
    public void testSetHit() {
        Cell cell = new Cell('A', 1);
        cell.setHit(true);
        assertTrue(cell.isHit());
    }

    @Test
    public void testSetMiss() {
        Cell cell = new Cell('A', 1);
        cell.setMiss(true);
        assertTrue(cell.isMiss());
    }

    @Test
    public void testToString() {
        Cell cell = new Cell('A', 1);
        assertEquals(".", cell.toString());
        cell.setOccupied(true);
        assertEquals("S", cell.toString());
        cell.setMiss(true);
        assertEquals("O", cell.toString());
        cell.setHit(true);
        assertEquals("X", cell.toString());
    }
}
