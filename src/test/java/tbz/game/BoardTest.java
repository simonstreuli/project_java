package tbz.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private Ship ship1;

    @BeforeEach
    public void setUp() {
        // Initialize a new board for each test
        board = new Board();
        ship1 = new Ship("test", 3); // Assuming the ship has a length of 3
    }

    @Test
    public void testBoardInitialization() {
        // Test if the grid is initialized correctly
        assertNotNull(board.getGrid());
        assertEquals(10, board.getGrid().length);
        assertEquals(10, board.getGrid()[0].length);
    }

    @Test
    public void testPlaceShip() {
        // Test if a ship can be placed on the board
        boolean placed = board.placeShip(ship1, 0, 0, true); // Place horizontally at (0, 0)
        assertTrue(placed);
        assertTrue(board.getGrid()[0][0].isOccupied());
        assertTrue(board.getGrid()[0][1].isOccupied());
        assertTrue(board.getGrid()[0][2].isOccupied());
    }

    @Test
    public void testCannotPlaceShipOnOccupiedCell() {
        // Test if a ship cannot be placed on an already occupied cell
        board.placeShip(ship1, 0, 0, true);
        Ship ship2 = new Ship("test", 3);
        boolean placed = board.placeShip(ship2, 0, 1, true); 
        assertFalse(placed);
    }

    @Test
    public void testAttackCellHit() {
        // Test if attacking a cell with a ship correctly registers a hit
        board.placeShip(ship1, 0, 0, true);
        boolean result = board.attackCell(0, 0);
        assertTrue(result);
        assertTrue(board.getGrid()[0][0].isHit());
        assertFalse(board.getGrid()[0][0].isMiss());
    }

    @Test
    public void testAttackCellMiss() {
        // Test if attacking an empty cell correctly registers a miss
        boolean result = board.attackCell(5, 5);
        assertFalse(result);
        assertFalse(board.getGrid()[5][5].isHit());
        assertTrue(board.getGrid()[5][5].isMiss());
    }

    @Test
    public void testAllShipsSunk() {
        // Test if the game detects when all ships are sunk
        Ship ship1 = new Ship("test",3);
        Ship ship2 = new Ship("test",2);
        board.placeShip(ship1, 0, 0, true);
        board.placeShip(ship2, 3, 3, true);

        // Attack and sink ship1
        board.attackCell(0, 0);
        board.attackCell(0, 1);
        board.attackCell(0, 2);

        // Attack and sink ship2
        board.attackCell(3, 3);
        board.attackCell(3, 4);

        assertTrue(board.allShipsSunk());
    }

    @Test
    public void testRandomShipPlacement() {
        // Test random ship placement
        Ship randomShip = new Ship("test",4);
        board.placeRandomShip(randomShip);
        assertTrue(randomShip.getPosition().size() > 0); // Check if the ship was placed
    }

    @Test
    public void testToString() {
        // Test if the toString method correctly prints the board
        String boardString = board.toString();
        assertTrue(boardString.contains("A"));
        assertTrue(boardString.contains("1"));
    }
}
