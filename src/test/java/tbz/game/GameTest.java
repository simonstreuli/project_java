package tbz.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {

    private Game game;
    private Board mockBoard;

    @BeforeEach
    public void setUp() {
        game = new Game();
        mockBoard = mock(Board.class);
        // Inject mock board into the game object (assuming game has a setter or you modify its constructor)
        game.setBoard(mockBoard);
    }

    @Test
    public void testIsValidInput_valid() {
        assertTrue(game.isValidInput("A1"));
        assertTrue(game.isValidInput("J10"));
    }

    @Test
    public void testIsValidInput_invalid() {
        assertFalse(game.isValidInput("A0"));
        assertFalse(game.isValidInput("K1"));
        assertFalse(game.isValidInput("A11"));
        assertFalse(game.isValidInput("A1B"));
    }

    @Test
    public void testStartAttack_valid() {
        String validInput = "A1";
        when(mockBoard.attackCell(0, 0)).thenReturn(true); // Simulate a hit
        game.startAttack(validInput);

        verify(mockBoard, times(1)).attackCell(0, 0); // Ensure attackCell was called with the correct parameters
        // Further checks for printing "Du hast getroffen!" can be done by verifying system output
    }

    @Test
    public void testStartAttack_invalid() {
        String invalidInput = "Z100";  // Out of bounds
        game.startAttack(invalidInput);

        // We cannot verify print output directly without capturing it,
        // but we can ensure that attackCell is not called
        verify(mockBoard, times(0)).attackCell(anyInt(), anyInt());
    }
}
