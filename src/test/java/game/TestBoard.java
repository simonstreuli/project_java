package src.test.java.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.game.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoard {

    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
        board.placeShip(new Ship("TestSchiff", 3), 0, 0, true);
    }

    @Test
    public void testShipPlacement_is_occupied_shouldReturnTrue() {
        assertTrue(board.getGrid()[0][0].isOccupied(), "Das Schiff ist auf [0][0] gesetzt");
        assertTrue(board.getGrid()[0][1].isOccupied(), "Das Schiff ist auf [0][1] gesetzt");
        assertTrue(board.getGrid()[0][2].isOccupied(), "Das Schiff ist auf [0][2] gesetzt");
    }

    @Test
    public void testShipPlacement_is_not_occupied_shouldReturnFalse() {
        assertFalse(board.getGrid()[0][3].isOccupied(), "Das Schiff ist NICHT auf [0][3] gesetzt");
    }

    @Test
    public void testAttackCell_ShipHit_got_hit_shouldReturnTrue() {
        assertTrue(board.attackCell(0, 2), "Das Schiff wurde getroffen");
    }

    @Test
    public void testAttackCell_ShipMiss_shoot_misses_the_Ship_shouldReturnFalse() {
        assertFalse(board.attackCell(0, 5), "Das Schiff wurde nicht getroffen");
    }

    @Test
    public void testPlaceShip_on_B5_with_length_2_shouldReturnTrue() {
        assertTrue(board.placeShip(new Ship("TestSchiff", 2), 1, 4, true), "Das Schiff wurde platziert");
    }

    @Test
    public void testPlaceShip_outsideTheGrid_on_J100_with_length_40_shouldThrowAException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            board.placeShip(new Ship("TestSchiff", 40), 9, 99, true);
        });
    }

    @Test
    public void testAllShipsSunk_but_one_alive_shouldReturnFalse() {
        assertFalse(board.allShipsSunk());
    }

    @Test
    public void testBoardInitialization() {
        assertNotNull(board.getShips());

        assertEquals(10, board.getGrid().length);
        for (int i = 0; i < 10; i++) {
            assertEquals(10, board.getGrid()[i].length);
        }
    }

    @Test
    public void testAllShipsSunk_shouldReturnTrue() {
        assertTrue(board.attackCell(0, 0), "Das Schiff wurde getroffen");
        assertTrue(board.attackCell(0, 1), "Das Schiff wurde getroffen");
        assertTrue(board.attackCell(0, 2), "Das Schiff wurde getroffen");

        assertTrue(board.allShipsSunk());
    }

    @Test
    public void testBoard_if_it_is_a_string() {
        System.out.println(board);
    }

    @Test
    public void testBoard_stringS_on_occupied_should_appear() {
        Cell cell = new Cell('A', 1);
        if (cell.isOccupied()) {
            System.out.println(cell);
        } else {
            System.out.println("nichts");
        }
    }

}
