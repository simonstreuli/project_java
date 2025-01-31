package src.test.java.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.game.Cell;
import src.main.java.game.Ship;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {

    private Ship ship;
    private Cell cell1, cell2, cell3;

    @BeforeEach
    public void setUp() {
        ship = new Ship("Fregatte", 3);
        cell1 = new Cell('A', 0);
        cell2 = new Cell('A', 1);
        cell3 = new Cell('A', 2);
        ship.addPosition(cell1);
        ship.addPosition(cell2);
        ship.addPosition(cell3);
    }

    @Test
    public void testShipInitialization() {
        assertEquals(3, ship.getLength());
        assertFalse(ship.isSunkStatus());
    }

    @Test
    public void testAddPosition() {
        assertEquals(3, ship.getPosition().size());
    }

    @Test
    public void testIsSunk() {
        assertFalse(ship.isSunk());
        cell1.setHit(true);
        assertFalse(ship.isSunk());
        cell2.setHit(true);
        assertFalse(ship.isSunk());
        cell3.setHit(true);
        assertTrue(ship.isSunk());
    }

    @Test
    public void testIsSunkStatus() {
        cell1.setHit(true);
        cell2.setHit(true);
        cell3.setHit(true);
        assertTrue(ship.isSunkStatus());
    }
}
