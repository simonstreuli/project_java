package src.test.java.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import src.main.java.game.Board;
import src.main.java.game.Ship;

public class BoardTest {

    private Board board;
    private Ship ship;

    @BeforeEach
    public void setUp() {
        board = new Board();
        ship = new Ship("Fregatte", 3);
    }

    @Test
    public void testPlaceShip() {
        assertTrue(board.placeShip(ship, 0, 0, true));
        assertTrue(board.getGrid()[0][0].isOccupied());
        assertTrue(board.getGrid()[0][1].isOccupied());
        assertTrue(board.getGrid()[0][2].isOccupied());
    }

    @Test
    public void testPlaceShip_invalidPosition() {
        assertFalse(board.placeShip(ship, 8, 8, true));  // Invalid placement
    }

    @Test
    public void testAttackCell_hit() {
        board.placeShip(ship, 0, 0, true);
        assertTrue(board.attackCell(0, 0));
        assertTrue(board.getGrid()[0][0].isHit());
    }

    @Test
    public void testAttackCell_miss() {
        board.placeShip(ship, 0, 0, true);
        assertFalse(board.attackCell(1, 0));
        assertTrue(board.getGrid()[1][0].isMiss());
    }

    @Test
    public void testAllShipsSunk() {
        board.placeShip(ship, 0, 0, true);
        board.attackCell(0, 0);
        board.attackCell(0, 1);
        board.attackCell(0, 2);
        assertTrue(board.allShipsSunk());
    }
}
