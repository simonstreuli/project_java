package src.main.java.game;

import java.util.*;

public class Game {
    private Board board;
    private int attempts;
    private Scanner scanner;
    private static Map<String, Integer> scoreboard = new LinkedHashMap<>();

    public Game() {
        scanner = new Scanner(System.in);
    }
    public int getAttempts() {
        return attempts;
    }
    public void menu() {
        while (true) {
            System.out.println("\n==================================");
            System.out.println("Willkommen zu Battleships!");
            System.out.println("==================================\n");
            System.out.println("1. Neues Spiel starten");
            System.out.println("2. Scoreboard anzeigen");
            System.out.println("3. Beenden");
            System.out.print("\nWähle eine Option: ");

            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "1":
                    startGame();
                    break;
                case "2":
                    displayScoreboard();
                    break;
                case "3":
                    System.out.println("Spiel wird beendet...");
                    return;
                default:
                    System.out.println("Ungültige Auswahl, bitte erneut versuchen.\n");
            }
        }
    }

    private void startGame() {
        System.out.print("\nGib deinen Namen ein: ");
        String playerName = scanner.nextLine();
        System.out.println();

        board = new Board();
        attempts = 0;
        setupGame();

        while (!board.allShipsSunk() && attempts < 20) {
            board.printBoard();
            System.out.println("\nSchiesse auf ein Schiff (z.B A1): ");
            String input = scanner.nextLine();
            startAttack(input);
        }

        if (board.allShipsSunk()) {
            System.out.println("\nDu hast alle Schiffe versenkt in " + attempts + " Versuchen!");
            scoreboard.put(playerName, attempts);
        } else {
            System.out.println("\nDu hast alle Versuche aufgebraucht.");
        }
    }

    private void setupGame() {
        board.placeRandomShip(new Ship("Fregatten", 3));
        board.placeRandomShip(new Ship("Fregatten", 3));
        board.placeRandomShip(new Ship("Minensucher", 2));
        board.placeRandomShip(new Ship("Schlachtschiff", 5));
        board.placeRandomShip(new Ship("Kreuzer", 4));
    }

    public void startAttack(String input) {
        if (isValidInput(input)) {
            char row = (char) (input.toUpperCase().charAt(0) - 'A');
            int column = Integer.parseInt(input.substring(1)) - 1;
            attempts++;
            boolean hit = board.attackCell(row, column);
            if (hit) {
                System.out.println("\nDu hast getroffen!");
            } else {
                System.out.println("\nDaneben :(");
            }
        } else {
            System.out.println("\nUngültige Eingabe");
        }
    }

    public boolean isValidInput(String input) {
        if (input.length() < 2 || input.length() > 3)
            return false;
        char rowChar = input.toUpperCase().charAt(0);
        int column;
        try {
            column = Integer.parseInt(input.substring(1));
        } catch (NumberFormatException e) {
            return false;
        }
        return rowChar >= 'A' && rowChar <= 'J' && column >= 1 && column <= 10;
    }

    private void displayScoreboard() {
        System.out.println("\n==================================");
        System.out.println("            Scoreboard");
        System.out.println("==================================\n");
        if (scoreboard.isEmpty()) {
            System.out.println("Noch keine Einträge im Scoreboard.\n");
        } else {
            scoreboard.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue() + " Versuche"));
            System.out.println();
        }
    }
}
