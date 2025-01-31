package src.test.java.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.game.Game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
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
        game.startAttack("A1");
        // Überprüfen, ob das Spiel korrekt reagiert
        // (z.B. Treffer oder Fehlschuss)
    }

    @Test
    public void testStartAttack_invalid() {
        game.startAttack("Z100");
        // Überprüfen, ob eine ungültige Eingabe korrekt behandelt wird
    }
}
